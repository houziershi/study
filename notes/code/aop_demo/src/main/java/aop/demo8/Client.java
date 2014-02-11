package aop.demo8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 8. Spring AOP：引入增强
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo8/spring.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");
        greetingImpl.sayHello("Jack");

        Apology apology = (Apology) greetingImpl;
        apology.saySorry("Jack");
    }
}
