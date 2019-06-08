package com.epam.hw.one.beans;

public class Pet {
    private static Pet ourInstance = new Pet();

    public static Pet getInstance() {
        return ourInstance;
    }

    private String nickname;

    private Pet() {
        nickname = "Dogg";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
