package aop.demo10;

import aop.Greeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 10. Spring AOP：自动代理（扫描 Bean 名称）
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo10/spring.xml");
        Greeting greeting = (GreetingImpl) context.getBean("greetingImpl");
        greeting.sayHello("Jack");
    }
}
