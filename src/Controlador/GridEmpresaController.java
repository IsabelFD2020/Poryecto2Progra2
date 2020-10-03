/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Proyecto2.Cliente;
import Proyecto2.Empresa;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rogera.gonzalez
 */
public class GridEmpresaController implements Initializable {

    @FXML
    private TableView<Cliente> tblEmpresas;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colEdad;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colContacto;
    @FXML
    private TableColumn colDescuento;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtContacto;
    @FXML
    private TextField txtDescuento;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    
    private ObservableList<Cliente> clientes;
    @FXML
    private TextField txtNombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Creo el observablelist
        clientes = FXCollections.observableArrayList();

        // Asigno las columnas con los atributos del modelo
        this.colNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("Apellido"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("Edad"));
        this.colId.setCellValueFactory(new PropertyValueFactory("Id"));
        this.colContacto.setCellValueFactory(new PropertyValueFactory("Contacto"));
        this.colDescuento.setCellValueFactory(new PropertyValueFactory("Descuento"));

        
    } 
    
    public void closeWindows() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnAgregar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void seleccionar(MouseEvent event) {
        
        // Obtengo la persona seleccionada
        Cliente c = this.tblEmpresas.getSelectionModel().getSelectedItem();

        // Sino es nula seteo los campos
        if (c != null) {
            this.txtNombre.setText(c.getNombre());
            this.txtApellidos.setText(c.getApellido());
            this.txtEdad.setText(c.getEdad());
            this.txtId.setText(c.getId()+"");
            //this.txtDPI.setText(c.getDPI()+"");
        }
        
    }

    @FXML
    private void btnAgregando(ActionEvent event) {
        
        try {

            // Obtengo los datos del formulario
            String Nombre = this.txtNombre.getText();
            String Apellido = this.txtApellidos.getText();
            String Edad = this.txtEdad.getText();
            int Id = Integer.parseInt(this.txtId.getText());
            String Contacto = this.txtContacto.getText();
            int Descuento = Integer.parseInt(this.txtDescuento.getText());

            // Creo una persona
            //Cliente c = new Cliente(Nombre, Apellido, Edad, Id, Dpi, Contacto, Descuento );
            Cliente c = new Empresa(Nombre, Apellido, Edad, Id, Contacto, Descuento);
            //c = new Empresa (Contacto, Descuento);
            

            // Compruebo si la persona esta en el lista
            if (!this.clientes.contains(c)) {
                // Lo añado a la lista
                this.clientes.add(c);
                // Seteo los items
                this.tblEmpresas.setItems(clientes);
            } else {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Cliente o DPI ya existente");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
        
    }

    @FXML
    private void btnModifico(ActionEvent event) {
        
        // Obtengo la persona seleccionada
        Cliente c = this.tblEmpresas.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un Cliente");
            alert.showAndWait();
        } else {

            try {
                // Obtengo los datos del formulario
                String Nombre = this.txtNombre.getText();
                String Apellido = this.txtApellidos.getText();
                String Edad = this.txtEdad.getText();
                int Id = Integer.parseInt(this.txtId.getText());

                // Creo una persona
                Cliente aux = new Cliente(Nombre, Apellido, Edad, Id);

                // Compruebo si la persona esta en el lista
                if (!this.clientes.contains(aux)) {

                    // Modifico el objeto
                    c.setNombre(aux.getNombre());
                    c.setApellido(aux.getApellido());
                    c.setEdad(aux.getEdad());
                    c.setId(aux.getId());

                    // Refresco la tabla
                    this.tblEmpresas.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Cliente modificado");
                    alert.showAndWait();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Cliente ya existente");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }

        }
        
    }

    @FXML
    private void btnEliminando(ActionEvent event) {
        
        // Obtengo la persona seleccionada
        Cliente c = this.tblEmpresas.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un Cliente");
            alert.showAndWait();
        } else {

            // La elimino de la lista
            this.clientes.remove(c);
            // Refresco la lista
            this.tblEmpresas.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Cliente eliminado");
            alert.showAndWait();

        }
        
    }
    
}
