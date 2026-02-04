package matteobenetazzo.esercizibu2s1d1;

import matteobenetazzo.esercizibu2s1d1.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EserciziBU2S1D1ApplicationTests {

    @Autowired
    private Menu menu;

    @Value("${coperto.price}")
    private double coverCharge;

    // TEST 1: il context di Spring parte
    @Test
    void contextLoads() {
    }

    // TEST 2: il menu esiste e ha gli elementi
    @Test
    void menuShouldContainPizzasToppingsAndDrinks() {
        assertEquals(3, menu.getPizzas().size());
        assertEquals(6, menu.getToppings().size());
        assertEquals(3, menu.getDrinks().size());
    }

    // TEST 3: coperto letto da application.properties
    @Test
    void coverChargeShouldBe2Euro() {
        assertEquals(2.00, coverCharge, 0.001);
    }

    // TEST 4: totale ordine senza coperti
    @Test
    void orderTotalWithoutCoversShouldBeOnlyItemsSum() {

        // creo tavolo e ordine
        Table table1 = new Table(1, 4, TableStatus.OCCUPATO);

        // prendo 2 item dal menu
        var pizza = menu.getPizzas().get(0);  // Margherita 5.50
        var drink = menu.getDrinks().get(1);  // Coca Cola 2.50

        Order order = new Order(
                1,
                OrderStatus.IN_CORSO,
                0,
                LocalTime.now(),
                table1,
                List.of(pizza, drink),
                coverCharge
        );

        // 5.50 + 2.50 = 8.00
        assertEquals(8.00, order.getTotal(), 0.001);
    }

    // TEST 5: PARAMETRICO sul totale con coperti
    // formula: totale = itemsSum + (covers * coverCharge)
    @ParameterizedTest
    @CsvSource({
            "1, 10.00", // items 8.00 + (1 * 2.00) = 10.00
            "2, 12.00", // items 8.00 + (2 * 2.00) = 12.00
            "3, 14.00"  // items 8.00 + (3 * 2.00) = 14.00
    })
    void orderTotalWithCoversShouldAddCoverCharge(int covers, double expectedTotal) {

        Table table1 = new Table(1, 4, TableStatus.OCCUPATO);

        var pizza = menu.getPizzas().get(0);  // 5.50
        var drink = menu.getDrinks().get(1);  // 2.50

        Order order = new Order(
                1,
                OrderStatus.IN_CORSO,
                covers,
                LocalTime.now(),
                table1,
                List.of(pizza, drink),
                coverCharge
        );

        assertEquals(expectedTotal, order.getTotal(), 0.001);
    }
}

