package Domain;
import App.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;

public class HibRunner {
    private static SessionFactory sessionFactory = null;

    public static void generateData(Session session){
        Category cat1 = new Category("jedzenie");
        Category cat2 = new Category("meble");

        Product prod1 = new Product("szafa", 3);
        Product prod2 = new Product("jajko", 5);
        Product prod3 = new Product("szynka", 3);

        prod1.setCategory(cat1);
        prod2.setCategory(cat1);
        prod3.setCategory(cat2);

        Supplier supplier1 = new Supplier("a", "b", "c", "zip1", "123");
        Supplier supplier2 = new Supplier("d", "e", "f", "zip2", "456");
        Customer customer1 = new Customer("Jan", "Strase", "Krako", "zip3", 0.8);


        supplier1.addProduct(prod1);
        supplier1.addProduct(prod2);
        supplier2.addProduct(prod3);

        Transactionx tr1 = new Transactionx(2,3);
        Transactionx tr2 = new Transactionx(2,3);
        tr1.addProduct(prod1);
        tr1.addProduct(prod2);
        tr2.addProduct(prod1);

//        session.persist(tr1);
//        session.persist(tr2);
        session.persist(customer1);
        session.persist(supplier1);
        session.persist(supplier2);
        session.persist(prod1);
        session.persist(prod2);
        session.persist(prod3);
        session.persist(cat1);
        session.persist(cat2);
    }

    public static void main(String[] args) {

        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        generateData(session);

        App app = new App(session);
        app.run();


        tx.commit();
        sessionFactory.close();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
