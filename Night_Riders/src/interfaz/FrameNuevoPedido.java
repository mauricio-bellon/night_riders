package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.ControladorProductos;
import controladores.ControladoresPedidoProducto;

public class FrameNuevoPedido implements ActionListener{
	/** Frame de la ventana */
	private JFrame frame;

	/** Atributos de labels */
	private JLabel labelCodigo;
	private JLabel labelFecha;
	private JLabel labelFechaEstimadaRecibido;
	private JLabel labelEstadoPedidoProducto;
	private JLabel labelCantidad;
	private JLabel labelFechaEstimadaEntrega;
	

	/** Atributos de TexField */
	private JTextField textCodigo;
	private JTextField textFecha;
	private JTextField textFechaEstimadaRecibido;
	private JTextField textEstadoPedidoProducto;
	private JTextField textCantidad;
	private JTextField textFechaEstimadaEntrega;

	/** Atributos de Botones */
	private JButton buttonIngresar;
	private JButton buttonCancelar;

	public FrameNuevoPedido (JFrame framePadre) {

		this.labelFecha = new JLabel("Fecha:");
		this.labelCodigo = new JLabel("Codigo:");
		this.labelFechaEstimadaRecibido = new JLabel("FechaEstimadaRecibido:");
		this.labelEstadoPedidoProducto = new JLabel("EstadoPedidoProducto:");
		this.labelCantidad = new JLabel("Cantidad:");
		this.labelFechaEstimadaEntrega = new JLabel("FechaEstimadaEntrega:");
		
		this.textFechaEstimadaRecibido = new JTextField(15);
		this.textCodigo = new JTextField(15);
		this.textFecha = new JTextField(15);
		this.textEstadoPedidoProducto = new JTextField(15);
		this.textCantidad = new JTextField(15);
		this.textFechaEstimadaEntrega = new JTextField(15);

		JButton buttonIngresar = new JButton("Ingresar");
		buttonIngresar.addActionListener(this);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(this);

		this.buttonIngresar = buttonIngresar;
		this.buttonCancelar = buttonCancelar;

		this.initalizeFrame(framePadre);
	}

	private void initalizeFrame(JFrame framePadre) {

		JFrame frame = new JFrame("Nuevo Pedido");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(framePadre);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel NuevoPedidoPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		constraints.gridx = 0;
		constraints.gridy = 0;
		NuevoPedidoPanel.add(this.labelCodigo, constraints);

		constraints.gridx = 1;
		NuevoPedidoPanel.add(this.textCodigo, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		NuevoPedidoPanel.add(this.labelFecha, constraints);

		constraints.gridx = 1;
		NuevoPedidoPanel.add(this.textFecha, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		NuevoPedidoPanel.add(this.labelFechaEstimadaRecibido, constraints);

		constraints.gridx = 1;
		NuevoPedidoPanel.add(this.textFechaEstimadaRecibido, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		NuevoPedidoPanel.add(this.labelEstadoPedidoProducto, constraints);

		constraints.gridx = 1;
		NuevoPedidoPanel.add(this.textEstadoPedidoProducto, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		NuevoPedidoPanel.add(this.labelCantidad, constraints);

		constraints.gridx = 1;
		NuevoPedidoPanel.add(this.textCantidad, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		NuevoPedidoPanel.add(this.labelFechaEstimadaEntrega, constraints);

		constraints.gridx = 1;
		NuevoPedidoPanel.add(this.textFechaEstimadaEntrega, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 3;
		constraints.anchor = GridBagConstraints.CENTER;
		NuevoPedidoPanel.add(buttonIngresar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 4;
		constraints.anchor = GridBagConstraints.CENTER;
		NuevoPedidoPanel.add(buttonCancelar, constraints);

		NuevoPedidoPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del Pedido"));

		frame.add(NuevoPedidoPanel);

		frame.pack();
		frame.setVisible(true);

		this.frame = frame;

	}

	/**
	 * Como implementos Action Listener, quiere decir que soy escuchado de
	 * eventos. Este método es quien se ejecutan cuando tocan un boton .
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		/* Debo primero conocer que botón fue clickeado */

		if (e.getSource() == this.buttonCancelar) {
			this.accionCancelar();
		} else {
			this.accionIngesar();
		}

	}

	private void accionIngesar() {

		// Si es ingresar se validan datos!

		String fieldCodigo = this.textCodigo.getText();
		String fieldFecha = this.textFecha.getText();
		String fieldFechaEstimadaRecibido = this.textFechaEstimadaRecibido.getText();
		String fieldEstadoPedidoProducto = this.textEstadoPedidoProducto.getText();
		String fieldCantidad = this.textCantidad.getText();
		String fieldFechaEstimadaEntrega = this.textFechaEstimadaEntrega.getText();

		// Si alguno es vacío, mostramos una ventana de mensaje
		if (fieldCodigo.equals("") || fieldFecha.equals("") || fieldFechaEstimadaRecibido.equals("") || fieldEstadoPedidoProducto.equals("") || fieldCantidad.equals("") || fieldFechaEstimadaEntrega.equals("")) {
			JOptionPane.showMessageDialog(frame, "Debe completar todos los datos solicitados.", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);

			return;
		}

		// Valiamos ahora, que no exista un Producto con dicha Codigo
		boolean existe = ControladoresPedidoProducto.existePedidoProducto(fieldCodigo);

		if (existe) {
			JOptionPane.showMessageDialog(frame, "El Pedido con dicho  codigo ya se ecuentra registrado.",
					"Pedido Existente!", JOptionPane.WARNING_MESSAGE);

			return;
		}
		Date Fecha = Date.valueOf(fieldFecha);
		Date FechaEstimadaRecibido = Date.valueOf(fieldFechaEstimadaRecibido);
		double EstadoPedidoProducto = Double.valueOf(fieldEstadoPedidoProducto);
		long Cantidad = Long.valueOf(fieldCantidad);
		Date FechaEstimadaEntrega = Date.valueOf(fieldFechaEstimadaEntrega);
		// Si estamos aquí,..quiere decir que no hay errores. Almacenamos el
		// Producto y volvemos al menu
		boolean almacenado = ControladoresPedidoProducto.ingresarNuevaPedidoProducto(fieldCodigo, Fecha, FechaEstimadaRecibido, EstadoPedidoProducto, Cantidad, FechaEstimadaEntrega);

		if (almacenado) {
			JOptionPane.showMessageDialog(frame, "El Pedido ha sido registrado con éxito.",
					"Producto Registrado!", JOptionPane.INFORMATION_MESSAGE);
			
			// cerramos la ventanta
			this.frame.dispose();

			
		}
		else{
			JOptionPane.showMessageDialog(frame, "Hubo un error al almacenar. Intente nuevamente más tarde",
					"Error al registrar!", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void accionCancelar() {
		// si se cancela, se eliminar la ventana
		this.frame.dispose();

	}

}
