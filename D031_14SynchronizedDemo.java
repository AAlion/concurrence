package com;

/**
 * 解决D031_11现象
 * 能够计算出正确的结果是因为在做累加操作时使用了同步代码块，
 * 这样就能保证每个线程所获得共享变量的值都是当前最新的值，
 * 如果不使用同步的话，就可能会出现A线程累加后，
 * 而B线程做累加操作有可能是使用原来的就值，即“脏值”。
 */

public class D031_14SynchronizedDemo implements Runnable {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new D031_14SynchronizedDemo());
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
        synchronized (D031_14SynchronizedDemo.class) {  //
            for (int i = 0; i < 10000000; i++) {
                count++;
            }
        }
    }

}
