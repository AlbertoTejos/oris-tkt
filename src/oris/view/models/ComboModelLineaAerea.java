
package oris.view.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import oris.model.dao.LineaAereaDAO;
import oris.model.dto.LineaAerea;


public final class ComboModelLineaAerea extends DefaultComboBoxModel {
    ArrayList<LineaAerea> lineas;

    public ComboModelLineaAerea() throws SQLException {
        actualizarLista();
    }
    
    public void actualizarLista() throws SQLException{  
        
        lineas = LineaAereaDAO.getInstance().getLineasAereas();
        addElement("Todas las lineas");
        for (LineaAerea lineaAerea : lineas) {
            addElement(lineaAerea.getCodigo()+" - "+lineaAerea.getNombre());
        }
              
       
    }
    
    public LineaAerea getLinea(int index){
        if (index > 0) {
            return lineas.get(index);
        }
        return null;
    }

    public String getCodigoLinea(int index){
        if (index > 0) {
            return lineas.get(index-1).getcIata();
        }
        return "";
    }
}
