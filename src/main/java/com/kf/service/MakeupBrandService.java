package com.kf.service;

import com.kf.service.vo.MakeupBrandVO;

import java.util.List;

/**
 * 品牌服务
 */
public interface MakeupBrandService  {

    List<MakeupBrandVO> selectAllMakeupBrand();

}
