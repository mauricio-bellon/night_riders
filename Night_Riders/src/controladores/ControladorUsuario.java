package controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import manejadores.ManejadorPerfiles;
import manejadores.ManejadorUsuario;
import Objetos.Usuario;
import Objetos.Perfiles;

public class ControladorUsuario {
	public static boolean ingresarNuevoUsuario(String codigo, String perf_Codigo, String nombre, String apellido, String nombreAcceso, String correo,
			String contraseña) {

		boolean pudeCrear;
		
		Perfiles perfiles = ManejadorPerfiles.obtenerPerfiles(perf_Codigo);
		Usuario usuario = new Usuario(codigo, perfiles, nombre, apellido, nombreAcceso, correo, contraseña);

		try {
			manejadores.ManejadorUsuario.guardarUsuario(usuario);
			pudeCrear = true;
		} catch (SQLException e) {
			// ca va el cofigo se falla el insert
			pudeCrear = false;
		}

		return pudeCrear;

	}
	public static boolean existeUsuario(String codigo){
		
		boolean existe;
		Usuario usuario = ManejadorUsuario.obtenerUsuario(codigo);
		
		if (usuario==null){
			existe = false;
		}
		else{
			existe = true;
		}
		
		return existe;
		
	}
	
	public static ArrayList<String> obtenerInfoUsuarios(){
		
		ArrayList<String> infoUsuarios = new ArrayList<>();
		
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) ManejadorUsuario.obtenerTodosUsuarios();
		
		for(Usuario usuario: usuarios){
			infoUsuarios.add(usuario.toString());
		}
		
		return infoUsuarios;
		
	}
	
	public static  ArrayList<Usuario> obtenerTodosUsuarios(){
		return (ArrayList<Usuario>) ManejadorUsuario.obtenerTodosUsuarios();
	}


}
