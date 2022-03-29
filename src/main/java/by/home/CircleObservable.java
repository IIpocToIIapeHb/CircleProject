package by.home;

import by.home.entity.Circle;
import by.home.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class CircleObservable extends Circle implements Observable {

    private final Integer id;

    private  final List<Observer> observers = new ArrayList<>();

    public CircleObservable(IdGenerator id, Point point, double radios) {
        super(point, radios);
        this.id = id.getId();
    }

    public Integer getId() {
        return id;
    }

    @Override
  public void setPoint(Point point) {
        super.setPoint(point);
        notifyObservers();
    }
    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
        notifyObservers();
    }


    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:observers){
            observer.update(this);
        }

    }
}
