package JavaLearning.Thread.CustomLock.ReadWriteLock.Practise;

public class Main {

    public static void main(String[] args){

        SharedResource resource1 = new SharedResource();
        SharedResource resource2= new SharedResource();

        Thread th1= new Thread(()->resource2.read());
        Thread th2= new Thread(()->resource1.read());
        Thread th3= new Thread(()->resource2.write(4));
        Thread th5 = new Thread(()->resource1.write(5));
        Thread th4= new Thread(()->resource1.read());

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
    }

}
