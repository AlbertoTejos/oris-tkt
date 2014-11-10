
package oris.view.models;

import javax.swing.DefaultComboBoxModel;


public class ComboModelPosicion extends DefaultComboBoxModel {


    public ComboModelPosicion() {     
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                    addElement(1);
                    addElement(2);
                    addElement(4);
                    addElement(5);
                    addElement(6);
                    addElement(7);
                    addElement(8);
                    addElement(9);
                    addElement(10);
                    
            }
        });
    }
    

    
}
