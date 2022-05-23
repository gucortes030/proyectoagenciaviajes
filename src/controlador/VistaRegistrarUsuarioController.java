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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.basedatos.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author Vieja Loca
 */
public class VistaRegistrarUsuarioController implements Initializable {
    UsuarioDAO usuarioDAO= new UsuarioDAO();

    @FXML
    private Label lblTituloRegUsu;
    @FXML
    private Label lblCrearCueRegUsu;
    @FXML
    private Label lblCorreoRegUsu;
    @FXML
    private TextField txtCorreoRegUsu;
    @FXML
    private Label lblContraseñaRegUsu;
    @FXML
    private PasswordField txtContraseñaRegUsu;
    @FXML
    private Label lblRepContraseñaRegUsu;
    @FXML
    private PasswordField txtRepContraseñaRegUsu;
    @FXML
    private Label lblCaracteresRegUsu;
    @FXML
    private Button btnRegUsu;
    @FXML
    private Button btnVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("VistaRegistrarUsuarioController-->initialize ");
       colocarIconos();
    }


    @FXML
    private void ClickEventBtnSiguiente(ActionEvent event) {
        //Si ningun campo esta vacio
        if(!txtCorreoRegUsu.getText().isEmpty() && !txtContraseñaRegUsu.getText().isEmpty()){
            //Recupera los datos de todos los campos
            String correo=txtCorreoRegUsu.getText();
            String password=txtContraseñaRegUsu.getText();
            String passwordRepetido=txtRepContraseñaRegUsu.getText();
            
            //Si ambos paswors son igaules
            if(password.equals(passwordRepetido)){
                System.out.println("Los paswors coinciden");
                int state=usuarioDAO.insertar(correo, password);//Inserta al usuario
                if(state==1){
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    cargarVentanaBienvenida("/vista/ViewHome.fxml",event);
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR al registrar usuario:state es"+state,"ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Los passwors no coinciden");
            }//Termina 2do if-else
              
        }else{
              JOptionPane.showMessageDialog(null, "ERROR al registrarse, ingresar todos los datos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }
          
        
    }//termina ClickEventBtnSiguiente

    @FXML
    private void ClickEventBtnVolver(ActionEvent event) {
        try {   
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/FXMLDocument.fxml"));
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
            vistaBVueController.init(txtCorreoRegUsu.getText());
            nuevoStage.show(); //mostramos el nuevoStage
            //this.stage.close();//cerramos la ventana actual
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void colocarIconos(){
        System.out.println("colocarIconos ");
        URL linkVolver=getClass().getResource("/imagenes/flechaIzq2.png");
        Image imageVolver=new Image(linkVolver.toString(),32,32,false,true);
        btnVolver.setGraphic(new ImageView(imageVolver));
        
    }
    
    
}
