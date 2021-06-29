package com.example.demo;

import com.example.demo.pets.*;
import com.example.demo.prototype.Human;
import com.example.demo.prototype.Sex;
import com.example.demo.vehicle.Bike;
import com.example.demo.vehicle.Car;
import com.example.demo.vehicle.Engine;
import com.example.demo.vehicle.Vehicle;
import com.example.demo.сompany.Address;
import com.example.demo.сompany.Company;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static int i=0;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ApplicationContext context;

        int num = 12;
        switch (num) {
            case 0:
                context = new AnnotationConfigApplicationContext(MessageConfig.class);
                Message message = context.getBean(Message.class);

                message.setMessage("This is simpe message.");
                System.out.println(message);
                break;
            case 1:
                context = new AnnotationConfigApplicationContext(Config.class);
                Cat cat = (Cat) context.getBean("Cat");
                System.out.println(cat.getPat().getName() + " : " + cat.getBreed());

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
                Vehicle vehicle = context.getBean("Bike1", Vehicle.class);
                System.out.println(vehicle.getClass());
                break;
            case 7:
                context = new AnnotationConfigApplicationContext(Config.class);
                Vehicle vehicle1 = context.getBean("Bike1", Vehicle.class);
                System.out.println(((Bike)vehicle1).anInt);
                break;
            case 8:
                context = new AnnotationConfigApplicationContext(Config.class);
                Bike bike = (Bike) context.getBean("Bike",Vehicle.class);
                bike.setColor("Фиолетовый");
                Bike bike1 = (Bike) context.getBean("Bike",Vehicle.class);
                System.out.println(bike1.getColor());
                break;
            case 9:
                context = new AnnotationConfigApplicationContext(Config.class);
                //Sex sex = context.getBean(Sex.class);
                //System.out.println(sex.isBoy());

                Human human = context.getBean(Human.class);
                Human human1 = context.getBean(Human.class);

                human.getSex().setIsBoy(false);

                System.out.println(human.getSex().isBoy()+"  "+human1.getSex().isBoy());

                break;

            case 10:
                String[] arr = new String[]{"a","b","c","d"};
                Stream<String> stream = Arrays.stream(arr);
                stream = Stream.of(arr);

                List<String> stringList = Arrays.asList(arr);

                stringList.parallelStream().forEach(a -> System.out.println(a));

                //stream.parallel().forEach(a -> System.out.println(a+"!"));
                System.out.println(stream.parallel().allMatch(a -> a.contains("a")));

                break;
            case  11:
                ArrayList<String> list = new ArrayList<>();
                list.add("One");
                list.add("OneAndOnly");
                list.add("Derek");
                list.add("Change");
                list.add("factory");
                list.add("justBefore");
                list.add("Italy");
                list.add("Italy");
                list.add("Thursday");
                list.add("");
                list.add("");

                list.stream().filter(a -> a.contains("a")).forEach(a -> System.out.println(a));
                list.stream().map(a -> a.length()).forEach(a -> System.out.println(a));
                System.out.println(list.stream().map(a -> a.length()).reduce(0,(a,b)->a+b));
                System.out.println(list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList()));



                break;
            case 12:
                Stream.generate(() -> i++).limit(100).forEach(j -> System.out.print(j+" "));
                System.out.println();
                Stream.iterate(0, n -> n+1).limit(100).forEach(j -> System.out.print(j+" "));
                System.out.println();
                Stream<Integer> stream1 = Stream.iterate(0, n -> n+1).limit(100);
                break;

        }

    }

}
