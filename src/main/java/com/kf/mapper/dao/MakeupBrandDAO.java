package com.kf.mapper.dao;

import com.kf.annotation.ExcelAnnotation;

import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;

/**
 * 化妆品DAO
 */
public class MakeupBrandDAO implements Serializable {
    private String uuid;

    @ExcelAnnotation(columnIndex = 0,columnName = "品牌地区")
    private String brandLocation;

    @ExcelAnnotation(columnIndex=1,columnName="品牌名称")
    private String brandName;
    @ExcelAnnotation(columnIndex=2,columnName="全拼")
    private String pinyin;//全拼
    @ExcelAnnotation(columnIndex=3,columnName="首字母")
    private String firstLetter;//首字母

    private String brand;//商标




    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLocation() {
        return brandLocation;
    }

    public void setBrandLocation(String brandLocation) {
        this.brandLocation = brandLocation;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
