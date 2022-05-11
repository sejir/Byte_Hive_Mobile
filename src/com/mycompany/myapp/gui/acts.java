/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Form;
import com.mycompany.myapp.entities.activites;
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
public class acts extends Form {

        public  acts(Form previous) { 
        setTitle("Liste des acts");

        servicesactvites es = new servicesactvites();
        ArrayList<activites> list = es.allacts();

        

            Button ajoutclub = new Button("Ajouter");
              ajoutclub.addPointerPressedListener(l -> {
 //               servicesactvites.getInstance().Delete(z);
            });

            Container chercherContianer = new Container();
            chercherContianer.setLayout(BoxLayout.y());
            chercherContianer.addAll(ajoutclub);
            this.add(chercherContianer);

            for (activites r : list) {

                Container c3 = new Container(BoxLayout.y());
 
               SpanLabel IdProduit = new SpanLabel( "activity ID"+r.getId_act());
        SpanLabel nb = new SpanLabel("nombre des participant"+r.getNb_personne());
        SpanLabel nomact = new SpanLabel( " nom activite "+r.getDescription());
        SpanLabel description = new SpanLabel( " Descreption"+r.getDescription());
        SpanLabel datedebut = new SpanLabel( "date de debut"+r.getD_debut());
        SpanLabel datefin = new SpanLabel( "date fin"+r.getD_fin());
        SpanLabel idemplacement = new SpanLabel(  "id emplacement"+r.getIdemplacement());
        SpanLabel emplacement = new SpanLabel( "emplacement"+r.getEmplacement());
        Button btnValider = new Button("Add activity");
                c3.add(nb);
                //c3.add(cat0);
                c3.add(nomact);
                c3.add(description);
                c3.add(datedebut);
                c3.add(datefin);
                c3.add(idemplacement);
                c3.add(emplacement);
                c3.add(btnValider);

                Button Delete = new Button("Delete");
                c3.add(Delete);
                
                Button Modifier = new Button("Modifier");
                Modifier.addPointerPressedListener(l -> {
                 new modifieract(this,r).show();
                });
                c3.add(Modifier);

                Delete.getAllStyles().setBgColor(0xF36B08);
                Delete.addActionListener(e -> {
                    Dialog alert = new Dialog("Attention");
                    SpanLabel message = new SpanLabel("Etes-vous sur de vouloir supprimer cet act ?\nCette action est irréversible!");
                    alert.add(message);
                    Button ok = new Button("Confirmer");
                    Button cancel = new Button(new Command("Annuler"));
                    //User clicks on ok to delete account
                    ok.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent evt) {
                            es.Delete(r.getId_act());

                            alert.dispose();
                            refreshTheme();
                        }

                    }
                    );

                    alert.add(cancel);
                    alert.add(ok);
                    alert.showDialog();

                    new acts(previous).show();

                });
                ajoutclub.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {

                        refreshTheme();
                    }

                });
                System.out.println("add act");

                addAll(c3);
}
                getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                        e -> previous.showBack()); // Revenir vers l'interface précédente

            

        }

    
    
    
}
