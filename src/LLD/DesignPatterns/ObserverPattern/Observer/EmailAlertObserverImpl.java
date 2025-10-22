package LLD.DesignPatterns.ObserverPattern.Observer;

import LLD.DesignPatterns.ObserverPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    String emailId;
    StockObservable obj;

    public EmailAlertObserverImpl(String emailId,StockObservable obj){
        this.emailId=emailId;
        this.obj= obj;
    }

    @Override
    public void update() {
        sendMail(emailId, "Hurry stock piled up");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("mail sent to: "+ emailId + " with msg " + msg);
        //can write other logic
    }
}
