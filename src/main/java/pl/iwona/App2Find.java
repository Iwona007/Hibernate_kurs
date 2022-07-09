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
public class App2Find {

    private static Logger logger = LogManager.getLogger(App2Find.class);

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("unit");//zdognie z baza danych do ktorej sa przypisane

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1L);
        logger.info(product);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
