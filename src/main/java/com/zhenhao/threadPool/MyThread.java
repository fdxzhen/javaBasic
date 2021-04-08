package com.zhenhao.threadPool;

import java.util.concurrent.ArrayBlockingQueue;

public class MyThread extends Thread {

    private Runnable task;
    private ArrayBlockingQueue<Runnable> taskQueue; //�̳߳ض���

    //���췽���������
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
