package pl.iwona.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.iwona.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App14DeleteOneToOne {
    private static Logger logger = LogManager.getLogger(App14DeleteOneToOne.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Product product = em.find(Product.class, 3L);
        if(product.getCategory().getProduct().size() == 1) { // sperdzenie ze do produktu jest przypisane tylko jedna kategoria
            em.remove(product.getCategory());
        }
        product.setCategory(null);

        em.getTransaction().commit();
        em.close();
    }
}
