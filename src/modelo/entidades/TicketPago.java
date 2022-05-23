
package modelo.entidades;

public class TicketPago {
    private float precio;
    private float TUA;
    private String cargosAdicionalesDetalles;
    private float cargosAdicionales;
    private float montoTotal;

    public TicketPago() {
    }

    public TicketPago(float precio, float TUA, String cargosAdicionalesDetalles, float cargosAdicionales, float montoTotal) {
        this.precio = precio;
        this.TUA = TUA;
        this.cargosAdicionalesDetalles = cargosAdicionalesDetalles;
        this.cargosAdicionales = cargosAdicionales;
        this.montoTotal = montoTotal;
    }

    
    
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


    public float getTUA() {
        return TUA;
    }

    public void setTUA(float TUA) {
        this.TUA = TUA;
    }


    public String getCargosAdicionalesDetalles() {
        return cargosAdicionalesDetalles;
    }

    public void setCargosAdicionalesDetalles(String cargosAdicionalesDetalles) {
        this.cargosAdicionalesDetalles = cargosAdicionalesDetalles;
    }

    public float getCargosAdicionales() {
        return cargosAdicionales;
    }

    public void setCargosAdicionales(float cargosAdicionales) {
        this.cargosAdicionales = cargosAdicionales;
    }
    
    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
    
}
