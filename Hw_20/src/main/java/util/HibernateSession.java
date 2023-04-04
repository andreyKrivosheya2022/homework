package util;

import entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;

public class HibernateSession {

    private static SessionFactory sessionFactory;
    private static List<Class> classes = List.of(Student.class);
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/hiber";
    private static final String USER = "root";
    private static final String PASSWORD = "hayday0992717546";
    private static final String DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    private static final String SHOW_SQL = "true";
    private static final String HBM2DDL_AUTO = "update";

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, DRIVER);
                properties.put(Environment.URL, URL);
                properties.put(Environment.USER, USER);
                properties.put(Environment.PASS, PASSWORD);
                properties.put(Environment.DIALECT, DIALECT);
                properties.put(Environment.SHOW_SQL, SHOW_SQL);
                properties.put(Environment.HBM2DDL_AUTO, HBM2DDL_AUTO);

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(classes.get(0));
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Couldn't get session factory. " + e.getMessage());
            }
        }
        return sessionFactory;
    }
}
