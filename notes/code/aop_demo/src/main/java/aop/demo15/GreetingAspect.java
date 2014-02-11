package aop.demo15;

import org.aspectj.lang.ProceedingJoinPoint;

public class GreetingAspect {

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
