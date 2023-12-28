package com.pi.restaurantservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`adresse`")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero")
    private int numero;
    @Column(name = "nom")
    private String nom;
    @Column(name = "rue")
    private String rue;
    @Column(name = "cite")
    private String cite;
    @Column(name = "ville")
    private String ville;

    public Adresse(int numero, String nom, String rue, String cite, String ville) {
        this.numero = numero;
        this.nom = nom;
        this.rue = rue;
        this.cite = cite;
        this.ville = ville;
    }

    public Adresse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCite() {
        return cite;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse [id=" + id + ", numero=" + numero + ", nom=" + nom + ", rue=" + rue + ", cite=" + cite
                + ", ville=" + ville + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + numero;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((rue == null) ? 0 : rue.hashCode());
        result = prime * result + ((cite == null) ? 0 : cite.hashCode());
        result = prime * result + ((ville == null) ? 0 : ville.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Adresse other = (Adresse) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (numero != other.numero)
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (rue == null) {
            if (other.rue != null)
                return false;
        } else if (!rue.equals(other.rue))
            return false;
        if (cite == null) {
            if (other.cite != null)
                return false;
        } else if (!cite.equals(other.cite))
            return false;
        if (ville == null) {
            if (other.ville != null)
                return false;
        } else if (!ville.equals(other.ville))
            return false;
        return true;
    }

}
