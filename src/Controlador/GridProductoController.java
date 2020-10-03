/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Proyecto2.Producto;
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
public class GridProductoController implements Initializable {

    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colMarca;
    @FXML
    private TableColumn colPrecio;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableView<Producto> tblProductos;
    
    private ObservableList<Producto> productos;
    @FXML
    private TableColumn colID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        // Creo el observablelist
        productos = FXCollections.observableArrayList();

        // Asigno las columnas con los atributos del modelo
        this.colNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colMarca.setCellValueFactory(new PropertyValueFactory("Marca"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("Precio"));
        this.colID.setCellValueFactory(new PropertyValueFactory("Id"));
            
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
        Producto c = this.tblProductos.getSelectionModel().getSelectedItem();

        // Sino es nula seteo los campos
        if (c != null) {
            this.txtNombre.setText(c.getNombre());
            this.txtMarca.setText(c.getMarca());
            this.txtPrecio.setText(c.getPrecio());
            this.txtId.setText(c.getId()+"");
            //this.txtDPI.setText(c.getDPI()+"");
        }
        
    }

    @FXML
    private void btnAgregando(ActionEvent event) {
        
        try {

            // Obtengo los datos del formulario
            String Nombre = this.txtNombre.getText();
            String Marca = this.txtMarca.getText();
            String Precio = this.txtPrecio.getText();
            int Id = Integer.parseInt(this.txtId.getText());
            

            // Creo una persona
            //Producto c = new Producto(Nombre, Marca, Precio, Id, Dpi, Contacto, Descuento );
            Producto c = new Producto(Nombre, Marca, Precio, Id);
            //c = new Empresa (Contacto, Descuento);
            

            // Compruebo si la persona esta en el lista
            if (!this.productos.contains(c)) {
                // Lo añado a la lista
                this.productos.add(c);
                // Seteo los items
                this.tblProductos.setItems(productos);
            } else {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Producto ya existente");
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
        Producto c = this.tblProductos.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un producto");
            alert.showAndWait();
        } else {

            try {
                // Obtengo los datos del formulario
                String Nombre = this.txtNombre.getText();
                String Marca = this.txtMarca.getText();
                String Precio = this.txtPrecio.getText();
                int Id = Integer.parseInt(this.txtId.getText());
                

                // Creo una persona
                Producto aux = new Producto(Nombre, Marca, Precio, Id);

                // Compruebo si la persona esta en el lista
                if (!this.productos.contains(aux)) {

                    // Modifico el objeto
                    c.setNombre(aux.getNombre());
                    c.setMarca(aux.getMarca());
                    c.setPrecio(aux.getPrecio());
                    c.setId(aux.getId());

                    // Refresco la tabla
                    this.tblProductos.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Producto modificado");
                    alert.showAndWait();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Producto Ya Existente");
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
        Producto c = this.tblProductos.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Porfavor selecciona un producto...");
            alert.showAndWait();
        } else {

            // La elimino de la lista
            this.productos.remove(c);
            // Refresco la lista
            this.tblProductos.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Producto dado de baja");
            alert.showAndWait();

        }
        
    }
    
}
