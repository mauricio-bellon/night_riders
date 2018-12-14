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

import controladores.ControladorProductos;;

public class FrameNuevoProducto implements ActionListener{
	/** Frame de la ventana */
	private JFrame frame;

	/** Atributos de labels */
	private JLabel labelCodigo;
	private JLabel labelNombre;
	private JLabel labelstockTotal;
	private JLabel labelstockMinimo;
	private JLabel labelSegmentacion;
	private JLabel labelPeso;
	private JLabel labeltipoEstiba;
	private JLabel labelvolumen;
	private JLabel labelprecio;
	private JLabel labelfechaVencimiento;
	private JLabel labelfechaElaborado;
	private JLabel labelLote;
	

	/** Atributos de TexField */
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textstockTotal;
	private JTextField textstockMinimo;
	private JTextField textSegmentacion;
	private JTextField textPeso;
	private JTextField texttipoEstiba;
	private JTextField textvolumen;
	private JTextField textprecio;
	private JTextField textfechaVencimiento;
	private JTextField textfechaElaborado;
	private JTextField textLote;

	/** Atributos de Botones */
	private JButton buttonIngresar;
	private JButton buttonCancelar;

	public FrameNuevoProducto (JFrame framePadre) {

		this.labelNombre = new JLabel("Nombre:");
		this.labelCodigo = new JLabel("Codigo:");
		this.labelstockTotal = new JLabel("stockTotal:");
		this.labelstockMinimo = new JLabel("stockMinimo:");
		this.labelSegmentacion = new JLabel("Segmentación:");
		this.labelPeso = new JLabel("Peso:");
		this.labeltipoEstiba = new JLabel("Tipo de Estiba:");
		this.labelvolumen = new JLabel("Volumen:");
		this.labelprecio = new JLabel("Precio:");
		this.labelfechaVencimiento = new JLabel("Fecha de vencimiento:");
		this.labelfechaElaborado = new JLabel("Fecha de Elaboracion:");
		this.labelLote = new JLabel("Lote:");

		this.textstockTotal = new JTextField(15);
		this.textCodigo = new JTextField(15);
		this.textNombre = new JTextField(15);
		this.textstockMinimo = new JTextField(15);
		this.textSegmentacion = new JTextField(15);
		this.textPeso = new JTextField(15);
		this.texttipoEstiba = new JTextField(15);
		this.textvolumen = new JTextField(15);
		this.textprecio = new JTextField(15);
		this.textfechaVencimiento = new JTextField(15);
		this.textfechaElaborado = new JTextField(15);
		this.textLote = new JTextField(15);

		JButton buttonIngresar = new JButton("Ingresar");
		buttonIngresar.addActionListener(this);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(this);

		this.buttonIngresar = buttonIngresar;
		this.buttonCancelar = buttonCancelar;

		this.initalizeFrame(framePadre);
	}

	private void initalizeFrame(JFrame framePadre) {

		JFrame frame = new JFrame("Nuevo Producto");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(framePadre);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel nuevoProductoPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		constraints.gridx = 0;
		constraints.gridy = 0;
		nuevoProductoPanel.add(this.labelCodigo, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textCodigo, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		nuevoProductoPanel.add(this.labelNombre, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textNombre, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelstockTotal, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textstockTotal, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelstockMinimo, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textstockMinimo, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelSegmentacion, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textSegmentacion, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelPeso, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textPeso, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labeltipoEstiba, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.texttipoEstiba, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelvolumen, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textvolumen, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelprecio, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textprecio, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelfechaVencimiento, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textfechaVencimiento, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelfechaElaborado, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textfechaElaborado, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoProductoPanel.add(this.labelLote, constraints);

		constraints.gridx = 1;
		nuevoProductoPanel.add(this.textLote, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 3;
		constraints.anchor = GridBagConstraints.CENTER;
		nuevoProductoPanel.add(buttonIngresar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 4;
		constraints.anchor = GridBagConstraints.CENTER;
		nuevoProductoPanel.add(buttonCancelar, constraints);

		nuevoProductoPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del Producto"));

		frame.add(nuevoProductoPanel);

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
		String fieldNombre = this.textNombre.getText();
		String fieldstockTotal = this.textstockTotal.getText();
		String fieldstockMinimo = this.textstockMinimo.getText();
		String fieldSegmentacion = this.textSegmentacion.getText();
		String fieldPeso = this.textPeso.getText();
		String fieldtipoEstiba = this.texttipoEstiba.getText();
		String fieldvolumen = this.textvolumen.getText();
		String fieldprecio = this.textprecio.getText();
		String fieldfechaVencimiento = this.textfechaVencimiento.getText();
		String fieldfechaElaborado = this.textfechaElaborado.getText();
		String fieldLote = this.textLote.getText();

		// Si alguno es vacío, mostramos una ventana de mensaje
		if (fieldCodigo.equals("") || fieldNombre.equals("") || fieldstockTotal.equals("") || fieldstockMinimo.equals("") || fieldSegmentacion.equals("") || fieldPeso.equals("") || fieldtipoEstiba.equals("") || fieldvolumen.equals("") || fieldprecio.equals("") || fieldfechaVencimiento.equals("") || fieldfechaElaborado.equals("") || fieldLote.equals("")) {
			JOptionPane.showMessageDialog(frame, "Debe completar todos los datos solicitados.", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);

			return;
		}

		// Valiamos ahora, que no exista un Producto con dicha Codigo
		boolean existe = ControladorProductos.existeProducto(fieldCodigo);

		if (existe) {
			JOptionPane.showMessageDialog(frame, "El Producto con dicho  codigo ya se ecuentra registrado.",
					"Producto Existente!", JOptionPane.WARNING_MESSAGE);

			return;
		}
		int peso = Integer.valueOf(fieldPeso);
		boolean tipoEstiba = Boolean.valueOf(fieldtipoEstiba);
		double volumen = Double.valueOf(fieldvolumen);
		long precio = Long.valueOf(fieldprecio);
		Date fechaVencimiento = Date.valueOf(fieldfechaVencimiento);
		Date fechaElaborado = Date.valueOf(fieldfechaElaborado);
		

		// Si estamos aquí,..quiere decir que no hay errores. Almacenamos el
		// Producto y volvemos al menu
		boolean almacenado = ControladorProductos.ingresarNuevoProducto(fieldCodigo, fieldNombre, fieldstockTotal, fieldstockMinimo, fieldSegmentacion, peso, tipoEstiba, volumen, precio, fechaVencimiento, fechaElaborado, fieldLote);

		if (almacenado) {
			JOptionPane.showMessageDialog(frame, "El Producto ha sido registrado con éxito.",
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
