package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test25 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {


            session = factory.getCurrentSession();
            Employee employee1 = new Employee("Martin","Wane","Sales",600);
            Detail detail1 = new Detail("Nevada","+004198002020","martin@gmail.com");

            employee1.setEmployeeDetail(detail1);
            detail1.setEmployee(employee1);

            session.beginTransaction();
            session.save(detail1);

            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");



        }finally {
            session.close();
            factory.close();
        }

    }
}
