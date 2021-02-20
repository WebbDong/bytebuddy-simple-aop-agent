package com.webbdong.bytebuddy.aop.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @author Webb Dong
 * @description: 使用 byte-buddy agent 实现一个简单的统计方法执行时间的 AOP
 * @date 2021-02-20 11:09 PM
 */
public class ByteBuddyAopAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform((builder, type, classLoader, module) -> builder.method(ElementMatchers.any())
                        .intercept(MethodDelegation.to(TimingInterceptor.class)))
                .installOn(inst);
    }

}
