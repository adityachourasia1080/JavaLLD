package JavaLearning.Thread.CustomLock.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String []args){

        ReentrantLock lock1 = new ReentrantLock();
        SharedResource resource1= new SharedResource();
        Thread th1= new Thread(()->{
            resource1.produce(lock1);
        });

        SharedResource resource2= new SharedResource();
        Thread th2= new Thread(()->{
            resource2.produce(lock1);
        });

        th1.start();
        th2.start();

    }
}
