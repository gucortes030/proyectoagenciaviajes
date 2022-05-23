
package modelo.entidades;

import java.sql.Date;
import java.util.ArrayList;

public class Vuelo {
   private int id;
   private Aeropuerto origen;
   private Aeropuerto destino;
   private String fechaSalida;
   private String fechallegada;
   private String horaSalida;
   private String horaLlegada;
   private Aerolinea aerolinea;
   private int LugDisponibles;
   private int LugReservados;
   private int totalLugares;
   private int tarifa;
   

    public Vuelo() {
    }

    public Vuelo(int id, Aeropuerto origen, Aeropuerto destino, String fechaSalida, String fechallegada, String horaSalida, String horaLlegada, Aerolinea aerolinea, int LugDisponibles, int LugReservados, int totalLugares, int tarifa) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechallegada = fechallegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.aerolinea = aerolinea;
        this.LugDisponibles = LugDisponibles;
        this.LugReservados = LugReservados;
        this.totalLugares = totalLugares;
        this.tarifa = tarifa;
    }

    
    
    public int getTotalLugares() {
        return totalLugares;
    }

    public void setTotalLugares(int totalLugares) {
        this.totalLugares = totalLugares;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }


    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(String fechallegada) {
        this.fechallegada = fechallegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }


    public int getLugDisponibles() {
        return LugDisponibles;
    }

    public void setLugDisponibles(int LugDisponibles) {
        this.LugDisponibles = LugDisponibles;
    }

    public int getLugReservados() {
        return LugReservados;
    }

    public void setLugReservados(int LugReservados) {
        this.LugReservados = LugReservados;
    }

   
    
    public String getFechaLlegar() {
        String fecha="";
        //fechallegada.
        //return fechallegada;
        return fecha;
    }
    
}
