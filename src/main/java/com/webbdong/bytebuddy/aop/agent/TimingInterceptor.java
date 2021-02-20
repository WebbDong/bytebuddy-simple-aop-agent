package com.webbdong.bytebuddy.aop.agent;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author Webb Dong
 * @description: 方法执行时间统计拦截器
 * @date 2021-02-20 11:38 PM
 */
public class TimingInterceptor {

    @RuntimeType
    public static Object intercept(@Origin Method method,
                                   @SuperCall Callable<?> callable) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return callable.call();
        } finally {
            System.out.println(method + " 执行时间(ms): " + (System.currentTimeMillis() - start));
        }
    }

}
