/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utp.studia.inpost;

import lombok.experimental.UtilityClass;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Gracjan Katek
 */
@UtilityClass
public class JpaUtils {
    public SessionFactory getSessionFactory() {
        Properties properties = new Properties();
            properties.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
            properties.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");
            properties.setProperty("hibernate.connection.username", "sa");
            properties.setProperty("hibernate.connection.password", "");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            properties.setProperty("hibernate.hbm2ddl.auto", "update");
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("hibernate.use_sql_comments", "true");
        Configuration configuration = new Configuration().addProperties(properties);
            configuration.addAnnotatedClass(Operations.class);
            configuration.addAnnotatedClass(Worker.class);
            configuration.addAnnotatedClass(PostOffice.class);
            configuration.addAnnotatedClass(Boxes.class);
            configuration.addAnnotatedClass(Transfers.class);
            configuration.addAnnotatedClass(Letters.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties())
            .build();
        SessionFactory sessionFactory = configuration
            .buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
