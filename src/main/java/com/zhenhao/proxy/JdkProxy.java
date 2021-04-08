package com.zhenhao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object target;
    public JdkProxy(Object target) {
        this.target = target;
    }
    // ������ǿ
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args);
        Object result = method.invoke(target,args);
        after(args);
        return result;
    }
    private void after(Object result) { System.out.println("���÷�����ִ�У�������" ); }
    private void before(Object[] args) { System.out.println("���÷���ǰִ�У�������" ); }

    /**
     * java�Ķ�̬����Proxy.newProxyInstance
     * @param <T>
     * @return
     */
    // ��ȡ�������
    public <T> T getProxy(){
        /**
         * loader  ���ĸ��������ȥ���ش������
         * interfaces ��̬��������Ҫʵ�ֵĽӿ�
         * h  ��̬��������ִ�е�ʱ�򣬻����this�����invokeִ��
         */
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
}
