package JavaLearning.Thread.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String []args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource resource = new SharedResource();
        
        Thread th1 = new Thread(() -> {
            resource.produce(lock);
        });

        Thread th2 = new Thread(() -> {
            resource.produce(lock);
        });

        SharedResource resource1 = new SharedResource();
        Thread th3= new Thread(()->{
            resource1.consume(lock);
        });
        th1.start();
        th2.start();
        th3.start();

    }




}
