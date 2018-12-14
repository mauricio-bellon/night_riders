package controladores;

import java.sql.SQLException;
import java.util.List;

import manejadores.ManejadorPerfiles;
import Objetos.Perfiles;

public class ControladorPerfiles {
public static boolean ingresarNuevoPerfiles(int perf_Codigo, String perf_Nombre){
		
		boolean pudeCrear;
		Perfiles perfiles = new Perfiles(perf_Codigo,perf_Nombre);
		
		try{
			ManejadorPerfiles.guardarPerfiles(perfiles);
			pudeCrear = true;
		}
		catch (SQLException e){
			// ca va el cofigo se falla el insert
			pudeCrear = false;
		}
		
		return pudeCrear;
		
	}
	
	public static boolean existePerfiles(String perf_Codigo){
		
		boolean existe;
		Perfiles perfiles = ManejadorPerfiles.obtenerPerfiles(perf_Codigo);
		
		if (perfiles==null){
			existe = false;
		}
		else{
			existe = true;
		}
		
		return existe;
		
	}
	
	public List<Perfiles> obtenerTodosPerfiles(){
		
		return ManejadorPerfiles.obtenerTodosPerfiles();
	}


}
