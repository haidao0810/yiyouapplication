package com.kf.service.impl;

import com.kf.mapper.MakeupBrandMapper;
import com.kf.mapper.dao.MakeupBrandDAO;
import com.kf.service.MakeupBrandService;
import com.kf.service.vo.MakeupBrandVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service(value = "MakeupBrandImpl")
public class MakeupBrandImpl implements MakeupBrandService {
    @Autowired
    MakeupBrandMapper makeupBrandMapper;
    @Override
    public List<MakeupBrandVO> selectAllMakeupBrand() {
        List<MakeupBrandDAO> daoList=makeupBrandMapper.selectAllMakeupBrand();
        List<MakeupBrandVO> showData=new ArrayList<>();
        if(!CollectionUtils.isEmpty(daoList)){
            int size=daoList.size();
            for(int i=0;i<size;i++){
                MakeupBrandVO vo=new MakeupBrandVO();
                MakeupBrandDAO dao=  daoList.get(i);
                vo.setBrandId(dao.getUuid());
                vo.setBrandName(dao.getBrandName());
                vo.setBrandLocation(dao.getBrandLocation());
                vo.setBrand(dao.getBrand());
                vo.setFirstLetter(dao.getFirstLetter());
                vo.setPinyin(dao.getPinyin());
                showData.add(vo);
            }
        }
        return showData;
    }
}
