package com.epam.hw.one.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Pet {
    private String nickname;

    public Pet() {
        nickname = "Dogg";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @PostConstruct
    public void init() {
        System.out.println("A new pet called " + nickname + " is born");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pet " + nickname + " is gone");
    }
}
