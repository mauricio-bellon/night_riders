package controladores;

import java.sql.SQLException;
import java.util.List;

//import manejadores.MenejadorCiudades;
import Objetos.Ciudades;

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
	
	public List<Ciudades> obtenerTodosCiudades(){
		
		return manejadores.MenejadorCiudades.obtenerTodosCiudades();
	}
}
