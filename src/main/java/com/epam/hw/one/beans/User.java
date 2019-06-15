package com.epam.hw.one.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User {
    private String name;

    public User() {
        name = "Snoop";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        System.out.println("A new " + name + " is born");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(name + " is gone");
    }
}
