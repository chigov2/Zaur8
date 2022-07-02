package hibernate_test2;


import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test26 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail3 = session.get(Detail.class,3);
            System.out.println(detail3.getEmployee());
            System.out.println(detail3);


            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");



        }finally {
            session.close();
            factory.close();
        }

    }
}
