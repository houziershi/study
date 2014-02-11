package aop.demo5;

import aop.Greeting;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 5. Spring AOP：前置增强 + 后置增强（编程式）
 */
public class Client1 {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Jack");
    }
}
