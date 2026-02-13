package sk.lab2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        store p = new store();
//      p.setProductId(1);
        p.setName("Laptop");
        p.setDescription("Dell i5");
        p.setPrice(55000);
        p.setQuantity(10);
        store p1 = new store();
//      p1.setProductId(1);
	    p1.setName("Laptop");
	    p1.setDescription("Hp i5");
	    p1.setPrice(60000);
	    p1.setQuantity(8);

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(store.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(p);
        session.persist(p1);
        store r = session.get(store.class, 1);

        r.setPrice(58000);
        r.setQuantity(12);

        store d = session.get(store.class, 2);
        session.delete(d);
        tx.commit();

        session.close();
        factory.close();
    }
}
