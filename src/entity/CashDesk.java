package entity;

import exception.ResourceException;

import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * Created by Nikita Mitroshin on 17.06.2015.
 */
public class CashDesk {

    private final Semaphore semaphore = new Semaphore(1, true);
    private ArrayList<Client> clients;
    private int number;
    private int speedOfService;

    public CashDesk(int number, int speedOfService) {
        clients = new ArrayList<>();
        this.number = number;
        this.speedOfService = speedOfService;
    }

    public void serveClient(Client client) throws ResourceException {
        clients.add(client);
        System.out.println("Client " + client.getClientName() + " come to cashDesk #" + number);
        while (true) {
            if(semaphore.tryAcquire()) {
                try {
                    System.out.println("Client " + client.getClientName() + " is serving on cashDesk #" + number);
                    client.sleep(speedOfService * client.getItemsInOrder());
                } catch (InterruptedException e) {
                    throw new ResourceException("превышено время ожидания", e);
                } finally {
                    semaphore.release();
                    break;
                }
            } else {
                if(client.canChooseAnotherCashDesk()) {
                    System.out.println("Client " + client.getClientName() + " goes to another cashDesk");
                    clients.remove(this);
                    break;
                }
            }

        }
        System.out.println("Client "+client.getClientName() + " is served");
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public int getNumber() {
        return number;
    }
}
