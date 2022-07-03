package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test31 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            Department department = new Department("Sales",700,1500);
            Employee employee1 = new Employee("Mike","Stoba",500);
            Employee employee2 = new Employee("Max","Stoba",600);
            Employee employee3 = new Employee("John","Doe",600);

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);
            department.addEmployeeToDepartment(employee3);

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
