
package controlador;

import DataBase.*;
import java.util.List;
import modelo.Persona;
import modelo.PersonaVacuna;
import modelo.Vacuna;

/**
 *
 * @author Nelly Becerra - Derek Needham
 * @version 23-11-2021
 */
public class Registro {
    
    
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
        if(validarRut(rutPersona)){
            System.out.println("RUT VALIDO");
            ConsultasPersona consultasPersona = new ConsultasPersona();
            return consultasPersona.buscarInformacionPersona(limpiarRut(rutPersona));
        }else{
            System.out.println("RUT NO VALIDO");
            return null;
        }
    }
    
    public int agregarPersona(Persona persona){
        ConsultasPersona consultasPersona = new ConsultasPersona();
        if(validarRut(persona.getRutPersona())){
            Persona validarPersona = buscarInformacionPersona(persona.getRutPersona());
            if(validarPersona.getRutPersona() == null){
                persona.setRutPersona(limpiarRut(persona.getRutPersona()));
                consultasPersona.agregarPersona(persona);
                return 1;
            }else{
                return 0;
            }
        }else{
            return 2;
        } 
    }
    
    public List<Persona> listaPersonas(){
        ConsultasPersona consultasPersona = new ConsultasPersona();
        return consultasPersona.listaPersonas();
    }
    
    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    public String limpiarRut(String rutPersona){
        String rutFormateado = rutPersona.replace(".","");
        System.out.println(rutFormateado);
        return rutFormateado;
    }
}