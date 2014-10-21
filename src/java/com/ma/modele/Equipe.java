/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.modele;

/**
 *
 * @author Casa Nova
 */
public class Equipe {
    int idCategorie,idCoach,idEquipe, assistant1, assistant2, assistant3,assistant4;
    String nomEquipe;
    

    public Equipe(int idEquipe, String nomEquipe, int idCategorie, int idCoach, int assistant1, int assistant2, int assistant3, int assistant4) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.idCategorie = idCategorie;
        this.idCoach = idCoach;
        this.assistant1 = assistant1;
        this.assistant2 = assistant2;
        this.assistant3 = assistant3;
        this.assistant4 = assistant4;       
        
    }
    
        public Equipe(String nomequipe, int idCategorie) {
        this.idCategorie = idCategorie;
        this.nomEquipe = nomequipe;
    }
        
       public Equipe( String nomequipe) {
        this.nomEquipe = nomequipe;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdcoach() {
        return idCoach;
    }

    public void setIdcoach(int idcoach) {
        this.idCoach = idcoach;
    }

    public int getIdequipe() {
        return idEquipe;
    }

    public void setIdequipe(int idequipe) {
        this.idEquipe = idequipe;
    }

    public String getNomequipe() {
        return nomEquipe;
    }

    public void setNomequipe(String nomequipe) {
        this.nomEquipe = nomequipe;
    }
    
    
}
