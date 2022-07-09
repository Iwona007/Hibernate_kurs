package pl.iwona;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.iwona.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App3Update {

    private static Logger logger = LogManager.getLogger(App3Update.class);

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("unit");//zdognie z baza danych do ktorej sa przypisane

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

//        Product product = entityManager.find(Product.class, 1L);
//        product.setName("Nowy Rower 01"); // dirty checking sprawdza czy wartosci pola sie pozmieniałay
        //Product merge = entityManager.merge(product);

        Product product = new Product();
        product.setId(1L);
        product.setName("Nowy Rower 02");
        Product merged = entityManager.merge(product);
        logger.info(product);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
