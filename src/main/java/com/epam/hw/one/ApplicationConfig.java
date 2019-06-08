package com.epam.hw.one;

import com.epam.hw.one.beans.Pet;
import com.epam.hw.one.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public User user() {
        return User.getInstance();
    }

    @Bean
    public Pet pet() {
        return  Pet.getInstance();
    }
}
