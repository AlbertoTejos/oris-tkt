
package oris.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oris.model.dto.Segmento;
import oris.model.db.Conexion;


public class SegmentoDAO extends Conexion{
    private static SegmentoDAO instance = null;
    
    
    private SegmentoDAO() {
        super();
    }
    
    public static SegmentoDAO getInstance(){
        if (instance==null) {
            instance= new SegmentoDAO(); 
        }
        return instance;
    }

    
     public ArrayList<Segmento> getSegmentoPorId(String ticket) throws SQLException{
        Statement stm = getConnection().createStatement();
        String sql = "SELECT * FROM segmentos WHERE ticket='"+ticket+"'";
        ArrayList<Segmento> segmentos = new ArrayList();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Segmento seg = new Segmento(rs.getString("ticket"));
            seg.setNumeroSegmento(rs.getInt("nro_segmento"));
            seg.setCodSalida(rs.getString("cod_salida"));
            seg.setCodLlegada(rs.getString("cod_llegada"));
            seg.setNomSalida(rs.getString("nom_salida"));
            seg.setNomLlegada(rs.getString("nom_llegada"));
            seg.setFechaSalida(rs.getString("fecha_salida"));
            seg.setHorSalida(rs.getString("hora_salida"));
            seg.setFechaLlegada(rs.getString("fecha_llegada"));
            seg.setHorLLegada(rs.getString("hora_llegada"));
            seg.setNumeroVuelo(rs.getString("nro_vuelo"));
            seg.setLineaAerea(rs.getString("linea_aerea"));
            seg.setCodClase(rs.getString("cod_clase"));
            segmentos.add(seg);
        }
        return segmentos;
    }
     
     
     
     public static void main(String[] args) throws SQLException {
        SegmentoDAO a = new SegmentoDAO();
        a.getSegmentoPorId("5252065233");
    }
}
