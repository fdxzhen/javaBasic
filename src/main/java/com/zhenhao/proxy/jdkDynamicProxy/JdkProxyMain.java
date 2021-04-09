package com.zhenhao.proxy.jdkDynamicProxy;

import java.util.HashSet;

/**
 * 参考文章：https://www.cnblogs.com/ferryman/p/13170057.html
 * 问题1：为什么 JDK 动态代理要基于接口实现？而不是基于继承来实现？
 *        因为 JDK 动态代理生成的对象默认是继承 Proxy ，Java 不支持多继承，所以 JDK 动态代理要基于接口来实现。
 * 问题2：JDK 动态代理中，目标对象调用自己的另一个方法，会经过代理对象么？
 *        内部调用方法使用的对象是目标对象本身，被调用的方法不会经过代理对象。
 */
public class JdkProxyMain {
    public static void main(String[] args) {
        // 标明目标 target 是 BuyServiceImpl
        JdkProxy proxy = new  JdkProxy(new  BuyServiceImpl());
        // 获取代理对象实例
       IBuyService buyItem = proxy.getProxy();

//        JdkProxyMain buyItem = proxy.getProxy();
        // 调用方法
        buyItem.buyItem(12345);
        HashSet hashSet = new HashSet<String>();

    }
}
