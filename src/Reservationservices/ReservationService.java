/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservationservices;

import com.codename1.io.ConnectionRequest;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.codename1.util.DateUtil;
import entities.Reservation;

/**
 *
 * @author Sejir
 */
public class ReservationService {
     private ConnectionRequest request;
	public boolean resultOK;

    private boolean responseResult;
    public ArrayList<Reservation> Reservations;

	public ReservationService() {
		request = DataSource.getInstance().getRequest();
	}

            public ArrayList<Reservation> getAllReservation() {
        String url = BaseService.BASE_URL + "/mesReservationsJson";
;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Reservations = parseReservation(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return Reservations;
    }
	
	public ArrayList<Reservation> parseReservation(String jsonText)  {
        try {
             Reservations = new ArrayList<Reservation>();
            Reservation p = new Reservation();
            JSONParser jp = new JSONParser();
            
//          String s = "["+jsonText+"]";
		   System.out.println(jsonText);
            Map<String, Object> ProjectListJson = jp.parseJSON(new CharArrayReader(find_(jsonText).toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) ProjectListJson.get("root");
            for (Map<String, Object> obj : list) {
              
           int IdRes = (int)Float.parseFloat(obj.get("idres").toString());
                                String nomclient=obj.get("nomclient").toString();
                                String prenomc = obj.get("prenomc").toString();
                                int idact = (int)Float.parseFloat(obj.get("idact").toString());
                                int numc = (int)Float.parseFloat(obj.get("numc").toString());
                                int nbrePerso = (int)Float.parseFloat(obj.get("nbrePerso").toString());
                                
                
                
              

               Reservations.add(new Reservation(IdRes,nomclient,prenomc,idact,nbrePerso,numc));
            }


        } catch (IOException ex) {
			
        }

        return Reservations;
    }
	
	public String  find_(String a){
			if(!a.substring(0,1).equals("[")){
                a = "["+a+"]";
			}
        return a;
    }
	
	public ArrayList<Reservation> findReclamation(int id) {
        String url = BaseService.BASE_URL + "/"+id;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(request.getResponseData()));
                Reservations = parseReservation(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return Reservations;
    }    
	
	public boolean deleteReservation(int id) {
        String url = BaseService.BASE_URL + "/supprimer/ReservationJson/"+id;
        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = request.getResponseCode() == 200; //Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        return resultOK;
    }
     
	public void ajouterReservation(Reservation p) {
       //try {
            
            MultipartRequest cr = new MultipartRequest();
            cr.setUrl(BaseService.BASE_URL+"/ajouter/ReservationJson");
            cr.setPost(false);
            cr.addArgument("Nomclient", p.getNomClient());  
            cr.addArgument("Prenomc", p.getPrenomC());
            cr.addArgument("Idact", p.getIdAct()+"");
            
            
            cr.addArgument("NbrePerso", p.getNbre_Perso()+"");
            cr.addArgument("Numc", p.getNumCabR()+"");
            
            //->substring(0,10)
           // String start_date = parseDate(p.getDateofcreation().toString() ,"EEE MMM dd HH:mm:ss zzz yyyy", "yyyy-MM-dd");
			
					
            cr.addResponseListener(e -> {
             

                if(cr.getResponseCode() == 200)
                    Dialog.show("Add","Reservationadded " +  p.getNomClient(), "OK",null);

         
            });
            NetworkManager.getInstance().addToQueueAndWait(cr);
            
        /*   }
        catch (ParseException e1) {
         e1.printStackTrace();
         }*/
    }
	
	
	 public void updateReservation(Reservation p,int idres) {
       
             
            MultipartRequest cr = new MultipartRequest();
            cr.setUrl(BaseService.BASE_URL+"/update/ReservationJson"+idres);
        cr.setPost(false);

         cr.addArgument("idres", p.getIdRes()+"");  
            cr.addArgument("nomclient", p.getNomClient());
            cr.addArgument("prenomc", p.getPrenomC());
            cr.addArgument("idact", p.getIdAct()+"");
            cr.addArgument("numc", p.getNumCabR()+"");
            cr.addArgument("nbrePerso",p.getNbre_Perso()+"");
            
            cr.addResponseListener(e -> {
             

                if(cr.getResponseCode() == 200)
                    Dialog.show("Update","Reclamation update " +idres , "OK",null);

         
            });     
            NetworkManager.getInstance().addToQueueAndWait(cr);
           
    }}