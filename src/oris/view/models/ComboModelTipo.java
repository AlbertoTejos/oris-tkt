
package oris.view.models;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import oris.model.dto.LineaAerea;


public class ComboModelTipo extends DefaultComboBoxModel {
    ArrayList<LineaAerea> lineas;

    public ComboModelTipo() {     
        actualizarLista();
    }
    
    public void actualizarLista(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    addElement("EMD"); //suman
                    addElement("TKT");
                    addElement("RFD");
                    addElement("ADM"); //suman
                    addElement("ACM"); //suman
                    addElement("SPDR"); //suman
                    addElement("SPCR"); //suman
                    addElement("RD"); // reembolso directo //restan
                    addElement("RI"); // reembolso indirecto //restan
            }
        }); 
    }
    
    
    public void setItem(String item){
        this.removeAllElements();
        addElement(item);
    }
    
    
}
