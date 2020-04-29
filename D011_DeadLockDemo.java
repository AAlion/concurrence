package com;

/**
 * 死锁示例
 *
 * 开启了两个线程threadA, threadB,
 * 其中threadA占用了resource_A, 并等待被threadB释放的resource _B
 * threadB占用了resource _B正在等待被threadA释放的resource _A
 * 因此threadA,threadB出现线程安全的问题，形成死锁。
 */
public class D011_DeadLockDemo {

    private static String resourceA ="A";

    private static String resourceB="B";

    public static void main(String[] args) {
        deadLock();
    }

    public static void deadLock(){
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(resourceA){
                    System.out.println("get resource A");

                    try {
                        Thread.sleep(3000);
                        synchronized(resourceB){
                            System.out.println("get resource B");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println("get resource B");

                    synchronized (resourceA){
                        System.out.println("get resource A");
                    }
                }


            }
        });

        threadA.start();
        threadB.start();
    }
}
