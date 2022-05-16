/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.ReclamationGuide;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Feryel Derouich
 */
public class ServiceRec {
    
    public ArrayList<ReclamationGuide> reclamation;
    
    public static ServiceRec instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceRec() {
         req = new ConnectionRequest();
    }

    public static ServiceRec getInstance() {
        if (instance == null) {
            instance = new ServiceRec();
        }
        return instance;
    }

    public boolean addRec(ReclamationGuide rg) {
        System.out.println(rg);
        System.out.println("Add Report");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = Statics.BASE_URL + "/ajouterreclamationguide?nom_guide="+rg.getGuide_name()+"&fullname"+rg.getFullname()+"&email"+rg.getEmail()+"&description"+rg.getDescription();
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("nom_guide", rg.getGuide_name());
       req.addArgument("fullname", rg.getFullname());
       req.addArgument("email", rg.getEmail());
       req.addArgument("description", rg.getDescription());
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<ReclamationGuide> parseRec(String jsonText){
        try {
            reclamation=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                ReclamationGuide rg = new ReclamationGuide();
                float id = Float.parseFloat(obj.get("id").toString());
                rg.setId((int)id);
                rg.setGuide_name((obj.get("guide name").toString()));
                rg.setEmail((obj.get("email").toString()));
                rg.setDescription((obj.get("message").toString()));
                if (obj.get("fullname")==null)
              rg.setFullname("null");
                else
                rg.setFullname(obj.get("fullname").toString());
                reclamation.add(rg);
            }
            
            
        } catch (IOException ex) {
            
        }
        return reclamation;
    }
    
    public ArrayList<ReclamationGuide> getAllRec(){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/displayReclamationGuide";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamation = parseRec(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamation;
    }
}
