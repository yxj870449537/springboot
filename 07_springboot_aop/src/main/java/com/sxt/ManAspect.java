package com.sxt;

import com.sxt.Entity.Man;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class ManAspect {
    //声明切面
    public static final String POINTCUT1 = "execution(* com.sxt.Entity.Man.eat(..))";
    public static final String POINTCUT2 = "execution(* com.sxt.Entity.Man.sleep(..))";

//    @Before(POINTCUT1)
    public void before(){
        System.out.println("饭前喝汤");
    }

//    @After(POINTCUT1)
    public void after(){
        System.out.println("饭后搞一根");
    }

//    @Around(POINTCUT1)
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        pjp.proceed();
        after();
    }

//    @AfterThrowing(value = POINTCUT1,throwing = "tw")
    public void exp(Throwable tw){
        System.out.println("出现异常："+tw.getMessage());
    }

    @Around(POINTCUT2)
    public Object around1(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        Object arg = args[0];
        before();
        Object proceed = pjp.proceed();
        after();
        return proceed;
    }
}
