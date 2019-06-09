package com.epam.hw.two;

import com.epam.hw.five.MyOwnScope;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyOwnBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("Inside MyOwnBeanFactoryPostProcessor");

        final String myOwnScopeName = "custom";
        beanFactory.registerScope(myOwnScopeName, new MyOwnScope());
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("Leaving MyOwnBeanFactoryPostProcessor");
        System.out.println();
    }
}
