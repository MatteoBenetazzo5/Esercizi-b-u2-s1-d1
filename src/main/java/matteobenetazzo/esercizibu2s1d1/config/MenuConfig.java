package matteobenetazzo.esercizibu2s1d1.config;

import matteobenetazzo.esercizibu2s1d1.entities.Drink;
import matteobenetazzo.esercizibu2s1d1.entities.Menu;
import matteobenetazzo.esercizibu2s1d1.entities.Pizza;
import matteobenetazzo.esercizibu2s1d1.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MenuConfig {

    // ---------------- TOPPINGS ----------------

    @Bean
    public Topping mozzarella() {
        return new Topping("Mozzarella", 220, 0.80);
    }

    @Bean
    public Topping basilico() {
        return new Topping("Basilico", 5, 0.20);
    }

    @Bean
    public Topping salamePiccante() {
        return new Topping("Salame piccante", 180, 1.20);
    }

    @Bean
    public Topping gorgonzola() {
        return new Topping("Gorgonzola", 260, 1.30);
    }

    @Bean
    public Topping parmigiano() {
        return new Topping("Parmigiano", 120, 0.90);
    }

    @Bean
    public Topping provola() {
        return new Topping("Provola", 230, 1.00);
    }

    @Bean
    public List<Topping> toppingsList(Topping mozzarella, Topping basilico, Topping salamePiccante, Topping gorgonzola, Topping parmigiano, Topping provola) {
        return Arrays.asList(mozzarella, basilico, salamePiccante, gorgonzola, parmigiano, provola);
    }

    // ---------------- PIZZAS ----------------

    @Bean
    public Pizza margherita(Topping mozzarella, Topping basilico) {
        return new Pizza("Pizza Margherita (pomodoro, mozzarella, basilico)", 980, 5.50, Arrays.asList(mozzarella, basilico));
    }

    @Bean
    public Pizza diavola(Topping mozzarella, Topping salamePiccante) {
        return new Pizza("Pizza Diavola (pomodoro, mozzarella, salame piccante)", 1180, 7.00, Arrays.asList(mozzarella, salamePiccante));
    }

    @Bean
    public Pizza quattroFormaggi(Topping mozzarella, Topping gorgonzola, Topping parmigiano, Topping provola) {
        return new Pizza("Pizza Quattro Formaggi (mozzarella, gorgonzola, parmigiano, provola)", 1320, 7.50, Arrays.asList(mozzarella, gorgonzola, parmigiano, provola));
    }

    @Bean
    public List<Pizza> pizzasList(Pizza margherita, Pizza diavola, Pizza quattroFormaggi) {
        return Arrays.asList(margherita, diavola, quattroFormaggi);
    }

    // ---------------- DRINKS ----------------

    @Bean
    public Drink acquaNaturale() {
        return new Drink("Acqua naturale", 0.5, 0, 1.20);
    }

    @Bean
    public Drink cocaCola() {
        return new Drink("Coca Cola", 0.33, 139, 2.50);
    }

    @Bean
    public Drink birra() {
        return new Drink("Birra", 0.5, 210, 4.00);
    }

    @Bean
    public List<Drink> drinksList(Drink acquaNaturale, Drink cocaCola, Drink birra) {
        return Arrays.asList(acquaNaturale, cocaCola, birra);
    }

    // ---------------- MENU ----------------

    @Bean
    public Menu menu(List<Pizza> pizzasList, List<Topping> toppingsList, List<Drink> drinksList) {
        return new Menu(pizzasList, toppingsList, drinksList);
    }
}


