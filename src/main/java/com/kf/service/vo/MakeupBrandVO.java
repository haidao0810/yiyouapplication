package com.kf.service.vo;

import com.kf.annotation.ExcelAnnotation;

import java.io.Serializable;

/**
 * 品牌VO
 */
public class MakeupBrandVO implements Serializable {
    private String brandId;

    private String brandLocation;

    private String brandName;

    private String pinyin;//全拼

    private String firstLetter;//首字母

    private String brand;//商标

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandLocation() {
        return brandLocation;
    }

    public void setBrandLocation(String brandLocation) {
        this.brandLocation = brandLocation;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
