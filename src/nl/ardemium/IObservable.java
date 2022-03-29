package nl.ardemium;

public interface IObservable {
    void registerObserver(Dish dish);

    void notifyObserver();

    void removeObserver(Dish dish);
}