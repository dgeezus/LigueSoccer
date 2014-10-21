package com.ma.modele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Casa Nova
 */
public class Utilisateur {
    
    String nom,prenom,courriel,adressPostale,mdp,ntelephone1,ntelephone2,ntelephone3;
    int idUtilisateur,ddn,passport,isAdmin,parentAdmin;

    
    public Utilisateur(int idUtilisateur, String nom, String prenom, String courriel, String adressPostale, String mdp, String ntelephone1, String ntelephone2, String ntelephone3, int ddn, int passport, int isAdmin, int parentAdmin) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.adressPostale = adressPostale;
        this.mdp = mdp;
        this.ntelephone1 = ntelephone1;
        this.ntelephone2 = ntelephone2;
        this.ntelephone3 = ntelephone3;
        this.ddn = ddn;
        this.passport = passport;
        this.isAdmin = isAdmin;
        this.parentAdmin = parentAdmin;
    }
    
        public Utilisateur(String nom, String prenom, String courriel, String mdp, int ddn) {
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel; 
        this.mdp = mdp; 
        this.ddn = ddn;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getAdressPostale() {
        return adressPostale;
    }

    public void setAdressPostale(String adressPostale) {
        this.adressPostale = adressPostale;
    }

    public int getParentAdmin() {
        return parentAdmin;
    }

    public void setParentAdmin(int parentAdmin) {
        this.parentAdmin = parentAdmin;
    }

    public int getDdn() {
        return ddn;
    }

    public void setDdn(int ddn) {
        this.ddn = ddn;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNtelephone1() {
        return ntelephone1;
    }

    public void setNtelephone1(String ntelephone1) {
        this.ntelephone1 = ntelephone1;
    }

    public String getNtelephone2() {
        return ntelephone2;
    }

    public void setNtelephone2(String ntelephone2) {
        this.ntelephone2 = ntelephone2;
    }

    public String getNtelephone3() {
        return ntelephone3;
    }

    public void setNtelephone3(String ntelephone3) {
        this.ntelephone3 = ntelephone3;
    }

   
    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}
