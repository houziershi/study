package aop.demo5;

import aop.Greeting;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 5. Spring AOP：前置增强 + 后置增强（编程式）【第2版】
 */
public class Client2 {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Jack");
    }
}
