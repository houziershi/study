package aop.demo11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 11. Spring AOP：自动代理（扫描切面配置）
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo11/spring.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingImpl");

        greetingImpl.sayHello("Jack");
        greetingImpl.goodMorning("Jack");
        greetingImpl.goodNight("Jack");
    }
}
