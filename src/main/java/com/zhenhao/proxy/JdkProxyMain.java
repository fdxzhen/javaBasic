package com.zhenhao.proxy;

import java.util.HashSet;

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
