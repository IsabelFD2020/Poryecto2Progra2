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
public class Empresa extends Cliente{
    
    private String Contacto;
    private int Descuento;

    public Empresa(String Nombre, String Apellido, String Edad, int Id, String Contacto, int Descuento) {
        super(Nombre, Apellido, Edad, Id);
        this.Contacto = Contacto;
        this.Descuento = Descuento;
    }

    public Empresa(String Contacto, int Descuento) {
        this.Contacto = Contacto;
        this.Descuento = Descuento;
    }

    
    
    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
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
        final Empresa other = (Empresa) obj;
        if (this.Descuento != other.Descuento) {
            return false;
        }
        if (!Objects.equals(this.Contacto, other.Contacto)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
