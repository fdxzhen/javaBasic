package com.zhenhao.proxy;

public class BuyServiceImpl implements  IBuyService {
    @Override
    public void buyItem(int userId) {
        System.out.println("小李不秃要买东西！小李不秃的id是： " + userId);
        refund(userId);
    }
    @Override
    public void refund(int nums) {
        System.out.println("商品过保质期了，需要退款，退款数量 ：" + nums);
    }
}
