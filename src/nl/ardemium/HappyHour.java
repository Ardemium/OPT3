package nl.ardemium;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class HappyHour implements IObservable {

    private final LocalTime localTime = LocalTime.now();
    private final LocalDate localDate = LocalDate.now();
    private final ArrayList<Dish> happyHourDish = new ArrayList<>();
    private static int happyHour = 15;
    private boolean happy = false;

    public static void setHappyHour(int newHappyHour) {
        happyHour = newHappyHour;
    }

    public static int getHappyHour() {
        return happyHour;
    }

    @Override
    public void registerObserver(Dish dish) {
        happyHourDish.add(dish);
    }

    @Override
    public void notifyObserver() {
        for (Dish d :
                happyHourDish) {
            if (d.getHappyHour().contains(String.format("%s", localDate.getDayOfWeek())) && localTime.getHour() == happyHour) {
                if (!happy) {
                    d.update(d.getPrice() * 0.5);
                    happy = true;
                }
                if (localTime.getHour() == happyHour + 1) {
                    d.update(d.getPrice() * 2);
                    happy = false;
                }
            }
        }
    }

    @Override
    public void removeObserver(Dish dish) {
        happyHourDish.remove(dish);
    }
}
