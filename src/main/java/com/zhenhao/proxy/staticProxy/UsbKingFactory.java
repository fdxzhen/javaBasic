package com.zhenhao.proxy.staticProxy;

//Ŀ����:��ʿ�ٳ���,�������û��ĵ�������
public class UsbKingFactory implements UsbSell {
    /**
     * ����һ������ ���� amount:��ʾһ�ι��������,��ʱ����
     * ����ֵ��ʾһ��u�̵ļ۸�
     *
     * @param amount
     * @return
     */
    @Override
//һ��128G��U����85Ԫ.
// ���ڸ���amount,����ʵ�ֲ�ͬ�ļ۸�,����10000��,������80,50000��75
    public float sell(int amount) {
        return 85.0f * amount;
    }
}


