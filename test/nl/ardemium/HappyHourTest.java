package nl.ardemium;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HappyHourTest {

    @Test
    void notifyObserver() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        if(localTime.getHour() == HappyHour.getHappyHour() && Menu.getMenuInstance().getDishList().get(0).getHappyHour().contains(String.format("%s",localDate.getDayOfWeek()))){
            double price = Menu.getMenuInstance().getDishList().get(0).getPrice();
            assertEquals(10/2,price);
        }
        else{
            double price = Menu.getMenuInstance().getDishList().get(0).getPrice();
            assertEquals(10,price);
        }
        HappyHour.setHappyHour(localTime.getHour());
        if(localTime.getHour() == HappyHour.getHappyHour() && Menu.getMenuInstance().getDishList().get(0).getHappyHour().contains(String.format("%s",localDate.getDayOfWeek()))){
            double price = Menu.getMenuInstance().getDishList().get(0).getPrice();
            assertEquals(10/2,price);
        }
        else{
            double price = Menu.getMenuInstance().getDishList().get(0).getPrice();
            assertEquals(10,price);
        }
    }
}