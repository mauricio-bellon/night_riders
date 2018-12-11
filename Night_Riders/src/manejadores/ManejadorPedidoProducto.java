package manejadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import Objetos.PedidoProducto;
import Objetos.Productos;

public class ManejadorPedidoProducto {
	private static PreparedStatement consultaInsertarPedidoProductos;
	private static PreparedStatement consultaPedidoProductosPorCodigo;
	private static PreparedStatement consultaTodosPedidoProducto;

	static {

		try {
			consultaInsertarPedidoProductos = DatabaseManager.getConnection()
					.prepareStatement("INSERT INTO PedidoProductos(Productos,fecha,fechaestimadarecibido,estadopedidoproducto,cantidad,fechaestimadaentrega) VALUES(?,?,?,?,?,?)");
			consultaPedidoProductosPorCodigo = DatabaseManager.getConnection()
					.prepareStatement("SELECT * FROM PedidoProductos WHERE id=?");
			consultaTodosPedidoProducto = DatabaseManager.getConnection().prepareStatement("SELECT * FROM PedidoProductos");

		} catch (SQLException e) {
			System.out.println("Error al crear consultas preparadas para Manejador de PedidoProductos");
		}
	}

	public static void guardarPedidoProductos(PedidoProducto pedidoproducto) throws SQLException {

		consultaInsertarPedidoProductos.setString(1, pedidoproducto.getProductos().getCodigo());
		consultaInsertarPedidoProductos.setDate(2, (java.sql.Date) pedidoproducto.getFecha());
		consultaInsertarPedidoProductos.setDate(3, (java.sql.Date) pedidoproducto.getFechaEstimadaRecibido());
		consultaInsertarPedidoProductos.setDouble(4, pedidoproducto.getEstadoPedidoProducto());
		consultaInsertarPedidoProductos.setLong(5, pedidoproducto.getCantidad());
		consultaInsertarPedidoProductos.setDate(6, (java.sql.Date) pedidoproducto.getFechaEstimadaEntrega());
		consultaInsertarPedidoProductos.executeQuery();

	}

	public static PedidoProducto obtenerPedidoProductos(String Id) {

		PedidoProducto resultado = null;

		try {
			consultaPedidoProductosPorCodigo.setString(1, Id);
			ResultSet resultadoConsulta = consultaPedidoProductosPorCodigo.executeQuery();

			if (resultadoConsulta.next()) {

				String CodigoProducto = resultadoConsulta.getString(1);
				Date Fecha = resultadoConsulta.getDate(2);
				Date fechaEstimadaRecibido = resultadoConsulta.getDate(3);
				Double EstadoPedidoProducto = resultadoConsulta.getDouble(4);
				Long Cantidad = resultadoConsulta.getLong(5);
				Date FechaEstimadaEntrega = resultadoConsulta.getDate(6);
				
				Productos producto = ManejadorProductos.obtenerProductos(CodigoProducto);
				
				resultado = new PedidoProducto(producto,Fecha,fechaEstimadaRecibido,EstadoPedidoProducto,Cantidad,FechaEstimadaEntrega);

			}

		} catch (SQLException e) {

		}

		return resultado;

	}

	public static  List<PedidoProducto> obtenerTodosPedidoProductos() {

		 List<PedidoProducto> resultado = new ArrayList<>();

		try {
			ResultSet resultadoConsulta = consultaTodosPedidoProducto.executeQuery();

			while (resultadoConsulta.next()) {

				String CodigoProducto = resultadoConsulta.getString(1);
				Date Fecha = resultadoConsulta.getDate(2);
				Date fechaEstimadaRecibido = resultadoConsulta.getDate(3);
				Double EstadoPedidoProducto = resultadoConsulta.getDouble(4);
				Long Cantidad = resultadoConsulta.getLong(5);
				Date FechaEstimadaEntrega = resultadoConsulta.getDate(6);
				
				Productos producto = ManejadorProductos.obtenerProductos(CodigoProducto);

				PedidoProducto pedidoproducto = new PedidoProducto(producto,Fecha,fechaEstimadaRecibido,EstadoPedidoProducto,Cantidad,FechaEstimadaEntrega);
				resultado.add(pedidoproducto);

			}

		} catch (SQLException e) {

		}

		return resultado;
	}


}