/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.EquipementVendre;
import com.mycompany.entities.User;
import com.mycompany.services.ServiceEquipementVendre;
import com.mycompany.services.ServiceUtlisateur;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class AjouterEquipementVendreForm extends Form{
    
    public AjouterEquipementVendreForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        
        tb.setBackCommand("", e -> {new SignInForm(res).show();});
        setUIID("SignIn");
         
                
        TextField nomEquipV = new TextField("", "Nom Equipement", 20, TextField.ANY);
        TextField prixEquipV = new TextField("", "Prix Equipement", 20, TextField.ANY);
        TextField descriptionEquipV = new TextField("", "Description", 20, TextField.ANY);
        TextField imageEquipV = new TextField("", "Image", 20, TextField.ANY);
        TextField quantiteEquipV = new TextField("", "Quantite Equipement", 20, TextField.ANY);
        TextField idF= new TextField("", "ID Fournisseur", 20, TextField.ANY);
        TextField ratingEquipV= new TextField("", "Rating", 20, TextField.ANY);

        nomEquipV.setSingleLineTextArea(false);
        prixEquipV.setSingleLineTextArea(false);
        descriptionEquipV.setSingleLineTextArea(false);
        imageEquipV.setSingleLineTextArea(false);
        quantiteEquipV.setSingleLineTextArea(false);
        idF.setSingleLineTextArea(false);
        ratingEquipV.setSingleLineTextArea(false);
        Button afficherEquiV = new Button("Afficher les Equipements");
        Button ajouterEquipV = new Button("Ajouter Equipement");


     
       
        afficherEquiV.addActionListener((e) -> {new AfficherEquipementVendre(res).show();});
    
        
        
        Container content = BoxLayout.encloseY(
                new Label("Ajouter Equipement à Vendre", "LogoLabel"),
                
                new Label(""),
                nomEquipV ,
         prixEquipV,
        descriptionEquipV,
        imageEquipV,
        quantiteEquipV ,
        idF,
        ratingEquipV
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                ajouterEquipV,
                FlowLayout.encloseCenter(afficherEquiV)
        ));
        ajouterEquipV.addActionListener((e) -> {
             
         try {
             if(nomEquipV.getText() =="" || prixEquipV.getText() ==""|| descriptionEquipV.getText() ==""|| imageEquipV.getText() ==""|| quantiteEquipV.getText() ==""|| idF.getText() ==""|| ratingEquipV.getText() =="") {
                 Dialog.show("Veuillez vérifier les doneés","","Annuler","OK");
             }
             else {
                 InfiniteProgress ip = new InfiniteProgress();
                 final Dialog iDialog = ip.showInfiniteBlocking();
                 EquipementVendre eq = new EquipementVendre(nomEquipV.getText(),prixEquipV.getText(),descriptionEquipV.getText(),imageEquipV.getText(),quantiteEquipV.getText(),Integer.parseInt(idF.getText()),Double.parseDouble(ratingEquipV.getText()));
                 
                
                 
                 ServiceEquipementVendre.getInstance().ajouterEquipementVendre(eq);
                 Dialog.show("Success","Equipement Ajouté","OK",null);
                
               new AfficherEquipementVendre(res).show();
                
                 
                
                 
             }
         }catch (Exception ex){
             ex.printStackTrace();
         }
         });
             
    
    
}
   
   
    
}
