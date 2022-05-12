/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.Preferences;

/**
 *
 * @author chayma
 */
public class SessionManager {
     public static Preferences pref ; 
     private static int id ;
     private static String email ;
     private static String password;
     private static String name ;
    private static String lastname ;
    private static String profilepicture ;
     public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }
     public static int getId() {
        return pref.get("id",id);// kif nheb njib id user connecté apres njibha men pref 
    }

    public static void setId(int id) {
        pref.set("id",id);//nsajl id user connecté  w na3tiha identifiant "id";
    }
     public static String getEmail() {
        return pref.get("email",email);
    }

    public static void setEmail(String email) {
         pref.set("email",email);
    }
     public static String getPassword() {
        return pref.get("password",password);
    }

    public static void setPassword(String password) {
         pref.set("password",password);
    }
    public static String getName() {
        return pref.get("name",name);
    }

    public static void setName(String name) {
         pref.set("name",name);
    }
    
       
    public static String getLastname() {
        return pref.get("lastname",lastname);
    }

    public static void setLastname(String lastname) {
         pref.set("lastname",lastname);
    }
    
    
    
    public static String getProfilepicture() {
        return pref.get("profilepicture",profilepicture);
    }

    public static void setProfilepicture(String profilepicture) {
         pref.set("profilepicture",profilepicture);
    }
    
                 
    
}
