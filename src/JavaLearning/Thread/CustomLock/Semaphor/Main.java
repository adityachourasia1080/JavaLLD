package JavaLearning.Thread.CustomLock.Semaphor;

import java.util.concurrent.Semaphore;

public class Main {
    public  static void main(String[] args){
        SharedResource resource = new SharedResource();
        Semaphore lock = new Semaphore(2);  // 2 threads can acquire lock

        for (int i = 1; i <= 10; i++) {
            final int threadId = i;
            new Thread(() -> resource.produce(lock)).start();
        }


    }
}
