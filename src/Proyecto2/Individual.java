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
public class Individual extends Cliente{
    
    private String DPI;

    public Individual(String Nombre, String Apellido, String Edad, int Id, String DPI ) {
        super(Nombre, Apellido, Edad, Id);
        this.DPI = DPI;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
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
        final Individual other = (Individual) obj;
        if (!Objects.equals(this.DPI, other.DPI)) {
            return false;
        }
        return true;
    }

   
    
    
    
    
}
