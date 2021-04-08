package com.zhenhao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object target;
    public JdkProxy(Object target) {
        this.target = target;
    }
    // 方法增强
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args);
        Object result = method.invoke(target,args);
        after(args);
        return result;
    }
    private void after(Object result) { System.out.println("调用方法后执行！！！！" ); }
    private void before(Object[] args) { System.out.println("调用方法前执行！！！！" ); }

    /**
     * java的动态代理Proxy.newProxyInstance
     * @param <T>
     * @return
     */
    // 获取代理对象
    public <T> T getProxy(){
        /**
         * loader  用哪个类加载器去加载代理对象
         * interfaces 动态代理类需要实现的接口
         * h  动态代理方法在执行的时候，会调用this里面的invoke执行
         */
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
}
