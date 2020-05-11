package com;

public class D031_12SynchronizedDemo {
    public static void main(String[] args) {
        //同步代码块，锁住的是类对象，并且还有一个同步静态方法，锁住的依然是该类的类对象
        synchronized (D031_12SynchronizedDemo.class){
        }
        method();
    }
    private static void method(){

    }
}
