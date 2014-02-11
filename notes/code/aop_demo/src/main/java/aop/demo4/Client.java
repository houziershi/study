package aop.demo4;

import aop.Greeting;

/**
 * 4. CGLib 动态代理
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("Jack");
    }
}
