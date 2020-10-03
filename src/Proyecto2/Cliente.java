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
public class Cliente {
    
    private String Nombre;
    private String Apellido;
    private String Edad;
    private int Id;
    //static int sigIdCliente = 1;

    public Cliente() {
        
    }
    
    
    
    public Cliente(String Nombre, String Apellido, String Edad, int Id) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cliente other = (Cliente) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellido, other.Apellido)) {
            return false;
        }
        if (!Objects.equals(this.Edad, other.Edad)) {
            return false;
        }
        return true;
    }

    
    
    


}
