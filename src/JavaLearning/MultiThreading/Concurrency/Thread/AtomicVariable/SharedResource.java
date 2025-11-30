package JavaLearning.MultiThreading.Concurrency.Thread.AtomicVariable;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {
    AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        counter.addAndGet(1);
    }

    public void printValue(){
        System.out.println("Value of counter is :" + counter);
    }

}
