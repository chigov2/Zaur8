package com.example.Zaur8;

import com.example.Zaur8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee employee3 = session.get(Employee.class,1);
//            employee3.setSalary(2500);
            session.createQuery("update Employee set salary=1000 where name='Mike'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");

        }finally {
            factory.close();
        }
    }
}
