package com.kf.controller;

import com.kf.common.JSONResult;
import com.kf.service.MakeupBrandService;
import com.kf.service.vo.MakeupBrandVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CCX on 2019/12/1.
 * 品牌控制器
 */

@RestController
@RequestMapping("api/makeup_message/v1")
public class MakeupBrandController {

    @Autowired
    @Qualifier("MakeupBrandImpl")
    MakeupBrandService makeupBrandService;


    @GetMapping("/get_makeup_brand_catalogue.json")
    /**
     * 获取品牌名录
     */
    public String getMakeupBrandCatalogue(@RequestParam (name = "deviceId", required = true ,defaultValue = "") String deviceId ){
        List<MakeupBrandVO> voList= makeupBrandService.selectAllMakeupBrand();
        return JSONResult.initSuccessResult("success").pusData(voList).toJsonString();
    }

}
