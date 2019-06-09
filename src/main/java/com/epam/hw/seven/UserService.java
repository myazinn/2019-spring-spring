package com.epam.hw.seven;

import com.epam.hw.one.beans.User;

public class UserService {
    public String helloUser(User user) {
        return "Hello, " + user.getName();
    }

    public int getUserPrivileges(User user) {
        return user.getName().length();
    }
}
