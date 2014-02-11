package aop.demo1;

import aop.Greeting;

/**
 * 1. 写死代码
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        greeting.sayHello("Jack");
    }
}
