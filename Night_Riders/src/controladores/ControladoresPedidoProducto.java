package controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import manejadores.ManejadorProductos;
import manejadores.ManejadorPedidoProducto;
import Objetos.Productos;
import Objetos.PedidoProducto;

public class ControladoresPedidoProducto {
	public static boolean ingresarNuevaPedidoProducto(String codigoProducto , Date fecha, Date fechaEstimadaRecibido, double estadoPedidoProducto,
			long cantidad, Date fechaEstimadaEntrega) {

		boolean pudeCrear;
		
		Productos productos = ManejadorProductos.obtenerProductos(codigoProducto);
		PedidoProducto pedidoProducto = new PedidoProducto(productos,fecha,fechaEstimadaRecibido,estadoPedidoProducto,cantidad,fechaEstimadaEntrega);

		try {
			ManejadorPedidoProducto.guardarPedidoProductos(pedidoProducto);
			pudeCrear = true;
		} catch (SQLException e) {
			// ca va el cofigo se falla el insert
			pudeCrear = false;
		}

		return pudeCrear;

	}
	
	public static ArrayList<String> obtenerInfoPedidoProductos(){
		
		ArrayList<String> infoMascotas = new ArrayList<>();
		
		ArrayList<PedidoProducto> pedidoProductos = ManejadorPedidoProducto.obtenerTodosPedidoProductos();
		
		for(PedidoProducto pedidoProducto: pedidoProductos){
			infoMascotas.add(pedidoProducto.toString());
		}
		
		return infoMascotas;
		
	}
	
	public static  ArrayList<PedidoProducto> obtenerTodasPedidoProductos(){
		return ManejadorPedidoProductos.obtenerTodasPedidoProductos();
	}

}
