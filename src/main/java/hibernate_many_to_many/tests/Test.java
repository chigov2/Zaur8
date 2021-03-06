package hibernate_many_to_many.tests;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Child.class)
                .buildSessionFactory();
        Session session = null;

        try{
            session = factory.getCurrentSession();

            Section section1 = new Section("Football");
            Child child1 = new Child("Mike",5);
            Child child2 = new Child("Alex",6);
            Child child3 = new Child("Olena",5);

            session.beginTransaction();

            session.save(section1);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.save(child1);
            session.save(child2);
            session.save(child3);

            session.getTransaction().commit();
            System.out.println("---------------");
            System.out.println("Done");

        }finally {
            session.close();
            factory.close();
        }



    }
}
