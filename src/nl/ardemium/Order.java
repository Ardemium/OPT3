package nl.ardemium;

import java.util.ArrayList;

public class Order{

    private ArrayList<ShareOrder> shareOrders;

    private Order(){}

    public Order(ShareOrder shareOrder) {
        if (shareOrders == null){
            this.shareOrders = new ArrayList<>();
        }
        setShareOrders(shareOrder);
    }

    public void setShareOrders(ShareOrder shareOrders){
        this.shareOrders.add(shareOrders);
    }

    public ArrayList<ShareOrder> getShareOrders(){
        return shareOrders;
    }

}