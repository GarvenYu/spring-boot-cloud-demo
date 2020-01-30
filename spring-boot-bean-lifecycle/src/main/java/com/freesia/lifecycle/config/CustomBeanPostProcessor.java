package com.freesia.lifecycle.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author yukaibo
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        //exec order 2
        System.out.println("Calling bean post processor before init for bean:: "+beanName + "class name: "+bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        //exec order 5
        System.out.println("Calling bean post processor after init for bean:: "+beanName + "class name: "+bean.getClass());
        return bean;
    }
}
