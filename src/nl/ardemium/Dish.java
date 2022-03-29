package nl.ardemium;

public class Dish implements IObserver {

    private Integer dishNumber = 0;
    private final String name;
    private double price;
    private String happyHour;

    public Dish(String name, double price, String happyHour) {
        this.dishNumber = dishNumber++;
        this.name = name;
        this.price = price;
        this.happyHour = happyHour;
    }

    public Integer getDishNumber() {
        return dishNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHappyHour() {
        return happyHour;
    }

    public void setHappyHour(String happyHour) {
        this.happyHour = happyHour;
    }

    @Override
    public void update(double price) {
        this.price = price;
    }
}
