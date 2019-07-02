package com.boge.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

import java.util.Map;

public class CustomCondition implements Condition {


    /**
     *
     * @param context 容器
     * @param metadata 注解相关信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        Map<String,Object> annotationAttribute = null;
        String beanName = "";
        if(metadata instanceof StandardAnnotationMetadata){
            StandardAnnotationMetadata standardAnnotationMetadata = (StandardAnnotationMetadata)metadata;
            annotationAttribute = metadata.getAnnotationAttributes(Configuration.class.getName());
            beanName = annotationAttribute.get("value").toString();
        }else {
            annotationAttribute = metadata.getAnnotationAttributes(Bean.class.getName());
            beanName = ((String[])annotationAttribute.get("name"))[0];
        }
        if("config2".equals(beanName)){
            if(osName.toLowerCase().contains("windows")){
                return true;
            }else {
                return false;
            }
        }
        if("bill".equals(beanName)){
            if(osName.toLowerCase().contains("windows")){
                return true;
            }else {
                return false;
            }
        }
        if("linus".equals(beanName)){
            if(osName.toLowerCase().contains("linux")){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
