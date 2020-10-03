/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rogera.gonzalez
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField txtContraseña;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnIngreso(ActionEvent event) {
        String Usuario = this.txtUsuario.getText();
        String Contraseña = this.txtContraseña.getText();
        if (Usuario.equals("123")&&Contraseña.equals("123")){
            
            try{
                //Cargo la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuVista.fxml"));
                
                // Cargo la ventana
                Parent root = loader.load();
                
                // Obtengo el controlador
                MenuController controlador = loader.getController();
                
                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
                
                // Indico que debe hacer al cerrar
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                
                // Ciero la ventana donde estoy
                Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
                myStage.close();
                
            } catch (IOException e){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                
            }
        } else {
    
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ADVERTENCIA");
                alert.setContentText("Usuario Incorrecto");
                alert.showAndWait();
        }
    }

    @FXML
    private void btnSalida(ActionEvent event) {
    }
    
}
