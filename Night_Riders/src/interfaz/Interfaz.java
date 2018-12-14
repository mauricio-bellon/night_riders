package interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*import java.text.ParseException;
import java.text.SimpleDateFormat;*/
import java.util.ArrayList;
//import java.util.Date;

import java.sql.Date;

import controladores.ControladorCiudades;
import controladores.ControladoresPedidoProducto;

import controladores.ControladorProductos;
import controladores.ControladorUsuario;
import excepciones.RangoOpcionException;

public class Interfaz {
	public static int EXIT = 7;
	
	/*public static String MENSAJE_CIUDADES = "-- Alta de Ciudades --\n\n";
	public static String MENSAJE_PEDIDOPRODUCTOS = "-- Alta Pedido Producto --\n\n";
	public static String MENSAJE_PRODUCTOS = "-- Alta de Productos --\n\n";
	public static String MENSAJE_USUARIOS = "-- ALta de Usuarios --\n\n";
	
	public static String MENU = "PRYECTO Night Riders\n\n" + "Seleccione una opcíon:\n\n"
			+ "1, Igresar Productos\n" + "2. Ingresar Pedidos\n" + "3. Ingresar Ciudad\n"
			+ "4. Registrar Usuario\n" + "5. Listar Pedidos\n" + "6. Listar Productos\n" + "7. Listar Ciudades" + "8. Salir\n";
	*/
	public static String MENSAJE_CIUDADES = "-- Alta de Ciudades\n\n";
	public static String MENSAJE_PEDIDOS = "-- Alta de Pedidos --\n\n";
	public static String MENSAJE_PEDIDOPRODUCTO = "-- Alta PedidoProducto --\n\n";
	public static String MENSAJE_REGISTRO = "-- Nuevo Usuario --\n\n";
	public static String MENSAJE_LISTADO_PRODUCTOS = "-- Listado de Productos --\n\n";
	public static String MENSAJE_LISTADO_PEDIDOS = "-- Listado de Pedidos --\n\n";
	public static String MENSAJE_LISTADO_CIUDADES = "-- Listado de Ciudades --\n\n";

	public static String MENU = "Proyecto Night Riders\n\n" + "Seleccione una opción:\n\n"
			+ "1. Ingresar Ciudad\n" + "2. Ingresar Pedidos\n" + "3. Ingresar Pedido Producto\n"
			+ "4. Registrar Usuario\n" + "5. Listar Producto\n" + "6. Listar Pedidos\n" + "7. Listar Ciudades" +"8.Salir\n";
	
	public static void main(String[] args) {

		// Inicializamos la lectura de la entrada
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(stream);

		// Leemos por primera vez
		int opcion = 0;

		// Comienzo la iteracion hasta que finalice
		while (opcion != EXIT) {

			// Imprimimos el menu por primera vez
			System.out.println(MENU);
			System.out.println();

			// Pedimos un dato de la entrada
			opcion = opcionElegida(reader);

			switch (opcion) {
			case 1:

				// Opcion de Ingresar Ciudad
				pedirDatosDeCiudad(reader);

				break;

			case 2:

				// Opcion de Ingresar Pedidos
				PedirDatosDePedidos(reader);

				break;

			case 3:

				// Opcion de Ingresar Pedidos
				pedirDatosPedidoProducto(reader);

				break;

			case 4:

				pedirDatosDeRegistro(reader);
				break;

			case 5:

				listarProducto();
				break;

			case 6:

				listarPedidos();
				break;
			case 7:
				ListarCiudades();
				break;
				
			default:
				break;
			}

			System.out.println();
			System.out.println();

		}

	}

	private static void listarProducto() {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_LISTADO_PRODUCTOS);
		System.out.println();
		System.out.println();

		ArrayList<String> infoProductos = ControladorProductos.obtenerInfoProductos();
		
