package JavaLearning.Thread.OnObjectSynchronised.MonitorLock.ProducerConsumer;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String args[]){
        ProducerConsumer producerConsumer = new ProducerConsumer(7);
        Thread producerThread = new Thread(()-> {
            try{
                Thread.sleep(10000);
            }catch(Exception e){
                //exception
            }
            producerConsumer.produceItems();

        });

        Thread consumerThread = new Thread(()-> producerConsumer.consumeItems());

        producerThread.start();
        consumerThread.start();

    }

}
