package nl.ardemium;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Dish> menu;
    private static Menu instance;
    private static final HappyHour observer = new HappyHour();

    private Menu() {
        this.menu = initMenu();
    }

    public static Menu getMenuInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        observer.notifyObserver();
        return instance;
    }

    private ArrayList<Dish> initMenu(){
        ArrayList<Dish> menu = new ArrayList<>();
        ArrayList<String> name = ASON.stripValue("Name", "DatabaseGerechten");
        ArrayList<String> price = ASON.stripValue("Price", "DatabaseGerechten");
        ArrayList<String> happyhour = ASON.stripValue("HappyHour", "DatabaseGerechten");
        for (int i = 0; i < name.size(); i++) {
            menu.add(new Dish(name.get(i), Double.parseDouble(price.get(i)), happyhour.get(i)));
            if(!menu.get(i).getHappyHour().equals("")){
                observer.registerObserver(menu.get(i));
            }
        }
        return menu;
    }

    public void mkDish(String name, double price, String happyHour){
        ASON.makeObject("Name",name,"Price",String.format("%.2f", price),"HappyHour",happyHour,"DatabaseGerechten");
        this.menu = initMenu();
    }

    public void rmDish(Integer dishNumber){
        menu.removeIf(d -> d.getDishNumber().equals(dishNumber));
        ASON.clearDatabase("DatabaseGerechten");
        for (Dish d :
             menu) {
            ASON.makeObject("Name",d.getName(),"Price",String.format("%.2f", d.getPrice()),"HappyHour",d.getHappyHour(),"DatabaseGerechten");
        }
    }

    public ArrayList<Dish> getDishList(){
        return menu;
    }
}