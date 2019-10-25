package com.mine.belf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class IoC {
    static Log createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());
        return (Log) Proxy.newProxyInstance(IoC.class.getClassLoader(),
                new Class<?>[]{Log.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final Log logClass;

        DemoInvocationHandler(Log myLogClass) {
            this.logClass = myLogClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            int value = (int) args[0];
            System.out.println("executed method:" + method.getName() + ", param:" + value);
            return method.invoke(logClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + logClass +
                    '}';
        }
    }

}
