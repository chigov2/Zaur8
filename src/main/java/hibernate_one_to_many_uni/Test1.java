package hibernate_one_to_many_uni;


import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            Department department = new Department("HR",800,1500);
            Employee employee1 = new Employee("Mike","Chigov",500);
            Employee employee2 = new Employee("Alex","Afanasiev",600);

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);

            session = factory.getCurrentSession();

            session.beginTransaction();

            session.save(department);

            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println("---------------------");


        }finally {
            session.close();
            factory.close();
        }


    }
}
