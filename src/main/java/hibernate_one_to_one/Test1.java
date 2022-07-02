package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try {


            Session session = factory.getCurrentSession();
            Employee employee1 = new Employee("Olena","gerasymluik","IT",800);
            Detail detail1 = new Detail("Vinnitsa","+380675063714","paginas88@gmail.com");

            employee1.setEmployeeDetail(detail1);

            session.beginTransaction();

            session.save(employee1);

            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");


        }finally {
            factory.close();
        }


    }
}
