package com.zhenhao.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zhenhao on 2021/4/8 14:42
 * Content:
 */
public class WriteExample {

    public static void main(String[] args) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append("ABCDEFGHIGKLMNOPQRSEUVWXYZ");
        }

        final String content = stringBuilder.toString();

        final String filepath1 = "write1.txt";
        final String filepath2 = "write2.txt";
        final String filepath3 = "write3.txt";
        final String filepath4 = "write4.txt";
        final String filepath5 = "write5.txt";
        final String filepath6 = "write6.txt";


        //方法1 ： 使用FileWriter写文件
        long stime1 = System.currentTimeMillis();
        fileWriterTest(filepath1, content);
        long etime1 = System.currentTimeMillis();
        System.out.println("FileWriter写入用时:" + (etime1 - stime1));

        //方法2 ： 使用BufferedWriter写文件
        long stime2 = System.currentTimeMillis();
        bufferedWriterTest(filepath2, content);
        long etime2 = System.currentTimeMillis();
        System.out.println("BufferedWriter写入用时:" + (etime2 - stime2));

        //方法3 ： 使用PrintWriter写文件
        long stime3 = System.currentTimeMillis();
        printWriterTest(filepath3, content);
        long etime3 = System.currentTimeMillis();
        System.out.println("PrintWriter写入用时:" + (etime3 - stime3));

        //方法4 ： 使用FileOutputWriter写文件
        long stime4 = System.currentTimeMillis();
        fileOutputWriterTest(filepath4, content);
        long etime4 = System.currentTimeMillis();
        System.out.println("FileOutputWriter写入用时:" + (etime4 - stime4));

        //方法5 ： 使用BufferedOutStream写文件
        long stime5 = System.currentTimeMillis();
        bufferedOutStreamTest(filepath5, content);
        long etime5 = System.currentTimeMillis();
        System.out.println("BufferedOutStream写入用时:" + (etime5 - stime5));

        //方法6 ： 使用Files写文件
        long stime6 = System.currentTimeMillis();
        filesTest(filepath6, content);
        long etime6 = System.currentTimeMillis();
        System.out.println("BufferedOutStream写入用时:" + (etime6 - stime6));

    }

    private static void filesTest(String filepath1, String content) throws IOException {
        Files.write(Paths.get(filepath1), content.getBytes());
    }

    private static void bufferedOutStreamTest(String filepath1, String content) throws IOException {

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filepath1));
        bufferedOutputStream.write(content.getBytes());

    }

    private static void fileOutputWriterTest(String filepath1, String content) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filepath1);
        fileOutputStream.write(content.getBytes());
    }

    private static void printWriterTest(String filepath1, String content) throws IOException {

        PrintWriter printWriter = new PrintWriter(new FileWriter(filepath1));
        printWriter.print(content);

    }

    private static void bufferedWriterTest(String filepath1, String content) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath1));
        bufferedWriter.write(content);
    }

    private static void fileWriterTest(String filepath1, String content) throws IOException {

        FileWriter fileWriter = new FileWriter(filepath1);
        fileWriter.append(content);
    }
}
