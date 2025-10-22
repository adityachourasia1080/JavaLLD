package JavaLearning.Thread.MonitorLock.ProducerConsumerQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerQueue {

    int size;
    Queue<Integer> q;

    public ProducerConsumerQueue(int size){
        this.size=size;
        q= new LinkedList<>();
    }

    public synchronized void produceItems(int item) throws Exception{
        while(q.size()==size){
            System.out.println("Queue is full:Producer has to wait for consumer to consume items");
            wait();
        }
        System.out.println("Producer :"+item);
        q.add(item);
        notifyAll();
    }

    public synchronized int consumeItems() throws Exception{
        while(q.isEmpty()){
            System.out.println("Queue is Empty: Have to wait for producer to produce items");
            wait();
        }
        int item= q.poll();
        System.out.println("Consumer :"+item);
        notifyAll();
        return item;
    }
}
