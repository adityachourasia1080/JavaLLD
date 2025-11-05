package JavaLearning.Thread.PessimisticLocks.MonitorLock.ThreadJoin;

public class Main {

    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource();

        Thread th1= new Thread(()->{
            try{
                System.out.println("Thread 1 is acquired");
                sharedResource.acquire();
                System.out.println("Thread 2 is released");
            }catch(Exception ex){
                //throws Exception
            }
        });


        th1.start();
        //try to see output commenting th1.join
        //so once th1.join is there main thread will only finish once th1 thread is done
        try{
            th1.join();
        }catch(Exception e){
            //exception
        }

        System.out.println("Main Thread Ended");


    }

}
