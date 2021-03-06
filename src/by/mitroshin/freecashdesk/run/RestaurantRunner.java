package by.mitroshin.freecashdesk.run;

import by.mitroshin.freecashdesk.entity.CashDesk;
import by.mitroshin.freecashdesk.entity.Client;
import by.mitroshin.freecashdesk.entity.Restaurant;
import java.util.Random;

/**
 * Created by Nikita Mitroshin on 17.06.2015.
 */
public class RestaurantRunner {

    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance("Mcdonalds");
        CashDesk cashDesk1 = new CashDesk(1, 140);
        CashDesk cashDesk2 = new CashDesk(2, 250);


        restaurant.addCashDesk(cashDesk1);
        restaurant.addCashDesk(cashDesk2);


        new Client(restaurant, 100, "client50").start();
        Random random = new Random();
        for (int i = 1; i < 8; i++) {

            int randNumbOfItems = random.nextInt(10) + 1;
            Client client =  new Client(restaurant, randNumbOfItems, "client"+i);
            client.start();
        }

    }

}
