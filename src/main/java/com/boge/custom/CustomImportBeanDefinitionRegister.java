package com.boge.custom;

import com.boge.bean.Green;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {


    /**
     *
     * @param importingClassMetadata 获取被注解的类的其他注解信息
     * @param registry Bean注册其
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("green",new RootBeanDefinition(Green.class));
    }
}
