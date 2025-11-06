package JavaLearning.Thread.CustomLock.Semaphor;

import java.util.concurrent.Semaphore;

public class SharedResource {

    boolean isAvailable = false;

    public void produce(Semaphore lock){
        try{
            lock.acquire();
            System.out.println("Lock acquired by :" + Thread.currentThread().getName());
            isAvailable= true;
            Thread.sleep(4000);
        }
        catch (Exception ignored){}
        finally {
            lock.release();
            System.out.println("Lock release by :" + Thread.currentThread().getName());
        }
    }


}
