
package oris.view.models;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboModelMoneda extends DefaultComboBoxModel {
   

    public ComboModelMoneda() {     
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                    addElement("CLP");
                    addElement("USD");
            }
        }); 
    }
    
public static int getIndexSelectedValue(String name){
        switch(name){
            case "USD":
                System.out.println("USD");
                return 2;
            case "CLP":
                System.out.println("CLP");
                return 1;       
        }
        
        return 0;
    }
    

    
    
}
