/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author chiha
 */
public class activites {
     public int id_act;
    public int nb_personne;
    public String nom_act;
    public String description;
    public  String d_debut ;
    public String d_fin ;
    public String emplacement;
    public int idemplacement;
 
    public activites(int id_act, int nb_personne, String nom_act, String description, String d_debut, String d_fin, String emplacement, int idemplacement) {
        this.id_act = id_act;
        this.nb_personne = nb_personne;
        this.nom_act = nom_act;
        this.description = description;
        this.d_debut = d_debut;
        this.d_fin = d_fin;
        this.emplacement = emplacement;
        this.idemplacement = idemplacement;
     }

    public activites(String nom_act, String description, String d_debut, String d_fin, String emplacement) {
        this.nom_act = nom_act;
        this.description = description;
        this.d_debut = d_debut;
        this.d_fin = d_fin;
        this.emplacement = emplacement;
     }

    public activites() {
    }

    
public activites(int nb_personne, String nom_act, String description, String d_debut,String d_fin, int idemplacement, String emplacement) {

    this.nb_personne = nb_personne;
        this.nom_act = nom_act;
        this.description = description;
        this.d_debut = d_debut;
        this.d_fin = d_fin;
        this.idemplacement = idemplacement;
        this.emplacement = emplacement;
    }
    
    
    
    
    
    public int getId_act() {
        return id_act;
    }

    public int getNb_personne() {
        return nb_personne;
    }

    public String getNom_act() {
        return nom_act;
    }

    public String getDescription() {
        return description;
    }

    public String getD_debut() {
        return d_debut;
    }

    public String getD_fin() {
        return d_fin;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public int getIdemplacement() {
        return idemplacement;
    }
 

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public void setNb_personne(int nb_personne) {
        this.nb_personne = nb_personne;
    }

    public void setNom_act(String nom_act) {
        this.nom_act = nom_act;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setD_debut(String d_debut) {
        this.d_debut = d_debut;
    }

    public void setD_fin(String d_fin) {
        this.d_fin = d_fin;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public void setIdemplacement(int idemplacement) {
        this.idemplacement = idemplacement;
    }
 

    @Override
    public String toString() {
        return "activites{" + "id_act=" + id_act + ", nb_personne=" + nb_personne + ", nom_act=" + nom_act + ", description=" + description + ", d_debut=" + d_debut + ", d_fin=" + d_fin + ", emplacement=" + emplacement + ", idemplacement=" + idemplacement +'}';
    }
   
   
   
   
   
    
}
