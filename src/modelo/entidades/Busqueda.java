
package modelo.entidades;

public class Busqueda {
    Vuelo vueloBuscado;
    int noPasajeros;

    public Busqueda() {
    }

    public Busqueda(Vuelo vueloBuscado, int noPasajeros) {
        this.vueloBuscado = vueloBuscado;
        this.noPasajeros = noPasajeros;
    }

    public Vuelo getVueloBuscado() {
        return vueloBuscado;
    }

    public void setVueloBuscado(Vuelo vueloBuscado) {
        this.vueloBuscado = vueloBuscado;
    }

    public int getNoPasajeros() {
        return noPasajeros;
    }

    public void setNoPasajeros(int noPasajeros) {
        this.noPasajeros = noPasajeros;
    }
    
    
    
}
