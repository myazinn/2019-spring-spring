package com.epam.hw;

import com.epam.hw.one.ApplicationConfig;
import com.epam.hw.one.beans.Pet;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        final Pet pet = applicationContext.getBean(Pet.class);
        System.out.println(pet.getNickname());
        applicationContext.close();
    }
}
