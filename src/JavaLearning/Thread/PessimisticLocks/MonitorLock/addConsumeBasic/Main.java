package JavaLearning.Thread.PessimisticLocks.MonitorLock.addConsumeBasic;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String args[]){
        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(()-> {
            try{
                Thread.sleep(10000);
            }catch(Exception e){
                //exception
            }
            sharedResource.addItem();

        });

        Thread consumerThread = new Thread(()->{
            sharedResource.consumeItem();
        });

        producerThread.start();
        consumerThread.start();

    }

}
