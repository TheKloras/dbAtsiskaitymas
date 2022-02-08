package me.thekloras.entity;

import javax.persistence.*;

@Entity
@Table(name = "knygos")

public class Knygos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "metai")
    private int metai;
    @Column(name = "leidimas")
    private int leidimas;
    @Column(name = "pavadinimas")
    private String pavadinimas;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "autoriaus_id")
    private Autoriai autoriai;

    public Knygos() {
    }

    public Knygos(int id, int metai, int leidimas, String pavadinimas) {
        this.id = id;
        this.metai = metai;
        this.leidimas = leidimas;
        this.pavadinimas = pavadinimas;
    }

    public Knygos(int metai, int leidimas, String pavadinimas) {
        this.metai = metai;
        this.leidimas = leidimas;
        this.pavadinimas = pavadinimas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMetai() {
        return metai;
    }

    public void setMetai(int metai) {
        this.metai = metai;
    }

    public int getLeidimas() {
        return leidimas;
    }

    public void setLeidimas(int leidimas) {
        this.leidimas = leidimas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Autoriai getAutoriai() {
        return autoriai;
    }

    public void setAutoriai(Autoriai autorius) {
        this.autoriai = autorius;
    }

    @Override
    public String toString() {
        return "Knygos{" +
                "id=" + id +
                ", metai=" + metai +
                ", leidimas=" + leidimas +

                ", pavadinimas='" + pavadinimas + '\'' +

                '}';
    }
}