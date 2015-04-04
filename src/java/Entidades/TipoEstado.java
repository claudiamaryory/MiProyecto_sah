
package Entidades;


public class TipoEstado {
    
    private String idtipoestado;
    private String nombre;

    public TipoEstado(String idtipoestado, String nombre) {
        this.idtipoestado = idtipoestado;
        this.nombre = nombre;
    }

    
    public String getIdtipoestado() {
        return idtipoestado;
    }

    public void setIdtipoestado(String idtipoestado) {
        this.idtipoestado = idtipoestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
