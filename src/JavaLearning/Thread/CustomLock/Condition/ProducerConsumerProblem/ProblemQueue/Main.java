package JavaLearning.Thread.CustomLock.Condition.ProducerConsumerProblem.ProblemQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource(6);
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                resource.producer(lock, condition,i);
            }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                resource.consumer(lock, condition);
            }
        });

        th1.start();
        th2.start();
    }
}
