package com.xuhuan.thread;

/**
 * 实现功能：
 * 子线程循环10次，接着主线程循环20次，
 * 接着又回到子线程循环10次，接着再回到主线程又循环20次，
 * 如此循环50次，请写出程序。
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        final BusinClass businClass = new BusinClass();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    businClass.fu(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            businClass.zi(i);
        }
    }
}

class BusinClass {
    boolean canRunFu = false;

    public synchronized void fu(int i) {
        while (!canRunFu) {
            try {
                //当前线程等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 20; j++) {
            System.out.println("主线程循环次数：" + j + "，交替执行次数：" + i);
        }
        canRunFu = false;
        //唤醒子线程
        this.notify();
    }

    public synchronized void zi(int i) {
        while (canRunFu) {
            try {
                //当前线程等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("子线程循环次数：" + j + "，交替执行次数：" + i);
        }
        canRunFu = true;
        //唤醒父线程
        this.notify();
    }
}
