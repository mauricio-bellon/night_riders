package controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	public static boolean existePedidoProducto(String codigoProducto){
		
		boolean existe;
		PedidoProducto pedidoProductos = ManejadorPedidoProducto.obtenerPedidoProductos(codigoProducto);
		
		if (pedidoProductos==null){
			existe = false;
		}
		else{
			existe = true;
		}
		
		return existe;
		
	}
	
	public static ArrayList<String> obtenerInfoPedidoProductos(){
		
		ArrayList<String> infoPedidoProducto = new ArrayList<>();
		
		ArrayList<PedidoProducto> pedidoProductos = (ArrayList<PedidoProducto>) ManejadorPedidoProducto.obtenerTodosPedidoProductos();
		
		for(PedidoProducto pedidoProducto: pedidoProductos){
			infoPedidoProducto.add(pedidoProducto.toString());
		}
		
		return infoPedidoProducto;
		
	}
	
	public static  ArrayList<PedidoProducto> obtenerTodosPedidoProductos(){
		return (ArrayList<PedidoProducto>) ManejadorPedidoProducto.obtenerTodosPedidoProductos();
	}

}