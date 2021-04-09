package com.zhenhao.proxy.staticProxy;


//淘宝是一个商家,代理金士顿U盘的销售
public class TaoBao implements UsbSell {
    //  声明 商家代理的厂家具体是谁
    private UsbKingFactory factory = new UsbKingFactory();

    @Override
// 实现销售U盘功能
    public float sell(int amount) {
//  向厂家发送订单,告诉厂家,我买了U盘,厂家发货
//  发送给工厂,我需要的订单,返回报价
        float price = factory.sell(amount);
//  商家需要加价也就是代理要增加价格
        price = price + 25;
//在目标类的方法调用后,你做的其他功能,都是增强的意思
        System.out.println("淘宝再给你返回一个优惠券,或者红包");
//  增加的价格
        return price;
    }
}

