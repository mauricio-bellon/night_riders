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
		/*initializeMenuVeterinario(menuBar, frame);
		initializeMenuConsultas(menuBar, frame);*/
		
		frame.setJMenuBar(menuBar);

	}

	/** Inicialicación de botones del menu de pedidos */
	
	private static void initializeMenuPedidos(JMenuBar menuBar, final JFrame frame) {
		
		JMenu pedidos = new JMenu("Pedidos");
		
		JMenuItem pedidoProd = new JMenuItem("Pedidos de Productos");
		
		pedidoProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameListarPedidos(frame);
            	
            }
        });

		pedidos.add(pedidoProd);
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
		
		JMenuItem listarMastcotas = new JMenuItem("Listar producto");
		
		listarMastcotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameListarProductos(frame);
            	
            }
        });

		producto.add(nuevoProducto);
		producto.add(listarMastcotas);
		
		menuBar.add(producto);
		
	}
	
	/** Inicialicación de botones del menu de Veterinario */
	/*
	private static void initializeMenuVeterinario(JMenuBar menuBar, final JFrame frame) {
		
		JMenu veterinarios = new JMenu("Veterinarios");
		
		JMenuItem nuevoVeterinario = new JMenuItem("Nuevo Veterinario");
		
		nuevoVeterinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameNuevoVeterinario(frame);
            	
            }
        });

		veterinarios.add(nuevoVeterinario);
		
		menuBar.add(veterinarios);
		
	}*/
	
	/** Inicialicación de botones del menu de Consultas */
	/*
	private static void initializeMenuConsultas(JMenuBar menuBar, final JFrame frame) {
		
		JMenu consultas = new JMenu("Consultas");
		
		JMenuItem nuevaConsulta = new JMenuItem("Nueva Consulta");
		
		nuevaConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameNuevaConsulta(frame);
            	
            }
        });
		
		JMenuItem listarConsultas = new JMenuItem("Listar Consultas");
		
		listarConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameListarConsultas(frame);
            	
            }
        });

		consultas.add(nuevaConsulta);
		consultas.add(listarConsultas);
		
		menuBar.add(consultas);		
	}*/

}
