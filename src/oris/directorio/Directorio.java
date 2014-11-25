/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oris.directorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class Directorio {
    
    private String ruta_excel;
    private BufferedReader bf;
    private static Directorio instance = null;

    public static Directorio getInstance() {
        if (instance == null) {
            instance = new Directorio();
        }
        
        return instance;
    }
   
    public Directorio(String ruta_excel) {
        this.ruta_excel = ruta_excel;
    }

    public String getRuta_excel() {
        return ruta_excel;
    }

    public void setRuta_excel(String ruta_excel) {
        this.ruta_excel = ruta_excel;
    }

    private Directorio() {
        
        try {
            
            bf = new BufferedReader(new FileReader("parametros.conf"));
            String cadena;
            while ((cadena = bf.readLine()) != null) {                
                if (!cadena.equals("")) {
                    String[] split = cadena.split("=>");
                    if (split.length<=1) {
                        split = new String[]{split[0],""};
                    }
                    switch (split[0].trim()) {
                        case "ruta_excel":
                            this.ruta_excel=split[1].trim();
                            break;
                    }
                }
                
            }
            bf.close();
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo de configuracion.");
        }
        }
    
    
    public boolean guardarCambios(){
        
        File f;
            f = new File("parametros.conf");
        try {
            
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.write("ruta_excel=>"+this.ruta_excel);
            pw.close();
            bw.close();
            JOptionPane.showMessageDialog(null,"Se ha guardado la configuración correctamente.");
            return true;
            
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"No se ha podido guardar la configuración.");
            return false;
        }

    }
    
    }
    

