package br.edu.unifei.utils;

import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * Configurador do session factory do Hibernate.
 * @author Tiago Romero Garcia
 */
public class HibernateUtils {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}