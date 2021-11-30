
package controlador;

import DataBase.*;
import java.util.List;
import modelo.Vacuna;

/**
 *
 * @author Derek Needham <deneedham@duocuc.cl>
 * @version 23-11-2021
 */
public class Registro {
    
    /*public static void main(String[] args) {
        Conexion con = new Conexion();
        con.obtenerConexion();
        ConsultasPersona consultaPersonas = new ConsultasPersona();
        ConsultasVacunas consultasVacunas = new ConsultasVacunas();
        //consultaPersonas.agregar();
        //consultasVacunas.agregarVacuna();
        consultaPersonas.listaPersonas();
    }*/
    
    public List<Vacuna> listaVacunacion(){
        ConsultasVacunas consultasVacunas = new ConsultasVacunas();
        return consultasVacunas.buscarListaVacuna();
    }
}