
package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.basedatos.VueloDAO;
import modelo.entidades.Aeropuerto;
import modelo.entidades.Busqueda;
import modelo.entidades.Usuario;
import modelo.entidades.Vuelo;


public class VistaListarVuelosController implements Initializable {
    Vuelo vueloSelec;
    Usuario usuario;
    VueloDAO vueloDAO=new VueloDAO();
    ArrayList<Vuelo> listaVuelos;
    ArrayList<ImageView> logosAerolinea=new ArrayList<ImageView>();
    int totalPasajeros=0;
    
    ArrayList<Label> etiquetasOrigen=new ArrayList<Label>();
    ArrayList<Label> etiquetasDestino=new ArrayList<Label>();
    ArrayList<Label> etiquetasHoraSalida=new ArrayList<Label>();
    ArrayList<Label> etiquetasHoraLlegada=new ArrayList<Label>();
    ArrayList<Label> etiquetasPrecio=new ArrayList<Label>();

    
    
    @FXML
    private AnchorPane panMain;
    @FXML
    private SplitPane splitHorizontal;
    @FXML
    private AnchorPane splitHorizontalAPanelArriba;
    @FXML
    private AnchorPane splitHorizontalAPanelAbajo;
    @FXML
    private SplitPane splitPanelVertical;
    @FXML
    private AnchorPane splitPanelVerticalIzquierda;
    @FXML
    private AnchorPane splitPanelVerticalDerecha;
    @FXML
    private VBox vBoxHorizontal;
    @FXML
    private Pane panVuelo1;
    @FXML
    private ImageView imgViewLogo1;
    @FXML
    private Label lblUsuario;
    @FXML
    private ImageView imgLogoSelec;
    @FXML
    private Label lblAerolinea;
    @FXML
    private Label lblOrigenSelec;
    @FXML
    private Label lblDestinoSelec;
    @FXML
    private Label lblDuracion;
    @FXML
    private Label lblNoVuelo;
    @FXML
    private Label lblHoraSalSelec;
    @FXML
    private Label lblHoraLlegSelec;
    @FXML
    private Label lblTarifa;
    @FXML
    private Label lblOrigen1;
    @FXML
    private Label lblHoraSalida1;
    @FXML
    private Label lblDestino1;
    @FXML
    private Label lblHoraLlegada1;
    @FXML
    private Label lblMonto1;
    @FXML
    private Pane panVuelo12;
    @FXML
    private ImageView imgViewLogo11;
    @FXML
    private Label lblOrigen11;
    @FXML
    private Label lblHoraSalida11;
    @FXML
    private Label lblDestino11;
    @FXML
    private Label lblHoraLlegada11;
    @FXML
    private Label lblMonto11;
    @FXML
    private Pane panVuelo121;
    @FXML
    private ImageView imgViewLogo111;
    @FXML
    private Label lblOrigen111;
    @FXML
    private Label lblHoraSalida111;
    @FXML
    private Label lblDestino111;
    @FXML
    private Label lblHoraLlegada111;
    @FXML
    private Label lblMonto111;
    @FXML
    private Pane panVuelo1211;
    @FXML
    private ImageView imgViewLogo1111;
    @FXML
    private Label lblOrigen1111;
    @FXML
    private Label lblHoraSalida1111;
    @FXML
    private Label lblDestino1111;
    @FXML
    private Label lblHoraLlegada1111;
    @FXML
    private Label lblMonto1111;
    @FXML
    private Pane panVuelo12111;
    @FXML
    private ImageView imgViewLogo11111;
    @FXML
    private Label lblOrigen11111;
    @FXML
    private Label lblHoraSalida11111;
    @FXML
    private Label lblDestino11111;
    @FXML
    private Label lblHoraLlegada11111;
    @FXML
    private Label lblMonto11111;
    @FXML
    private Label lblPrecio;
    @FXML
    private Label lblTUA;
    @FXML
    private Label lblMontoTotal;
    @FXML
    private Button btnComprar;
    @FXML
    private Label lblNoPasajeros;
    @FXML
    private Pane panIzqDetalles;
    @FXML
    private Pane panIzqPrecio;
    @FXML
    private Button btn1;
    @FXML
    private Button btnPanel2;
    @FXML
    private Button btnPanel3;
    @FXML
    private Button btnPanel4;
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ENTRANDO AL METODO initialize");
        //crearObjetos();
    }


    public void infoEntreVentanas(Busqueda busqueda,String usuario){
        int tamLista=0;
        System.out.println("ENTRANDO AL METODO infoEntreVentanas");
        lblUsuario.setText(usuario);
        lblNoPasajeros.setText(busqueda.getNoPasajeros()+" Pasajeros");
        totalPasajeros=busqueda.getNoPasajeros();
        llenarListasEtiquetas();
        
        Vuelo vuelo=busqueda.getVueloBuscado();
        Aeropuerto salida=vuelo.getOrigen();
        Aeropuerto llegada=vuelo.getDestino();
        String fechaElegida=busqueda.getVueloBuscado().getFechaSalida();
        //System.out.println("ORIGEN:"+salida.getCiudad());
        //System.out.println("SALIDA:"+llegada.getCiudad());
        //System.out.println("FECHA:"+fechaElegida);
        //System.out.println("Pasajeros:"+busqueda.getNoPasajeros());
        
        
        listaVuelos=vueloDAO.consultarVuelos(salida,llegada ,fechaElegida, busqueda.getNoPasajeros());
        if(listaVuelos==null){
            System.err.println("LA CONSULTA NO DEVOLVIO UNA LISTA VACIA");
        }
        //Vuelo vueloAux=listaVuelos.get(0);
        //String cadena="Voy a ir a:"+vueloAux.getOrigen().getCiudad();
        //|System.out.println(cadena);
        
        tamLista=listaVuelos.size();
        switch(tamLista){
            case 1:
                panVuelo12.setVisible(false);
                panVuelo121.setVisible(false);
                panVuelo1211.setVisible(false);
                panVuelo12111.setVisible(false);
            case 2:
                panVuelo121.setVisible(false);
                panVuelo1211.setVisible(false);
                panVuelo12111.setVisible(false);
            case 3:
                panVuelo1211.setVisible(false);
                panVuelo12111.setVisible(false);
            case 4:
                panVuelo12111.setVisible(false);
            case 5:
                System.out.println("Hay 5 registros");
            default: System.out.println("Hubo un error en el switch");
        }
        llenarPanelIzquierdo(listaVuelos.get(0),busqueda.getNoPasajeros());
        llenarPanelDerecho(listaVuelos,busqueda.getNoPasajeros());
    }
    
    private void llenarPanelIzquierdo(Vuelo  vueloAux,int pasajeros){
        System.out.println("ENTRANDO AL METODO llenarPanelIzquierdo");
        //ArrayList<Vuelo> lista=vuelos;
        Image imageLogo;
        String destino;
        String origen;
        String aerolinea;
        String duracion;
        int noVuelo;
        String horaSale;
        String horaLlega;
        int tarifaInt;
        int precioInt;
        double TUAInt=524.6;
        double montoInt;
        
        //System.out.println("ORIGEN:"+origen);
        origen=vueloAux.getOrigen().getCiudad();
        destino=vueloAux.getDestino().getCiudad();
        aerolinea=vueloAux.getAerolinea().getNombre();
        imageLogo=obtenerLogo(aerolinea);
        noVuelo=vueloAux.getId();
        horaSale=vueloAux.getHoraSalida();
        horaLlega=vueloAux.getHoraLlegada();
        calcularTiempo(horaSale,horaLlega);
        tarifaInt=vueloAux.getTarifa();
        precioInt=calcularPrecio(tarifaInt,pasajeros);
        montoInt=precioInt+TUAInt;
        
        //System.out.println("DESTINO:"+destino);
        imgLogoSelec.setImage(imageLogo);
        lblAerolinea.setText(aerolinea);
        lblOrigenSelec.setText(origen);
        lblDestinoSelec.setText(destino);
        lblNoVuelo.setText(String.valueOf(noVuelo));
        lblHoraSalSelec.setText(horaSale);
        lblHoraLlegSelec.setText(horaLlega);
        lblTarifa.setText("MNX$ "+String.valueOf(tarifaInt));
        lblPrecio.setText("MNX$ "+String.valueOf(precioInt));
        lblTUA.setText("MNX$ "+String.valueOf(TUAInt));
        lblMontoTotal.setText("MNX$ "+String.valueOf(montoInt));  
    }
    
    private void llenarPanelDerecho(ArrayList<Vuelo> vuelos,int pasajeros){
        System.out.println("ENTRANDO AL METODO llenarPanelDerecho");
        Image imageLogo;
        int longitud=vuelos.size();
        String auxdestino=vuelos.get(0).getDestino().getCiudad();
        String auxorigen=vuelos.get(0).getOrigen().getCiudad();
        String auxAeroli;
        int auxprecio;
        
        for(int i=0;i<longitud;i++){
            auxAeroli=vuelos.get(i).getAerolinea().getNombre();
            imageLogo=obtenerLogo(auxAeroli);
            logosAerolinea.get(i).setImage(imageLogo);
            
            etiquetasOrigen.get(i).setText(auxorigen);
            etiquetasHoraSalida.get(i).setText(vuelos.get(i).getHoraSalida());
            etiquetasDestino.get(i).setText(auxdestino);
            etiquetasHoraLlegada.get(i).setText(vuelos.get(i).getHoraLlegada());
            
            auxprecio=calcularPrecio(vuelos.get(i).getTarifa(), pasajeros);
            etiquetasPrecio.get(i).setText(String.valueOf(auxprecio));
        
        }
    }
    
    private void llenarListasEtiquetas(){
        System.out.println("ENTRANDO AL METODO llenarListasEtiqueta");
        
        logosAerolinea.add(imgViewLogo1);
        logosAerolinea.add(imgViewLogo11);
        logosAerolinea.add(imgViewLogo111);
        logosAerolinea.add(imgViewLogo1111);
        logosAerolinea.add(imgViewLogo11111);
        
        etiquetasOrigen.add(lblOrigen1);
        etiquetasOrigen.add(lblOrigen11);
        etiquetasOrigen.add(lblOrigen111);
        etiquetasOrigen.add(lblOrigen1111);
        etiquetasOrigen.add(lblOrigen1111);
        
        etiquetasDestino.add(lblDestino1);
        etiquetasDestino.add(lblDestino11);
        etiquetasDestino.add(lblDestino111);
        etiquetasDestino.add(lblDestino1111);
        etiquetasDestino.add(lblDestino11111);
        
        etiquetasHoraSalida.add(lblHoraSalida1);
        etiquetasHoraSalida.add(lblHoraSalida11);
        etiquetasHoraSalida.add(lblHoraSalida111);
        etiquetasHoraSalida.add(lblHoraSalida1111);
        etiquetasHoraSalida.add(lblHoraSalida11111);
        
        etiquetasHoraLlegada.add(lblHoraLlegada1);
        etiquetasHoraLlegada.add(lblHoraLlegada11);
        etiquetasHoraLlegada.add(lblHoraLlegada111);
        etiquetasHoraLlegada.add(lblHoraLlegada1111);
        etiquetasHoraLlegada.add(lblHoraLlegada11111);
        
        etiquetasPrecio.add(lblMonto1);
        etiquetasPrecio.add(lblMonto11);
        etiquetasPrecio.add(lblMonto111);
        etiquetasPrecio.add(lblMonto1111);
        etiquetasPrecio.add(lblMonto11111);
    }
    
    private Image obtenerLogo(String aerolinea){
        /*Image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)*/
        
        Image imageLogo=null;
        if(aerolinea.equals("Aeromexico")){
          URL linkLogo=getClass().getResource("/imagenes/aeromexicoLogo32.jpg");
          imageLogo=new Image(linkLogo.toString(),32,32,false,true);
          return imageLogo;
        }
        if(aerolinea.equals("Interjet")){
          URL linkLogo=getClass().getResource("/imagenes/logoInterjet32.png");
          imageLogo=new Image(linkLogo.toString(),32,32,false,true);
          return imageLogo;
        }
        if(aerolinea.equals("Viva")){
          URL linkLogo=getClass().getResource("/imagenes/iconoViva20.jpg");
          imageLogo=new Image(linkLogo.toString(),50,24,false,true);
          return imageLogo;
        }
        if(aerolinea.equals("Volaris")){
          URL linkLogo=getClass().getResource("/imagenes/logoVolaris32.jpg");
          imageLogo=new Image(linkLogo.toString(),32,32,false,true);
          return imageLogo;
        }
        
        return imageLogo;
    }
    
    private int calcularPrecio(int tarifa,int noPasaje){
        System.out.println("ENTRANDO AL METODO calcularPrecio");
        
        int monto=tarifa*noPasaje;
        return monto;
    }
    
    private void calcularTiempo(String horaIni,String horaFin){
        System.out.println("ENTRANDO AL METODO calcularTiempo");
        System.out.println("Hora1Recibida:"+horaIni);
        System.out.println("Hora2Recibida:"+horaFin);
        
        String[] horaSeparada1;
        String[] horaSeparada2;
        
        horaSeparada1=horaIni.split(":");
        horaSeparada2=horaFin.split(":");
        
        System.out.println("HORA-INI:"+horaSeparada1);
        System.out.println("HORA-FIN:"+horaSeparada2);
        /*Hora1Recibida:05:10:00
          Hora2Recibida:09:45:00*/
    }

    @FXML
    private void clickEventPanVuelo1(MouseEvent event) {
       
    }

    @FXML
    private void clickEventPanVuelo12(MouseEvent event) {
       
    }

    @FXML
    private void clickEventPanVuelo121(MouseEvent event) {
        
    }

    @FXML
    private void clickEventPanVuelo1211(MouseEvent event) {
   
    }

    @FXML
    private void ClickEventBtnPanel2(ActionEvent event) {
        System.out.println("ESTAMOS EN ClickEventBtnPanel2");
        System.out.println("Aerolinea:"+listaVuelos.get(1).getAerolinea().getNombre());
        System.out.println("Tarifa:"+listaVuelos.get(1).getTarifa());
        
        llenarPanelIzquierdo(listaVuelos.get(1),totalPasajeros);
    }

    @FXML
    private void ClickEventBtnPanel1(ActionEvent event) {
        llenarPanelIzquierdo(listaVuelos.get(0),totalPasajeros);
    }

    @FXML
    private void ClickEventBtnPanel3(ActionEvent event) {
        llenarPanelIzquierdo(listaVuelos.get(2),totalPasajeros);
    }

    @FXML
    private void ClickEventBtnPanel4(ActionEvent event) {
        llenarPanelIzquierdo(listaVuelos.get(3),totalPasajeros);
    }
    
}
