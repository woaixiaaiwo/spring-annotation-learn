package com.boge.config;

import com.boge.bean.Color;
import com.boge.bean.Person;
import com.boge.bean.Red;
import com.boge.custom.CustomCondition;
import com.boge.custom.CustomImportBeanDefinitionRegister;
import com.boge.custom.CustomImportSelector;
import org.springframework.context.annotation.*;

//如果放在类上，表示满足当前条件，这个类中配置的所有bean才能生效
@Conditional(CustomCondition.class)
@Configuration("config2") //标识为一个配置类
@Import({Color.class, Red.class, CustomImportSelector.class, CustomImportBeanDefinitionRegister.class})//@Import导入的组件，id默认为全类名
public class ConfigClass2 {

    /** q
     * @Conditional({Condition}):按照一定的条件进行判断，满足条件给容器注入Bean
     */
    @Bean("bill")
    public Person person(){
        return new Person("Bill Gates",62);
    }

    @Bean("linus")
    @Conditional(CustomCondition.class)
    public Person person02(){
        return new Person("Linus ",48);
    }

    /**
     * spring导入组件的三种方式
     * 1）使用@PackageScan，@Component等注解，适用于自己编写的组件
     * 2）使用@Bean，用于导入第三方组件
     * 3）使用@Import，快速导入第三方组件。@Import注解的value为数组类型，可以导入多个组件
     *   1)@Import(要导入到容器的组件Class数组)，容器就会自动注册该组件，id默认为全类名
     *   2)使用ImportSelector
     *   3)使用ImportBeanDefinitionRegistrar
     * 4）使用FactoryBean
     */


}
