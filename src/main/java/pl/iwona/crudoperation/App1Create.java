package pl.iwona.crudoperation;

import pl.iwona.entity.Product;
import pl.iwona.entity.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Hello world!
 *
 */
public class App1Create
{

    private static Logger logger = LogManager.getLogger(App1Create.class);

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("unit");//zdognie z baza danych do ktorej sa przypisane

    public static void main( String[] args )
    {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        logger.info("Hello");

        Product product = new Product();
        product.setName("Rower 01");
        product.setDescription("Opis produktu 01");
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());
        product.setPrice(new BigDecimal("19.99"));
        product.setProductType(ProductType.REAL);

        entityManager.persist(product);

        logger.info(product);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
