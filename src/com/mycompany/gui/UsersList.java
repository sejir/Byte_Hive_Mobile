/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.User;
import com.mycompany.services.ServiceUtlisateur;
import java.util.ArrayList;

/**
 *
 * @author chayma
 */
public class UsersList extends BaseForm {
    Form current;
    public UsersList(Resources res){
        super("Newsfeed",BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("List of Users");
        getContentPane().setScrollVisible(true);
       

      
      
      
        
        add(LayeredLayout.encloseIn(
                
                BorderLayout.south(
                        GridLayout.encloseIn(3,
                                FlowLayout.encloseCenter(
                                        )
                        )
                )
        ));
        ServiceUtlisateur us = new ServiceUtlisateur();
        ArrayList<User> list = us.affichageUsers();

        {
           
            for (User u : list) {

          
 
                Container c3 = new Container(BoxLayout.y());
               
                 SpanLabel cat= new SpanLabel("Email :" + u.getEmail());
                 SpanLabel cat1= new SpanLabel("name :" + u.getName());
                 SpanLabel cat2= new SpanLabel("lastname :" + u.getLastname());
                 SpanLabel cat3= new SpanLabel("password :" + u.getPassword());

               
                     
                      
                        c3.add(cat);
                        c3.add(cat1);
                        c3.add(cat2);
                        c3.add(cat3);
       
       
                
                //new ListArticle(previous).show();
              
                
          
            
                       
                        
           System.out.println("");
              
  add(c3);
  
          
        }
     
        }
        
        
        
        
        
        
        
    }
    
}
