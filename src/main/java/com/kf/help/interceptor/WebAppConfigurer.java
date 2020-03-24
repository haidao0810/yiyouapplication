package com.kf.help.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc  配置
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    /**
     * 这里需要先将拦截器入住，不然无法获取到拦截器中的redistemplate
     * @return
     */

    @Bean
    public DeviceInterceptor getDeviceInterceptor(){
        return new DeviceInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getDeviceInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/api/sys_message/v1/**").//添加不拦截路径
                excludePathPatterns("/api/web/makeup_message/v1/**").
                excludePathPatterns("/error");
    }
}
