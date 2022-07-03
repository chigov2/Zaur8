package hibernate_one_to_many_uni;



import hibernate_one_to_many_uni.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test_delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

//            Department department = session.get(Department.class, 1);
            Department department = session.get(Department.class, 1);
            session.delete(department);
//            System.out.println(department);
//            System.out.println(department.getEmployees());

//            Employee employee = session.get(Employee.class,4);
//            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");

        }finally {
            session.close();
            factory.close();
        }


    }
}
