package com.epam.hw.three;

import com.epam.hw.one.beans.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.Assert.*;


@ComponentScan(basePackages = {"com.epam.hw.one", "com.epam.hw.three"})
public class MyOwnContextListenerTest {

    @Test
    public void listenerTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyOwnContextListenerTest.class);
        final User user = ctx.getBean(User.class);
        assertEquals("Snoop refreshed", user.getName());
    }

}