package aop.demo8;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {

    @Override
    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return super.invoke(invocation);
    }
}
