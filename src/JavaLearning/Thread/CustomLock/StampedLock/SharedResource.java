package JavaLearning.Thread.CustomLock.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    int a=10;
    public void producer(StampedLock lock){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken Optimistic lock");
            a=11;
            Thread.sleep(6000);
            if (lock.validate(stamp)){
                System.out.println("Updated value Successfully");
            }
            else{
                System.out.println("Rollback of work");
                a=10; //rollback
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void consumer(StampedLock lock){
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by :" + Thread.currentThread().getName());

        try{
            System.out.println("Performing work");
            a=9;
        }
        finally{
            lock.unlockWrite(stamp);
            System.out.println("Write lock released by :" + Thread.currentThread().getName());
        }
    }

}
