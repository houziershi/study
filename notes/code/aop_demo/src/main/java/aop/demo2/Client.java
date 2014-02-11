package aop.demo2;

import aop.Greeting;

/**
 * 2. 静态代理
 */
public class Client {

    public static void main(String[] args) {
        Greeting greetingProxy = new GreetingProxy(new GreetingImpl());
        greetingProxy.sayHello("Jack");
    }
}
