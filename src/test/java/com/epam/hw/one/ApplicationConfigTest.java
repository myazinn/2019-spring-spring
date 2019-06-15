package com.epam.hw.one;

import com.epam.hw.one.beans.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationConfigTest {

    @Test
    void petConfigTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final Pet pet = applicationContext.getBean(Pet.class);
        assertEquals("Dogg", pet.getNickname());

        final String doggy = "Doggy";
        pet.setNickname(doggy);

        assertEquals(doggy, ((Pet) applicationContext.getBean("pet")).getNickname());
    }
}
