/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.util.HashMap;
import java.util.Map;
import com.codename1.ui.Form;

/**
 *
 * @author chiha
 */
     public class HomeForm extends Form{
       Form current;
    public HomeForm () {
        current=this;
        setTitle("Home Page");
       // setLayout(BoxLayout.y());
        Button btnAdd = new Button("add activity");
        Button btnShow = new Button("Show activity");
         Button btnShowF = new Button("Show activity Front");
          Button btnShowT = new Button("Show Interactions TEST");
        
 //Toolbar tb = this.getToolbar();
btnAdd.addActionListener((evt) -> new Addact(current).show());
btnShow.addActionListener((evt) -> new acts(current).show()); 
btnShowT.addActionListener((evt) -> new CalendarForm().show());

addAll(btnAdd,btnShow,btnShowF,btnShowT);
         //getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, (evt) -> {this.showBack();});
    }
    private Map<String, Object> createListEntry(String name, String date) {
    Map<String, Object> entry = new HashMap<>();
    entry.put("Line1", name);
    entry.put("Line2", date);
    return entry;
}
}
