package aop.demo3;

import aop.Greeting;

/**
 * 3. JDK 动态代理
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("Jack");
    }
}
