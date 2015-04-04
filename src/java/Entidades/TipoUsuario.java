package Entidades;


public class TipoUsuario {
    
   private String idrol;
   private String nombre;

    public TipoUsuario(String idrol, String nombre) {
        this.idrol = idrol;
        this.nombre = nombre;
    }

    public String getIdrol() {
        return idrol;
    }

    public void setIdrol(String idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
   
}
