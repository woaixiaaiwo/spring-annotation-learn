package com.boge.bean;

public class Car {

    public Car(){
        System.out.println("---实例化方法---");
    }

    public void init(){
        System.out.println("---初始化方法---");
    }

    public void destroy(){
        System.out.println("---销毁方法---");
    }

}
