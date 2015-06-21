package by.mitroshin.freecashdesk.entity;

import by.mitroshin.freecashdesk.exception.ResourceException;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nikita Mitroshin on 17.06.2015.
 */
public class CashDesk {

    private ReentrantLock lock = new ReentrantLock();
    private LinkedList<Client> clients;
    private int number;
    private int timeOfService;

    public CashDesk(int number, int timeOfService) {
        clients = new LinkedList<>();
        this.number = number;
        this.timeOfService = timeOfService;

    }

    public void serveClient(Client client) throws ResourceException {
        System.out.println("Client "+client.getClientName() + " is serving on cashDesk#"+getNumber());
        try {
            client.sleep(timeOfService * client.getItemsInOrder());
        } catch (InterruptedException e) {
            throw new ResourceException("InterruptedException!!!", e);
        }
        System.out.println("Client "+client.getClientName() + " is served");
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public int getNumber() {
        return number;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
