package entity;

import exception.ResourceException;
import org.apache.log4j.Logger;

/**
 * Created by Nikita Mitroshin on 17.06.2015.
 */
public class Client extends Thread {

    public final static Logger LOG = Logger.getLogger(Client.class);
    private Restaurant restaurant;
    private CashDesk cashDesk;
    private String name;
    private int itemsInOrder;

    public Client(Restaurant restaurant, int itemsInOrder, String name) {
        this.restaurant = restaurant;
        this.itemsInOrder = itemsInOrder;
        this.name = name;
    }


    public String getClientName() {
        return name;
    }

    public int getItemsInOrder() {
        return itemsInOrder;
    }

    @Override
    public void run() {
        System.out.println("Client "+name+" comes to restaurant " + restaurant.getName() );
        this.cashDesk = chooseCashDesk();
        System.out.println("Client "+name+" choosed cashDesk #"+cashDesk.getNumber());


        try {
            cashDesk.serveClient(this);
        } catch (ResourceException e) {
            LOG.error("ResourñeException!!! ", e);
        }
        System.out.println("Client " + getClientName() + " leaves restaurant");
    }

    private CashDesk chooseCashDesk(){
        CashDesk result = restaurant.getCashDesks().get(0);
        for (CashDesk cashDesk : restaurant.getCashDesks()) {
            if(cashDesk.getClients().size() < result.getClients().size()) {
                result = cashDesk;
            }
        }
        return result;
    }

    public boolean canChooseAnotherCashDesk() {
        CashDesk result = chooseCashDesk();
        if(result.getClients().size() < cashDesk.getClients().size()) {
            cashDesk = result;
            try {
                cashDesk.serveClient(this);
            } catch (ResourceException e) {
                LOG.error("ResourñeException!!! ", e);
            }
            return true;
        }
        return false;
    }



}

