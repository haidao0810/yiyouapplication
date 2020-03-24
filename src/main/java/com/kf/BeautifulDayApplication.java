package com.kf;

import com.kf.utils.RestTemplateUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@MapperScan("com.kf.mapper")
@SpringBootApplication
public class BeautifulDayApplication {

	public static void main(String[] args)  {
		SpringApplication.run(BeautifulDayApplication.class, args);
	}
}
