package com.kf.help.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 设备合规aop
 *
 */
@Component
@Aspect
public class DeviceComplianceAop {

//    @Pointcut("execution(* com.kf.controller.*.*(..))&&! execution(* com.kf.controller.SysManagerController.*(..))")
//    public void checkDeviceCompliance(){
//
//    }
//
//    @Before("checkDeviceCompliance()")
//    public void checkDeviceComplianceBefore(JoinPoint joinPoint){
//       throw  new RuntimeException("123");
//    }

}
