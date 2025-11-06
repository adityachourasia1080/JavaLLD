package JavaLearning.Thread.CustomLock.Condition.ProducerConsumerProblem;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    public void produce(ReentrantLock lock , Condition condition){
        try{
            lock.lock();
            System.out.println("Producer lock acquired by : "+ Thread.currentThread().getName());
            if(isAvailable){
                System.out.println("Producer thread is waiting : "+ Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            System.out.println("Producer lock released by : "+ Thread.currentThread().getName());
        }
    }

    public void consumer(ReentrantLock lock , Condition condition){
        try{
            lock.lock();
            System.out.println("Consumer lock acquired by : "+ Thread.currentThread().getName());
            if(!isAvailable){
                System.out.println("Consumer thread is waiting : "+ Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            System.out.println("Consumer lock released by : "+ Thread.currentThread().getName());
        }
    }
}
