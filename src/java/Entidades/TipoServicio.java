package Entidades;

public class TipoServicio {
    
   private String tipoServicio;
   private String nombre;

    public TipoServicio(String tipoServicio, String nombre) {
        this.tipoServicio = tipoServicio;
        this.nombre = nombre;
    }
   

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
