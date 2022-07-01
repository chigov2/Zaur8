package com.example.Zaur8;

import com.example.Zaur8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List employees = session.createQuery("from Employee " +
                    "where name ='Mike' and salary >900" )
                    .getResultList();
            for(Object e : employees){
                System.out.println("------------------------");
                System.out.println(e);
                System.out.println("------------------------");
            }

            session.getTransaction().commit();

            System.out.println("Done");
            System.out.println("---------------------");

        }finally {
            factory.close();
        }
    }
}
