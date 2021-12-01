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
import modelo.Vacuna;

/**
 *
 * @author Jorge
 */
public class ConsultasVacunas {
    
    public boolean agregarVacuna(Vacuna nuevaVacuna){
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO vacuna(nombreVacuna,empresaVacuna,tiempoEspera) VALUES(?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nuevaVacuna.getNombreVacuna());
            stmt.setString(2, nuevaVacuna.getEmpresaVacuna());
            stmt.setInt(3, nuevaVacuna.getTiempoEspera());
            
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
    
    
    
    public List<Vacuna> buscarListaVacuna(){
        
        List<Vacuna> listaVacuna = new ArrayList<>();
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
                        
            String query = "SELECT idVacuna, nombreVacuna, empresaVacuna, tiempoEspera FROM vacuna";
            PreparedStatement stmt = cnx.prepareStatement(query);

//          Se ejecuta consulta
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Vacuna vacuna = new Vacuna();
                vacuna.setIdVacuna(rs.getInt("idVacuna"));
                vacuna.setNombreVacuna(rs.getString("nombreVacuna"));
                vacuna.setEmpresaVacuna(rs.getString("empresaVacuna"));
                vacuna.setTiempoEspera(rs.getInt("tiempoEspera"));
                listaVacuna.add(vacuna);
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
        return listaVacuna;
        
    }
}
