package me.thekloras.DAO;

import me.thekloras.entity.Autoriai;
import me.thekloras.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class AutoriaiDAO {

    public AutoriaiDAO() {

    }

    public void insert(Autoriai autoriai) {
        // Norint atlikti uzklausa i DB reikia is sesiju gamyklos paprasyti sesijos.
        // Sesiju objektas yra lengvasvoris (lightweight).
        // Sesiju galima tureti neribota kieki per aplikacija.
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(autoriai);

        session.getTransaction().commit();
        System.out.println("Sekmingai issaugojam nauja objekta.");
    }

    public void update(Autoriai autoriai) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(autoriai);

        session.getTransaction().commit();
        System.out.println("Irasa pavyko sekmingai atnaujinti (pagal ID).");
    }

    public void delete(Autoriai autoriai) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(autoriai);

        session.getTransaction().commit();
        System.out.println("Irasa pavyko sekmingai pasalinti.");
    }

    public void deleteById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Autoriai autoriai = (Autoriai) session.get(Autoriai.class, id);
        if (autoriai != null) {
            session.delete(autoriai);
            System.out.println("Pavyko istrinti naudojant ID");
        }
        session.getTransaction().commit();
    }

    public Autoriai searchByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Autoriai autoriai = session.get(Autoriai.class, id);

        session.getTransaction().commit();
        System.out.println("Pavyko atlikti paieska sekmingai pagal ID.");

        return autoriai;
    }

    public List<Autoriai> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Autoriai> autoriai = new ArrayList<>();
        // Panaudosime hibernate query language (HQL). Naudojama su metodu create query.
        autoriai = session.createQuery("from Autoriai a where a.vardas like '" + name + "'").getResultList();

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atlikti paieska pagal varda.");

        return autoriai;
    }


}
