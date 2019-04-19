package com.ucmed.hnust.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * Created by ZY-LJ-1446 on 2018/6/7.
 */
public class GreetingAroundAdvice implements MethodInterceptor /*,MethodBeforeAdvice,AfterReturningAdvice*/ {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        Object [] s=invocation.getArguments();
        System.out.println(result+s[0].toString());
        after();
        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
