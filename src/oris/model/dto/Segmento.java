
package oris.model.dto;


public class Segmento {
    private String ticket;
    private int numeroSegmento;
    private String codSalida;
    private String codLlegada;
    private String nomSalida;
    private String nomLlegada;
    private String horSalida;
    private String horLLegada;
    private String fechaSalida;
    private String fechaLlegada;
    private String numeroVuelo;
    private String lineaAerea;
    private String codClase;

    public Segmento(String ticket) {
        this.ticket = ticket.trim();
        this.numeroSegmento = 0;
        this.codSalida = "";
        this.codLlegada = "";
        this.nomSalida = "";
        this.nomLlegada = "";
        this.horSalida = "";
        this.horLLegada = "";
        this.fechaSalida = "";
        this.fechaLlegada = "";
        this.numeroVuelo = "";
        this.lineaAerea = "";
        this.codClase = "";
    }
    
    



    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida.trim();
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada.trim();
    }

        
    
    public int getNumeroSegmento() {
        return numeroSegmento;
    }

    public void setNumeroSegmento(int numeroSegmento) {
        this.numeroSegmento = numeroSegmento;
    }



    public String getCodSalida() {
        return codSalida;
    }

    public void setCodSalida(String codSalida) {
        this.codSalida = codSalida.trim();
    }

    public String getCodLlegada() {
        return codLlegada;
    }

    public void setCodLlegada(String codLlegada) {
        this.codLlegada = codLlegada.trim();
    }

    public String getNomSalida() {
        return nomSalida;
    }

    public void setNomSalida(String nomSalida) {
        this.nomSalida = nomSalida.trim();
    }

    public String getNomLlegada() {
        return nomLlegada;
    }

    public void setNomLlegada(String nomLlegada) {
        this.nomLlegada = nomLlegada.trim();
    }

    public String getHorSalida() {
        return horSalida;
    }

    public void setHorSalida(String horSalida) {
        this.horSalida = horSalida.trim();
    }

    public String getHorLLegada() {
        return horLLegada;
    }

    public void setHorLLegada(String horLLegada) {
        this.horLLegada = horLLegada.trim();
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo.trim();
    }

    public String getLineaAerea() {
        return lineaAerea;
    }

    public void setLineaAerea(String lineaAerea) {
        this.lineaAerea = lineaAerea.trim();
    }

    public String getCodClase() {
        return codClase;
    }

    public void setCodClase(String codClase) {
        this.codClase = codClase.trim();
    }

    @Override
    public String toString() {
        return "Segmento{" + "ticket=" + ticket + ", numeroSegmento=" + numeroSegmento + ", codSalida=" + codSalida + ", codLlegada=" + codLlegada + ", nomSalida=" + nomSalida + ", nomLlegada=" + nomLlegada + ", horSalida=" + horSalida + ", horLLegada=" + horLLegada + ", fechaSalida=" + fechaSalida + ", fechaLlegada=" + fechaLlegada + ", numeroVuelo=" + numeroVuelo + ", lineaAerea=" + lineaAerea + ", codClase=" + codClase + '}';
    }
    
    
  
    
    
    
  
    
    
    
    
    
}
