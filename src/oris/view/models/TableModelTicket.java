package oris.view.models;

import java.awt.Desktop;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oris.model.dao.TicketDAO;
import oris.model.dto.Ticket;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class TableModelTicket extends DefaultTableModel {

    private ArrayList<Ticket> tickets;
    private String nombreArchivo;

    //Constructor
    //COLUMNAS DE LA TABLA ALMACENADAS EN UN ARRAY
    public TableModelTicket() {
        super(new String[]{"Tipo", "Linea Aerea", "Estado", "Ticket", "Num File", "Fec Emision", "Fec Vuelo", "Ruta", "Nombre Pax", "Moneda", "Valor Neto", "Valor Tasas", "Valor Final", "% Com", "Ticket Reem", "Oris", "Gds"}, 0);
    }

    //POR CADA TICKET EN EL ARRAYLIST
    public void actualizaTabla() {

        System.out.println("insertando :" + getRowCount());
        this.setRowCount(0);
        for (Ticket tic : tickets) {

            String fec_sal = "";
            try {
                fec_sal = tic.getSegmentos().get(0).getFechaSalida();
            } catch (Exception e) {
                fec_sal = "";
            }
            DecimalFormat format = new DecimalFormat("###,###.##");
            String oris = (tic.isOris()) ? "1" : "0";

            addRow(new Object[]{tic.getTipo(),
                tic.getcLineaAerea(),
                tic.getEstado(),
                tic.getTicket(),
                tic.getNumFile(),
                tic.getFechaEmision(),
                fec_sal,
                tic.getRuta(),
                tic.getNombrePasajero(),
                tic.getMoneda(),
                format.format(tic.getValorNeto()),
                format.format(tic.getValorTasas()),
                format.format(tic.getValorFinal()),
                tic.getComision(),
                tic.getOldTicket(),
                oris,
                tic.getGds()
            });
        }
    }

    public void getTickets(String fechaDesde, String fechaHasta, String lineaAerea, String nfile, String numeroTicket) throws SQLException {

        tickets = TicketDAO.getInstance().getTickets(fechaDesde, fechaHasta, lineaAerea, nfile, numeroTicket);
        if (tickets.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han encotrado registros.");
        }
    }


    @Override
    public boolean isCellEditable(int row, int column) {
        return false; 
    }

    public synchronized void removeAllRows() {
        int rowCount = getRowCount() - 1;
        System.out.println("hola");
        for (int i = rowCount; i >= 0; i--) {
            removeRow(i);
            System.out.println("removidas");
        }

    }

    public void eliminarTicket(Ticket t, int row) throws SQLException {
        TicketDAO.getInstance().deleteTicket(t);
        this.tickets.remove(row);
    }

    public Ticket getTicket(int a) {
        return tickets.get(a);

    }
    
    public ArrayList<Ticket> getArrayTicket(int filasTotal){
        
        return tickets;
    }

    public void exportarTicket(JTable table, ArrayList<Ticket> ticket, String ruta, String desde, String hasta) throws IOException {
        
       this.nombreArchivo = "Tickets "+desde+" hasta "+hasta+".xls";

       
       File file = new File(ruta+"/"+nombreArchivo);
       new File(ruta).mkdirs();
       if (!file.exists()) {
           try {
               file.createNewFile();
           } catch (IOException ex) {
               System.out.println(ex);
           }
       }
        
        TableModel model = table.getModel();
        try {
           try (FileWriter fw = new FileWriter(file)) {
               for (int i = 0; i < model.getColumnCount(); i++) {
                   fw.write(model.getColumnName(i) + "\t");
               }

               fw.write("\n");

               for (int i = 0; i < model.getRowCount(); i++) {
                   for (int j = 0; j < model.getColumnCount(); j++) {
                       fw.write(model.getValueAt(i, j).toString() + "\t");
                   }
                   fw.write("\n");
               }
               
               ejecutarExcel(file);
               System.out.println("Abriendo el archivo: "+file);
           }

        } catch (Exception ex) {
            Logger.getLogger(TableModelTicket.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void ejecutarExcel(File archivo) throws IOException{
        System.out.println("Abriendo excel...");
        
        try {
            if(archivo.canExecute()){
            Desktop.getDesktop().open(archivo);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
 
}
