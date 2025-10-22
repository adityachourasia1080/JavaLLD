package JavaLearning.Thread.MonitorLock.ProducerConsumerQueue;

public class Main {

    static void main(String[] args){
        ProducerConsumerQueue producerConsumerQueue = new ProducerConsumerQueue(3);
        Thread th1= new Thread(()->{
            try{
                for (int i=0;i<=8;i++){
                    producerConsumerQueue.produceItems(i);
                }
            }catch(Exception e){
                //exception will be thrown
            }
        });

        Thread th2= new Thread(()->{
            try{
                for (int i=0;i<=8;i++){
                    producerConsumerQueue.consumeItems();
                }
            }catch(Exception e){
                //exception will be thrown
            }
        });

        th1.start();
        th2.start();

    }
}
