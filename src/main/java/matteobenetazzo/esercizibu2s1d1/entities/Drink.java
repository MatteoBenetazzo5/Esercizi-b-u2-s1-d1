package matteobenetazzo.esercizibu2s1d1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Drink {
    private String name;
    private double liters;
    private int calories;
    private double price;
}
