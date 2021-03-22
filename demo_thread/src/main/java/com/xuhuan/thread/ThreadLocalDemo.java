package com.xuhuan.thread;

import java.util.Random;

/**
 * 线程范围内的共享数据
 * 使用jdk自带工具实现
 */
public class ThreadLocalDemo {

    //单个共享数据
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    //多个共享数据
    private static ThreadLocal<MyThreadScopeData> threadScopeDataLocal = new ThreadLocal<MyThreadScopeData>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println("线程名称：" + Thread.currentThread().getName() + " data:" + data);
                    //单个共享变量
                    x.set(data);
                    //多个共享变量
                    MyThreadScopeData myData = new MyThreadScopeData("name_" + data, data);
                    threadScopeDataLocal.set(myData);
                    new A().getData();
                    new B().getData();
                }
            }).start();
        }
    }

    static class A {
        public void getData() {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " A getData():" + x.get());
            MyThreadScopeData data = threadScopeDataLocal.get();
            System.out.println("线程名称：" + Thread.currentThread().getName() + " A myThreadScopeData():" + data.toString());
        }
    }

    static class B {
        public void getData() {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " B getData():" + x.get());
            MyThreadScopeData data = threadScopeDataLocal.get();
            System.out.println("线程名称：" + Thread.currentThread().getName() + " B myThreadScopeData():" + data.toString());
        }
    }
}

class MyThreadScopeData {
    private String name;
    private int age;

    public MyThreadScopeData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyThreadScopeData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}