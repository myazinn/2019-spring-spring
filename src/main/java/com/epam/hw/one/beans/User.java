package com.epam.hw.one.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User {
    private static User ourInstance = new User();

    public static User getInstance() {
        return ourInstance;
    }

    private String name;

    private User() {
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
