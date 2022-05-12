/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import com.codename1.components.FloatingActionButton;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;

import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import entities.Reservation;

import Reservationservices.CabineService;
import Reservationservices.ReservationService;
import com.codename1.ui.Component;
import com.codename1.ui.Image;
import com.codename1.ui.Slider;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.events.ScrollListener;



/**
 *
 * @author Sejir
 */
public class ReservationFrom extends com.codename1.ui.Form {
     public ReservationFrom() {
        //this(com.codename1.ui.util.Resources.getGlobalResources()); 
                setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
		fab.getAllStyles().setBgColor(0x5ed84f);
		fab.addActionListener((ActionListener) (ActionEvent evt1) -> {
    

              new ReservationAddFrom().show();

           }); 
		fab.bindFabToContainer(this.getContentPane());
        ReservationService sr = new ReservationService();
        for (Reservation T :  sr.getAllReservation()) {
                  addItem(T);
        }
    }
    
//    //public ReservationFrom(com.codename1.ui.util.Resources resourceObjectInstance) {
//        initGuiBuilderComponents(resourceObjectInstance);
//        getTitleArea().setUIID("Container");
//        getToolbar().setUIID("Container");
//        getToolbar().getTitleComponent().setUIID("Reservation");
//        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "Reservation", 3.5f);
//       getToolbar().addCommandToLeftBar("", mat, e -> new ReservationFrom().show());
//        getContentPane().setUIID("ReservationaAddForm");
//        
//       
//    }
    

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
           
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Reservation");
        setName("ReservationForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
    }// </editor-fold>



    
    public void addItem(Reservation T) {

        
        Container C = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Label idres = new Label("idres : "+T.getIdRes());
        Label Idact = new Label("idact : "+T.getIdAct());
		Label NomClient = new Label("nomclient : "+T.getNomClient());
        Label PrenomC = new Label("prenomc : "+T.getPrenomC());
        Label Nbre_Perso = new Label("Nbre_Perso : "+T.getNbre_Perso());
        Label NumCabR = new Label("NumCabR : "+T.getNumCabR());
		Label delete = new Label("");
		Label edit = new Label("");
        delete.setTextPosition(LEFT);
		 edit.setTextPosition(LEFT);

        
 //Graphic

  Font f = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_ITALIC, Font.SIZE_MEDIUM);
        Idact.getAllStyles().setFgColor(0x607D8B);
        Idact.getAllStyles().setFont(f);
        NomClient.getAllStyles().setFgColor(0xFFFFFF);
        PrenomC.getAllStyles().setFgColor(0xFFFFFF);
        Nbre_Perso.getAllStyles().setFgColor(0xFFFFFF);
        NumCabR.getAllStyles().setFgColor(0xFFFFFF);
        delete.getAllStyles().setFgColor(0xfa626b);
        delete.getAllStyles().setFont(f);     
        
        C.getAllStyles().setBgColor(0x28afd0);
        C.getAllStyles().setBgTransparency(255);
		        edit.getAllStyles().setFgColor(0x6967ce);
				
        C.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
        C.getAllStyles().setPadding(30,30,30,30);
        C.getAllStyles().setBorder(RoundRectBorder.create()
                .strokeColor(0xFFFFFF)
                .cornerRadius(2)
                .topOnlyMode(true).stroke(3,false));
		
	FontImage.setMaterialIcon(delete, FontImage.MATERIAL_DELETE);
	        FontImage.setMaterialIcon(edit, FontImage.MATERIAL_EDIT);

	
	       ReservationService s = new ReservationService();
        delete.addPointerPressedListener((ActionListener) (ActionEvent evt) -> {
        s.deleteReservation(T.getIdRes());
        Dialog.show("Success", "Reservation Deleted", "OK", null);
		    new ReservationFrom().show();
        });
		 edit.addPointerPressedListener((ActionListener) (ActionEvent evt) -> {
			new ReservationUpdateForm(T).show();
        });
		 
        C1.add(edit);
		C1.add(delete);
		
		C.add(idres);
        
		C.add(Idact);
                C.add(NomClient);
        C.add(PrenomC);
        C.add(Nbre_Perso);
        C.add(NumCabR);
		C.add(C1);
        add(C);
 

    } 
}
