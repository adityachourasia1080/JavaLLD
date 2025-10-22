package JavaLearning.Thread.MonitorLock.addConsumeBasic;

public class SharedResource {

    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent= true;
        System.out.println("Producer thread calling notify method");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consumer thread inside consumeItem method");
        while(!isItemPresent){
            try{
                System.out.println("Consumer thread is waiting");
                wait();// release all the monitor lock here
            }catch(Exception e){
                //exception goes here
            }
        }
        System.out.println("Consumer thread consume the items");
        isItemPresent=false;
    }

}
