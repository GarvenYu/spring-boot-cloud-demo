package com.freesia.multidatasource.secondway.aop;

import com.freesia.multidatasource.secondway.config.DataSourceThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author yukaibo
 */
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.freesia.multidatasource.secondway.aop.SwitchDataSource) || " +
            "@within(com.freesia.multidatasource.secondway.aop.SwitchDataSource)")
    public void dataSourcePointCut(){
        log.info("切点hit");
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String dataSourceKey = getDataSourceAnnotation(joinPoint).value();
        DataSourceThreadLocal.setContextKey(dataSourceKey);
        log.info("切换数据源{}",dataSourceKey);
        try{
            return joinPoint.proceed();
        }finally {
            DataSourceThreadLocal.removeContextKey();
        }
    }

    /**
     * 根据类或方法获取数据源注解
     */
    private SwitchDataSource getDataSourceAnnotation(ProceedingJoinPoint joinPoint){
        Class<?> targetClass = joinPoint.getTarget().getClass();
        SwitchDataSource annotation = targetClass.getAnnotation(SwitchDataSource.class);
        if(Objects.nonNull(annotation)){
            return annotation;
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod().getAnnotation(SwitchDataSource.class);
    }

}
