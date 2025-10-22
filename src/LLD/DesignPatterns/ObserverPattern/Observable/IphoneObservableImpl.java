package LLD.DesignPatterns.ObserverPattern.Observable;

import LLD.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{

    private List<NotificationAlertObserver> observerList;
    private int stockCount;

    public IphoneObservableImpl(){
        observerList= new ArrayList<>();
        stockCount=0;
    }

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer: observerList){
            observer.update();
        }

    }

    @Override
    public void setStockCount(int newStockAdded) {
        if (stockCount==0) notifySubscribers(); // As stock count is zero when newStockAdded i will notify thus this logic
        stockCount+=newStockAdded;
    }

    @Override
    public int getData() {
        return stockCount;
    }
}
