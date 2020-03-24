package com.kf.WebController;

import com.kf.common.CollectionCode;
import com.kf.common.JSONResult;
import com.kf.mapper.dao.MakeupBrandDAO;
import com.kf.service.ExcelHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/web/makeup_message/v1")
public class WebMakeupBrandController {
    @Autowired
    @Qualifier("ExcelHandleImpl")
    ExcelHandleService excelHandleService;

    @PostMapping("/post_makeup_brand_catalogue_message.json")
    /**
     * 导入目录信息
     */
    public String importMakeupBrandBaseMessage(HttpServletRequest request){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile excel = multipartRequest.getFile("filename");
        excelHandleService.importForExcel(excel);

        return JSONResult.initErrorResult(CollectionCode.NET_ERROR_CODE_403,"未知错误").toJsonString();
    }
}
