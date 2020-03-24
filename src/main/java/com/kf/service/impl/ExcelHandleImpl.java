package com.kf.service.impl;

import com.kf.common.UUIDUnit;
import com.kf.mapper.MakeupBrandMapper;
import com.kf.mapper.dao.MakeupBrandDAO;
import com.kf.service.ExcelHandleService;
import com.kf.utils.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

/**
 *  Excel 实现类
 */
@Service(value = "ExcelHandleImpl")
public class ExcelHandleImpl implements ExcelHandleService{

    @Autowired
    MakeupBrandMapper makeupBrandMapper;

    @Override
    public List<MakeupBrandDAO> importForExcel(MultipartFile file) {
        List<MakeupBrandDAO> excelData=ExcelUtil.readExcelObject(file, MakeupBrandDAO.class);
        if(!CollectionUtils.isEmpty(excelData)){
            for(MakeupBrandDAO dao :excelData){
                dao.setUuid(UUIDUnit.initUUID());
            }
            makeupBrandMapper.insetMakeupBrandList(excelData);
        }

        return excelData;
    }
}
