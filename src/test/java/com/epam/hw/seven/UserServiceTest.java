package com.epam.hw.seven;

import com.epam.hw.one.ApplicationConfig;
import com.epam.hw.one.beans.User;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void AOPTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        final String proxyHello = "Hello, fella";
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return proxyHello;
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });

        UserService proxy = (UserService) enhancer.create();

        assertEquals(proxyHello, proxy.helloUser(null));

        final User user = applicationContext.getBean(User.class);

        int privileges = proxy.getUserPrivileges(user);
        assertEquals(user.getName().length(), privileges);

        assertThrows(NullPointerException.class, () -> proxy.getUserPrivileges(null));
    }

}