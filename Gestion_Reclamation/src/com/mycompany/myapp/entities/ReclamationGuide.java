/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Feryel Derouich
 */
public class ReclamationGuide {
    private int id;
    private String guide_name;
    private String fullname;
    private String email;
    private String description;

    public ReclamationGuide(int id, String guide_name, String fullname, String email, String description) {
        this.id = id;
        this.guide_name = guide_name;
        this.fullname = fullname;
        this.email = email;
        this.description = description;
    }

    public ReclamationGuide(String guide_name, String fullname, String email, String description) {
        this.guide_name = guide_name;
        this.fullname = fullname;
        this.email = email;
        this.description = description;
    }

    public ReclamationGuide() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuide_name() {
        return guide_name;
    }

    public void setGuide_name(String guide_name) {
        this.guide_name = guide_name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + 
                "id=" + id + 
                ", guide name=" + guide_name + 
                ", Fullname=" + fullname + 
                ", Email=" + email + 
                ", Message=" + description + "\n";
    }
    
    
}
