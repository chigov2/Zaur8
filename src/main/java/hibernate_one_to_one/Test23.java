package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test23 {
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

            Employee employee3 = session.get(Employee.class,15);
            System.out.println(employee3.getEmployeeDetail());

            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");


        }finally {
            session.close();
            factory.close();
        }

    }
}
