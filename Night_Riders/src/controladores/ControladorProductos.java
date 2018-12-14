package controladores;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


import Objetos.Productos;
import manejadores.ManejadorProductos;

public class ControladorProductos {
	
	public static boolean ingresarNuevoProducto(String codigo, String nombre, String stockTotal, String stockMinimo, String segmentacion, int peso,
		boolean tipoEstiba, double volumen, long precio, Date fechaVencimiento, Date fechaElaborado, String lote){
		
		boolean pudeCrear;
		Productos productos = new Productos(codigo,nombre,stockTotal,stockMinimo,segmentacion,peso,tipoEstiba,volumen,precio,fechaVencimiento,fechaElaborado,lote);
		
		try{
			ManejadorProductos.guardarProductos(productos);
			pudeCrear = true;
		}
		catch (SQLException e){
			// ca va el cofigo se falla el insert
			pudeCrear = false;
		}
		
		return pudeCrear;
		
	}
	
	public static boolean existeProducto(String codigo){
		
		boolean existe;
		Productos productos = ManejadorProductos.obtenerProductos(codigo);
		
		if (productos==null){
			existe = false;
		}
		else{
			existe = true;
		}
		
		return existe;
		
	}
	
	public static ArrayList<String> obtenerInfoProductos(){
		
		ArrayList<String> infoProductos = new ArrayList<>();
		
		ArrayList<Productos> productos = ManejadorProductos.obtenerTodasProductos();
		
		for(Productos producto: productos){
			infoProductos.add(producto.toString());
		}
		
		return infoProductos;
		
	}
	
	public static ArrayList<Productos> obtenerTodosProductos(){
		
		return  ManejadorProductos.obtenerTodasProductos();
	}

}
