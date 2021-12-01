/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Atencion;
import modelo.Persona;
import modelo.PersonaVacuna;

/**
 *
 * @author Jorge
 */
public class ConsultasPersona {
    
    public boolean agregarPersona(Persona persona){
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO persona(rutPersona,Nombres,Apellidos) VALUES(?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, persona.getRutPersona());
            stmt.setString(2, persona.getNombres());
            stmt.setString(3, persona.getApellidos());
            
//          Se ejecuta consulta
            stmt.executeUpdate(); 
//          Se cierra consulta            
            stmt.close(); 
//          Se cierra conexión            
            cnx.close();
          
            return true;

        } catch (SQLException e) {
            System.out.println("ERROR en la base de datos: " + e.getMessage());
            return false;
        } catch (Exception e){
            System.out.println("ERROR al ingresar datos de atención!!! " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizar(Atencion atencion){
        
        Date date;
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            date = atencion.getFecha();
            
            String query = "UPDATE atencion set fecha = ?,rut = ?,nombre = ?,apaterno = ?,amaterno = ?,vacuna = ?,dosisnum = ?,minespera = ?,observacion = ? WHERE idatencion = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            stmt.setString(2, atencion.getRut());
            stmt.setString(3, atencion.getNombre());
            stmt.setString(4, atencion.getAPaterno());
            stmt.setString(5, atencion.getAMaterno());
            stmt.setString(6, atencion.getVacuna());
            stmt.setInt(7, atencion.getDosisNum());
            stmt.setInt(8, atencion.getMinEspera());
            stmt.setString(9, atencion.getObservacion());
            stmt.setInt(10, atencion.getIdAtencion());
            
//          Se ejecuta consulta
            stmt.executeUpdate(); 
//          Se cierra consulta            
            stmt.close(); 
//          Se cierra conexión            
            cnx.close();
            
            return true;

        } catch (SQLException e) {
            System.out.println("ERROR en la base de datos: " + e.getMessage());
            return false;
        } catch (Exception e){
            System.out.println("ERROR al actualizar datos de atención!!! " + e.getMessage());
            return false;
        }

    }
    
    public boolean eliminar(int idAtencion){
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            
            String query = "DELETE FROM atencion WHERE idatencion = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idAtencion);

            
//          Se ejecuta consulta
            stmt.executeUpdate(); 
//          Se cierra consulta            
            stmt.close(); 
//          Se cierra conexión            
            cnx.close();
            
            return true;

        } catch (SQLException e) {
            System.out.println("ERROR en la base de datos: " + e.getMessage());
            return false;
        } catch (Exception e){
            System.out.println("ERROR al eliminar datos de atención!!! " + e.getMessage());
            return false;
        }
    }
    
    
    
    public List<PersonaVacuna> buscarInformacionVacunaPersona(int idPersona){
       
        List<PersonaVacuna> listaPersonaVacuna = new ArrayList<>();
       
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT p.Nombres, p.Apellidos, v.nombreVacuna, pv.fechaVacunacion FROM persona_vacuna pv JOIN persona p on pv.idPersona = p.idPersona JOIN vacuna v on pv.idVacuna = v.idVacuna WHERE pv.idPersona = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idPersona);
            
//          Se ejecuta consulta
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                PersonaVacuna personaVacuna = new PersonaVacuna();
                personaVacuna.setNombres(rs.getString("p.Nombres"));
                personaVacuna.setApellidos(rs.getString("p.Apellidos"));
                personaVacuna.setNombreVacuna(rs.getString("v.nombreVacuna"));
                personaVacuna.setFechaVacunacion(rs.getDate("pv.fechaVacunacion"));
                listaPersonaVacuna.add(personaVacuna);
            }
            rs.close();
//          Se cierra consulta            
            stmt.close(); 
//          Se cierra conexión            
            cnx.close();
            

        } catch (SQLException e) {
            System.out.println("ERROR en la base de datos: " + e.getMessage());

        } catch (Exception e){
            System.out.println("ERROR al actualizar datos de atención!!! " + e.getMessage());

        }
        return listaPersonaVacuna;
    }
    
    public Persona buscarInformacionPersona(String rutPersona){
       
        Persona Persona = new Persona();
       
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT idPersona, Nombres, Apellidos, rutPersona FROM persona WHERE rutPersona = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, rutPersona);
            
//          Se ejecuta consulta
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Persona.setIdPersona(rs.getInt("idPersona"));
                Persona.setNombres(rs.getString("Nombres"));
                Persona.setApellidos(rs.getString("Apellidos"));
                Persona.setRutPersona(rs.getString("rutPersona"));
            }
            rs.close();
//          Se cierra consulta            
            stmt.close(); 
//          Se cierra conexión            
            cnx.close();
            

        } catch (SQLException e) {
            System.out.println("ERROR en la base de datos: " + e.getMessage());

        } catch (Exception e){
            System.out.println("ERROR al actualizar datos de atención!!! " + e.getMessage());

        }
        return Persona;
    }
    
    
    public List<Persona> listaPersonas(){
       
        List<Persona> listaPersona = new ArrayList<Persona>();
        
        try {
            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT idPersona, rutPersona, nombres, apellidos FROM persona";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
//          Se ejecuta consulta
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setRutPersona(rs.getString("rutPersona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                listaPersona.add(persona);
            }
            rs.close();
//          Se cierra consulta            
            stmt.close(); 
//          Se cierra conexión            
            cnx.close();
            

        } catch (SQLException e) {
            System.out.println("ERROR en la base de datos: " + e.getMessage());

        } catch (Exception e){
            System.out.println("ERROR al actualizar datos de atención!!! " + e.getMessage());

        }
        
        return listaPersona;
    }
}
