package JavaLearning.MultiThreading.Executor.ThreadPoolExecutor;

import java.sql.SQLSyntaxErrorException;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){

// ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,
//               TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

        //customized with Thread factory and rejectedExecutorHandler
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(),new CustomRejectHandler());

        //then only keepAliveTime makes sense it will terminate Thread that is idle for this much time
        //executor.allowCoreThreadTimeOut(true);

        // Creating tasks to submit to thread pool executor(min thread =2 , max thread=4, queue size=2)
        for(int i=1;i<=8;i++){
            executor.submit(()->{
                try{
                    Thread.sleep(5000);
                }catch (Exception e){}

                System.out.println("Task processed :"+ Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}


// two way for thread Factory
// first is Executors.defaultThreadFactory()
// second way is below creating custom thread factory
class CustomThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread th= new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}


//two ways for reject handler
//first is  new ThreadPoolExecutor.DiscardPolicy(), many
//second is as below
class CustomRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}


//Interview Question
//why u have taken corePoolsize as 2 why not 10,15 or any other no what's hte logic?
//how will u decide min. max pool size
//Answer in Notes

