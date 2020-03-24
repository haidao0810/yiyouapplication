package com.kf.service;

import com.kf.mapper.dao.MakeupBrandDAO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Excel 文件导入导出服务
 */
public interface ExcelHandleService{
     List<MakeupBrandDAO> importForExcel(MultipartFile file);
}
