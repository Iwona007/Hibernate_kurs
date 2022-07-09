package pl.iwona.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.iwona.entity.Attribute;
import pl.iwona.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App10ManyToMany {

    private static Logger logger = LogManager.getLogger(App10ManyToMany.class);

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("unit");//zdognie z baza danych do ktorej sa przypisane

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 3L);
        logger.info(product);
        logger.info(product.getAttributes());

        logger.info("====");

        Attribute attribute = entityManager.find(Attribute.class, 3L);
        logger.info(attribute);
        logger.info(attribute.getProducts());


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
