package com.epam.hw.three;

import com.epam.hw.one.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyOwnContextListener {

    private final ApplicationContext context;

    @Autowired
    public MyOwnContextListener(ApplicationContext context) {
        this.context = context;
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("Context has been refreshed!");
        System.out.println(event);

        final User user = context.getBean(User.class);
        user.setName(user.getName() + " refreshed inside context listener");
    }
}
