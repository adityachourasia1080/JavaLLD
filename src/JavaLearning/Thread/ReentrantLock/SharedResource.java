package JavaLearning.Thread.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;

    public void produce(ReentrantLock lock){
        try{
            lock.lock();
            System.out.println("Lock Acquired by :"+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }
        catch (Exception e){}
        finally{
            lock.unlock();
            System.out.println("Lock Release by :"+ Thread.currentThread().getName());

        }
    }
}
