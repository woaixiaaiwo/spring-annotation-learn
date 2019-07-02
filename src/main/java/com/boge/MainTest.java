package com.boge;

import com.boge.bean.Person;
import com.boge.config.ConfigClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigClass.class);
        System.out.println(applicationContext.getBean(Person.class));

    }

}
