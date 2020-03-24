package com.kf.utils;

import com.kf.advice.ExcelFileException;
import com.kf.annotation.ExcelAnnotation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel 工具类
 */
public class ExcelUtil {

    public static <T extends Object> List<T> readExcelObject(MultipartFile file,Class<T> clazz){

        // 存储excel数据
        List<T> list = new ArrayList<>();
        if(file==null){
            return list;
        }
        Workbook wookbook = null;
        InputStream inputStream=null;
        try {
             inputStream=file.getInputStream();
        } catch (IOException e) {
            throw new ExcelFileException("文件读取异常");
        }
        //判断不同版本的excel
        if(file.getOriginalFilename().endsWith(".xls")){
            wookbook=xls(inputStream);

        }else if(file.getOriginalFilename().endsWith(".xlsx")){
            wookbook=xlsx(inputStream);
        }else{
            throw new ExcelFileException("非Excel文件");
        }
        if(wookbook!=null){
            //只支持单sheet 获取单表
            Sheet sheet= wookbook.getSheetAt(0);
            //获取总行数
            int rowNum=sheet.getLastRowNum()+1;

            // 获取类所有属性
            Field[] fields = clazz.getDeclaredFields();
            // 创建实体
            T obj =null;
            Cell cell = null;
            for(int i=1;i<rowNum;i++){
                Row row=sheet.getRow(i);

                try{
                    obj=clazz.newInstance();
                    ExcelAnnotation excelAnnotation=null;
                    for( Field f:fields){
                        //设置属性可以访问
                        f.setAccessible(true);
                        //判断是否有注解
                        if(f.isAnnotationPresent(ExcelAnnotation.class)){
                            //获得注解
                            excelAnnotation=f.getAnnotation(ExcelAnnotation.class);

                            //获取到索引
                            int index=excelAnnotation.columnIndex();
                            //获取到单元格
                            cell=  row.getCell(index);
                            setFieldValue(obj,f,cell);
                        }
                    }
                    list.add(obj);

                }catch (Exception e){
                    e.printStackTrace();
                    throw new ExcelFileException("文件读取异常");
                }
            }


        }
        return list;
    }

    /**
     * 绑定实体值
     */
    private static void setFieldValue(Object obj,Field f, Cell cell){
        try {
            cell.setCellType(CellType.STRING);

            if (f.getType() == byte.class || f.getType() == Byte.class) {

                f.set(obj, Byte.parseByte(cell.getStringCellValue()));

            } else if (f.getType() == int.class || f.getType() == Integer.class) {

                f.set(obj, Integer.parseInt(cell.getStringCellValue()));

            } else if (f.getType() == Double.class || f.getType() == double.class) {

                f.set(obj, Double.parseDouble(cell.getStringCellValue()));

            } else if (f.getType() == BigDecimal.class) {

                f.set(obj, new BigDecimal(cell.getStringCellValue()));

            } else {

                f.set(obj, cell.getStringCellValue());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 对excel 2003处理
     */
    private static Workbook xls(InputStream is){
        // 得到工作簿
        try {
            return new HSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对excel 2007处理
     */
    private static Workbook xlsx(InputStream is) {
        try {
            // 得到工作簿
            return new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
