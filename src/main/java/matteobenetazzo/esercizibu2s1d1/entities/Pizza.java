package matteobenetazzo.esercizibu2s1d1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Pizza {
    private String name;
    private int calories;
    private double price;

    private List<Topping> toppings;
}

