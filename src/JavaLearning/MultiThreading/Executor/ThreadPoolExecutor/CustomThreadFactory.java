package JavaLearning.MultiThreading.Executor.ThreadPoolExecutor;

import java.util.concurrent.ThreadFactory;

// two way for thread Factory
// first is Executors.defaultThreadFactory()
// second way is below creating custom thread factory
class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}
