package com.zhenhao.threadPool;

public class Test {

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(5);
        for (int i = 0; i < 20; i++) {
            myThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "ִ����");
                }
            });
            System.out.println("�̳߳��߳�����====��" + myThreadPool.getThreads().size());
            System.out.println("�̳߳صȴ���������=��" + myThreadPool.getTaskQueue().size());
        }

    }
}
