
package oris.model.dto;


public class LineaAerea {
    private String codigo;
    private String nombre;
    private String cIata;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcIata() {
        return cIata;
    }

    public void setcIata(String cIata) {
        this.cIata = cIata;
    }

    public LineaAerea() {
    }

    @Override
    public String toString() {
        return "LineaAerea{" + "codigo=" + codigo + ", nombre=" + nombre + ", cIata=" + cIata + '}';
    }
    
    
}
