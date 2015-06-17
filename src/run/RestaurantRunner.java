package run;

import entity.CashDesk;
import entity.Client;
import entity.Restaurant;

import java.util.Random;

/**
 * Created by Nikita Mitroshin on 17.06.2015.
 */
public class RestaurantRunner {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Mcdonalds");
        CashDesk cashDesk1 = new CashDesk(1, 140);
        CashDesk cashDesk2 = new CashDesk(2, 250);

        restaurant.addCashDesk(cashDesk1);
        restaurant.addCashDesk(cashDesk2);


        Random random = new Random();
        for (int i = 1; i < 5; i++) {
            int randNumbOfItems = random.nextInt(10) + 1;
            Client client =  new Client(restaurant, randNumbOfItems, "client"+i);
            client.start();
        }
    }

}
