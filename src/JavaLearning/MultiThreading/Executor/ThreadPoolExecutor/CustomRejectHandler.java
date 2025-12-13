package JavaLearning.MultiThreading.Executor.ThreadPoolExecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

//two ways for reject handler
//first is  new ThreadPoolExecutor.DiscardPolicy(), many
//second is as below
class CustomRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}
