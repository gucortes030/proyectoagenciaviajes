/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.basedatos.AeropuertoDAO;
import modelo.basedatos.FechasDAO;
import modelo.entidades.Aeropuerto;
import modelo.entidades.Busqueda;
import modelo.entidades.Usuario;
import modelo.entidades.Vuelo;

/**
 * FXML Controller class
 *
 * @author Vieja Loca
 */
public class VistaBuscarVueloController implements Initializable {
    AeropuertoDAO aeropuertoDAO=new AeropuertoDAO();
    //FechasDAO fechaSeleccionadaDAO=new FechasDAO();
    
    private Label lblNombreUsuario;
    @FXML
    private Label lblBuscarV;
    @FXML
    private Label lblCorreoUsuario;
    @FXML
    private Pane panOrigenBusVue;
    @FXML
    private ComboBox<Aeropuerto> comboOrigenBusVue;
    @FXML
    private Pane panDestinoBusVue;
    @FXML
    private ComboBox<Aeropuerto> comboDestinoBusVue;
    @FXML
    private Label lblOrigen;
    @FXML
    private Label lblDestino;
    @FXML
    private Label lblFechaBusVue;
    private ComboBox<String> comboPasajerosBusVue; //Contiene una lista de los tipos de pasajeros
       // ComboBox<String> combotipoPasajero=new ComboBox<>();
    
    @FXML
    private Button btnBuscarVuelos;
    @FXML
    private Spinner<Integer> spinnerNumPasajeros;
    
