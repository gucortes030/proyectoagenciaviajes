
package modelo.entidades;

public class Equipaje {
    private String tipo;
    private String destalles;

    public Equipaje() {
    }

    public Equipaje(String tipo, String destalles) {
        this.tipo = tipo;
        this.destalles = destalles;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestalles() {
        return destalles;
    }

    public void setDestalles(String destalles) {
        this.destalles = destalles;
    }
    
}
