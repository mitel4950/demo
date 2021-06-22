package com.example.demo;

import com.example.demo.pets.*;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.demo.pets")
@PropertySource("classpath:application.properties")
public class Config {
    @Bean(name = "Pat")
    public Pat getPat() {
        return new Pat("Том");
    }


    @Bean(name = "Cat")
    @Profile("dev")
    public Cat devGetCat() {
        return new Cat("Уличный");
    }

    @Bean(value = "Cat")
    @Profile("production")
    public Cat productionGetCat() {
        return new Cat("Породистый");
    }


}
