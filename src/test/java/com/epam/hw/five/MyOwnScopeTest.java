package com.epam.hw.five;

import com.epam.hw.one.ApplicationConfig;
import com.epam.hw.one.beans.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MyOwnScopeTest {
    @Test
    void scopeRefreshTest() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        final Pet initialPet = applicationContext.getBean(Pet.class);
        Pet pet;
        int counter = 0;
        while (initialPet == (pet = applicationContext.getBean(Pet.class))) {
            counter++;
        }
        assertTrue(counter < MyOwnScope.SCOPE_REFRESH_RATE);


        for (int i = 0; i < MyOwnScope.SCOPE_REFRESH_RATE; i++) {
            assertSame(pet, applicationContext.getBean(Pet.class));
        }

        final Pet newPet = applicationContext.getBean(Pet.class);
        assertNotSame(pet, newPet);
        assertSame(newPet, applicationContext.getBean(Pet.class));
    }
}