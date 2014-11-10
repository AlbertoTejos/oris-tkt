
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
                    addElement("EMD");
                    addElement("TKT");
                    addElement("RFD");
                    addElement("MPD");
                    addElement("ADM");
                    addElement("ACM");
                    addElement("SPDR");
                    addElement("SPCR");
            }
        }); 
    }
    
    
    public void setItem(String item){
        this.removeAllElements();
        addElement(item);
    }
    
    
}
