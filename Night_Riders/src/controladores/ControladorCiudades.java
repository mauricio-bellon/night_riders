package controladores;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Objetos.Ciudades;
import manejadores.MenejadorCiudades;

public class ControladorCiudades {
	public static boolean ingresarNuevaCiudad(String codigo, String nombre){
		
		boolean pudeCrear;
		Ciudades ciudades = new Ciudades(codigo, nombre);
		
		try{
			manejadores.MenejadorCiudades.guardarCiudades(ciudades);
			pudeCrear = true;
		}
		catch (SQLException e){
			// ca va el codigo se falla el insert
			pudeCrear = false;
		}
		
		return pudeCrear;
		
	}
	
	public static boolean existeCiudades(String codigo){
		
		boolean existe;
		Ciudades ciudades = manejadores.MenejadorCiudades.obtenerCiudades(codigo);
		
		if (ciudades==null){
			existe = false;
		}
		else{
			existe = true;
		}
		
		return existe;
		
	}
	
	public static ArrayList<String> obtenerInfoCiudades(){
		
		ArrayList<String> infoCiudades = new ArrayList<>();
		
		ArrayList<Ciudades> ciudades = (ArrayList<Ciudades>) MenejadorCiudades.obtenerTodosCiudades();
		
		for(Ciudades ciudad: ciudades){
			infoCiudades.add(ciudad.toString());
		}
		
		return infoCiudades;
		
	}
	
	public static ArrayList<Ciudades> obtenerTodosCiudades(){
		
		return (ArrayList<Ciudades>) MenejadorCiudades.obtenerTodosCiudades();
	}
}
