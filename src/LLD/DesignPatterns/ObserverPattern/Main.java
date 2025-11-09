package LLD.DesignPatterns.ObserverPattern;

import LLD.DesignPatterns.ObserverPattern.Observable.IphoneObservableImpl;
import LLD.DesignPatterns.ObserverPattern.Observable.StockObservable;
import LLD.DesignPatterns.ObserverPattern.Observer.EmailAlertObserverImpl;
import LLD.DesignPatterns.ObserverPattern.Observer.MobileAlertObserverImpl;
import LLD.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;

public class Main {

    public static void main(String[] args){
        StockObservable IphoneObservable= new IphoneObservableImpl();
        NotificationAlertObserver observer1= new EmailAlertObserverImpl("aditya@ge.com",IphoneObservable);
        NotificationAlertObserver observer2= new EmailAlertObserverImpl("Atharva@gmail.com",IphoneObservable);
        NotificationAlertObserver observer3= new MobileAlertObserverImpl("9511854174",IphoneObservable);

        IphoneObservable.add(observer1);
        IphoneObservable.add(observer2);
        IphoneObservable.add(observer3);
        System.out.println("Adding stock");
        IphoneObservable.setStockCount(4);

        IphoneObservable.setStockCount(6);  // no notification as prev stock is not zero
        System.out.println("Removing old stock as it is empty");
        IphoneObservable.setStockCount(-10); //old stock was 4+6 so to make it zeo -10
        System.out.println("Adding stock");
        IphoneObservable.setStockCount(100);  //Notification

    }
}
