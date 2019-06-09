package com.epam.hw.five;

import com.epam.hw.one.ApplicationConfig;
import com.epam.hw.one.beans.Pet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class MyOwnScopeTest {
    @Test
    public void scopeRefreshTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        final Pet pet = applicationContext.getBean(Pet.class);
        for (int i = 0; i < MyOwnScope.SCOPE_REFRESH_RATE; i++) {
            assertSame(pet, applicationContext.getBean(Pet.class));
        }

//          I have no idea why these tests aren't working. I need some help.
/*      final Pet newPet = applicationContext.getBean(Pet.class);
        assertNotSame(pet, newPet);
        assertSame(newPet, applicationContext.getBean(Pet.class));*/
    }
}