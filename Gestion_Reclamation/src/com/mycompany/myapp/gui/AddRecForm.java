/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.ReclamationGuide;
import com.mycompany.myapp.services.ServiceRec;

/**
 *
 * @author bhk
 */
public class AddRecForm extends Form{

    public AddRecForm(Form previous) {
        setTitle("Add a new report");
        setLayout(BoxLayout.y());
        
        TextField tfFullname = new TextField("","Fullname");
        TextField tfEmail= new TextField("", "Email");
        TextField tfGuidename= new TextField("", "Guide name");
        TextField tfDesc= new TextField("", "Message");
        Button btnValider = new Button("Add report");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfFullname.getText().length()==0)||(tfEmail.getText().length()==0)||(tfGuidename.getText().length()==0)||(tfDesc.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        ReclamationGuide rg = new ReclamationGuide(tfGuidename.getText().toString(), tfFullname.getText().toString(), tfEmail.getText().toString(), tfDesc.getText().toString());
                        if( ServiceRec.getInstance().addRec(rg))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                           new ListRecForm(previous).show();
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Email must be valid", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfGuidename, tfFullname,tfEmail, tfDesc,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
}
