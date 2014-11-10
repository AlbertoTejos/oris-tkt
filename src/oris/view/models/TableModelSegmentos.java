
package oris.view.models;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import oris.model.dao.TicketDAO;
import oris.model.dto.Segmento;
import oris.model.dto.Ticket;

public final class TableModelSegmentos extends DefaultTableModel{
    private Ticket ticket;
    
    
    public TableModelSegmentos(Ticket ticket){
        super(new String[]{"N° Segmento","Ciudad Salida","Ciudad LLegada","Fecha Salida","Fecha Llegada","Vuelo","Linea Aerea","Clase"},0);
        this.ticket = ticket;       
        actualizaTabla();
    }
    
    public void actualizaTabla(){    
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {           
                for (Segmento  seg : ticket.getSegmentos()) {
                    addRow(new Object[]{seg.getNumeroSegmento(),seg.getNomSalida(),seg.getNomLlegada(),seg.getFechaSalida()+" "+seg.getHorSalida(),seg.getFechaLlegada()+" "+seg.getHorLLegada(),seg.getNumeroVuelo(),seg.getLineaAerea(),seg.getCodClase()}); 
                }
            }
        });  

    }
    
    

    
    
    @Override
    public boolean isCellEditable(int row, int column) {
            return false;
    }
    
    public void removeAllRows(){
        int rowCount= getRowCount();
        System.out.println(rowCount);
        for(int i = rowCount - 1; i >=0; i--)
        {
           removeRow(i); 
        }
    }
    
    
//    public Ticket getTicket(int a){
//       // return tickets.get(a);
//    }
    
    
    
    
   
}
