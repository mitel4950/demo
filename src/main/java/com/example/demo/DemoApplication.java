package com.example.demo;

import com.example.demo.pets.Cat;
import com.example.demo.pets.Dog;
import com.example.demo.pets.Pat;
import org.springframework.beans.factory.annotation.Value;
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

        int num = 3;
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
        }





    }

}
