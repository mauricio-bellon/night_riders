package interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controladores.ControladorCiudades;
import controladores.ControladorClientes;
import controladores.ControladorConsultas;
import controladores.ControladorMascotas;
import controladores.ControladoresPedidoProducto;
import controladores.ControladorPerfiles;
import controladores.ControladorProductos;
import controladores.ControladorUsuario;
import controladores.ControladorVeterinarios;
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

			System.out.print("FechaEstimadaRecibido: ");
			String FechaEstimadaRecibido = reader.readLine();
			System.out.println();

			System.out.print("EstadoPedidoProducto: ");
			String EstadoPedidoProducto = reader.readLine();
			System.out.println();
			
			System.out.print("Cantidad: ");
			String Cantidad = reader.readLine();
			System.out.println();

			System.out.print("FecbaEstimadaEntrega: ");
			String FecbaEstimadaEntrega = reader.readLine();
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

				boolean existeVeterinario = ControladorVeterinarios.existeVeterinario(codigoProd);

				if (existeVeterinario) {

					System.out.print("Ya existe un veterinario con codigoProd " + codigoProd + " en el sistema.");
				} else {

					// Si llegamos aqui intentamos crear el veterinario, Si se
					// da algún error, mostramos un msj y volvemos al menu

					boolean pudeCrear = ControladorVeterinarios.ingresarNuevaVeterinario(codigoProd, Fecha, FechaEstimadaRecibido,
							ci);

					if (pudeCrear) {
						System.out.print("Veterinario con codigoProd " + codigoProd + " creado exitosamente!");
					} else {
						System.out.print("Ocurrió un error al guardar el veterinario. Intente nuevamente.");
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

			System.out.print("Patente Mascota: ");
			String nroPatenteMascota = reader.readLine();
			System.out.println();

			System.out.print("codigoProd Veterinario: ");
			String codigoProdVeterinaio = reader.readLine();
			System.out.println();

			System.out.print("Fecha (dd/MM/YYYY): ");
			String fechaString = reader.readLine();
			System.out.println();

			// Mostramos la información ingresada para pedir la confirmación

			System.out.println();
			System.out.println();
			System.out.println("Se ingresará en el sistema una Consulta con los siguientes datos:");
			System.out.println();
			System.out.println("PATENTE MASCOTA: " + nroPatenteMascota);
			System.out.println("codigoProd VETERINARIO: " + codigoProdVeterinaio);
			System.out.println("FECHA: " + fechaString);
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

				System.out.print("Alta de consulta cancelada!");
			} else {

				// Si confirma que si, validamos que el veterinario y la mascota
				// esten previamente en el sistema

				boolean existeVeterinario = ControladorVeterinarios.existeVeterinario(codigoVeterinaio);
				boolean existeMascota = ControladorMascotas.existeMascota(nroPatenteMascota);

				if (!existeVeterinario) {

					System.out
							.print("No se encuentra un Veterinario con CODIGO " + codigoVeterinaio + " en el sistema.");
				} else {

					if (!existeMascota) {
						System.out.print(
								"No se encuentra una Mascota con NRO PATENTE " + nroPatenteMascota + " en el sistema.");
					} else {

						// Transofrmamos la fecha de Strign en el formato
						// indicado al tipo Date.
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

						try {
							Date fecha = sdf.parse(fechaString);

							// Si llegamos aqui intentamos crear el cliente, Si
							// se da algún error, mostramos un msj y volvemos al
							// menu

							boolean pudeCrear = ControladorConsultas.ingresarNuevaConsulta(codigoVeterinaio,
									nroPatenteMascota, fecha);

							if (pudeCrear) {
								System.out.print("Consulta creada exitosamente!");
							} else {
								System.out.print("Ocurrió un error al guardar la consulta. Intente nuevamente.");
							}
						} catch (ParseException e) {
							System.out.print("Error en el formato de la fecha.");
						}

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

			System.out.print("FechaEstimadaRecibido: ");
			String FechaEstimadaRecibido = reader.readLine();
			System.out.println();

			System.out.print("Apellido: ");
			String apellido = reader.readLine();
			System.out.println();

			System.out.print("CI: ");
			String ci = reader.readLine();
			System.out.println();

			// Mostramos la información ingresada para pedir la confirmación

			System.out.println();
			System.out.println();
			System.out.println("Se ingresará en el sistema el CLiente con los siguientes datos:");
			System.out.println();
			System.out.println("FechaEstimadaRecibido: " + FechaEstimadaRecibido);
			System.out.println("APELLIDO: " + apellido);
			System.out.println("FechaEstimadaRecibido: " + ci);
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

				boolean existeCliente = ControladorClientes.existeCliente(ci);

				if (existeCliente) {

					System.out.print("Ya existe un cliente con CI " + ci + " en el sistema.");
				} else {

					// Si llegamos aqui intentamos crear el cliente, Si se da
					// algún error, mostramos un msj y volvemos al menu

					boolean pudeCrear = ControladorClientes.ingresarNuevoCliente(FechaEstimadaRecibido, apellido, ci);

					if (pudeCrear) {
						System.out.print("Cliente con CI " + ci + " creado exitosamente!");
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

			System.out.print("Numero Patente: ");
			String nroPatente = reader.readLine();
			System.out.println();

			System.out.print("Tipo: ");
			String tipo = reader.readLine();
			System.out.println();

			System.out.print("FechaEstimadaRecibido: ");
			String FechaEstimadaRecibido = reader.readLine();
			System.out.println();

			System.out.print("Edad: ");
			String edadString = reader.readLine();
			System.out.println();

			System.out.print("CI Cliente: ");
			String ciCliente = reader.readLine();
			System.out.println();

			// Mostramos la información ingresada para pedir la confirmación

			System.out.println();
			System.out.println();
			System.out.println("Se ingresará en el sistema la Mascota con los siguientes datos:");
			System.out.println();
			System.out.println("NUMERO PATENTE: " + nroPatente);
			System.out.println("TIPO: " + tipo);
			System.out.println("FechaEstimadaRecibido: " + FechaEstimadaRecibido);
			System.out.println("EDAD: " + edadString);
			System.out.println("CI CLIENTE: " + ciCliente);
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

				boolean existeCliente = ControladorClientes.existeCliente(ciCliente);

				boolean esNumeroEdad = true;
				int edad = -1;
				try {
					edad = Integer.valueOf(edadString);
				} catch (NumberFormatException e) {
					esNumeroEdad = false;
				}

				boolean existeMascota = ControladorMascotas.existeMascota(nroPatente);

				// Si no existe el cliente, motramos un msj

				if (!existeCliente) {
					System.out.print("No se encuentra un Cliente con CI " + ciCliente + " en el sistema.");
				} else {

					// Si el cliente existe, validamos que la edad sea un valor
					// numérico

					if (!esNumeroEdad) {
						System.out.print("La edad debe ser un número válido.");
					} else {

						// POr ultimo, validamos que no exista mascota con ea
						// patente

						if (existeMascota) {
							System.out.print(
									"Ya existe una masctoa con el NRO de PATENTE " + nroPatente + " en el sistema.");
						} else {
							// Si llegamos aqui intentamos crear la mascota, Si
							// se da algún error, mostramos un msj y volvemos al
							// menu

							boolean pudeCrear = ControladorMascotas.ingresarNuevaMascota(nroPatente, tipo, edad, FechaEstimadaRecibido,
									ciCliente);

							if (pudeCrear) {
								System.out.print("Mascota con NRO PATENTE " + nroPatente + " creada exitosamente!");
							} else {
								System.out.print("Ocurrió un error al guardar la mascota. Intente nuevamente.");
							}
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
}
