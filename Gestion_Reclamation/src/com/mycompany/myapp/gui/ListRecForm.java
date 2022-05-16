/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.ReclamationGuide;
import com.mycompany.myapp.services.ServiceRec;
import java.util.ArrayList;
/**
 *
 * @author Feryel Derouich
 */
public class ListRecForm extends Form {
    
    public ListRecForm(Form previous) {
        setTitle("List Reports");

        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceRec.getInstance().getAllRec().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        
        /*
        ArrayList<ReclamationGuide>list = ServiceRec.getInstance().getAllRec();
        for (ReclamationGuide rg : list){
            addButton(rg.getGuide_name(), rg.getFullname(), rg.getEmail(), rg.getDescription(), rg);
        }
        */
    }

    /*
    private void addButton(String guide_name, String fullname, String email, String description, ReclamationGuide rg) {
        
        Container cnt = new Container();
        
        TextArea ta = new TextArea(guide_name);
        ta.setUIID("NewsTopLine");
        ta.setEditable(false);
        
        cnt.add(BorderLayout.CENTER, BoxLayout.encloseY(ta));
        
        add(cnt);
    }
    */
    
}
