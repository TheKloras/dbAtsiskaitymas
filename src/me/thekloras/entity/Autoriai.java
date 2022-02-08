package me.thekloras.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "autoriai")

public class Autoriai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "vardas")
    private String vardas;
    @Column(name = "pavarde")
    private String pavarde;
    @OneToMany(mappedBy = "autoriai", cascade = CascadeType.ALL)
    private List<Knygos> knygos;

    public Autoriai() {
    }

    public Autoriai(int id, String vardas, String pavarde) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public Autoriai(String vardas, String pavarde) {
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public List<Knygos> getKnygos() {
        return knygos;
    }

    public void setKnygos(List<Knygos> knygos) {
        this.knygos = knygos;
    }

    @Override
    public String toString() {
        return "Autoriai{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                '}';
    }
}