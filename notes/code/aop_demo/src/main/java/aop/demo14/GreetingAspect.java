package aop.demo14;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    @DeclareParents(value = "aop.demo14.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;
}
