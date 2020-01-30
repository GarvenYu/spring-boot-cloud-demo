package com.freesia.lifecycle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yukaibo
 * @date 2020-01-30 14:32:17
 * */
@Data
@AllArgsConstructor
public class Car {
    private String band;
    private String color;
    private int maxSpeed;

    public Car(){
        //exec order 1
        System.out.println("exec car construct method");
    }

    public void setBand(String band){
        System.out.println("exec car set band");
    }

    private void carInitMethod(){
        //exec order 4
        System.out.println("exec car init method");
    }

    private void carDestroyMethod(){
        //exec order 7
        System.out.println("exec car destroy method");
    }

    @PostConstruct
    public void postConstruct(){
        //exec order 3
        System.out.println("post construct");
    }

    @PreDestroy
    public void preDestroy(){
        //exec order 6
        System.out.println("pre destroy");
    }
}
