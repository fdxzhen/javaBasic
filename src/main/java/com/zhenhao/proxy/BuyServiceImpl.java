package com.zhenhao.proxy;

public class BuyServiceImpl implements  IBuyService {
    @Override
    public void buyItem(int userId) {
        System.out.println("С�ͺҪ������С�ͺ��id�ǣ� " + userId);
        refund(userId);
    }
    @Override
    public void refund(int nums) {
        System.out.println("��Ʒ���������ˣ���Ҫ�˿�˿����� ��" + nums);
    }
}
