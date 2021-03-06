package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test31_get {
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

            Department department = session.get(Department.class, 1);
            System.out.println("Show department ->");
            System.out.println(department);
            System.out.println("----------------------");
            System.out.println(department.getEmployees());
//            Employee employee = session.get(Employee.class,1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());

            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");

        }finally {
            session.close();
            factory.close();
        }


    }
}
