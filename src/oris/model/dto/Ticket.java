
package oris.model.dto;

import java.util.ArrayList;


public class Ticket {
    private String pnr;//
    private String numFile;//
    private String ticket;//
    private String oldTicket;//
    private String codEmd;//
    private String fechaEmision;//
    private String fechaAnulacion;//
    private String fechaRemision;//
    private int posicion;//
    private String nombrePasajero;//
    private String tipoPasajero;//
    private String cLineaAerea;//
    private String ruta;//
    private String moneda;//
    private Double valorNeto;//
    private Double valorTasas;//
    private Double valorFinal;//  
    private Double comision;//
    private String fPago;
    private String tipo;//
    private String estado;//
    private boolean oris;
    private String gds;

    public String getGds() {
        return gds;
    }

    public void setGds(String gds) {
        this.gds = gds;
    }
    private ArrayList<Segmento> segmentos;

    
    
    public boolean isOris() {
        return oris;
    }

    public void setOris(boolean oris) {
        this.oris = oris;
    }
    

    
    private String getFechaSQL(String fecha){//01/02/2013
        if (fecha!=null) {
            if (fecha.length() > 8) {
                return fecha.replace("/", "-");
            }
        }        
        return "1900-01-01";
    }
    
    
   public String getFechaEmisionSql(){
       return getFechaSQL(fechaEmision);
   }
   public String getFechaAnulacionSql(){
       return getFechaSQL(fechaAnulacion);
   }
   public String getFechaReemisionSql(){
       return getFechaSQL(fechaRemision);
   }

    public ArrayList<Segmento> getSegmentos() {
        return segmentos;
    }

    public void setSegmentos(ArrayList<Segmento> segmentos) {
        this.segmentos = segmentos;
    }
   

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr.trim();
    }

    public String getNumFile() {
        return numFile;
    }

    public void setNumFile(String numFile) {
        this.numFile = numFile.trim();
    }

    public String getFechaEmision() {
        return fechaEmision.substring(0,10);
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision.trim();
    }

    public String getFechaAnulacion() {
       return fechaAnulacion;
    }

    public void setFechaAnulacion(String fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion.trim();
    }

    public String getFechaRemision() {
        return fechaRemision;
    }

    public void setFechaRemision(String fechaRemision) {
        this.fechaRemision = fechaRemision.trim();
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda.trim();
    }

    public Double getValorNeto() {
        if (valorNeto==null) {
            return 0.00;
        }
        return valorNeto;
    }

    public void setValorNeto(Double valorNeto) {
        this.valorNeto = valorNeto;
    }

    public Double getValorTasas() {
        if (valorTasas==null) {
            return 0.00;
        }
        return valorTasas;
    }

    public void setValorTasas(Double valorTasas) {
        this.valorTasas = valorTasas;
    }

    public Double getValorFinal() {
        if (valorFinal==null) {
            return 0.00;
        }
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado.trim();
    }
    
    
    

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta.trim();
    }

    
        
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.trim();
    }
    
    

    
    

    public String getCodEmd() {
        return codEmd;
    }

    public void setCodEmd(String codEmd) {
        this.codEmd = codEmd.trim();
    }



    public String getOldTicket() {
        return oldTicket;
    }

    public void setOldTicket(String oldTicket) {
        this.oldTicket = oldTicket.trim();
    }
    
    
    
    public String getfPago() {
        
        if (fPago.length() > 4) {
            if (fPago.substring(0, 2).equals("O/")) {
                return fPago.substring(2, 6);
            }
            return fPago.substring(0, 4);
        }
        return fPago;
    }

    public void setfPago(String fPago) {
        this.fPago = fPago.trim();
    }

    public String getcLineaAerea() {
        return cLineaAerea;
    }

    public void setcLineaAerea(String cLineaAerea) {
        this.cLineaAerea = cLineaAerea.trim();
    }

    public Double getComision() {
        if (comision==null) {
            return 0.00;
        }
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Ticket{" + "pnr=" + pnr + ", numFile=" + numFile + ", ticket=" + ticket + ", oldTicket=" + oldTicket + ", codEmd=" + codEmd + ", fechaEmision=" + fechaEmision + ", fechaAnulacion=" + fechaAnulacion + ", fechaRemision=" + fechaRemision + ", posicion=" + posicion + ", nombrePasajero=" + nombrePasajero + ", tipoPasajero=" + tipoPasajero + ", cLineaAerea=" + cLineaAerea + ", ruta=" + ruta + ", moneda=" + moneda + ", valorNeto=" + valorNeto + ", valorTasas=" + valorTasas + ", valorFinal=" + valorFinal + ", comision=" + comision + ", fPago=" + fPago + ", tipo=" + tipo + ", estado=" + estado + ", segmentos=" + segmentos + ", gds=" + gds+'}';
    }

    
    
    public Ticket(String ticket) {
        this.tipoPasajero="ADT";
        this.comision=0.0;
        this.nombrePasajero="";
        this.posicion=0;
        this.ticket=ticket.trim();
        this.fPago="";
        this.cLineaAerea="";//T-K045-5251879214
        this.oldTicket="";
        this.codEmd="";
        this.gds = "";
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket.trim();
    }


    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero.trim();
    }


    public String getTipoPasajero() {
        return tipoPasajero;
    }

    public void setTipoPasajero(String tipoPasajero) {
        if (tipoPasajero.length() <= 3) {
            this.tipoPasajero = tipoPasajero.trim();
        }else{
            this.tipoPasajero = "ADT";
        }
        
    }

  
   
    
}
