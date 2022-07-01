package com.example.Zaur8;

import com.example.Zaur8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Sidorov", "IT", 800);
            session.beginTransaction();

//            session.save(employee);
//            session.getTransaction().commit();//vse`

//            int myId = employee.getId();
//            System.out.println(myId);

//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee1 = session.get(Employee.class,9);
            session.getTransaction().commit();
            System.out.println(employee1);
            System.out.println("Done");
            System.out.println("---------------------");


        }finally {
            factory.close();
        }


    }
}
