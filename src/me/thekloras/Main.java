package me.thekloras;

import me.thekloras.DAO.AutoriaiDAO;
import me.thekloras.DAO.KnygosDAO;
import me.thekloras.entity.Autoriai;
import me.thekloras.entity.Knygos;
import me.thekloras.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        //dropALL();
        AutoriaiDAO autoriaiDAO = new AutoriaiDAO();
        KnygosDAO knygosDAO = new KnygosDAO();

        Autoriai autorius1 = new Autoriai("Jonas","Butrimas");
        Autoriai autorius2 = new Autoriai("Vytautas","Saudargas");
        Autoriai autorius3 = new Autoriai("Tomas","Žutautas");
        Autoriai autorius4 = new Autoriai("Lukas","Petraitis");
        Autoriai autorius5 = new Autoriai("Gabija","Matuzaitė");

        autoriaiDAO.insert(autorius1);
        autoriaiDAO.insert(autorius2);
        autoriaiDAO.insert(autorius3);
        autoriaiDAO.insert(autorius4);
        autoriaiDAO.insert(autorius5);

        Knygos knyga1 = new Knygos(2000,1,"Mein Kampf");
        Knygos knyga2 = new Knygos(2010,2,"Mein Kampf");
        Knygos knyga3 = new Knygos(2005,2,"Radži. Likimas");
        Knygos knyga4 = new Knygos(2005,2,"Radži. Likimas");
        Knygos knyga5 = new Knygos(1999,1,"Kaip būti");

        knyga1.setAutoriai(autorius2);
        knyga2.setAutoriai(autorius2);
        knyga3.setAutoriai(autorius1);
        knyga4.setAutoriai(autorius5);
        knyga5.setAutoriai(autorius4);

        knygosDAO.insert(knyga1);
        knygosDAO.insert(knyga2);
        knygosDAO.insert(knyga3);
        knygosDAO.insert(knyga4);
        knygosDAO.insert(knyga5);

        //--Paieska
        List<Knygos> knygosList = knygosDAO.searchByName("Mein Kampf");
        System.out.println(knygosList);

        //--Redagavimas
        Autoriai autoriusx = new Autoriai(autorius4.getId(), "Antanas", "Smetona");
        Knygos knygax = new Knygos(knyga4.getId(),2002,1,"MySQL For Dummies");

        autoriaiDAO.update(autoriusx);
        knygax.setAutoriai(autoriusx);
        knygosDAO.update(knygax);
        System.out.println("Redaguoti irasai");

        //--Trynimas
        int id = 2;
        autoriaiDAO.deleteById(id);
        System.out.println("Istrintas vartotojas pagal id:" + id);

        //--Spec. Uzsakymas
        int metai = 2005;
        System.out.printf(metai + " Metuose buvo isleista " + knyguIsleidimoMetai(metai) + " knygu(os)");

        HibernateUtil.getSessionFactory().close();
    }
    public static void dropALL(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery( "DROP TABLE IF EXISTS *");
        query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("Ištrinama viskas iš db");
    }
    public static int knyguIsleidimoMetai(int metai){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int kiek = Integer.parseInt(session.createSQLQuery("SELECT COUNT(*) FROM knygos a WHERE metai ='" + metai + "'").getSingleResult().toString());
        session.getTransaction().commit();
        return kiek;
    }
}
