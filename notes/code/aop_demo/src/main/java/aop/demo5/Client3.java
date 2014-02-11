package aop.demo5;

import aop.Greeting;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 5. Spring AOP：环绕增强（编程式）【第3版】
 */
public class Client3 {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAroundAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Jack");
    }
}
