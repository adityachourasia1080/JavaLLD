package JavaLearning.Thread.OnObjectSynchronised.MonitorLock.StopSuspendDeprecated;

public class Main {

    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource();

        Thread th1= new Thread(()->{
            try{
                sharedResource.acquire();
            }catch(Exception ex){
                //throws Exception
            }
        });

        Thread th2= new Thread(()->{
            try{
                sharedResource.release();
            }catch(Exception ex){
                //throws Exception
            }
        });

        th1.start();
        th2.start();

        try{
            Thread.sleep(8000);
        }catch(Exception ex){
            //throws Exception
        }
        
    }

}
