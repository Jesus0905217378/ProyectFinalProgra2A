/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package proyectofinal_p2a;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jesus Alberto
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private VBox FXMLSelect;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        //AbrirForm("FXML.fxml");
        //AbrirForm("/proyectofinal_p2a/Formularios/FXMLSelect.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //Connection getConnection() 
       
    } 
    
    private VBox AbrirForm(String url) throws IOException{
        return (VBox) FXMLLoader.load(getClass().getResource(url));
    }
            
    
    
}
