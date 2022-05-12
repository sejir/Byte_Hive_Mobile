/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.EquipementVendre;
import com.mycompany.gui.ProfileForm;
import com.mycompany.gui.SessionManager;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *       
 *
 * @author user
 */
public class ServiceEquipementVendre {
    
  //singleton 
    public static ServiceEquipementVendre instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceEquipementVendre getInstance() {
        if(instance == null )
            instance = new ServiceEquipementVendre();
        return instance ;
    }
    
    
    
    public ServiceEquipementVendre() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public void ajouterEquipementVendre(EquipementVendre eq) {
        
        String url = Statics.BASE_URL + "/addEquipvendre?idequipement=" + eq.getIdEquipement() + "&nomequipv=" + eq.getNomEquipement() +"&prixequipv=" + eq.getPrixEquipement()+ "&descriptionequipv=" + eq.getDescriptionEquipement() + "&imageequipv=" + eq.getImageEquipement() + "&quantiteequipv=" + eq.getQuantiteEquipement() + "$idfour" + eq.getIdFournisseur() + "$ratingv" + eq.getRating(); //création de l'URL
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    
    //affichage
    
    public ArrayList<EquipementVendre>afficherEquipementVendre() {
        ArrayList<EquipementVendre> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/displayEquipvendre";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapEquipV = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapEquipV.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        EquipementVendre eq = new EquipementVendre();
                        System.out.println("data = " +jsonp);
                        
                   float id = Float.parseFloat(obj.get("idequipement").toString());
//                      float idF = Float.parseFloat(obj.get("idfournisseur").toString());
//                    double rating = Double.parseDouble(obj.get("rating").toString());

                    eq.setIdEquipement((int) id);
                    eq.setNomEquipement(obj.get("nomequipement").toString());
                    eq.setPrixEquipement(obj.get("prixequipement").toString());
                    eq.setDescriptionEquipement(obj.get("descriptionequipement").toString());
                    eq.setImageEquipement(obj.get("imageequipement").toString());
                    eq.setQuantiteEquipement(obj.get("quantiteequipement").toString());
//            eq.setIdFournisseur((int) idF);
//                    eq.setRating(rating);
                            
                        
                        
                        //insert data into ArrayList result
                        result.add(eq);
                       
                      
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
    
    
    //Delete 
    public boolean supprimerEquipementVendre(int id ) {
        String url = Statics.BASE_URL +"/deleteEquipvendre"+id;
        
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    
    
    //Update 
    public boolean modifierEquipementVendre(EquipementVendre eq) {
        String url = Statics.BASE_URL + "/updateEquipvendre?idequipement=" + eq.getIdEquipement() + "&nomequipv=" + eq.getNomEquipement() +"&prixequipv=" + eq.getPrixEquipement()+ "&descriptionequipv=" + eq.getDescriptionEquipement()+ "&quantiteequipv=" + eq.getQuantiteEquipement() + "&idfour" + eq.getIdFournisseur() ; //création de l'URL
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    
    
}
