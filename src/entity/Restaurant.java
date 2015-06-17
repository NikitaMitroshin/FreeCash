package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nikita Mitroshin on 17.06.2015.
 */
public class Restaurant {

    private String name;
    private ArrayList<CashDesk> cashDesks;

    public Restaurant(String name) {
        this.name = name;
        cashDesks = new ArrayList<>();
    }

    public void addCashDesk(CashDesk cashDesk) {
        cashDesks.add(cashDesk);
    }

    public String getName() {
        return name;
    }

    public List<CashDesk> getCashDesks() {
        return Collections.unmodifiableList(cashDesks);
    }
}
