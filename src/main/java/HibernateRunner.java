

import entity.Company;
import entity.PersonalInfo;
import entity.Role;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HibernateConfiguration;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {

    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) throws SQLException {

        Company google =  Company.builder()
                .name("Google")
                .build();

        User user = User.builder()
                .username("iva2n@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Ivan")
                        .lastName("Ivanov")
                        .age(32)
                        .build())
                .company(google)
                .build();

        try {
            SessionFactory sessionFactory = HibernateConfiguration.buildSessionFactory();

            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();

//               session1.saveOrUpdate(google);
//               session1.save(user);
                User savedUser = session1.get(User.class, 2L);

                System.out.println(savedUser);

                session1.getTransaction().commit();
            }
        } catch (Exception e) {

        }

    }
}

