package com.zhenhao.proxy.jdkDynamicProxy;

import java.util.HashSet;

/**
 * �ο����£�https://www.cnblogs.com/ferryman/p/13170057.html
 * ����1��Ϊʲô JDK ��̬����Ҫ���ڽӿ�ʵ�֣������ǻ��ڼ̳���ʵ�֣�
 *        ��Ϊ JDK ��̬�������ɵĶ���Ĭ���Ǽ̳� Proxy ��Java ��֧�ֶ�̳У����� JDK ��̬����Ҫ���ڽӿ���ʵ�֡�
 * ����2��JDK ��̬�����У�Ŀ���������Լ�����һ���������ᾭ���������ô��
 *        �ڲ����÷���ʹ�õĶ�����Ŀ������������õķ������ᾭ���������
 */
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
