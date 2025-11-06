package JavaLearning.Thread.OnObjectSynchronised.MonitorLock.ThreadJoin;

public class SharedResource {

    boolean isItemAvailable;
    public SharedResource(){
        //do nothing constructor
    }

    public synchronized void acquire() throws InterruptedException {
        while(isItemAvailable){
            System.out.println("wait for item to release");
            wait();
        }
        isItemAvailable=true;
        Thread.sleep(7000);
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while(!isItemAvailable){
            System.out.println("wait for item to acquire");
            wait();
        }
        isItemAvailable=false;
        notify();
    }
}
