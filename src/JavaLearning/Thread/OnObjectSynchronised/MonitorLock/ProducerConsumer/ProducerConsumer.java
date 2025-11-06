package JavaLearning.Thread.OnObjectSynchronised.MonitorLock.ProducerConsumer;

public class ProducerConsumer {

    int size;
    int maxQueueSize;


    public ProducerConsumer(int maxQueueSize){
        this.maxQueueSize=maxQueueSize;
    }
    public synchronized void produceItems(){
        try {
            while(size== maxQueueSize){
                System.out.println("Producer is waiting for consumer to consume a item");
                wait();
            }

            size++;
            System.out.println("Producer produced the item");
            notifyAll();

        }catch(Exception e){
            //exception to be thrown
        }
    }

    public synchronized void consumeItems(){

        try {
            while (size==0) {
                System.out.println("Consumer is waiting as no items are present");
                wait();

            }
            System.out.println("Consumer thread consume the item");
            size--;
            notifyAll();
        }catch (Exception e){
            //exception to be catch here
        }
    }
}
