package com.example.demo;

import com.example.demo.pets.*;
import com.example.demo.сompany.Address;
import com.example.demo.сompany.Company;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        ApplicationContext context;

        int num = 6;
        switch (num)
        {
            case 0:
                context = new AnnotationConfigApplicationContext(MessageConfig.class);
                Message message = context.getBean(Message.class);

                message.setMessage("This is simpe message.");
                System.out.println(message);
                break;
            case 1:
                context = new AnnotationConfigApplicationContext(Config.class);
                Cat cat = (Cat)context.getBean("Cat");
                System.out.println(cat.getPat().getName() +" : "+ cat.getBreed());

                break;
            case 2:                 //Я хз, что это такое
                context = new AnnotationConfigApplicationContext();
                Resource resource = context.getResource("resources/log4j.properties");
                System.out.println(resource);
                break;
            case 3:
                context = new AnnotationConfigApplicationContext(Config.class);
                Dog dog = context.getBean("dog", Dog.class);
                System.out.println(dog.HelloWorld());
                break;




            case 4:
                context = new AnnotationConfigApplicationContext(Config.class);
                Address address = new Address("High Street", 1000);
                Company company = new Company(address);

                Company company1 = new Company(context.getBean(Address.class));
                break;
            case 5:
                context = new AnnotationConfigApplicationContext(Config.class);
                Tiger tiger = (Tiger) context.getBean("tiger", new Pat("Тигрёнок"));
                Lion lion = context.getBean(Lion.class);
                System.out.println(tiger.getPat().getName());
                System.out.println(lion.getPat().getName());

                break;
            case 6:
                context = new AnnotationConfigApplicationContext(Config.class);
                Config.Animal animal = context.getBean(Config.Animal.class);
                break;
        }

    }

}
