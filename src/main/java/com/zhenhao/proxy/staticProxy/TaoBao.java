package com.zhenhao.proxy.staticProxy;


//�Ա���һ���̼�,�����ʿ��U�̵�����
public class TaoBao implements UsbSell {
    //  ���� �̼Ҵ���ĳ��Ҿ�����˭
    private UsbKingFactory factory = new UsbKingFactory();

    @Override
// ʵ������U�̹���
    public float sell(int amount) {
//  �򳧼ҷ��Ͷ���,���߳���,������U��,���ҷ���
//  ���͸�����,����Ҫ�Ķ���,���ر���
        float price = factory.sell(amount);
//  �̼���Ҫ�Ӽ�Ҳ���Ǵ���Ҫ���Ӽ۸�
        price = price + 25;
//��Ŀ����ķ������ú�,��������������,������ǿ����˼
        System.out.println("�Ա��ٸ��㷵��һ���Ż�ȯ,���ߺ��");
//  ���ӵļ۸�
        return price;
    }
}

