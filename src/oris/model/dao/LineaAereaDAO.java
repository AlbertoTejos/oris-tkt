package oris.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oris.model.db.Conexion;
import oris.model.dto.LineaAerea;


public class LineaAereaDAO extends Conexion{
    private static LineaAereaDAO instance = null;
    
    
    private LineaAereaDAO() {
        super();
    }
    
    public static LineaAereaDAO getInstance(){
        if (instance==null) {
            instance= new LineaAereaDAO(); 
        }
        return instance;
    }

    
     public ArrayList<LineaAerea> getLineasAereas() throws SQLException{
        Statement stm = getConnection().createStatement();
        String sql = "SELECT * FROM operad WHERE ciata IS NOT NULL ";
        ArrayList<LineaAerea> lineas = new ArrayList();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            LineaAerea la = new LineaAerea();
            la.setCodigo(rs.getString("codigo").trim());
            la.setNombre(rs.getString("nombre").trim());
            la.setcIata(rs.getString("ciata").trim());
            System.out.println(la);
            lineas.add(la);
        }
        return lineas;
    }
     
     
     public static void main(String[] args) throws SQLException {
        LineaAereaDAO a = new LineaAereaDAO();
        a.getLineasAereas();
    }
}
