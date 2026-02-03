package matteobenetazzo.esercizibu2s1d1.runners;

import matteobenetazzo.esercizibu2s1d1.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OrdersRunner.class);

    private final ApplicationContext ctx;

    @Value("${coperto.price}")
    private double coverCharge;

    public OrdersRunner(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run(String... args) throws Exception {

        // 1) Prendo il menu dallo "scatolone" di Spring
        Menu menu = ctx.getBean(Menu.class);

        // 2) Stampo il menu con logger
        stampaMenu(menu);

        // 3) Creo un ordine
        Order ordine = creaOrdine(menu);

        // 4) Stampo l'ordine creato
        stampaOrdine(ordine);
    }

    private void stampaMenu(Menu menu) {

        logger.info("------ MENU PIZZE ------");
        for (Pizza p : menu.getPizzas()) {
            logger.info("{} - {}€ - {} cal", p.getName(), p.getPrice(), p.getCalories());
        }

        logger.info("------ MENU TOPPINGS ------");
        for (Topping t : menu.getToppings()) {
            logger.info("{} - {}€ - {} cal", t.getName(), t.getPrice(), t.getCalories());
        }

        logger.info("------ MENU DRINKS ------");
        for (Drink d : menu.getDrinks()) {
            logger.info("{} ({}L) - {}€ - {} cal", d.getName(), d.getLiters(), d.getPrice(), d.getCalories());
        }
    }

    private Order creaOrdine(Menu menu) {

        // creo un tavolo
        Table table1 = new Table(1, 4, TableStatus.OCCUPATO);

        // creo lista di cose ordinate
        List<MenuItem> items = new ArrayList<>();
        items.add(menu.getPizzas().get(0));     // prima pizza
        items.add(menu.getToppings().get(2));   // topping extra
        items.add(menu.getDrinks().get(1));     // drink

        // creo ordine
        return new Order(
                1,
                OrderStatus.IN_CORSO,
                2,
                LocalTime.now(),
                table1,
                items,
                coverCharge
        );
    }

    private void stampaOrdine(Order ordine) {

        logger.info("------ ORDINE CREATO ------");
        logger.info("Tavolo: {}", ordine.getTable());
        logger.info("Numero ordine: {}", ordine.getOrderNumber());
        logger.info("Stato: {}", ordine.getStatus());
        logger.info("Coperti: {}", ordine.getCovers());
        logger.info("Ora acquisizione: {}", ordine.getAcquisitionTime());
        logger.info("Elementi: {}", ordine.getItems());
        logger.info("Totale ordine: {}€", ordine.getTotal());
    }
}

