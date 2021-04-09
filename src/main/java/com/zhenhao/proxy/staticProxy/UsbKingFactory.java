package com.zhenhao.proxy.staticProxy;

//目标类:金士顿厂家,不接受用户的单独购买
public class UsbKingFactory implements UsbSell {
    /**
     * 定义一个方法 参数 amount:表示一次购买的数量,暂时不用
     * 返回值表示一个u盘的价格
     *
     * @param amount
     * @return
     */
    @Override
//一个128G的U盘是85元.
// 后期根据amount,可以实现不同的价格,例如10000个,单击是80,50000个75
    public float sell(int amount) {
        return 85.0f * amount;
    }
}


