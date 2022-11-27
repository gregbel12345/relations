package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession();
    }
}
