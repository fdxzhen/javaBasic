package com.zhenhao.proxy.cglibDynamicProxy;


/**
 * ��Ҫ����cglib
 *ҵ���ࣨ����Ҫ����ӿڣ�
 * cglib�����ࣨʵ�ֽӿ�MethodInterceptor��
 * �ο����£�https://www.cnblogs.com/muscleape/p/9018308.html
 */
public class TestCglib {
	public static void main(String[] args) {
		UserServiceCglib cglib = new UserServiceCglib();
		UserServiceImpl bookFacedImpl = (UserServiceImpl) cglib.getInstance(new UserServiceImpl());
		bookFacedImpl.addUser();
	}
}
