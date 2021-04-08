package com.zhenhao.threadPool;

import java.util.concurrent.ArrayBlockingQueue;

public class MyThread extends Thread {

    private Runnable task;
    private ArrayBlockingQueue<Runnable> taskQueue; //线程池队列

    //构造方法传入参数
    public MyThread(Runnable task, ArrayBlockingQueue<Runnable> taskQueue) {
        this.task = task;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true){
            if(task != null){
                task.run();
                task = null;
            }else {
                Runnable runnable = taskQueue.poll();
                if(runnable != null){
                    runnable.run();
                }
            }
        }
    }
}
