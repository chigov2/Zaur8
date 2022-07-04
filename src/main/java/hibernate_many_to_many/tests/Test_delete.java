package hibernate_many_to_many.tests;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Child.class)
                .buildSessionFactory();
        Session session = null;

        try{
            session = factory.getCurrentSession();


            session.beginTransaction();

//            Section section = session.get(Section.class,1);
//
//            System.out.println("Section1-> "+ section);
//            System.out.println("Section1 and children -> "+ section.getChildrens());
//            System.out.println("---------------");
            Child child1 = session.get(Child.class,3);

            System.out.println("Child1 -> "+ child1);
            System.out.println("Child1 and section -> "+child1.getSections());


            session.getTransaction().commit();
            System.out.println("---------------");

            System.out.println("Done");

        }finally {
            session.close();
            factory.close();
        }



    }
}
