
package modelo.entidades;

import java.util.ArrayList;

public class Reservacion {
    private int id;
    private Vuelo vuelo;
    private ArrayList<Pasajero> Pasajeros=new ArrayList<Pasajero>();
    private String usuario;
    private TicketPago pago;
    private Equipaje equipaje;

    public Reservacion() {
    }

    public Reservacion(int id,Vuelo vuelo, String usuario, TicketPago pago,Equipaje equipaje) {
        this.id=id;
        this.vuelo = vuelo;
        this.usuario = usuario;
        this.pago = pago;
        this.equipaje=equipaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }



    public ArrayList<Pasajero> getPasajeros() {
        return Pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> Pasajeros) {
        this.Pasajeros = Pasajeros;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public TicketPago getPago() {
        return pago;
    }

    public void setPago(TicketPago pago) {
        this.pago = pago;
    }

    public Equipaje getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(Equipaje equipaje) {
        this.equipaje = equipaje;
    }
    
    
}
