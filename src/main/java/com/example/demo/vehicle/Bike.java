package com.example.demo.vehicle;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;

@DependsOn
public class Bike implements Vehicle {
    private String color;

    @Value("90")
    public int anInt;

    @Required
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
