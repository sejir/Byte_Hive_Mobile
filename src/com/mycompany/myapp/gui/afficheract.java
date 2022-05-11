/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Form;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.gui.Addact;
import com.mycompany.myapp.gui.modifieract;
 import java.util.ArrayList;
import java.io.IOException;
import com.mycompany.myapp.entities.activites;
import com.mycompany.myapp.services.servicesactvites;
import com.mycompany.myapp.utils.statics;
/**
 *
 * @author chiha
 */
public class afficheract extends Form {

        public  afficheract(Form previous) {
         Container topp = BoxLayout.encloseY();
       
 topp.setScrollableY(true);
         topp.setScrollVisible(false);
          this.add(topp);
         // super("list Badges",new BorderLayout());
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
      Container b = new Container(BoxLayout.y());
    
        b.setScrollableY(true);
        
            add( b);
          
              // final BrowserComponent cmp = new BrowserComponent();
           /*    BrowserComponent browser = new BrowserComponent();
               browser.setURL("http://127.0.0.1:8000/user");
              add(browser);
               */
    //cmp.setPage("<!doctype html><html><body>Hello World <br><br>Helloooooo<br><br></body></html>", null);
    //add(cmp);
        
           String[] characters = { "none","","titre Asc", "","titre Desc","","datea ASC", "","datea DESC"};
     Picker p = new Picker();
p.setStrings(characters);
p.setSelectedString(characters[0]);
p.addActionListener((e) ->
        {
             ToastBar.showMessage("You sorted the Display by  " + p.getSelectedString(), FontImage.MATERIAL_INFO);
                   //this.removeAll();
                   b.removeAll();
                   if(p.getSelectedString()== characters[2] )
                  display(1,"",b); 
                   if(p.getSelectedString()== characters[4] )
                  display(2,"",b);
                   if(p.getSelectedString()== characters[6] )
                  display(3,"",b); 
                   if(p.getSelectedString()== characters[8] )
                  display(4,"",b);
                    if(p.getSelectedString()== characters[0] )
                  display(0,"",b);
                   
        }
    );
TextField searchbar = new TextField("","Search");
searchbar.addDataChangedListener(new DataChangedListener() {
            public void dataChanged(int type, int index) {
               b.removeAll();
               display(-1,searchbar.getText(),b); 
            
            }
        });

   topp.add(BorderLayout.west(p).add(BorderLayout.EAST,searchbar));
   

 
      display(0,"",b);   
     
    
    }
        public void display(int orderby,String search,Container b)
        {
             
            
b.removeAll();
//this.add(BorderLayout.NORTH,p); 
        SpanLabel sp = new SpanLabel();
        
         ArrayList<activites> list;
        list = new ArrayList<>();
        ArrayList<Button> buttons = null;
        if(orderby != -1)
        list = servicesactvites.getInstance().allacts(orderby);
        else
        list = servicesactvites.getInstance().allacts(search);
        
        
      
        
            EncodedImage enc = null;
            
Image imgs;
ImageViewer imgv;
String urli ;


         for ( activites ev : list) {
            
             Container elements = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             elements.setScrollableY(true);
               
              
             
              
               
            
               
               
        Container buttonss = BoxLayout.encloseX();
      
              Button update = new Button();
              Button delete = new Button();
             
                FontImage.setMaterialIcon(delete, FontImage.MATERIAL_DELETE);
                FontImage.setMaterialIcon(update, FontImage.MATERIAL_UPDATE);
                buttonss.add(BorderLayout.west(update)
                 
              
                .add(BorderLayout.EAST,delete));

 Label nomact = new Label(ev.getNom_act());
     
             elements.add(buttonss);
          
                b.add(BorderLayout.center(elements).
        add(BorderLayout.WEST));
               
               
       update.addActionListener((evt) ->{
    
     new modifieract(this,ev).show();
    
});
     
delete.addActionListener((evt) ->{
   
      if( servicesactvites.getInstance().Delete(ev.getId_act())){
                   Dialog.show("Success","act Deleted","OK",null);}
               else
               {
                   Dialog.show("Error","Request Error","OK",null);
               }
});


     
        
        }
         this.revalidate();

    }
    
}
