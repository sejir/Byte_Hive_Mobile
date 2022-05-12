/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;
import com.codename1.io.CharArrayReader;
import  com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.URL;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.User;
import com.mycompany.utils.Statics;
import java.util.Map;
import com.mycompany.gui.ProfileForm;
import com.mycompany.gui.BaseForm;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.SignInForm;
import com.codename1.ui.events.ActionListener;
import com.mycompany.gui.SessionManager;
import com.mycompany.utils.Statics;
import com.mycompany.gui.ProfileForm;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;



/**
 *
 * @author chayma 
 */
public class ServiceUtlisateur {
    
    //singleton 
    public static ServiceUtlisateur  instance = null;
    public static boolean resultOK = true;
    String json;
    //initialisation connection request 
    private ConnectionRequest req;   
    public static ServiceUtlisateur getInstance() {
        if (instance == null)
            instance= new ServiceUtlisateur ();
        return instance;
        
    }
   
   public ServiceUtlisateur (){
       req = new ConnectionRequest(); 
   }
   //ajout de l'utlisateur
  public void ajouteruser(User user){
       String url=Statics.BASE_URL+"/ajouteruser?email=" +user.getEmail()+"&name=" 
+user.getName()+"&lastname=" +user.getLastname()+"&password=" +user.getPassword()+"&profilepicture="+user.getProfilepicture();   
  req.setUrl(url);
  req.addResponseListener((e)->{
      
  String str = new String (req.getResponseData()); //Response json 
  System.out.println("data == "+str);
  });
  NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 requete sinon yet3ada chay  
}
  
  public void login(TextField email,TextField password,Resources rs) {
     
        
        String url = Statics.BASE_URL+"/signin?email="+email.getText().toString()+"&password="+password.getText().toString();
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        
        req.setUrl(url);
        req.setPost(true);
        req.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            
            String json = new String(req.getResponseData()) + "";
            try {
            
            if(json.equals("failed")) {
                
                
                
                Dialog.show("Echec d'authentification","Email or password incorrect","OK",null);
              
                
            }
            else {
                System.out.println("data =="+json);
                
                Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                
                
            float id = Float.parseFloat(user.get("id").toString());
                SessionManager.setId((int)id);//jibt id ta3 user ly3ml login w sajltha fi session ta3i
                
                SessionManager.setPassword(user.get("password").toString());
                SessionManager.setEmail(user.get("email").toString());
                SessionManager.setName(user.get("name").toString());
                SessionManager.setLastname(user.get("lastname").toString());  
                SessionManager.setProfilepicture(user.get("profilepicture").toString());
                
                     if(user.size() >0 ) { // l9a user
                        // new BaseForm().show();
                      
                     new ProfileForm(rs).show();
                     } else {
                             Dialog.show("Echec d'authentification","Email or password incorrect","OK",null);
                             email.setText("");
                password.setText("");
                     }
                    
                    }
            
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
   
        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
   

   
   
  
   
   
   //affichage des utlisateurs
   /*public ArrayList<User>affichageUser(){
    ArrayList<User> result = new ArrayList<>();
    String url = Statics.BASE_URL+"/display";
    req.setUrl(url);
    req.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
            JSONParser jsonp;
            jsonp = new JSONParser();
            try {
               Map<String,Object>mapUsers = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
               
               
               List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapUsers.get("root");
               
               for(Map<String, Object> obj : listOfMaps)
              
               {
                User us = new User();
                
                float id = Float.parseFloat(obj.get("id").toString());
                String email = obj.get("email").toString();
                String password = obj.get("password").toString();
                String name = obj.get("name").toString();
                String lastname= obj.get("lastname").toString();
                String profilepicture = obj.get("profilepicture").toString();
                
                us.setId((int)id);
                us.setEmail(email);
                us.setPassword(password);
                us.setName(name);
                us.setLastname(lastname);
                us.setProfilepicture(profilepicture);
                
                result.add(us);
                
                
                
            }
            }catch(Exception ex) {
               ex.printStackTrace();
            }
            
        }
        
    });
    NetworkManager.getInstance().addToQueueAndWait(req);
    return result;
       
   }*/
   public String  getPasswordByEmail(String  email, Resources rs ) {
        
        
        String url = Statics.BASE_URL+"/getPasswordByEmail?email="+email;
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        
        req.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            
            json = new String(req.getResponseData()) + "";
            
            
            try {
            
          
                    
             
                    System.out.println("data =="+json);
                    Map<String,Object> password = j.parseJSON(new CharArrayReader(json.toCharArray()));
                   
                    
                    
                     
                
            
            
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    return json;
    }
  
  
}
