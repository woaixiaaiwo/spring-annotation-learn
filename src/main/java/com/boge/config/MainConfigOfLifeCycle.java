package com.boge.config;


import com.boge.bean.Car;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * bean的生命周期
 *         bean 创建---初始化---销毁的过程
 * 管理同期bean的生命周期
 * 我们可以自定义初始化和销毁方法，容器在bean进行到生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 创建:
 *      单实例：容器创建时初始化
 *      多实例：获取Bean时初始化
 *
 * 初始化：
 *      属性设置完成之后调用
 *
 * 销毁：
 *      单实例：容器关闭时调用
 *      多实例：容器不会管理，不会调用
 *
 * 1)、指定初始化和销毁方法
 *     使用@Bean指定init-method和destroy-method
 *
 * 2)、实现InitializingBean和DisposableBean
 *
 * 3)、使用@PostConstruct注解，初始化和属性完成之后执行，标注在方法上
 *     使用@PreDestroy注解，容器销毁之前通知其进行清理工作
 *
 * 4）、使用BeanPostProcessor:
 *      postProcessBeforeInitialization方法：在InitializingBean的afterPropertiesSet方法调用之前调用
 *      postProcessAfterInitialization方法：在InitializingBean的afterPropertiesSet方法调用之后调用
 *
 *
 * 在调用InitializingBean的afterPropertiesSet方法调用之前，Spring会遍历所有BeanPostProcessor，调用postProcessBeforeInitialization方法。
 * 如果其中一个返回null，则跳出循环
 * 在调用InitializingBean的afterPropertiesSet方法调用之后，Spring会遍历所有BeanPostProcessor，postProcessAfterInitialization方法。
 * 同理，如果其中一个返回null，则跳出循环
 * 这些过程都是在属性注入之后才执行
 *
 */
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

}
