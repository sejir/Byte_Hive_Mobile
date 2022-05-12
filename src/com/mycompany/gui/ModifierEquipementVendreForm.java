/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.EquipementVendre;
import com.mycompany.services.ServiceEquipementVendre;

/**
 *
 * @author Lenovo
 */
public class ModifierEquipementVendreForm extends BaseForm {
   
    Form current;
    public ModifierEquipementVendreForm(Resources res , EquipementVendre r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
   
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Commande");
        getContentPane().setScrollVisible(false);
       
       
        super.addSideMenu(res);
       
        TextField nomeq = new TextField(String.valueOf(r.getNomEquipement()), "nom" , 20 , TextField.ANY);
        TextField prix = new TextField(r.getPrixEquipement(), "prix" , 20 , TextField.ANY);
         TextField desc = new TextField(r.getDescriptionEquipement(), "description" , 20 , TextField.ANY);
        TextField nom_e = new TextField(r.getQuantiteEquipement(), "Quantite" , 20 , TextField.ANY);
     //      TextField idfour = new TextField(r.getIdFournisseur(), "Quantite" , 20 , TextField.ANY);
       
        nomeq.setUIID("NewsTopLine");
        prix.setUIID("NewsTopLine");
        desc.setUIID("NewsTopLine");
        nom_e.setUIID("NewsTopLine");
       
        nomeq.setSingleLineTextArea(true);
        prix.setSingleLineTextArea(true);
        desc.setSingleLineTextArea(true);
          nom_e.setSingleLineTextArea(true);
       
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   {
           
         
           r.setNomEquipement(nomeq.getText());
           r.setPrixEquipement(prix.getText());
           r.setDescriptionEquipement(desc.getText());
              r.setQuantiteEquipement(nom_e.getText());
       
       
       //appel fonction modfier reclamation men service
       
       if(ServiceEquipementVendre.getInstance().modifierEquipementVendre(r)) { // if true
           new AfficherEquipementVendre(res).show();
           refreshTheme();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new AfficherEquipementVendre(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
       Label l1 = new Label();
       
        Container content = BoxLayout.encloseY(
                l1, l2,
                new FloatingHint(nomeq),
                createLineSeparator(),
                new FloatingHint(prix),
                createLineSeparator(),
                new FloatingHint(desc),
                 createLineSeparator(),
                new FloatingHint(nom_e),
               
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
               
               
        );
       
        add(content);
        show();
       
       
    }
}