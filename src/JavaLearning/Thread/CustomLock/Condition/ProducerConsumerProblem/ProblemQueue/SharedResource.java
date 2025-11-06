package JavaLearning.Thread.CustomLock.Condition.ProducerConsumerProblem.ProblemQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    ArrayDeque<Integer>dq;
    int capacity;

    public SharedResource(int capacity){
        dq= new ArrayDeque<>();
        this.capacity=capacity;
    }

    public void producer(ReentrantLock lock, Condition condition,int value){
        try{
            lock.lock();
            System.out.println("Producer lock acquired by : "+ Thread.currentThread().getName());
            while(dq.size() == capacity){
                System.out.println("Queue Capacity is full waiting");
                condition.await();
            }
            dq.offer(value);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            System.out.println("Producer lock released by : "+ Thread.currentThread().getName());
        }
    }

    public void consumer(ReentrantLock lock, Condition condition){
        try{
            lock.lock();
            System.out.println("Consumer lock acquired by : "+ Thread.currentThread().getName());
            while(dq.isEmpty()){
                System.out.println("List is Empty waiting");
                condition.await();
            }
            dq.poll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            System.out.println("Consumer lock released by : "+ Thread.currentThread().getName());
        }
    }
}
