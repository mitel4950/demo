package com.example.demo.pets;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    String str;
    public String HelloWorld() {
        return "HelloWorld";
    }
    public Dog(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
