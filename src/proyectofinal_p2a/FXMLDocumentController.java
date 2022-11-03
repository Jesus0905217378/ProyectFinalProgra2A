/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package proyectofinal_p2a;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static proyectofinal_p2a.Datos.Conexion.getConnection;
import proyectofinal_p2a.Datos.UsuarioJDBC;
//import static proyectofinal_p2a.Datos.UsuarioJDBC.user;
/**
 *
 * @author Jesus Alberto
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button button;
    @FXML
    private Button ButtonLimpiar;
    @FXML
    private TextField TexFieldUser;
    @FXML
    private PasswordField PasswordFieldPass;

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        AbrirForm("FXML.fxml");
        AbrirForm("/proyectofinal_p2a/Formularios/FXMLSelect.fxml");
        try {
             getConnection();
           } catch (Exception e) {
      label.setText("Error al conectar a la base de datos");
            System.out.println( e.getMessage ());
      System.exit (0);
           }
      label.setText("Conectado a la base");
   
  //  UsuarioJDBC.insert(2);
//        try {
            //UsuarioJDBC.user();
//        } catch (Exception e) {
//        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
       
    } 
    
    private VBox AbrirForm(String url) throws IOException{
        return (VBox) FXMLLoader.load(getClass().getResource(url));
    }
            
//    public boolean Login(String user, String pass){
//        try {
//            
//        } catch (Exception e) {
//        }
//    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
        TexFieldUser.setText("");
        PasswordFieldPass.setText("");
    }
    
}
