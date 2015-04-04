package Entidades;


public class MedicionServicio {
  
    private String idmedserv;
    private String cedulacliente;
    private String idservicio;
    private String idtipmedicion;
    private String observacion;

    public MedicionServicio(String idmedserv, String cedulacliente, String idservicio, String idtipmedicion, String observacion) {
        this.idmedserv = idmedserv;
        this.cedulacliente = cedulacliente;
        this.idservicio = idservicio;
        this.idtipmedicion = idtipmedicion;
        this.observacion = observacion;
    }

    public String getIdmedserv() {
        return idmedserv;
    }

    public void setIdmedserv(String idmedserv) {
        this.idmedserv = idmedserv;
    }

    public String getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(String cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public String getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    public String getIdtipmedicion() {
        return idtipmedicion;
    }

    public void setIdtipmedicion(String idtipmedicion) {
        this.idtipmedicion = idtipmedicion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

   
}
