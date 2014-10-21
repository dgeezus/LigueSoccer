package com.ma.modele;
/**
 *
 * @author usager
 */
public class Categorie {

    private int idCategorie;
    private int age;
    private int adulte;
    private String niveau;
    private int genre;

    public Categorie(int age, String niveau, int genre, int adulte) {
        this.age = age;
        this.niveau = niveau;
        this.genre = genre;
        this.adulte = adulte;
    }

    public Categorie(int idCategorie, int age, String niveau, int genre, int adulte) {
        this.idCategorie = idCategorie;
        this.age = age;
        this.niveau = niveau;
        this.genre = genre;
        this.adulte = adulte;
    }

    public int getAdulte() {
        return adulte;
    }

    public void setAdulte(int adulte) {
        this.adulte = adulte;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
}
