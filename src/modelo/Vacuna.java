/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Nelly Becerra - Derek Needham
 */
public class Vacuna {
    public int idVacuna;
    public String nombreVacuna;
    public String empresaVacuna;
    public int tiempoEspera;

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getEmpresaVacuna() {
        return empresaVacuna;
    }

    public void setEmpresaVacuna(String empresaVacuna) {
        this.empresaVacuna = empresaVacuna;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }
    
    
}
