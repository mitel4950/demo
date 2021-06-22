package com.example.demo.pets;

import javax.annotation.Resource;
public class Cat {
    private String breed;
    @Resource(name = "Pat")
    private Pat pat;
    public Cat (String breed){
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public Pat getPat() {
        return pat;
    }
}
