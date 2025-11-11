package JavaLearning.Thread.CustomLock.ReadWriteLock.Practise;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//implement read and writee function on a data where read can only read it and write will change its value
public class SharedResource {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    int data=0;

    //mimics shared lock functionality
    public void read(){
        lock.readLock().lock();
        try{
            System.out.println("Shared lock is acquire on data "+ data +" by thread "+Thread.currentThread().getName());
            Thread.sleep(2000);
        }
        catch(Exception e){}
        finally{
            lock.readLock().unlock();
            System.out.println("Shared lock is released on data "+ data +" by thread "+Thread.currentThread().getName());
        }
    }

    //minics exclusive lock functionality
    public void write(int value){
        lock.writeLock().lock();
        try{
            System.out.println("Exclusive lock is acquire where initial value was "+ data +" curr value is "+ value+ " by thread "+Thread.currentThread().getName());
            data =value;
            Thread.sleep(2000);
        }
        catch(Exception e){}
        finally{
            System.out.println("Exclusive lock is release by thread "+Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
