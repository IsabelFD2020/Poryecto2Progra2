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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rogera.gonzalez
 */
public class MenuClienteController implements Initializable {

    @FXML
    private Button btnIndividual;
    @FXML
    private Button btnEmpresa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void closeWindows() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnEmpresa.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnIngresoIndividual(ActionEvent event) {
        
        try{
                //Cargo la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridClienteVista.fxml"));
                
                // Cargo la ventana
                Parent root = loader.load();
                
                // Obtengo el controlador
                GridClienteController controlador = loader.getController();
                
                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
                
                // Indico que debe hacer al cerrar
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                
                // Ciero la ventana donde estoy
                Stage myStage = (Stage) this.btnIndividual.getScene().getWindow();
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
    private void btnIngresoEmpresa(ActionEvent event1) {
        
        try{
                //Cargo la vista
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/vista/GridEmpresaVista.fxml"));
                
                // Cargo la ventana
                Parent root1 = loader1.load();
                
                // Obtengo el controlador
                GridEmpresaController controlador1 = loader1.getController();
                
                // Creo el Scene
                Scene scene1 = new Scene(root1);
                Stage stage1 = new Stage();
                stage1.initModality(Modality.APPLICATION_MODAL);
                stage1.setScene(scene1);
                stage1.show();
                
                // Indico que debe hacer al cerrar
                stage1.setOnCloseRequest(e1 -> controlador1.closeWindows());
                
                // Ciero la ventana donde estoy
                Stage myStage = (Stage) this.btnEmpresa.getScene().getWindow();
                myStage.close();
                
            } catch (IOException e){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                
            }
        
    }
    
}
