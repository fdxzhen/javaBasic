package com.zhenhao.proxy.staticProxy;

/**
 * ���������ٴ��ܽᾲ̬��������ɵĹ���:
 * ==============Ŀ�����з����ĵ��ù�����ǿ==========
 *
 * usbSell �ӿڶ�����һ����������ʵ��
 * UsbKingFactory ����ʵ�ֵ�useSell�ӿڣ����Ҳ����ܿͻ���������
 * TaoBao ʵ�ʵ��ù����Ĺ��򷽷�������ʵ�ֵ�useSell�ӿ����дӹ��̻�ȡ����Ʒԭ�ۣ���ԭ�ۻ����ϼ��������������
 *
 * �ο����£�https://blog.csdn.net/weixin_46801232/article/details/109307609
 */
public class ShopMain {
    public static void main(String[] args) {
        //����������̼��Ա�����
        TaoBao taoBao = new TaoBao();
        //��ֻ���Ա���һ����Ʒ,�õ�����
        float price = taoBao.sell(2);
        System.out.println("����һ����Ʒ.�Ա��ı���Ϊ: " + price);
    }
}
