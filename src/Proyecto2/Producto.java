/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2;

import java.util.Objects;

/**
 *
 * @author rogera.gonzalez
 */
public class Producto {
    
    private String Nombre;
    private String Marca;
    private String Precio;
    private int Id;

    public Producto() {
    }

    public Producto(String Nombre, String Marca, String Precio, int Id) {
        this.Nombre = Nombre;
        this.Marca = Marca;
        this.Precio = Precio;
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.Precio != other.Precio) {
            return false;
        }
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Marca, other.Marca)) {
            return false;
        }
        return true;
    }
    
    

    
    
    
    
    
}
