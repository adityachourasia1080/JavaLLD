package JavaLearning.Thread.CustomLock.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class Main {

    public static void main(String[] args){
        SharedResource resource = new SharedResource();
        StampedLock lock = new StampedLock();

        Thread th1= new Thread(()-> {resource.producer(lock);});

        Thread th2= new Thread(()->{resource.consumer(lock);});

        th1.start();
        th2.start();

        //since in producer thread is sleeping for 6 sec consumer has
        // updatd the value so the row version/status for that data hs ben incremented
    }
}
