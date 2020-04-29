package com;

import java.util.concurrent.*;

/**
 * 新建一个线程的三种方式：
 *
 * 1.通过继承Thread类，重写run方法；
 *
 * 2.通过实现runable接口；
 *
 * 3.通过实现callable接口
 *
 */
public class D012_1CreateThreadDemo {

    public static void main(String[] args) {
        //1.继承Thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("1继承Thread");
                super.run();
            }

        };
        thread.start();

        //实现runable接口
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2实现runable接口");
            }
        });
        thread1.start();
    }

    //3.实现callable接口
    ExecutorService service = Executors.newSingleThreadExecutor();
    Future<String> future = service.submit(new Callable() {
        @Override
        public String call() throws Exception {
            return "3通过实现Callable接口";
        }

    });
    String result;
    {
        try {
            result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
