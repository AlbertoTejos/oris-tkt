
package oris.model.dao;

import oris.model.db.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oris.model.dto.Ticket;


public class TicketDAO extends Conexion{
    
    private static TicketDAO instance = null;
    private String campos_ticket = "pnr,num_file,ticket,old_ticket,cod_emd,"
                                + "fecha_emision,fecha_anula,fecha_remision,posicion_pasajero,nombre_pasajero,"
                                + "tipo_pasajero,cod_linea_aerea,ruta,moneda,valor_neto,"
                                + "valor_tasas,valor_final,comision,forma_pago,tipo"
                                + ",estado,oris,gds";
    private String campos_segmentos="ticket,nro_segmento,cod_salida,cod_llegada,nom_salida,nom_llegada,fecha_salida,hora_salida,fecha_llegada,hora_llegada,nro_vuelo,linea_aerea,cod_clase";
    public TicketDAO() {
        super();
    }
    
    
    public static TicketDAO getInstance(){
        if (instance==null) {
            instance= new TicketDAO(); 
        }
        return instance;
    }
    
    
    public ArrayList<Ticket> getTicket(Ticket tic_in) throws SQLException{
        Statement stm = getConnection().createStatement();
        String campos = "id,pnr,num_file,ticket,old_ticket,cod_emd,convert(varchar, fecha_emision, 103) as fecha_emisionb,convert(varchar, fecha_anula, 103) as fecha_anula ,convert(varchar, fecha_remision, 103) as fecha_remision ,posicion_pasajero,nombre_pasajero,tipo_pasajero,cod_linea_aerea,ruta,moneda,valor_neto,valor_tasas,valor_final,comision,forma_pago,tipo,estado,oris,gds";
        String sql = "SELECT "+campos+" FROM TICKET WHERE ticket='"+tic_in.getTicket()+"' "; 

        ArrayList<Ticket> tickets = new ArrayList();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Ticket tic = new Ticket(rs.getString("ticket"));
            tic.setPnr(rs.getString("pnr"));
            tic.setNumFile(rs.getString("num_file"));
            tic.setOldTicket(rs.getString("old_ticket"));
            tic.setCodEmd(rs.getString("cod_emd"));
            tic.setFechaEmision(rs.getString("fecha_emisionb"));
            tic.setFechaAnulacion(rs.getString("fecha_anula"));
            tic.setFechaRemision(rs.getString("fecha_remision"));
            tic.setPosicion(rs.getInt("posicion_pasajero"));
            tic.setNombrePasajero(rs.getString("nombre_pasajero"));
            tic.setTipoPasajero(rs.getString("tipo_pasajero"));
            tic.setcLineaAerea(rs.getString("cod_linea_aerea"));
            tic.setRuta(rs.getString("ruta"));
            tic.setMoneda(rs.getString("moneda"));
            tic.setValorNeto(rs.getDouble("valor_neto"));
            tic.setValorTasas(rs.getDouble("valor_tasas"));
            tic.setValorFinal(rs.getDouble("valor_final"));
            tic.setComision(rs.getDouble("comision"));
            tic.setfPago(rs.getString("forma_pago"));
            tic.setTipo(rs.getString("tipo"));
            tic.setEstado(rs.getString("estado"));
            if (rs.getInt("oris")==1) {
                tic.setOris(true);
            }else{
                tic.setOris(false);
            }
            tic.setGds(rs.getString("gds"));
            tic.setSegmentos(SegmentoDAO.getInstance().getSegmentoPorId(tic.getTicket()));
            tickets.add(tic);
            
        }
        return tickets;
    }
    
    public  void updateTicket(Ticket tic) throws SQLException{
    Connection con = getConnection();     
    con.createStatement().executeUpdate("UPDATE ticket SET "
                + "pnr='"+ tic.getPnr()+"',"
                + "num_file='"+ tic.getNumFile()+"',"
                + "old_ticket='"+ tic.getOldTicket()+"',"
                + "cod_emd='"+ tic.getCodEmd()+"',"
                + "fecha_emision='"+ tic.getFechaEmisionSql()+"',"
                + "fecha_anula='"+ tic.getFechaAnulacionSql()+"',"
                + "fecha_remision='"+ tic.getFechaReemisionSql()+"',"
                + "posicion_pasajero='"+ tic.getPosicion()+"',"
                + "nombre_pasajero='"+ tic.getNombrePasajero()+"',"
                + "tipo_pasajero='"+ tic.getTipoPasajero()+"',"
                + "cod_linea_aerea='"+ tic.getcLineaAerea()+"',"
                + "ruta='"+ tic.getRuta()+"',"
                + "moneda='"+ tic.getMoneda()+"',"
                + "valor_neto='"+ tic.getValorNeto()+"',"
                + "valor_tasas='"+ tic.getValorTasas()+"',"
                + "valor_final='"+ tic.getValorFinal()+"',"
                + "comision='"+ tic.getComision()+"',"
                + "forma_pago='"+ tic.getfPago()+"',"
                + "tipo='"+ tic.getTipo()+"',"
                + "estado='"+ tic.getEstado()+"',"
                + "oris = '0'" //cada ves que se modifica un ticket el campo oris vuelve a 0
                + "gds='"+ tic.getGds()+"',"
                +" WHERE ticket='"+tic.getTicket()+"'");    
    }
    
    public  boolean insertTicket(Ticket tic) throws SQLException{
    Connection con = getConnection();
    
    ArrayList<Ticket> ticket = getTicket(tic);
 
    
    if (ticket.size()!=0) {
        return false;
    }
    con.createStatement().executeUpdate("INSERT INTO ticket("+campos_ticket+") VALUES('"
                + tic.getPnr()+"','"
                + tic.getNumFile()+"','"
                + tic.getTicket()+"','"
                + tic.getOldTicket()+"','"
                + tic.getCodEmd()+"','"
                + tic.getFechaEmisionSql()+"','"
                + tic.getFechaAnulacionSql()+"','"
                + tic.getFechaReemisionSql()+"','"
                + tic.getPosicion()+"','"
                + tic.getNombrePasajero()+"','"
                + tic.getTipoPasajero()+"','"
                + tic.getcLineaAerea()+"','"
                + tic.getRuta()+"','"
                + tic.getMoneda()+"','"
                + tic.getValorNeto()+"','"
                + tic.getValorTasas()+"','"
                + tic.getValorFinal()+"','"
                + tic.getComision()+"','"
                + tic.getfPago()+"','"
                + tic.getTipo()+"','"
                + tic.getEstado()+"',"
                + "'0'"
                + tic.getGds()+"','"
                +")");    
    
        return true;
    }
    
    
    public ArrayList<Ticket> getTickets(String desde , String hasta , String lAerea, String nfile, String numeroTicket) throws SQLException{
        Statement stm = getConnection().createStatement();
        String campos = "id,pnr,num_file,ticket,old_ticket,cod_emd,convert(varchar, fecha_emision, 103) as fecha_emisionb,convert(varchar, fecha_anula, 103) as fecha_anula ,convert(varchar, fecha_remision, 103) as fecha_remision ,posicion_pasajero,nombre_pasajero,tipo_pasajero,cod_linea_aerea,ruta,moneda,valor_neto,valor_tasas,valor_final,comision,forma_pago,tipo,estado,oris,gds";
        String sql = "SELECT "+campos+" FROM TICKET WHERE fecha_emision BETWEEN convert(datetime, '"+desde+"', 103) AND convert(datetime, '"+hasta+"', 103) "; 
        
        if (!lAerea.equals("")) {
            sql += " AND cod_linea_aerea='"+lAerea+"'";
        }
        
        if (!nfile.equals("")) {
            sql += " AND num_file='"+nfile+"'";
        }
        
        if (!numeroTicket.equals("")) {
            sql += "AND ticket ='"+numeroTicket+"'";
        }
        
        sql +="ORDER BY fecha_emision DESC ,ticket ASC";
        
        System.out.println(sql);
        ArrayList<Ticket> tickets = new ArrayList();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Ticket tic = new Ticket(rs.getString("ticket"));
            tic.setPnr(rs.getString("pnr"));
            tic.setNumFile(rs.getString("num_file"));
            tic.setOldTicket(rs.getString("old_ticket"));
            tic.setCodEmd(rs.getString("cod_emd"));
            tic.setFechaEmision(rs.getString("fecha_emisionb"));
            tic.setFechaAnulacion(rs.getString("fecha_anula"));
            tic.setFechaRemision(rs.getString("fecha_remision"));
            tic.setPosicion(rs.getInt("posicion_pasajero"));
            tic.setNombrePasajero(rs.getString("nombre_pasajero"));
            tic.setTipoPasajero(rs.getString("tipo_pasajero"));
            tic.setcLineaAerea(rs.getString("cod_linea_aerea"));
            tic.setRuta(rs.getString("ruta"));
            tic.setMoneda(rs.getString("moneda"));
            tic.setValorNeto(rs.getDouble("valor_neto"));
            tic.setValorTasas(rs.getDouble("valor_tasas"));
            tic.setValorFinal(rs.getDouble("valor_final"));
            tic.setComision(rs.getDouble("comision"));
            tic.setfPago(rs.getString("forma_pago"));
            tic.setTipo(rs.getString("tipo"));
            tic.setEstado(rs.getString("estado"));
            if (rs.getInt("oris")==1) {
                tic.setOris(true);
            }else{
                tic.setOris(false);
            }
            tic.setGds(rs.getString("gds"));
            tic.setSegmentos(SegmentoDAO.getInstance().getSegmentoPorId(tic.getTicket()));
            tickets.add(tic);   
        }
        return tickets;
    }
    
    
    public void deleteTicket(Ticket t) throws SQLException{
        Statement stm = getConnection().createStatement();
        String ticket = t.getTicket();
        String sql = "DELETE FROM TICKET WHERE ticket = '"+ticket+"' ";       
        stm.executeUpdate(sql);
        sql = "DELETE FROM SEGMENTOS WHERE ticket = '"+ticket+"' ";       
        stm.executeUpdate(sql);     
    }
    
    
    public boolean existeNumFile(Ticket t ) throws SQLException{
        if (t.getNumFile()==null || t.getNumFile().trim().equals("")) {
            return true;
        }
        Statement stm = getConnection().createStatement();
        String sql = "SELECT num_file FROM file_ WHERE num_file='"+t.getNumFile()+"'";       
        ResultSet rs = stm.executeQuery(sql);
        int cont = 0;
         
        while (rs.next()) {
            cont++;
        }
        System.out.println(cont);
        if (cont > 0) {
            return true;
        }else{
            return false;
        }
    }
    
    
    
    
    public static void main(String[] args) throws SQLException {
        TicketDAO a = new TicketDAO();    
        Ticket tic = new Ticket("123");
        //tic.setNumFile("1001");
        System.out.println(a.existeNumFile(tic));
    }
    
    
    
   
}
