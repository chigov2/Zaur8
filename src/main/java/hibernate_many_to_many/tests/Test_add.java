package hibernate_many_to_many.tests;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_add {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Child.class)
                .buildSessionFactory();
        Session session = null;

        try{
            session = factory.getCurrentSession();

            Section section1 = new Section("Volleyball");
            Section section2 = new Section("Jumping");
            Section section3 = new Section("SnowBoarding");

            Child child3 = new Child("Vlad",11);

            child3.addSectionToChild(section1);
            child3.addSectionToChild(section2);
            child3.addSectionToChild(section3);

            session.beginTransaction();

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
