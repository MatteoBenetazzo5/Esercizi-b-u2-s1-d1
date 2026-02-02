package matteobenetazzo.esercizibu2s1d1;

import matteobenetazzo.esercizibu2s1d1.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EserciziBU2S1D1Application {

    public static void main(String[] args) {

        SpringApplication.run(EserciziBU2S1D1Application.class, args);

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(EserciziBU2S1D1Application.class);

        Menu menu = ctx.getBean(Menu.class);
        System.out.println(menu);

        ctx.close();
    }
}
