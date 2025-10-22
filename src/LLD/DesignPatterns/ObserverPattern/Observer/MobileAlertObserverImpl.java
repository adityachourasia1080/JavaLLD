package LLD.DesignPatterns.ObserverPattern.Observer;

import LLD.DesignPatterns.ObserverPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    String username;
    StockObservable obj;

    public MobileAlertObserverImpl(String username,StockObservable obj){
        this.username=username;
        this.obj= obj;
    }

    @Override
    public void update() {
        sendMail(username,"Hurry stock piled up");
    }

    private void sendMail(String username, String msg) {
        System.out.println("username notification sent : "+ username+ " with msg " + msg);
        //can write other logic
    }
}
