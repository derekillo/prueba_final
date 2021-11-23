
package modelo;

import java.util.Date;

/**
 *
 * @author Derek Needham <deneedham@duocuc.cl>
 * @version 23-11-2021
 */
public class Atencion {
    
    private int idAtencion;
    private Date fecha;
    private String rut;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String vacuna;
    private int dosisNum;
    private int minEspera;
    private String observacion;

    public Atencion() {
    }

    public Atencion(int idAtencion, Date fecha, String rut, String nombre, String aPaterno, String aMaterno, String vacuna, int dosisNum, int minEspera, String observacion) {
        this.idAtencion = idAtencion;
        this.fecha = fecha;
        this.rut = rut;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.vacuna = vacuna;
        this.dosisNum = dosisNum;
        this.minEspera = minEspera;
        this.observacion = observacion;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAPaterno() {
        return aPaterno;
    }

    public void setAPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getAMaterno() {
        return aMaterno;
    }

    public void setAMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public int getDosisNum() {
        return dosisNum;
    }

    public void setDosisNum(int dosisNum) {
        this.dosisNum = dosisNum;
    }

    public int getMinEspera() {
        return minEspera;
    }

    public void setMinEspera(int minEspera) {
        this.minEspera = minEspera;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
