
package oris.model.db;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |

public class Parametros {

    private String servidor;
    private String baseDeDatos;
    private String puerto;
    private String usuario;
    private String contrasena;

    private static Parametros instance= null;

    
   public static Parametros getInstance(){
        if (instance==null) {
           instance = new Parametros();
        }
        return instance;
   }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

   

    
    private Parametros(){cargarXml();}

    @Override
    public String toString() {
        return "Parametros{" + "servidor=" + servidor + ", baseDeDatos=" + baseDeDatos + ", puerto=" + puerto + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }
    
    public void cargarXml(){ 
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( "config.xml" );
        try
        {
            Document document = (Document)builder.build( xmlFile );
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren();

            for ( int i = 0; i < list.size(); i++ )
            {

                Element tabla = (Element) list.get(i);
                switch(tabla.getName()){
                    case "servidor":
                        this.setServidor(tabla.getValue());
                        break;
                    case "basededatos":
                        this.setBaseDeDatos(tabla.getValue());
                        break;    
                    case "puerto":
                        this.setPuerto(tabla.getValue());
                        break;    
                    case "usuario":
                        this.setUsuario(tabla.getValue());
                        break;
                    case "contrasena":
                        this.setContrasena(tabla.getValue());
                        break;    
                }
              
            }
        }catch ( IOException | JDOMException io ) {
            System.out.println( io.getMessage() );
        }
    }

    public static void main(String[] args) {
        System.out.println(Parametros.getInstance());
    }
   }
    
    
    
    
    
