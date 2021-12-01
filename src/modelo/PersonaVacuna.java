/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Nelly Becerra - Derek Needham
 */
public class PersonaVacuna {
    public int idPersonaVacuna;
    public String nombres;
    public String apellidos;
    public String nombreVacuna;
    public Date fechaVacunacion;

    public int getIdPersonaVacuna() {
        return idPersonaVacuna;
    }

    public void setIdPersonaVacuna(int idPersonaVacuna) {
        this.idPersonaVacuna = idPersonaVacuna;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Date getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(Date fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }
    
    
}
