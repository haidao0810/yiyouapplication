package com.kf.mapper;

import com.kf.mapper.dao.MakeupBrandDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/**
 * 品牌mapper
 */
public interface MakeupBrandMapper {

    /**
     * 插入品牌列表
     * @param datas
     */
   void  insetMakeupBrandList(List<MakeupBrandDAO> datas);

   List<MakeupBrandDAO> selectAllMakeupBrand();
}
