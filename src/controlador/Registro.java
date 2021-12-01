
package controlador;

import DataBase.*;
import java.util.List;
import modelo.Persona;
import modelo.PersonaVacuna;
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
    
    public boolean agregarVacuna(Vacuna vacuna){
        ConsultasVacunas consultasVacunas = new ConsultasVacunas();
        return consultasVacunas.agregarVacuna(vacuna);
    }
    
    public List<PersonaVacuna> buscarInformacionVacunaPersona(int idPersona){
        ConsultasPersona consultasPersona = new ConsultasPersona();
        return consultasPersona.buscarInformacionVacunaPersona(idPersona);
    }
    
    public Persona buscarInformacionPersona(String rutPersona){
        ConsultasPersona consultasPersona = new ConsultasPersona();
        return consultasPersona.buscarInformacionPersona(rutPersona);
    }
    
    public boolean agregarPersona(Persona persona){
        ConsultasPersona consultasPersona = new ConsultasPersona();
        return consultasPersona.agregarPersona(persona);
    }
    
    public List<Persona> listaPersonas(){
        ConsultasPersona consultasPersona = new ConsultasPersona();
        return consultasPersona.listaPersonas();
    }
}