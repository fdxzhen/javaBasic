package com.zhenhao.threadPool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class MyThreadPool {

    private ArrayList<Thread> threads;  //线程池
    private ArrayBlockingQueue<Runnable> taskQueue; //线程池队列
    private int threadNum; //线程池初始化线程数
    private int workThreadNum;  //工作中的线程数


    public MyThreadPool(int initPoolNum) {
        threadNum = initPoolNum;
        threads = new ArrayList<>(initPoolNum);
        //任务队列初始化为线程池线程数的四倍
        taskQueue = new ArrayBlockingQueue<>(initPoolNum * 4);

        threadNum = initPoolNum;
        workThreadNum = 0;
    }

    public synchronized void execute(Runnable runnable) {

        //线程池未满，每加入一个任务则开启一个线程
        if (workThreadNum < threadNum) {
            MyThread myThead = new MyThread(runnable, taskQueue);
            myThead.start();
            threads.add(myThead);
            workThreadNum++;
        }
        //线程池已满，放入任务队列，等待有空闲线程时执行
        else {
        //队列已满，无法添加时，拒绝任务
            if (!taskQueue.offer(runnable)) {
                //rejectTask();
                System.out.println("线程池已满");
            }
        }
    }

    public ArrayList<Thread> getThreads() {
        return threads;
    }

    public void setThreads(ArrayList<Thread> threads) {
        this.threads = threads;
    }

    public ArrayBlockingQueue<Runnable> getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(ArrayBlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public int getWorkThreadNum() {
        return workThreadNum;
    }

    public void setWorkThreadNum(int workThreadNum) {
        this.workThreadNum = workThreadNum;
    }
}
