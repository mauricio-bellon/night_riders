package manejadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objetos.Ciudades;

public class MenejadorCiudades {
	private static PreparedStatement consultainsertarCiudades;
	private static PreparedStatement consultaCiudadesID;
	private static PreparedStatement consultaTodasCiudades;

	static {

		try {
			consultainsertarCiudades = DatabaseManager.getConnection()
					.prepareStatement("INSERT INTO CIUDADES(CODIGO,NOMBRE) VALUES(?,?)");
			consultaCiudadesID = DatabaseManager.getConnection()
					.prepareStatement("SELECT * FROM CIUDADES WHERE CODIGO=?");
			consultaTodasCiudades = DatabaseManager.getConnection().prepareStatement("SELECT * FROM CIUDADES");

		} catch (SQLException e) {
			System.out.println("Error al crear consultas preparadas para Manejador de CIUDADES");
		}
	}

	public static void guardarCiudades(Ciudades ciudades) throws SQLException {

		consultainsertarCiudades.setString(1, ciudades.getCodigo());
		consultainsertarCiudades.setString(2, ciudades.getNombre());
		consultainsertarCiudades.executeQuery();

	}

	public static Ciudades obtenerCiudades(String Codigo) {

		Ciudades resultado = null;

		try {
			consultaCiudadesID.setString(1, Codigo);
			ResultSet resultadoConsulta = consultaCiudadesID.executeQuery();

			if (resultadoConsulta.next()) {

				String codigo = resultadoConsulta.getString(1);
				String nombre = resultadoConsulta.getString(2);
				resultado = new Ciudades(codigo, nombre);

			}

		} catch (SQLException e) {

		}

		return resultado;

	}

	public static  List<Ciudades> obtenerTodosCiudades() {

		 List<Ciudades> resultado = new ArrayList<>();

		try {
			ResultSet resultadoConsulta = consultaTodasCiudades.executeQuery();

			while (resultadoConsulta.next()) {

				String codigo = resultadoConsulta.getString(1);
				String nombre = resultadoConsulta.getString(2);

				Ciudades ciudades = new Ciudades(codigo, nombre);
				resultado.add(ciudades);

			}

		} catch (SQLException e) {

		}

		return resultado;
	}


}