    final int valorInicial=1;
    SpinnerValueFactory<Integer> valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20,valorInicial);
    
    @FXML
    private DatePicker datePickerFechaVuelo;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ENTRANDO AL METODO 'initialize' DEL CONTROLADOR BUSCAR-VUELO");
        inicializaCombos();
        colocarIconos(); 
        spinnerNumPasajeros.setValueFactory(valueFactory);
          
    }// Termina el metodo initialize    
    
    public void init(String texto){
        System.out.println("ESTAMOS EN EL METODO init DEL CONTROLADOR BUSCAR-VUELO");
        lblCorreoUsuario.setText(texto);

    }
    

    private void clickEventComboPasajeros(ActionEvent event) {
        System.out.println("Entrando al  METODO 'clickEventComboPasajeros' DEL CONTROLADOR BUSCAR-VUELO");
        //Object object=evento.getSource();
	//if(object.equals(combobox)){
	//	System.out.println(combobox.getSelectionModel().getSelectedItem());
	//}
        //System.out.println("ENTRANDO AL METODO 'initialize' DEL CONTROLADOR BUSCAR-VUELO");
        System.out.println(comboPasajerosBusVue.getSelectionModel().getSelectedItem());
        System.out.println("Saliendo del  METODO 'clickEventComboPasajeros' DEL CONTROLADOR BUSCAR-VUELO");
        
    }

    @FXML
    private void clickEventComboOrigen(ActionEvent event) {
        System.out.println("ESTAMOS EN EL METODO clickEventComboOrigen");
        int idOrigen=comboOrigenBusVue.getSelectionModel().getSelectedItem().getId();
        llenaCombosOD(comboDestinoBusVue, "destino",idOrigen);
 
    }

    @FXML
    private void clickEventComboDestino(ActionEvent event) {
        System.out.println("ESTAMOS EN EL METODO clickEventComboDestino");
    }

    @FXML
    private void clickEventBtnBuscar(ActionEvent event) {
        System.out.println("ESTAMOS EN EL METODO clickEventBtnBuscar");
        Busqueda busqueda=reunirDatos();
        cargarVentanaListarVuelos("/vista/VistaListarVuelos.fxml",event,busqueda);
    }

    @FXML
    private void clickEventDatePickerFechaVuelo(ActionEvent event) {
        System.out.println("clickEventDatePickerFechaVuelo");
        /* ESTA LINEA DE CODIGO REALMENTE SE HACE EN EL BOTON SIGUIENTE*/
        //state=fechaSeleccionadaDAO.insertarFecha(fechaInsertar, 25);
        
        
    }
    
    private void llenaCombosOD(ComboBox comboBox, String type, int indeAero){//Llenara el ComboBox que le pasemos
        System.out.println("ESTAMOS EN EL METODO llenaCombosOD");
        ArrayList list = type.equals("origen") ?  aeropuertoDAO.consultaAeropuertos(): aeropuertoDAO.consultaAeropuertos(indeAero);
        if(list.size()>0){
            comboBox.getItems().addAll(list);
        }
    }
    
    
    private String invertirFecha(String fecha){
        System.out.println("ESTAMOS EN EL METODO invertirFecha");
        String[] fechaSeparada;
        String nuevaFecha;
        
        fechaSeparada=fecha.split("/");
        
        nuevaFecha=fechaSeparada[2]+"-"+fechaSeparada[1]+"-"+fechaSeparada[0];
        System.out.println("LA NUEVA FECHA ES:"+nuevaFecha);
        return nuevaFecha;
    }
    
    
    private void colocarIconos(){
        System.out.println("ESTAMOS EN EL METODO colocarIconos");
        URL linkBuscar=getClass().getResource("/imagenes/lupa48B.png");
        Image imageBuscar=new Image(linkBuscar.toString(),32,32,false,true);
        btnBuscarVuelos.setGraphic(new ImageView(imageBuscar));
    }
    
   
    private void inicializaCombos(){
        System.out.println("ESTAMOS EN EL METODO inicializaCombos-->VistaBuscarVueloController");
        llenaCombosOD(comboOrigenBusVue,"origen",0);
        
        /*Crear lista de objetos Aero, desplegable para agregarlo al comboBox*/
        ArrayList<Aeropuerto> listaDestino;
        /*Llenamos la lista con lo que devuelva 'aeropuertoDAO.consultaAeropuertos()'*/
        listaDestino=aeropuertoDAO.consultaAeropuertos();
        System.out.println("listaDestino[0].ciudad:"+listaDestino.get(0).getCiudad());
        
        if(listaDestino.size()>0){//Si el arrayList no esta vacio
            comboDestinoBusVue.getItems().addAll(listaDestino);//Agregamos la coleccion al ComboBox Vacio
        }
    }
    
    
    private Busqueda reunirDatos(){
        System.out.println("ESTAMOS EN EL METODO reunirDatos");
        int numeroPasajeros=0;
        int idOrigen=0;
        String fecha=datePickerFechaVuelo.getEditor().getText();
        fecha=invertirFecha(fecha);
        Aeropuerto aeropuertoOrigen=comboOrigenBusVue.getSelectionModel().getSelectedItem();
        Aeropuerto aeropuertoDestino=comboDestinoBusVue.getSelectionModel().getSelectedItem();
        numeroPasajeros=spinnerNumPasajeros.getValue();
        
        Vuelo vuelo=new Vuelo();
        vuelo.setOrigen(aeropuertoOrigen);
        vuelo.setDestino(aeropuertoDestino);
        vuelo.setFechaSalida(fecha);
        Busqueda busqueda=new Busqueda(vuelo,numeroPasajeros);

        //JOptionPane.showMessageDialog(null, "idOrigen:"+aeropuertoOrigen.getId()+"\tidDestino:"+aeropuertoDestino.getId()+"\nFecha:"+fecha+"\tPasaje:"+numeroPasajeros);
        return busqueda;
    }
    
    private void cargarVentanaListarVuelos(String url,Event event,Busqueda busquedaVuelo){
        try {
            System.out.println("ENTRANDO AL METODO cargarVentanaListarVuelos");
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource(url));
            //Parent root=FXMLLoader.load(getClass().getResource(url));
            Parent root=loader.load();
            Scene nuevaScene=new Scene(root);//cargamos el nodo raiz ala nueva scena
            Stage nuevoStage=new Stage();//Creamos un nuevo stage
            nuevoStage.setScene(nuevaScene);//Agregamos la nuevaScena al nuevoStage
            VistaListarVuelosController vistaListVuelosController=loader.getController();
            vistaListVuelosController.infoEntreVentanas(busquedaVuelo,lblCorreoUsuario.getText());
            
            System.out.println("INFORMACION DEL VUELO:");
            System.out.println("Origen:"+busquedaVuelo.getVueloBuscado().getOrigen().getCiudad());
            System.out.println("Destino:"+busquedaVuelo.getVueloBuscado().getDestino().getCiudad());
            System.out.println("Fecha:"+busquedaVuelo.getVueloBuscado().getFechaSalida());
            System.out.println("Pasajeros:"+busquedaVuelo.getNoPasajeros());
            nuevoStage.show(); //mostramos el nuevoStage
            //this.stage.close();//cerramos la ventana actual
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
