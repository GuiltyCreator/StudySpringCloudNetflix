package com.dcone.springcloud.client.aop;

import com.dcone.springcloud.client.config.properties.PersonProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-18
 */
@Aspect
@Slf4j
@Component
@ConditionalOnClass({PersonProperties.class})
public class LogAspect {

    @Resource
    private PersonProperties personProperties;


    @Pointcut("execution(public * com.dcone.springcloud.client.controller..*(..))")
    public void log(){}

    @Before(value = "log()")
    public void before(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        log.info("URL:" + request.getRequestURL().toString());
        log.info("RemoteIP:" + request.getRemoteAddr());
        log.info("LocalIP:" + request.getLocalAddr());
    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void afterReturning(Object ret){
        log.info("person:" + personProperties.toString());
        log.info("return:" + ret);
    }

}
