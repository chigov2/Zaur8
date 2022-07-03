package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)

                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();



            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");


        }finally {
            session.close();
            factory.close();
        }


    }
}
