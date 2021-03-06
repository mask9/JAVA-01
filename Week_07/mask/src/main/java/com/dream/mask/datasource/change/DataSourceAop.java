package com.dream.mask.datasource.change;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    @Pointcut(value = "execution(* com.dream.mask.datasource.change.dao.*.*(..) )")
    public void pointCut() {}
    
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        String method = joinPoint.getSignature().getName();
        
    }
}
