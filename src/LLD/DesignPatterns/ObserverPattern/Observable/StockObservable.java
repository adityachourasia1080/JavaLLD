package LLD.DesignPatterns.ObserverPattern.Observable;

import LLD.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;

//comman interface to support all stock like iphone, Laptop, lamp etc
public interface StockObservable {

     void add(NotificationAlertObserver observer);
     void remove(NotificationAlertObserver observer);
     void notifySubscribers();
     void setStockCount(int newStockAdded);
     int getData();

}
