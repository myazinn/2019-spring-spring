package com.epam.hw.one;

import com.epam.hw.one.beans.Pet;
import com.epam.hw.one.beans.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.epam.hw"})
public class ApplicationConfig {
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    @Scope("custom")
    public Pet pet() {
        return new Pet();
    }
}
