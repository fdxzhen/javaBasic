package com.zhenhao.threadPool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class MyThreadPool {

    private ArrayList<Thread> threads;  //�̳߳�
    private ArrayBlockingQueue<Runnable> taskQueue; //�̳߳ض���
    private int threadNum; //�̳߳س�ʼ���߳���
    private int workThreadNum;  //�����е��߳���


    public MyThreadPool(int initPoolNum) {
        threadNum = initPoolNum;
        threads = new ArrayList<>(initPoolNum);
        //������г�ʼ��Ϊ�̳߳��߳������ı�
        taskQueue = new ArrayBlockingQueue<>(initPoolNum * 4);

        threadNum = initPoolNum;
        workThreadNum = 0;
    }

    public synchronized void execute(Runnable runnable) {

        //�̳߳�δ����ÿ����һ����������һ���߳�
        if (workThreadNum < threadNum) {
            MyThread myThead = new MyThread(runnable, taskQueue);
            myThead.start();
            threads.add(myThead);
            workThreadNum++;
        }
        //�̳߳�����������������У��ȴ��п����߳�ʱִ��
        else {
        //�����������޷����ʱ���ܾ�����
            if (!taskQueue.offer(runnable)) {
                //rejectTask();
                System.out.println("�̳߳�����");
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
