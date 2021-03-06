package com.example.demo;

import com.example.demo.pets.*;
import com.example.demo.prototype.Human;
import com.example.demo.prototype.Sex;
import com.example.demo.vehicle.Bike;
import com.example.demo.vehicle.Car;
import com.example.demo.vehicle.Engine;
import com.example.demo.vehicle.Vehicle;
import com.example.demo.сompany.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.demo.pets")
@ComponentScan("com.example.demo.сompany")
@ComponentScan("com.example.demo.vehicle")
@ComponentScan("com.example.demo.prototype")
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


    @Bean
    public Address getAddres() {
        return new Address("High Street", 1000);
    }


    @Bean(name = {"tiger", "kitty"})
    @Scope(value = "prototype")
    Tiger getTiger(Pat pat) {
        return new Tiger(pat);
    }

    @Bean(name = "lion")
    Lion getLion() {
        return new Lion("Hardcoded lion name");
    }

    public interface Animal {
    }


    @Bean(name = "Bike")
    Vehicle getVehicle() {
        return new Bike();
    }

    @Bean(name = "Bike1")
    Vehicle getVehicle1() {
        Bike bike = new Bike();
        bike.setColor("Говяный");
        return bike;
    }

    @Bean(name = "Sex")
    Sex getSex() {
        return new Sex(true);
    }


    @Bean(name = "Human")
    @Scope("prototype")
    Human getHuman() {
        return new Human();
    }

}
