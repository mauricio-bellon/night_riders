package interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controladores.ControladorCiudades;
import controladores.ControladoresPedidoProducto;
import controladores.ControladorPerfiles;
import controladores.ControladorProductos;
import controladores.ControladorUsuario;
import excepciones.RangoOpcionException;

public class Interfaz {
	public static int EXIT = 7;
	
	public static String MENSAJE_CIUDADES = "-- Alta de Ciudades --\n\n";
	public static String MENSAJE_PEDIDOPRODUCTOS = "-- Alta Pedido Producto --\n\n";
	public static String MENSAJE_PERFILES = "-- Alta de Perfiles --\n\n";
	public static String MENSAJE_PRODUCTOS = "-- Alta de Productos --\n\n";
	public static String MENSAJE_USUARIOS = "-- ALta de Usuarios --\n\n";
	
	public static String MENU = "PRYECTO Night Riders\n\n" + "Seleccione una opcíon:\n\n"
			+ "1, Igresar Productos\n" + "2. Ingresar Pedidos\n" + "3. Ingresar Veterinario\n"
			+ "4. Registrar Usuario\n" + "5. Listar Pedidos\n" + "6. Listar Productos\n" + "7. Salir\n";
	
	public static void main (String[] args) {
		
		InputStreamReader stream = new InputStreamReader (System.in);
		BufferedReader reader = new BufferedReader(stream);
		
		int opcion = 0;
		
		while (opcion != EXIT) {
			System.out.println(MENU);
			System.out.println();
			
			opcion = opcionElegida(reader);
			switch (opcion) {
			case 1:
				
			}
		}
	}
}
