
package oris.view.models;

import javax.swing.DefaultComboBoxModel;

public class ComboModelTipoPax extends DefaultComboBoxModel {


    public ComboModelTipoPax() {     
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                    addElement("ADT");
                    addElement("CHD");
                    addElement("INF");
                    
            }
        });
    }
    

    
}
