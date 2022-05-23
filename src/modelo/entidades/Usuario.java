
package modelo.entidades;


public class Usuario {
    private int id;
    private String correo;
    private String contraseña;
    
    public Usuario(){

    }

    public Usuario(int id, String correo, String contraseña) {
        this.id = id;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public Usuario(String correo, String contraseña) {
        
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
    
    
}
