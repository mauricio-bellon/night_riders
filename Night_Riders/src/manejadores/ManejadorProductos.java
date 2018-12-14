package manejadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Objetos.Productos;

public class ManejadorProductos {
	private static PreparedStatement consultaInsertarProductos;
	private static PreparedStatement consultaProductoPorCodigo;
	private static PreparedStatement consultaTodosProductos;

	static {

		try {
			consultaInsertarProductos = DatabaseManager.getConnection().prepareStatement(
					"INSERT INTO Productos(codigo,nombre,stocktotal,stockminimo,segmetacion,peso,tipoestiba,volumen,precio,fechavencimiento,fechaelaborado,lote) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			consultaProductoPorCodigo = DatabaseManager.getConnection()
					.prepareStatement("SELECT * FROM Productos WHERE Codigo=?");
			consultaTodosProductos = DatabaseManager.getConnection().prepareStatement("SELECT * FROM Productos");

		} catch (SQLException e) {
			System.out.println("Error al crear consultas preparadas para Manejador de Productos");
		}
	}

	public static void guardarProductos(Productos productos) throws SQLException {

		consultaInsertarProductos.setString(1, productos.getCodigo());
		consultaInsertarProductos.setString(2, productos.getNombre());
		consultaInsertarProductos.setString(3, productos.getStockTotal());
		consultaInsertarProductos.setString(4, productos.getStockMinimo());
		consultaInsertarProductos.setString(5, productos.getSegmentacion());
		consultaInsertarProductos.setInt(6, productos.getPeso());
		consultaInsertarProductos.setBoolean(7, productos.isTipoEstiba());
		consultaInsertarProductos.setDouble(8, productos.getVolumen());
		consultaInsertarProductos.setLong(9, productos.getPrecio());
		consultaInsertarProductos.setDate(10, (java.sql.Date) productos.getFechaVencimiento());
		consultaInsertarProductos.setDate(11, (java.sql.Date) productos.getFechaElaborado());
		consultaInsertarProductos.setString(12, productos.getLote());
		consultaInsertarProductos.executeQuery();

	}

	public static Productos obtenerProductos(String Codigo) {

		Productos resultado = null;

		try {
			consultaProductoPorCodigo.setString(1, Codigo);
			ResultSet resultadoConsulta = consultaProductoPorCodigo.executeQuery();

			if (resultadoConsulta.next()) {

				String Nombre = resultadoConsulta.getString(2);
				String StockTotal = resultadoConsulta.getString(3);
				String StockMinimo = resultadoConsulta.getString(4);
				String Segmentacion = resultadoConsulta.getString(5);
				int Peso = resultadoConsulta.getInt(6);
				Boolean TipoEstiba = resultadoConsulta.getBoolean(7);
				Double Volumen = resultadoConsulta.getDouble(8);
				Long Precio = resultadoConsulta.getLong(9);
				Date FechaVencimiento = resultadoConsulta.getDate(10);
				Date FechaElaborado = resultadoConsulta.getDate(11);
				String Lote = resultadoConsulta.getString(12);
				
				
				resultado = new Productos(Codigo, Nombre, StockTotal, StockMinimo, Segmentacion, Peso, TipoEstiba, Volumen, Precio, FechaVencimiento, FechaElaborado, Lote);

			}

		} catch (SQLException e) {

		}

		return resultado;

	}

	public static ArrayList<Productos> obtenerTodasProductos() {

		ArrayList<Productos> resultado = new ArrayList<>();

		try {
			
			ResultSet resultadoConsulta = consultaTodosProductos.executeQuery();

			while (resultadoConsulta.next()) {
				
				String Codigo = resultadoConsulta.getString(1);
				String Nombre = resultadoConsulta.getString(2);
				String StockTotal = resultadoConsulta.getString(3);
				String StockMinimo = resultadoConsulta.getString(4);
				String Segmentacion = resultadoConsulta.getString(5);
				int Peso = resultadoConsulta.getInt(6);
				Boolean TipoEstiba = resultadoConsulta.getBoolean(7);
				Double Volumen = resultadoConsulta.getDouble(8);
				Long Precio = resultadoConsulta.getLong(9);
				Date FechaVencimiento = resultadoConsulta.getDate(10);
				Date FechaElaborado = resultadoConsulta.getDate(11);
				String Lote = resultadoConsulta.getString(12);

				Productos productos = new Productos(Codigo, Nombre, StockTotal, StockMinimo, Segmentacion, Peso, TipoEstiba, Volumen, Precio, FechaVencimiento, FechaElaborado, Lote);
				
				resultado.add(productos);

			}

		} catch (SQLException e) {

		}

		return resultado;

	}


}
