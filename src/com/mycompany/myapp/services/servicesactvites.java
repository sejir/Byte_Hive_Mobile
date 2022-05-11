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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.myapp.entities.activites;
import com.mycompany.myapp.utils.statics;
  /**
 *
 * @author chiha
 */
public class servicesactvites {
    
     public ArrayList<activites> activites;
    
    public static servicesactvites instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public servicesactvites() {
        req = new ConnectionRequest();
    }

    public static servicesactvites getInstance() {
        if (instance == null) {
            instance = new servicesactvites();
        }
        return instance;
    }
    
     
    public boolean addact(activites t) {
        System.out.println(t);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = statics.BASE_URL + "/addactiviteJSON?nomAct="+t.getNom_act()+"&description="+t.getDescription()+"dDebut="+t.getD_debut()+"dFin="+t.getD_fin()+"&emplacement="+t.getEmplacement()+"nbPersonne="+t.getNb_personne()+"idemplacement="+1+"idUser="+1;//mizel l user

       req.setUrl(url);
       
       req.addArgument("nomAct", t.getNom_act());
       req.addArgument("description", t.getDescription());
       req.addArgument("nbPersonne", t.getNb_personne()+"");
        req.addArgument("dDebut", t.getD_debut()+""); 
       req.addArgument("dFin", t.getD_fin()+"");
       req.addArgument("emplacement", t.getEmplacement()+"");
      req.addArgument("idemplacement", t.getIdemplacement()+"");
       //req.addArgument("id_user", t.getid()+"");
     //
      System.out.println(t);
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
 
    
    
    public ArrayList<activites> parseact(String jsonText){
        try {
            activites=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> EvenementsListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)EvenementsListJson.get("root");
             for(Map<String,Object> obj : list){
                activites t = new activites();
     
                float id = Float.parseFloat(obj.get("idAct").toString()); 
                t.setId_act((int)id);
                
                 float idemplacement = Float.parseFloat(obj.get("idemplacement").toString()); 
                t.setIdemplacement((int)idemplacement);
                
                float nb_participant = Float.parseFloat(obj.get("nbPersonne").toString());
                t.setNb_personne((int)nb_participant);
                if (obj.get("nomAct")==null)
              t.setNom_act("null");
              
                else
                    t.setNom_act(obj.get("nomAct").toString());
                activites.add(t);
                    
                if (obj.get("dDebut")==null)
              t.setNom_act("null");
              
                else
                    t.setD_fin(obj.get("dDebut").toString());
                activites.add(t);
                  if (obj.get("dFin")==null)
              t.setNom_act("null");
              
                else
                    t.setD_fin(obj.get("dFin").toString());
                activites.add(t);
                
             
if (obj.get("description")==null)
              t.setDescription("null");
              
                else
                    t.setDescription(obj.get("description").toString());
                activites.add(t); 
                  
if (obj.get("emplacement")==null)
              t.setEmplacement("null");
              
                else
                    t.setEmplacement(obj.get("emplacement").toString());
                activites.add(t); 
                
            }

            
            
            
        } catch (IOException ex) {
            
        }
        return activites;
    }
     
    
    public ArrayList<activites> allacts(){
        //String url = Statics.BASE_URL+"/activites/";
        String url = statics.BASE_URL+"/showall/";
         req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                activites = parseact(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return activites;
    }
    
    
    
    public boolean Delete(int id_act) {
        
          req = new ConnectionRequest();
        String url = statics.BASE_URL+"/deleteEventJSON/"+id_act;

        req.setUrl(url);

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

    
 public boolean modifieract(activites t,int id ) {
    
              String url = statics.BASE_URL + "/updateEventJSON/"+id+"?nomAct="+t.getNom_act()+ "&description="+t.getDescription()+"&dDebut="+t.getD_debut()+"&dFin="+ t.getD_fin()+"emplacement="+t.getEmplacement()+"nbPersonne="+t.getNb_personne() ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public ArrayList<activites> allacts(int order){
      

         String url = statics.BASE_URL+"/showall?nb="+order;
        req.setUrl(url);
        req.setPost(false);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              activites=parseact(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return activites;
        
    }
    public ArrayList<activites> allacts(String searched){
      
         String url = statics.BASE_URL+"/searchArticle?str="+searched;
        req.setUrl(url);
        req.setPost(false);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              activites=parseact(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       // NetworkManager.getInstance().addToQueueAsync(req);
        return activites;
        
    }
    
}
