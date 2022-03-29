package nl.ardemium;

import java.util.ArrayList;

public class Participant {

    private final String name;
    private ArrayList<Order> orderArrayList;

    public Participant(String name) {
        this.name = name;
        this.orderArrayList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void mkOrder(Order order){
        orderArrayList.add(order);
    }

    public String calculateCosts(){
        double costs = 0.0;
        for (Order o : orderArrayList){
            for (ShareOrder s : o.getShareOrders()){
                costs += s.getPriceShareOrder();
            }
        }
        return String.format("%.2f", costs);
    }

    public void payInvoice(){
        this.orderArrayList = new ArrayList<>();
    }

    @Override
    public String toString(){
         StringBuilder invoice = new StringBuilder();
        for (Order o : orderArrayList){
            for (ShareOrder s : o.getShareOrders()){
                invoice.append(String.format("%s x%s %s %s %n", s.getDish().getPrice(), s.getQuantity(), s.getDish().getName(), s.getPriceShareOrder()));
            }
        }
        invoice.append("Totaal: ").append(calculateCosts());
        return invoice.toString();
    }
}