		if (infoProductos.isEmpty()){
			System.out.println("No hay productos ingresadas en el sistema.");
		}
		else{
			System.out.println("Codigo,FechaEstimadaRecibido,stockTotal,stockMinimo,Segmentacion,Peso,tipoEstiba,volumen,precio,fechaVencimiento,fechaElaborado,Lote");
			for (String info: infoProductos){
				System.out.println(info);
			}
		}

	}
	
	private static void listarPedidos() {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_LISTADO_PEDIDOS);
		System.out.println();
		System.out.println();

		ArrayList<String> infoPedidos = ControladoresPedidoProducto.obtenerInfoPedidoProductos();
		
		if (infoPedidos.isEmpty()){
			System.out.println("No hay Pedidos ingresadas en el sistema.");
		}
		else{
			
			for (String info: infoPedidos){
				System.out.println(info);
			}
		}

	}

	private static void pedirDatosPedidoProducto(BufferedReader reader) {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_PEDIDOPRODUCTO);
		System.out.println();

		try {

			// Pedimos uno a uno los datos del curso

			System.out.print("CodigoProd: ");
			String codigoProd = reader.readLine();
			System.out.println();

			System.out.print("Fecha: ");
			String Fecha = reader.readLine();
			System.out.println();

			System.out.print("Fecha Estimada Recibido: ");
			String FechaEstimadaRecibido = reader.readLine();
			System.out.println();

			System.out.print("Estado Pedido Producto: ");
			String EstadoPedidoProducto = reader.readLine();
			System.out.println();
			
			System.out.print("Cantidad: ");
			String Cantidad = reader.readLine();
			System.out.println();

			System.out.print("Fecha Estimada Entrega: ");
			String FechaEstimadaEntrega = reader.readLine();
			System.out.println();
			

			// Mostramos la información ingresada para pedir la confirmación

			System.out.println();
			System.out.println();
			System.out.println("Se ingresará en el sistema el Pedido de Productos con los siguientes datos:");
			System.out.println();
			System.out.println("Codigo Producto: " + codigoProd);
			System.out.println("Fecha: " + Fecha);
			System.out.println("FechaEstimadaRecibido: " + FechaEstimadaRecibido);
			System.out.println("EstadoPedidoProducto: " + EstadoPedidoProducto);
			System.out.println("Cantidad: " + Cantidad);
			System.out.println("FechaEstimadaEntrega: " + FechaEstimadaEntrega);
			System.out.println();
			System.out.print("¿Confirma los datos? (Y/N)");

			// Leemos la confirmación del usuario

			String confirma = reader.readLine();

			// Mientras que no seleccione Y o N, volvemos a pedirle la
			// confimación

			while (!(confirma.equals("Y") || confirma.equals("N"))) {
				System.out.println();
				System.out.print("¿Confirma los datos? (Y/N)");
				confirma = reader.readLine();
			}

			// Si confirma que no, volvemos al menu
			System.out.println();
			System.out.println();

			if (confirma.equals("N")) {

				System.out.print("Alta PedidoProducto cancelado!");
			} else {

				// Si confirma que si, validamos que el veterinario con dicho
				// codigoProd no exista previamente en el sistema

				boolean existePedido = ControladoresPedidoProducto.existePedidoProducto(codigoProd);

				if (existePedido) {

					System.out.print("Ya existe un Pedido de producto con este mismo codigoProd " + codigoProd + " en el sistema.");
				} else {

					// Si llegamos aqui intentamos crear el pedido, Si surge
					// da algún error, mostramos un msj y volvemos al menu
					Date Fec = Date.valueOf(Fecha);
					Date FecEst = Date.valueOf(FechaEstimadaRecibido);
					double EstPed = Double.valueOf(EstadoPedidoProducto);
					long Cant = Long.valueOf(Cantidad);
					Date FechEstiEnt = Date.valueOf(FechaEstimadaEntrega);
					boolean pudeCrear = ControladoresPedidoProducto.ingresarNuevaPedidoProducto(codigoProd, Fec, FecEst, EstPed, Cant, FechEstiEnt);
					if (pudeCrear) {
						System.out.print("Pedido Producto con codigoProd " + codigoProd + " creado exitosamente!");
					} else {
						System.out.print("Ocurrió un error al guardar el pedido. Intente nuevamente.");
					}
				}

			}

		} catch (IOException e) {
			System.out.print("Ocurrió un error al leer los datos de pantalla. Intente nuevamente.");
		}

	}

	private static void pedirDatosDeRegistro(BufferedReader reader) {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_REGISTRO);
		System.out.println();

		try {

			// Pedimos uno a uno los datos del curso

			System.out.print("Codigo: ");
			String codigo = reader.readLine();
			System.out.println();

			System.out.print("Codigo Perfil: ");
			String CodPerf = reader.readLine();
			System.out.println();

			System.out.print("Nombre: ");
			String Nombre = reader.readLine();
			System.out.println();
			
			System.out.print("Apellido: ");
			String Apellido = reader.readLine();
			System.out.println();
			
			System.out.print("Nombre Acceso: ");
			String NombreAcc = reader.readLine();
			System.out.println();
			
			System.out.print("Correo: ");
			String Correo = reader.readLine();
			System.out.println();
			
			System.out.print("Contraseña: ");
			String clave = reader.readLine();
			System.out.println();

			// Mostramos la información ingresada para pedir la confirmación

			System.out.println();
			System.out.println();
			System.out.println("Se ingresará en el sistema un nuevo Usuario con los siguientes datos:");
			System.out.println();
			System.out.println("Codigo: " + codigo);
			System.out.println("Codigo Perfil: " + CodPerf);
			System.out.println("Nombre: " + Nombre);
			System.out.println("Apellido: " + Apellido);
			System.out.println("NombreAcc: " + NombreAcc);
			System.out.println("Correo: " + Correo);
			System.out.println("Contraseña: " + clave);
			System.out.println();
			System.out.print("¿Confirma los datos? (Y/N)");

			// Leemos la confirmación del usuario

			String confirma = reader.readLine();

			// Mientras que no seleccione Y o N, volvemos a pedirle la
			// confimación

			while (!(confirma.equals("Y") || confirma.equals("N"))) {
				System.out.println();
				System.out.print("¿Confirma los datos? (Y/N)");
				confirma = reader.readLine();
			}

			// Si confirma que no, volvemos al menu
			System.out.println();
			System.out.println();

			if (confirma.equals("N")) {

				System.out.print("Alta de Usuario cancelada!");
			} else {

				// Si confirma que si, validamos que el usuario
				// esten previamente en el sistema

				boolean existePedido = ControladorUsuario.existeUsuario(codigo);

				if (!existePedido) {

					System.out
							.print("No se encuentra un Usuario con CODIGO " + codigo + " en el sistema.");
				} else {


					// Transofrmamos la fecha de Strign en el formato
					// indicado al tipo Date.
					
					//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					//Date fecha = sdf.parse(fechaString);

					// Si llegamos aqui intentamos crear el cliente, Si
					// se da algún error, mostramos un msj y volvemos al
					// menu
					boolean pudeCrear = ControladorUsuario.ingresarNuevoUsuario(codigo, CodPerf, Nombre, Apellido, NombreAcc, Correo, clave);
					if (pudeCrear) {
						System.out.print("Usuario creado exitosamente!");
					} else {
						System.out.print("Ocurrió un error al guardar el usuario. Intente nuevamente.");
					}
				}
			}

		} catch (IOException e) {
			System.out.print("Ocurrió un error al leer los datos de pantalla. Intente nuevamente.");
		}

	}

	private static void pedirDatosDeCiudad(BufferedReader reader) {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_CIUDADES);
		System.out.println();

		try {

			// Pedimos uno a uno los datos del curso

			System.out.print("Codigo: ");
			String Codigo = reader.readLine();
			System.out.println();

			System.out.print("Nombre: ");
			String Nombre = reader.readLine();
			System.out.println();

			// Mostramos la información ingresada para pedir la confirmación

			System.out.println();
			System.out.println();
			System.out.println("Se ingresará en el sistema el CLiente con los siguientes datos:");
			System.out.println();
			System.out.println("Codigo: " + Codigo);
			System.out.println("Nombre: " + Nombre);
			System.out.println();
			System.out.print("¿Confirma los datos? (Y/N)");

			// Leemos la confirmación del usuario

			String confirma = reader.readLine();

			// Mientras que no seleccione Y o N, volvemos a pedirle la
			// confimación

			while (!(confirma.equals("Y") || confirma.equals("N"))) {
				System.out.println();
				System.out.print("¿Confirma los datos? (Y/N)");
				confirma = reader.readLine();
			}

			// Si confirma que no, volvemos al menu
			System.out.println();
			System.out.println();

			if (confirma.equals("N")) {

				System.out.print("Alta de Ciudades cancelada!");
			} else {

				// Si confirma que si, validamos que el cliente con dicha CI no
				// exista previamente en el sistema

				boolean existeCiudad = ControladorCiudades.existeCiudades(Codigo);

				if (existeCiudad) {

					System.out.print("Ya existe un ciudad con este codigo " + Codigo + " en el sistema.");
				} else {

					// Si llegamos aqui intentamos crear la ciudad, Si se da
					// algún error, mostramos un msj y volvemos al menu

					boolean pudeCrear = ControladorCiudades.ingresarNuevaCiudad(Codigo, Nombre);

					if (pudeCrear) {
						System.out.print("Ciudad con Codigo " + Codigo + " creado exitosamente!");
					} else {
						System.out.print("Ocurrió un error al guardar el cliente. Intente nuevamente.");
					}
				}

			}

		} catch (IOException e) {
			System.out.print("Ocurrió un error al leer los datos de pantalla. Intente nuevamente.");
		}

	}

	private static void PedirDatosDePedidos(BufferedReader reader) {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_PEDIDOS);
		System.out.println();

		try {

			// Pedimos uno a uno los datos del curso

			System.out.print("Cod Prod: ");
			String CodProd = reader.readLine();
			System.out.println();

			System.out.print("Fecha: ");
			String Fecha = reader.readLine();
			System.out.println();

			System.out.print("Fecha Estimada Recibido: ");
			String FechaEstimadaRecibido = reader.readLine();
			System.out.println();
			
			System.out.print("Estado Pedido Producto: ");
			String EstadoPedidoProducto = reader.readLine();
			System.out.println();

			System.out.print("Cantidad: ");
			String Cantidad = reader.readLine();
			System.out.println();

			System.out.print("Fecha Estimada Entrega: ");
			String FechaEstimadaEntrega = reader.readLine();
			System.out.println();

			// Mostramos la información ingresada para pedir la confirmación

			System.out.println();
			System.out.println();
			System.out.println("Se ingresará en el sistema la Mascota con los siguientes datos:");
			System.out.println();
			System.out.println("NUMERO PATENTE: " + CodProd);
			System.out.println("Fecha: " + Fecha);
			System.out.println("FechaEstimadaRecibido: " + FechaEstimadaRecibido);
			System.out.println("Estado Pedido Producto: " + EstadoPedidoProducto);
			System.out.println("Cantidad: " + Cantidad);
			System.out.println("Fecha Estimada Entrega: " + FechaEstimadaEntrega);
			System.out.println();
			System.out.print("¿Confirma los datos? (Y/N)");

			// Leemos la confirmación del usuario

			String confirma = reader.readLine();

			// Mientras que no seleccione Y o N, volvemos a pedirle la
			// confimación

			while (!(confirma.equals("Y") || confirma.equals("N"))) {
				System.out.println();
				System.out.print("¿Confirma los datos? (Y/N)");
				confirma = reader.readLine();
			}

			// Si confirma que no, volvemos al menu
			System.out.println();
			System.out.println();

			if (confirma.equals("N")) {

				System.out.print("Alta de Pedidos cancelada!");
			} else {

				// ANtes de proceder, validamos tres cosas,...
				// 1. Que exista el cliente
				// 2. Que no exista otra mascota con la misma patente
				// 3. Que el valor de edad es un número

				boolean existePedido = ControladoresPedidoProducto.existePedidoProducto(CodProd);

				

				boolean existeProducto = ControladorProductos.existeProducto(CodProd);

				// Si no existe el producto, motramos un msj

				if (!existePedido) {
					System.out.print("No se encuentra un Producto con Codigo " + CodProd + " en el sistema.");
				} else {

						// POr ultimo, validamos que no exista pedido con ese
						// codigo

						if (existeProducto) {
							System.out.print(
									"Ya existe un pedido con el codigo " + CodProd + " en el sistema.");
						} else {
							// Si llegamos aqui intentamos crear el pedido, Si
							// se da algún error, mostramos un msj y volvemos al
							// menu
							Date Fec = Date.valueOf(Fecha);
							Date FecEst = Date.valueOf(FechaEstimadaRecibido);
							double EstPed = Double.valueOf(EstadoPedidoProducto);
							long Cant = Long.valueOf(Cantidad);
							Date FechEstiEnt = Date.valueOf(FechaEstimadaEntrega);
							boolean pudeCrear = ControladoresPedidoProducto.ingresarNuevaPedidoProducto(CodProd, Fec, FecEst, EstPed, Cant, FechEstiEnt);

							if (pudeCrear) {
								System.out.print("Pedido con codigo " + CodProd + " creada exitosamente!");
							} else {
								System.out.print("Ocurrió un error al guardar el Pedido. Intente nuevamente.");
							}
						}

					}

				}

		} catch (IOException e) {
			System.out.print("Ocurrió un error al leer los datos de pantalla. Intente nuevamente.");
		}

	}

	private static int opcionElegida(BufferedReader reader) {

		int resultado = 0;
		String opcionLeida = null;

		try {
			opcionLeida = reader.readLine();
			resultado = Integer.valueOf(opcionLeida);
			validarRangoOpcion(resultado);
		} catch (IOException e) {
			System.out.println("Error al leer de la entrada estandar, ingrese nuevamente su opción\n");
		} catch (NumberFormatException e) {
			System.out.println("Debe ingresar un número, ingrese nuevamente su opción\n");

		} catch (RangoOpcionException e) {
			System.out.println(e.getMessage());
		}

		return resultado;
	}

	// Metodo que valida que la opcion estÃ© entre 1 y 4
	private static void validarRangoOpcion(int opcion) throws RangoOpcionException {

		if (opcion <= 0 || opcion > 8) {
			throw new RangoOpcionException("El rango de la opcion debe estar entre 1 y 7");
		}

	}
	
	private static void ListarCiudades() {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_LISTADO_CIUDADES);
		System.out.println();
		System.out.println();

		ArrayList<String> infoCiudades = ControladorCiudades.obtenerInfoCiudades();
		
		if (infoCiudades.isEmpty()){
			System.out.println("No hay ciudades ingresadas en el sistema.");
		}
		else{
			System.out.println("Codigo,Nombre");
			for (String info: infoCiudades){
				System.out.println(info);
			}
		}

	}
}
