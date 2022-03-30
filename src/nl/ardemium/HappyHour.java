package nl.ardemium;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class HappyHour implements IObservable {

    private final LocalTime localTime = LocalTime.now();
    private final LocalDate localDate = LocalDate.now();
    private final ArrayList<Dish> happyHourDish = new ArrayList<>();
    private final ArrayList<Boolean> happy = new ArrayList<>();
    private static int happyHour = 15;

    public static void setHappyHour(int newHappyHour) {
        happyHour = newHappyHour;
    }

    public static int getHappyHour() {
        return happyHour;
    }

    @Override
    public void registerObserver(Dish dish) {
        happyHourDish.add(dish);
        happy.add(false);
    }

    @Override
    public void notifyObserver() {
        int counter = 0;
        for (Dish d :
                happyHourDish) {
            if (d.getHappyHour().contains(String.format("%s", localDate.getDayOfWeek()))) {
                if (!happy.get(counter) && localTime.getHour() == happyHour) {
                    d.update(d.getPrice() * 0.5);
                    happy.set(counter, true);
                }
                if ((localTime.getHour() == (1 + happyHour))) {
                    d.update(d.getPrice() * 2);
                    happy.set(counter, false);
                }
            }
            counter++;
        }
    }

    @Override
    public void removeObserver(Dish dish) {
        happyHourDish.remove(dish);
    }
}
