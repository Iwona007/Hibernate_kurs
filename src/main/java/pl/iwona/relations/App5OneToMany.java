package pl.iwona.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.iwona.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Hello world!
 */
public class App5OneToMany {

    private static Logger logger = LogManager.getLogger(App5OneToMany.class);

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("unit");//zdognie z baza danych do ktorej sa przypisane

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Product> products = entityManager.createQuery("select p from Product p").getResultList();

        for (Product product: products) {
            logger.info(product.getName());
            logger.info(product.getReviews());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
