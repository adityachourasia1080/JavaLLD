package JavaLearning.Thread.CustomLock.Semaphor;

import java.util.concurrent.Semaphore;

public class Main {
    public  static void main(String[] args){
        SharedResource resource = new SharedResource();
        Semaphore lock = new Semaphore(2);  // 2 threads can acquire lock

        Thread th1= new Thread(()->{resource.produce(lock);});
        Thread th2 = new Thread(()->{resource.produce(lock);});
        Thread th3 = new Thread(()->{resource.produce(lock);});
        Thread th4= new Thread(()->{resource.produce(lock);});

        th1.start();
        th2.start();
        th3.start();
        th4.start();


    }
}
