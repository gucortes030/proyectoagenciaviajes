
package modelo.entidades;

import java.util.ArrayList;

public class Avion {
    private int totalAsientos;
    private int totalAsientosReservados;
    

    public Avion() {
    }

    public Avion(int totalAsientos, int totalAsientosReservados) {
        this.totalAsientos = totalAsientos;
        this.totalAsientosReservados = totalAsientosReservados;
    }

    public int getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(int totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public int getTotalAsientosReservados() {
        return totalAsientosReservados;
    }

    public void setTotalAsientosReservados(int totalAsientosReservados) {
        this.totalAsientosReservados = totalAsientosReservados;
    }

}
