package com.epam.hw.one;

import com.epam.hw.one.beans.Pet;
import com.epam.hw.one.beans.User;
import com.epam.hw.two.MyOwnBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
