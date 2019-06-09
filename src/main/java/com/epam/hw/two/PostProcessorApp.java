package com.epam.hw.two;

import com.epam.hw.one.ApplicationConfig;
import com.epam.hw.one.beans.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(
                        ApplicationConfig.class,
                        MyOwnBeanFactoryPostProcessor.class);

        final Pet pet = applicationContext.getBean(Pet.class);
        System.out.println(pet.getNickname());
    }
}
