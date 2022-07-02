package com.example.Zaur8;

import com.example.Zaur8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee2 = session.get(Employee.class,1);
//            session.delete(employee2);
            session.createQuery("delete Employee " +
                    "where name = 'Mike'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");

        }finally {
            factory.close();
        }
    }
}
