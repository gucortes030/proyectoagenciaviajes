/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.basedatos.AdminBD;
import modelo.basedatos.FechasDAO;
import modelo.basedatos.UsuarioDAO;
import modelo.entidades.Usuario;

/**
 *
 * @author Vieja Loca
 */
public class FXMLDocumentController implements Initializable {
    //AdminBD datos=new AdminBD();//Inicializa la base de datos
    UsuarioDAO usuarioDAO= new UsuarioDAO();
    //FechasDAO fechasDAO=new FechasDAO();
    
    
    private  Stage stage;
    
    private Label label;
    @FXML
    private Label lblTitulo;
    @FXML
    private Pane panelIniSesion;
    @FXML
    private Label lblIniciarSesion;
    @FXML
    private Label lblCorreo;
    @FXML
    private TextField txtCorreo;
    @FXML
    private Label lblContraseña;
    @FXML
    private Button btnSiguiente;
    @FXML
    private Button btnRegistrarse;
    @FXML
    private PasswordField txtContraseñaIniSess;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World Es Una Prueba!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ENTRANDO AL METODO initialize");
        //fechasDAO.consultarFechas();
        
    }    
    
    
    private void eventKeytxtCorreo(KeyEvent event){
      Object evt=event.getSource(); //Para saber en que nodo se ocasiono dicho evento
      if(evt.equals(txtCorreo)){
          if(event.getCharacter().equals(" ")){
             event.consume();
          }
          
      }else if(evt.equals(txtContraseñaIniSess)){
          if(event.getCharacter().equals(" ")){
             event.consume();
          }
      }
    
    }//termina eventKeytxtCorreo
    
    private void eventAction(ActionEvent event){
        /*Object objectE=event.getSource();
        if(objectE.equals(btnSiguiente)){
          if(!txtCorreo.getText().isEmpty() && !txtContraseñaIniSess.getText().isEmpty()){
              String correo=txtCorreo.getText();
              String password=txtContraseñaIniSess.getText();
              int state=usuarioDAO.login(correo, password);
              if(state!=-1){
                  if(state==1){
                      JOptionPane.showMessageDialog(null, "Datos correctos puede ingresar al sistema");
                  }else{
                      JOptionPane.showMessageDialog(null,"ERROR al iniciar sesion, datos de acceso incorrectos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                  }
              }
              
          }else{
              JOptionPane.showMessageDialog(null, "ERROR al iniciar sesion, datos de acceso incorrectos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
          }
        
        }*/
        
        
    }

    @FXML
    private void ClickEventBtnSiguiente(ActionEvent event) {
        int state;
        if(!txtCorreo.getText().isEmpty() && !txtContraseñaIniSess.getText().isEmpty()){
            String correo=txtCorreo.getText();
            String password=txtContraseñaIniSess.getText();//De aqui  hacia abajo
            
            state=usuarioDAO.login(correo, password);
            //state=1;
            
            if(state!=-1){
                if(state==1){
                    JOptionPane.showMessageDialog(null, "Datos CORRECTOS PUEDE INGRESAR AL SISTEMA");
                    
                    cargarVentanaBienvenida("/vista/VistaBuscarVuelo.fxml",event);
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR AL INICIAR SESION, DATOS DE ACCESO INCORRECTOS !!!!","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                }
            }
              
        }else{
              JOptionPane.showMessageDialog(null, "ERROR AL INICIAR SESION, DATOS DE ACCESO INCORRECTOS !!!!","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }
               
        
    }//termina ClickEventBtnSiguiente

    @FXML
    private void ClickEventBtnRegistrarse(ActionEvent event) {
        System.out.println("ClickEventBtnRegistrarse");
        cargarVentanaRegistro("/vista/VistaRegistrarUsuario.fxml",event);                 
    }//termina ClickEventBtnRegistrarse  
 
    
    private void cargarVentanaBienvenida(String url,Event event){
        try {
            System.out.println("ENTRANDO AL METODO CARGAR VISTA");
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource(url));
            //Parent root=FXMLLoader.load(getClass().getResource(url));
            Parent root=loader.load();
            Scene nuevaScene=new Scene(root);//cargamos el nodo raiz ala nueva scena
            Stage nuevoStage=new Stage();//Creamos un nuevo stage
            nuevoStage.setScene(nuevaScene);//Agregamos la nuevaScena al nuevoStage
            VistaBuscarVueloController vistaBVueController=loader.getController();
            vistaBVueController.init(txtCorreo.getText());
            nuevoStage.show(); //mostramos el nuevoStage
            //this.stage.close();//cerramos la ventana actual
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void cargarVentanaRegistro(String url,Event event){
        System.out.println("cargarVentanaRegistro");
        try {
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource(url));
            //Parent root=FXMLLoader.load(getClass().getResource(url));
            Parent root=loader.load();
            Scene nuevaScene=new Scene(root);//cargamos el nodo raiz ala nueva scena
            Stage nuevoStage=new Stage();//Creamos un nuevo stage
            nuevoStage.setScene(nuevaScene);//Agregamos la nuevaScena al nuevoStage
            
            nuevoStage.show(); //mostramos el nuevoStage
            //this.stage.close();//cerramos la ventana actual
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
