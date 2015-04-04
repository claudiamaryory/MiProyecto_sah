package Entidades;

public class Cliente {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String barrio;
    private String telefono;
    private String celular;
    private String email;
    private String servi;

    public Cliente(String nombre, String apellido, String cedula, String direccion, String barrio, String telefono, String celular, String email, String servi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.barrio = barrio;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.servi = servi;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServi() {
        return servi;
    }

    public void setServi(String servi) {
        this.servi = servi;
    }
   
    
    
    
}
