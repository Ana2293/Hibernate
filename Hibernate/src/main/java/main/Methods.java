package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public interface Methods {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    //Adaugare angajat in baza de date
    default void addEmployee(){

    }

    //Schimbarea datelor despre angajat pe baza ID-ului
    default void updateEmployee(){

    }

    //Stergerea unui angajat pe baza ID-ului
     default void deleteEmployee(){

    }

    //Afisarea tuturor angajatilor din baza de date
    public default void listAll(){

    }

    //Sortarea angajatilor crescator dupa varsta
     default void sortAscending(){

    }

    //Sortarea angajatilor descrescator dupa varsta
    default void sortDescending(){

    }

    //Afisarea angajatilor cu varsta mai mare de 30 de ani
    default void sortByAge(){

    }

    //Afisarea angajatilor cu salariul cuprins intre 4000 si 6000 lei
    default void sortBySalary(){

    }

}
