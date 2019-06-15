package com.epam.hw.three;

import com.epam.hw.one.ApplicationConfig;
import com.epam.hw.one.beans.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MyOwnContextListenerTest {

    @Test
    void listenerTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final User user = ctx.getBean(User.class);
        assertTrue(user.getName().endsWith(" refreshed inside context listener"));
    }

}