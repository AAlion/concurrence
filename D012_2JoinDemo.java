package com;

/**
 * 协作 join的使用
 * 如果一个线程实例A执行了threadB.join(),
 * 其含义是：当前线程A会等待threadB线程终止后threadA才会继续执行
 *
 * 下面的例子中一个创建了10个线程，每个线程都会等待前一个线程结束才会继续运行。
 */
public class D012_2JoinDemo {
    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread(); //
        for (int i = 1; i <= 100; i++) {
            Thread curThread = new JoinThread(previousThread);
            curThread.start();

            previousThread = curThread;
        }
    }

    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + "terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}


