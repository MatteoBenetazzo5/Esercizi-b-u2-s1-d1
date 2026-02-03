package matteobenetazzo.esercizibu2s1d1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {
    private int orderNumber;
    private OrderStatus status;
    private int covers;
    private LocalTime acquisitionTime;
    private Table table;
    private List<MenuItem> items;
    private double coverCharge;

    public double getTotal() {
        double itemsTotal = 0;
        for (MenuItem item : items) {
            itemsTotal += item.getPrice();
        }
        return itemsTotal + (covers * coverCharge);
    }
}

