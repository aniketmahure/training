package org.designPatterns.singleton;

public class singletonExample{
    public static void main(String[] args) {
        Runnable task=() -> {
            Logger logger= Logger.getInstance();
            logger.log(Thread.currentThread().getName()+" logger is working");
        };
        //thread creation
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}