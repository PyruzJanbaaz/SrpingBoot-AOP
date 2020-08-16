package com.pyruz.aspects;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogHandler {

    final Logger logger;

    public LogHandler(Logger logger) {
        this.logger = logger;
    }


    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }

    @Before("restController()")
    public void beforeAnyRestController(JoinPoint joinPoint) {
        Map params = new HashMap();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            params.put(((CodeSignature) joinPoint.getSignature()).getParameterNames()[i], joinPoint.getArgs()[i]);
        }
        logger.info(params.toString());
    }

    @AfterReturning(pointcut = "restController()", returning = "result")
    public void afterAnyRestController(Object result) {
        logger.info(result.toString());
    }

    @AfterThrowing(pointcut = "restController()", throwing = "exception")
    public void afterThrowing(Throwable exception) {
        logger.error(exception.getMessage());
    }


}

