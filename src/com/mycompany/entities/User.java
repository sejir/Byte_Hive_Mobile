/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author chayma
 */
public class User {
    private int id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String profilepicture;
    private boolean ban;
    private boolean activate;

    public User() {
    }
  
    
    public User(int id, String email, String password, String name, String lastname, String profilepicture, boolean ban, boolean activate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.profilepicture = profilepicture;
        this.ban = ban;
        this.activate = activate;
    }

    public User(String email, String password, String name, String lastname, String profilepicture, boolean ban, boolean activate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.profilepicture = profilepicture;
        this.ban = ban;
        this.activate = activate;
    }

    public User(String email, String password, String name, String lastname, String profilepicture) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.profilepicture = profilepicture;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
   

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", lastname=" + lastname + ", name=" + name + ", lastname=" + lastname + ", profilepicture=" + profilepicture + ", ban=" + ban + ", activate=" + activate + '}';
    }  
    
}
