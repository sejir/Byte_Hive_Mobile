/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.capture.Capture;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.util.ArrayList;
import java.util.List;
 


import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources; 




import com.mycompany.myapp.entities.activites;
import com.mycompany.myapp.services.servicesactvites;
 /**
 *
 * @author chiha
 */
     public class modifieract extends Form {
             Form previous;
     public modifieract(Form previous,activites ev)
    { 
        
        super("Newsfeed", BoxLayout.y());

        setTitle("Modifier Votre club");

        TextField nom = new TextField(ev.getNom_act(), "nom act", 20, TextField.ANY);
        nom.setUIID("TextFieldBlack");

        TextField Description = new TextField(ev.getDescription(), "descr", 20, TextField.ANY);
        Description.setUIID("TextFieldBlack");

        TextField datedeb = new TextField(ev.getD_debut(), "date debut ", 20, TextField.ANY);
        datedeb.setUIID("TextFieldBlack");

        TextField datefin = new TextField(ev.getD_fin(), "date fin", 20, TextField.ANY);
        datefin.setUIID("TextFieldBlack");

   
 
        
        Button btnModifier = new Button("Modifier");
        btnModifier.setUIID("Button");

        //OnClick Button
        btnModifier.addPointerPressedListener(l -> {

            ev.setNom_act(nom.getText());
            ev.setDescription(Description.getText());
            ev.setD_debut(datedeb.getText());
            ev.setD_fin(datefin.getText());

            //Appel a la methode UPDATE
            if (servicesactvites.getInstance().modifieract(ev,ev.getId_act())) {
                //If True
                 new afficheract(this).show();

            }
        });

        Label l2 = new Label("");
        Label l3 = new Label("");
        Label l4 = new Label("");
        Label l5 = new Label("");

        Label l1 = new Label();

        Container content = BoxLayout.encloseY(
                l1, l2,
             
                new FloatingHint(Description),
                new FloatingHint(datedeb),
                new FloatingHint(datefin),
                new FloatingHint(nom),
                btnModifier
             
        );

        add(content);
        show();
    }
}
