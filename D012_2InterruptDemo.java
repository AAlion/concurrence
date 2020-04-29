package com;

/**
 * 中断 interrupted的使用
 *
 * 两个线程分别为sleepThread和BusyThread,
 * sleepThread睡眠1s，BusyThread执行死循环。
 * 分别对着两个线程进行中断操作，
 * 看出sleepThread抛出InterruptedException后清除标志位，而busyThread就不会清除标志位。
 *
 */
public class D012_2InterruptDemo {
    public static void main(String[] args) {
        // sleepThread 睡眠 1000ms
        final Thread sleepThread = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        // busyzThread一直执行死循环
        Thread busyThread = new Thread(){
            @Override
            public void run(){
                while(true);
            }

        };
        sleepThread.start();
        busyThread.start();

        sleepThread.interrupt();
        busyThread.interrupt();

        while(sleepThread.isInterrupted()){
            System.out.println("sleepThread isInterrupted:" + sleepThread.isInterrupted());
            System.out.println("busyThread isInterrupted:" + busyThread.isInterrupted());
        }
    }
}
