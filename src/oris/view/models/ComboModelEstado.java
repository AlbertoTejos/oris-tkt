
package oris.view.models;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import oris.model.dto.LineaAerea;


public class ComboModelEstado extends DefaultComboBoxModel {


    public ComboModelEstado() {     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    addElement("");
                    addElement("ANULADO");
            }
        });
    }
    

    
}
