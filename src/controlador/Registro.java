
package controlador;

import bd.Conexion;
import java.util.Date;
import modelo.Atencion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Derek Needham <deneedham@duocuc.cl>
 * @version 23-11-2021
 */
public class Registro {
    
    public boolean agregar(Atencion atencion){
        
        Date date;
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            date = atencion.getFecha();
            
            String query = "INSERT INTO atencion(fecha,rut,nombre,apaterno,amaterno,vacuna,dosisnum,minespera,observacion) VALUES(?,?,?,?,?,?,?,?,?)";
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
    
    public Atencion buscarAtencion(int idAtencion){
       
       Atencion atencion = new Atencion();
       Date date;
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            date = atencion.getFecha();
            
            String query = "SELECT idatencion,fecha,rut,nombre,apaterno,amaterno,vacuna,dosisnum,minespera,observacion FROM atencion WHERE idatencion = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idAtencion);
            
//          Se ejecuta consulta
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                atencion.setIdAtencion(rs.getInt("idatencion"));
                atencion.setFecha(rs.getDate("fecha"));
                atencion.setRut(rs.getString("rut"));
                atencion.setNombre(rs.getString("nombre"));
                atencion.setAPaterno(rs.getString("apaterno"));
                atencion.setAMaterno(rs.getString("amaterno"));
                atencion.setVacuna(rs.getString("vacuna"));
                atencion.setDosisNum(rs.getInt("dosisnum"));
                atencion.setMinEspera(rs.getInt("minespera"));
                atencion.setObservacion(rs.getString("observacion"));
                
                
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
        return atencion;
    }
    
    public List<Atencion> buscarAtenciones(){
        
        List<Atencion> lista = new ArrayList<>();
        
        Date date;
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
                        
            String query = "SELECT idatencion,fecha,rut,nombre,apaterno,amaterno,vacuna,dosisnum,minespera,observacion FROM atencion ORDER BY fecha";
            PreparedStatement stmt = cnx.prepareStatement(query);

//          Se ejecuta consulta
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Atencion atencion = new Atencion();
                atencion.setIdAtencion(rs.getInt("idatencion"));
                atencion.setFecha(rs.getDate("fecha"));
                atencion.setRut(rs.getString("rut"));
                atencion.setNombre(rs.getString("nombre"));
                atencion.setAPaterno(rs.getString("apaterno"));
                atencion.setAMaterno(rs.getString("amaterno"));
                atencion.setVacuna(rs.getString("vacuna"));
                atencion.setDosisNum(rs.getInt("dosisnum"));
                atencion.setMinEspera(rs.getInt("minespera"));
                atencion.setObservacion(rs.getString("observacion"));
                
                lista.add(atencion);
                
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
        return lista;
        
    }
}
