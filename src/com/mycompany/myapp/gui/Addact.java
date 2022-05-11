/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.activites;
import com.mycompany.myapp.services.servicesactvites;
import java.util.ArrayList;
import com.mycompany.myapp.utils.statics;
/**
 *
 * @author chiha
 */

public class Addact extends Form{
Form previous;

    private String fileNameInServer = "";
    

    public Addact(Form previous){
        
        
    
 setTitle("Add a new product");
        setLayout(BoxLayout.y());
        TextField IdProduit = new TextField("", "activity ID");
        TextField nb = new TextField("", "nombre des participant");
        TextField nomact = new TextField("", " nom activite ");
        TextField description = new TextField("", " Descreption");
        TextField datedebut = new TextField("", "date de debut");
        TextField datefin = new TextField("", "date fin");
        TextField idemplacement = new TextField("", "id emplacement");
        TextField emplacement = new TextField("", "emplacement");
        Button btnValider = new Button("Add activity");

Font materialFontAjout = FontImage.getMaterialDesignFont();
        int size = Display.getInstance().convertToPixels(5, true);
        materialFontAjout = materialFontAjout.derive(size, Font.STYLE_PLAIN);
        Button Delete = new Button("Supprimer");
        Delete.setIcon(FontImage.create("\uea4c", Delete.getUnselectedStyle(), materialFontAjout));
        btnValider.addActionListener((e) -> {
        activites t = new activites(Integer.parseInt(nb.getText()),nomact.getText(),description.getText(),datedebut.getText(),datefin.getText(),Integer.parseInt(idemplacement.getText()),(emplacement.getText()));
            System.out.println("data  ==" + t);
            servicesactvites.getInstance().addact(t);

        });
        addAll(nb, nomact, description, datedebut, datefin,idemplacement,emplacement, btnValider);

 
    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel"))
                .add(BorderLayout.CENTER, v));
    }
    



}