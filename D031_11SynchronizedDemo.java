package com;

/**
 * synchronized
 * 现象:
 * 开启了10个线程，每个线程都累加了1000000次，
 * 如果结果正确的话自然而然总数就应该是10 * 1000000 = 10000000。
 * 可就运行多次结果都不是这个数，而且每次运行结果都不一样。
 */
public class D031_11SynchronizedDemo implements Runnable {

    private static int count = 0;
//concurrence
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new D031_11SynchronizedDemo());
            thread.start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("result:" + count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
    }

}
