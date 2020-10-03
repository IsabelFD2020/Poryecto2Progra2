/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rogera.gonzalez
 */
public class MenuController implements Initializable {

    @FXML
    private Button btnClientes;
    @FXML
    private Button btnProductos;
    @FXML
    private Button btnCompras;
    @FXML
    private Label txtMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    public void closeWindows() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/LoginVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnClientes.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnIngresoClientes(ActionEvent event) {
        
        try{
                //Cargo la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuClienteVista.fxml"));
                
                // Cargo la ventana
                Parent root = loader.load();
                
                // Obtengo el controlador
                MenuClienteController controlador = loader.getController();
                
                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
                
                // Indico que debe hacer al cerrar
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                
                // Ciero la ventana donde estoy
                Stage myStage = (Stage) this.btnClientes.getScene().getWindow();
                myStage.close();
                
            } catch (IOException e){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                
            }
        
    }

    @FXML
    private void btnIngresoProducto(ActionEvent event) {
        
        try{
                //Cargo la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridProductoVista.fxml"));
                
                // Cargo la ventana
                Parent root = loader.load();
                
                // Obtengo el controlador
                GridProductoController controlador = loader.getController();
                
                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
                
                // Indico que debe hacer al cerrar
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                
                // Ciero la ventana donde estoy
                Stage myStage = (Stage) this.btnProductos.getScene().getWindow();
                myStage.close();
                
            } catch (IOException e){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                
            }
        
    }

    @FXML
    private void btnIngresoCompras(ActionEvent event) {
    }
    
}
