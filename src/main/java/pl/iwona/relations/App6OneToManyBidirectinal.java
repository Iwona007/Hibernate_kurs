package pl.iwona.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.iwona.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Hello world!
 */
public class App6OneToManyBidirectinal {

    private static Logger logger = LogManager.getLogger(App6OneToManyBidirectinal.class);

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("unit");//zdognie z baza danych do ktorej sa przypisane

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Review> reviews = entityManager.createQuery("select r from Review r").getResultList();

        for (Review review: reviews) {
            logger.info(review);
            logger.info(review.getProduct());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
