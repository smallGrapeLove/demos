package com.xuhuan.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内的共享数据
 * 自定义实现
 */
public class ThreadScopeShareData {

    private static Map<Thread, Integer> threadMap = new HashMap<Thread, Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println("线程名称：" + Thread.currentThread().getName() + " data:" + data);
                    threadMap.put(Thread.currentThread(), data);
                    new A().getData();
                    new B().getData();
                }
            }).start();
        }
    }

    static class A {
        public void getData() {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " A getData():" + threadMap.get(Thread.currentThread()));
        }
    }

    static class B {
        public void getData() {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " B getData():" + threadMap.get(Thread.currentThread()));
        }
    }
}
