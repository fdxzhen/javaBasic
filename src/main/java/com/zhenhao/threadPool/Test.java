package com.zhenhao.threadPool;

public class Test {

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(5);
        for (int i = 0; i < 20; i++) {
            myThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "执行中");
                }
            });
            System.out.println("线程池线程数量====》" + myThreadPool.getThreads().size());
            System.out.println("线程池等待队列数量=》" + myThreadPool.getTaskQueue().size());
        }

    }
}
