package nl.ardemium;

public class ShareOrder{

    private Dish dish;
    private int quantity;

    public ShareOrder(Dish dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }

    public double getPriceShareOrder(){
        return dish.getPrice() * quantity;
    }

    public Dish getDish(){
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }
}