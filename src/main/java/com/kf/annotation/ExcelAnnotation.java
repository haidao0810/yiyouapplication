package com.kf.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Excel 注解标识
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelAnnotation {

    public int columnIndex() default 0;

    public String columnName() default "";
}
