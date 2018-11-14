package manejadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objetos.Usuario;
import Objetos.Perfiles;

public class ManejadorUsuario {
	private static PreparedStatement consultaInsertarUsuario;
	private static PreparedStatement consultaUsuarioPorCodigo;
	private static PreparedStatement consultaTodosUsuario;

	static {

		try {
			consultaInsertarUsuario = DatabaseManager.getConnection()
					.prepareStatement("INSERT INTO USUARIO(USU_CODIGO,PERF_CODIGO,USU_NOMBRE,USU_APELLIDO,USU_NOMACCESO,USU_CONTRASENA,USU_CORREO) VALUES(?,?,?,?,?,?,?)");
			consultaUsuarioPorCodigo = DatabaseManager.getConnection()
					.prepareStatement("SELECT * FROM USUARIO WHERE USU_NOMACCESO=?");
			consultaTodosUsuario = DatabaseManager.getConnection().prepareStatement("SELECT * FROM USUARIOS");

		} catch (SQLException e) {
			System.out.println("Error al crear consultas preparadas para Manejador de USUARIO");
		}
	}

	public static void guardarUsuario(Usuario usuario) throws SQLException {

		consultaInsertarUsuario.setString(1, usuario.getCodigo());
		consultaInsertarUsuario.setInt(2, usuario.getPerfiles().getPerf_Codigo());
		consultaInsertarUsuario.setString(3, usuario.getNombre());
		consultaInsertarUsuario.setString(4, usuario.getApellido());
		consultaInsertarUsuario.setString(5, usuario.getNombreAcceso());
		consultaInsertarUsuario.setString(6, usuario.getCorreo());
		consultaInsertarUsuario.setString(7, usuario.getContraseña());
		consultaInsertarUsuario.executeQuery();

	}

	public static Usuario obtenerUsuario(String Usu_NOMACCESO) {

		Usuario resultado = null;

		try {
			consultaUsuarioPorCodigo.setString(1, Usu_NOMACCESO);
			ResultSet resultadoConsulta = consultaUsuarioPorCodigo.executeQuery();

			if (resultadoConsulta.next()) {

				String codigo = resultadoConsulta.getString(1);
				String nomperfiles = resultadoConsulta.getString(2);
				
				Perfiles perfiles = ManejadorPerfiles.obtenerPerfiles(nomperfiles);
				
				String nombre = resultadoConsulta.getString(3);
				String apellido = resultadoConsulta.getString(4);
				String nombreacceso = resultadoConsulta.getString(5);
				String correo = resultadoConsulta.getString(6);
				String contraseña = resultadoConsulta.getString(7);

				resultado = new Usuario(codigo, perfiles, nombre, apellido, nombreacceso, correo, contraseña);

			}

		} catch (SQLException e) {

		}

		return resultado;

	}

	public static  List<Usuario> obtenerTodosUsuarios() {

		 List<Usuario> resultado = new ArrayList<>();

		try {
			ResultSet resultadoConsulta = consultaTodosUsuario.executeQuery();

			while (resultadoConsulta.next()) {

				String codigo = resultadoConsulta.getString(1);
				String nompefiles = resultadoConsulta.getString(2);
				String nombre = resultadoConsulta.getString(3);
				String apellido = resultadoConsulta.getString(4);
				String nombreacceso = resultadoConsulta.getString(5);
				String correo = resultadoConsulta.getString(6);
				String contraseña = resultadoConsulta.getString(7);
				Usuario usuario = new Usuario(codigo,nompefiles,nombre,apellido,nombreacceso,correo,contraseña);
				resultado.add(usuario);

			}

		} catch (SQLException e) {

		}

		return resultado;
	}

}
