package com.zhenhao.proxy.staticProxy;

/**
 * 所以我们再次总结静态代理类完成的功能:
 * ==============目标类中方法的调用功能增强==========
 *
 * usbSell 接口定义了一个卖东西的实现
 * UsbKingFactory 另外实现的useSell接口，厂家不接受客户单独购买
 * TaoBao 实质调用工厂的购买方法。另外实现的useSell接口中有从工程获取的商品原价，在原价基础上加了利润进行售卖
 *
 * 参考文章：https://blog.csdn.net/weixin_46801232/article/details/109307609
 */
public class ShopMain {
    public static void main(String[] args) {
        //创建代理的商家淘宝对象
        TaoBao taoBao = new TaoBao();
        //我只向淘宝买一件产品,得到报价
        float price = taoBao.sell(2);
        System.out.println("购买一件产品.淘宝的报价为: " + price);
    }
}
