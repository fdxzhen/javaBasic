package com.zhenhao.proxy;

import java.util.HashSet;

public class JdkProxyMain {
    public static void main(String[] args) {
        // ����Ŀ�� target �� BuyServiceImpl
        JdkProxy proxy = new  JdkProxy(new  BuyServiceImpl());
        // ��ȡ�������ʵ��
       IBuyService buyItem = proxy.getProxy();

//        JdkProxyMain buyItem = proxy.getProxy();
        // ���÷���
        buyItem.buyItem(12345);


        HashSet hashSet = new HashSet<String>();

    }
}
