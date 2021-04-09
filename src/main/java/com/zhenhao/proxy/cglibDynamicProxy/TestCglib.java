package com.zhenhao.proxy.cglibDynamicProxy;


/**
 * 需要引入cglib
 *业务类（不需要定义接口）
 * cglib代理类（实现接口MethodInterceptor）
 * 参考文章：https://www.cnblogs.com/muscleape/p/9018308.html
 */
public class TestCglib {
	public static void main(String[] args) {
		UserServiceCglib cglib = new UserServiceCglib();
		UserServiceImpl bookFacedImpl = (UserServiceImpl) cglib.getInstance(new UserServiceImpl());
		bookFacedImpl.addUser();
	}
}
