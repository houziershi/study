package aop.demo9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 9. Spring AOP：切面
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo9/spring.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");

        greetingImpl.sayHello("Jack");
        greetingImpl.goodMorning("Jack");
        greetingImpl.goodNight("Jack");
    }
}
