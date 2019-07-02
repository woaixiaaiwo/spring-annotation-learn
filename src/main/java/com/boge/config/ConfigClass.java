package com.boge.config;

import com.boge.bean.Person;
import com.boge.controller.BookController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Configuration //标识为一个配置类
@ComponentScan(value = "com.boge",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {
                ServiceMode.class
        })
},useDefaultFilters = false)
// ComponentScan value：指定要扫描的包
// excludeFilters = Filter[] 指定扫描的时候按照什么规则排除哪些组件
// includeFilters = FIlter[] 指定扫描的时候只需要包含哪些组件。在使用时，需要把ComponentScan.useDefaultFilters置为false
// FilterType.ANNOTATION 按照注解过滤
// FilterType.ASSIGNABLE_TYPE 按照给定的类型
// FilterType.ASPECTJ 使用AspjectJ表达式
// FilterType.REGEX 使用正则表达式
// FilterType.CUSTOM 自定义规则，必须实现TypeFilter接口

//如果同时配置了includeFilter和excludeFilter，会先执行includeFilter的匹配，再执行excludeFilter的匹配
//而且includeFilter和excludeFilter会匹配被扫描包下的每一个类，不管该类是否使用了Spring的组件注解
//比如scanTest下的ScanTest类就没有使用Spring的组件注解，但是依然可以实现注入
public class ConfigClass {

    @Bean // 标识为一个组件
    public Person person(){
        return new Person("zhangsan",20);
    }

}
