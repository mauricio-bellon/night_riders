package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class FramePrincipal {
	/**
	 *  Método que se ejecuta cuando se inicia la aplicación. Invoca a "createAndShowGUI"
	 *  para que se generen los componentes.
	 */
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	/** Método que inicializa toda la ventatna principal */
	
	private static void createAndShowGUI() {

		
		JFrame frame = new JFrame("Veterinaria");
		
		frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		initializeMenuBar(frame);

		// Display the window.
		frame.setVisible(true);
	}

	
	/** Inicializamos la barra de menu de arriba */
	
	private static void initializeMenuBar(JFrame frame) {
		
		JMenuBar menuBar = new JMenuBar();
		
		initializeMenuPedidos(menuBar, frame);
		initializeMenuProductos(menuBar, frame);
		initializeMenuUsuario(menuBar, frame);
		initializeMenuCiudades(menuBar, frame);
		frame.setJMenuBar(menuBar);

	}

	/** Inicialicación de botones del menu de pedidos */
	
	private static void initializeMenuPedidos(JMenuBar menuBar, final JFrame frame) {
		
		JMenu pedidos = new JMenu("Pedidos");
		
		JMenuItem pedidoProd = new JMenuItem("Pedidos de Productos");
		
		pedidoProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameNuevoPedido(frame);
            	
            }
        });
		
		JMenuItem listarPedidos = new JMenuItem("Listado Pedidos");
		
		listarPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameListarPedidos(frame);
            	
            }
        });

		pedidos.add(pedidoProd);
		pedidos.add(listarPedidos);
		menuBar.add(pedidos);
		
	}
	
	/** Inicialicación de botones del menu de producto */
	
	private static void initializeMenuProductos(JMenuBar menuBar, final JFrame frame) {
		
		JMenu producto = new JMenu("Productos");
		
		JMenuItem nuevoProducto = new JMenuItem("Nuevo Producto");
		
		nuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameNuevoProducto(frame);
            	
            }
        });
		
		JMenuItem listarProductos = new JMenuItem("Listar producto");
		
		listarProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameListarProductos(frame);
            	
            }
        });

		producto.add(nuevoProducto);
		producto.add(listarProductos);
		
		menuBar.add(producto);
		
	}
	
	/** Inicialicación de botones del menu de Usuario */
	private static void initializeMenuUsuario(JMenuBar menuBar, final JFrame frame) {
		
		JMenu usuario = new JMenu("Usuarios");
		
		JMenuItem nuevoUsuario = new JMenuItem("Nuevo Usuario");
		
		nuevoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameNuevoUsuario(frame);
            	
            }
        });

		usuario.add(nuevoUsuario);
		
		menuBar.add(usuario);
		
	}
	
	/** Inicialicación de botones del menu de Consultas */
	
	private static void initializeMenuCiudades(JMenuBar menuBar, final JFrame frame) {
		
		JMenu ciudades = new JMenu("Ciudades");
		
		JMenuItem listarCiudades = new JMenuItem("Listar Ciudades");
		
		listarCiudades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameListarCiudades(frame);
            	
            }
        });
		
		JMenuItem nuevaCiudad = new JMenuItem("Nueva Ciudad");
		
		nuevaCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameNuevaCiudad(frame);
            	
            }
        });

		ciudades.add(listarCiudades);
		ciudades.add(nuevaCiudad);
		
		menuBar.add(ciudades);		
	}

}
