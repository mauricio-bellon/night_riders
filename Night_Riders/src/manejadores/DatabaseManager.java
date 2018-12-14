package manejadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class DatabaseManager {
	private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "NightRiders";
	private static String CLAVE = "NightRiders";
	
	static{
		try {
			Locale.setDefault(new Locale("es","ES"));
			databaseConnection = DriverManager.getConnection(CONNECTION_STRING,USUARIO,CLAVE);
		} catch (SQLException e) {
			System.out.println("Error creando la conexión a la base de datos");
		} 

	}
	
	public static Connection getConnection() {
		
		return databaseConnection;
		
	}

}
