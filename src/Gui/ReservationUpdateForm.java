/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;

import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import Reservationservices.ReservationService;
import entities.Reservation;
/**
 *
 * @author Sejir
 */
public class ReservationUpdateForm extends com.codename1.ui.Form {
        public ReservationUpdateForm(Reservation r) {
        this(com.codename1.ui.util.Resources.getGlobalResources()); 
                setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label lbact = new Label("  "+" Idact : ");
            TextField tfact = new TextField(r.getIdAct()+"", " Idact");
            
            Label lbnom = new Label("  "+" NomClient : ");
            TextField tfnom = new TextField(r.getNomClient(), " NomClient");
			
			Label lbpre = new Label("  "+" PrenomC : ");
            TextField tfpre = new TextField(r.getPrenomC(), " PrenomC");
            
            Label lbnb = new Label("  "+" Nbre_Perso : ");
            TextField tfnb = new TextField(r.getNbre_Perso()+"", " Nbre_Perso");
            
            Label lbnum = new Label("  "+" NumCabR : ");
            TextField tfnum = new TextField(r.getNumCabR()+"", " NumCabR");
            
            
            
            
            
            
            
            
            
            
      

			Button btn = new Button("Valider");
             //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
             //Date endDate = formatter.parse(end_date.getText()); 
             //Date endDate2 = formatter.parse(end_date.getText()); 
             c.add(lbact);
             c.add(tfact);
	     c.add(lbnom);
             c.add(tfnom);
             c.add(lbpre);
             c.add(tfpre);
             c.add(lbnb);
             c.add(tfnb);
             c.add(lbnum);
             c.add(tfnum);
             
             
             c.add(btn);	
             add(c);
            //addAll(name,owner,end_date,end_date,description,btn);

            show();
            btn.addActionListener((ActionListener) (ActionEvent evt1) -> {
          
           tfact.getText();
         
                Reservation T=new Reservation( tfnom.getText(), tfpre.getText(), Integer.valueOf(tfact.getText()), Integer.valueOf(tfnb.getText()), Integer.valueOf(tfnum.getText()) );
                ReservationService sp=new ReservationService();
                 
                         
                if(!tfact.getText().equals("") && !tfnom.getText().equals("") && !tfpre.getText().equals("")&& !tfnb.getText().equals("")&& !tfnum.getText().equals("") ){
                    
					
					sp.updateReservation(T, r.getIdRes());
					new ReservationFrom().showBack();
					
                }
                else{
                 Dialog.show("WARNING"," verifié vos paramètres ", "OK",null);
                }

 

            });
        
    }
    
    public ReservationUpdateForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
//        getToolbar().addCommandToLeftBar("", mat, e -> new SignInForm().show());
        getContentPane().setUIID("SignInForm");
        
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    


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

    
}
