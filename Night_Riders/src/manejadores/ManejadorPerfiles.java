package manejadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objetos.Perfiles;

public class ManejadorPerfiles {
	private static PreparedStatement consultaInsertarPerfiles;
	private static PreparedStatement consultaPerfilesPorCodigo;
	private static PreparedStatement consultaTodosPerfiles;

	static {

		try {
			consultaInsertarPerfiles = DatabaseManager.getConnection()
					.prepareStatement("INSERT INTO PERFILES(PERF_CODIGO,Perf_Nombre) VALUES(?,?)");
			consultaPerfilesPorCodigo = DatabaseManager.getConnection()
					.prepareStatement("SELECT * FROM PERFILES WHERE Perf_Codigo=?");
			consultaTodosPerfiles = DatabaseManager.getConnection().prepareStatement("SELECT * FROM PERFILES");

		} catch (SQLException e) {
			System.out.println("Error al crear consultas preparadas para Manejador de Perfiles");
		}
	}

	public static void guardarPerfiles(Perfiles perfiles) throws SQLException {

		consultaInsertarPerfiles.setInt(1, perfiles.getPerf_Codigo());
		consultaInsertarPerfiles.setString(2, perfiles.getPerf_Nombre());
		consultaInsertarPerfiles.executeQuery();

	}

	public static Perfiles obtenerPerfiles(String Perf_Codigo) {

		Perfiles resultado = null;

		try {
			consultaPerfilesPorCodigo.setString(1, Perf_Codigo);
			ResultSet resultadoConsulta = consultaPerfilesPorCodigo.executeQuery();

			if (resultadoConsulta.next()) {

				int codigo = resultadoConsulta.getInt(1);
				String nomperfiles = resultadoConsulta.getString(2);
				resultado = new Perfiles(codigo, nomperfiles);

			}

		} catch (SQLException e) {

		}

		return resultado;

	}

	public static  List<Perfiles> obtenerTodosPerfiles() {

		 List<Perfiles> resultado = new ArrayList<>();

		try {
			ResultSet resultadoConsulta = consultaTodosPerfiles.executeQuery();

			while (resultadoConsulta.next()) {

				int codigo = resultadoConsulta.getInt(1);
				String nomperfiles = resultadoConsulta.getString(2);

				Perfiles perfiles = new Perfiles(codigo, nomperfiles);
				resultado.add(perfiles);

			}

		} catch (SQLException e) {

		}

		return resultado;
	}
}
