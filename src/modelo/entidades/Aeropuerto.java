
package modelo.entidades;

public class Aeropuerto {
    private int id;
    private String estado;
    private String ciudad;

    public Aeropuerto() {
    }

    public Aeropuerto(int id, String estado, String ciudad) {
        this.id = id;
        this.estado = estado;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return ""+ ciudad + '(' + estado + ')';
    }
    
    public String cdEdoString(){
        return ""+ciudad+":"+estado;
    }
    /*@Override
    public String toString() {
        return "Aeropuerto{" + "estado=" + estado + ", ciudad=" + ciudad + '}';
    }*/
    
    
}
