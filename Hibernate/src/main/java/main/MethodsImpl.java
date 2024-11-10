package main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class MethodsImpl implements Methods {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    //Adaugare angajat in baza de date
    public void addEmployee(Session session, Person person) {

        session.beginTransaction();
        Person p = new Person("Mirela", 30, "Timisoara", 10200);

        session.save(p);
        session.getTransaction().commit();
        session.close();
    }


    //Schimbarea datelor despre angajat pe baza ID-ului
    public void updateEmployee(Session session, Person person) {
        session.beginTransaction();
        String hql = "update Person p set p.surname = 'Viorel' where p.id = 3";
        Query query = session.createQuery(hql);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    //Stergerea unui angajat pe baza ID-ului
    public void deleteEmployee(Session session, Person person) {
        session.beginTransaction();
        String hql1 = "delete from Person p where p.id = 8";
        Query query1 = session.createQuery(hql1);
        query1.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    //Afisarea tuturor angajatilor din baza de date
    public void listAll(Session session, Person person) {
        session.beginTransaction();
        String hql2 = "from Person p";
        Query query2 = session.createQuery(hql2);
        List results = query2.list();

        for (Object p : results) {
            System.out.println(p);
        }
        session.close();
    }

    //Sortarea angajatilor crescator dupa varsta
    public void sortAscending(Session session, Person person) {
        session.beginTransaction();
        String hql3 = "from Person p order by p.age asc";
        Query query3 = session.createQuery(hql3);
        List results1 = query3.list();

        for (Object p : results1) {
            System.out.println(p);
        }
        session.close();
    }

    //Sortarea angajatilor descrescator dupa varsta
    public void sortDescending(Session session, Person person) {
        session.beginTransaction();
        String hql4 = "from Person p order by p.age desc";
        Query query4 = session.createQuery(hql4);
        List results2 = query4.list();

        for (Object p : results2) {
            System.out.println(p);
        }
        session.close();
    }

    //Afisarea angajatilor cu varsta mai mare de 30 de ani
    public void sortByAge(Session session, Person person) {
        session.beginTransaction();
        String hql5 = "from Person p where p.age >= 30";
        Query query5 = session.createQuery(hql5);
        List results3 = query5.list();

        for (Object p : results3) {
            System.out.println(p);
        }
        session.close();
    }

    //Afisarea angajatilor cu salariul cuprins intre 4000 si 6000 lei
    public void sortBySalary(Session session, Person person) {
        session.beginTransaction();
        String hql6 = "from Person p where p.salary >= 4000 and p.salary <= 6000";
        Query query6 = session.createQuery(hql6);
        List results4 = query6.list();

        for (Object p : results4) {
            System.out.println(p);
        }
        session.close();
    }

}