package JavaLearning.MultiThreading.Concurrency.Thread.AtomicVariable;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        Thread t1= new Thread(()->{
            for (int i=0;i<200;i++) sharedResource.increment();
        });

        Thread t2= new Thread(()->{
            for (int i=0;i<200;i++) sharedResource.increment();
        });

        t1.start();
        t2.start();

        Thread.sleep(5000);
        sharedResource.printValue();

        //Also try without atomic variable u will not get 400
    }
}
