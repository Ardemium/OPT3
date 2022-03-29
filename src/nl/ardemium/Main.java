package nl.ardemium;

public class Main {

    public static void main(String[] args) {
        Participant p = new Participant("Arthur");

        ShareOrder s = new ShareOrder(Menu.getMenuInstance().getDishList().get(1), 3);
        p.mkOrder(new Order(s));
        s = new ShareOrder(Menu.getMenuInstance().getDishList().get(2), 2);
        p.mkOrder(new Order(s));

        System.out.println(p.toString());
    }
}
