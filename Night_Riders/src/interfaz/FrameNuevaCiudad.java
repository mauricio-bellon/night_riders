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

import controladores.ControladorCiudades;

public class FrameNuevaCiudad implements ActionListener{
	/** Frame de la ventana */
	private JFrame frame;

	/** Atributos de labels */
	private JLabel labelCodigo;
	private JLabel labelNombre;
	

	/** Atributos de TexField */
	private JTextField textCodigo;
	private JTextField textNombre;

	/** Atributos de Botones */
	private JButton buttonIngresar;
	private JButton buttonCancelar;

	public FrameNuevaCiudad (JFrame framePadre) {

		this.labelNombre = new JLabel("Nombre:");
		this.labelCodigo = new JLabel("Codigo:");
		
		this.textCodigo = new JTextField(15);
		this.textNombre = new JTextField(15);
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

		JPanel NuevaCiudadPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		constraints.gridx = 0;
		constraints.gridy = 0;
		NuevaCiudadPanel.add(this.labelCodigo, constraints);

		constraints.gridx = 1;
		NuevaCiudadPanel.add(this.textCodigo, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		NuevaCiudadPanel.add(this.labelNombre, constraints);

		constraints.gridx = 1;
		NuevaCiudadPanel.add(this.textNombre, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 3;
		constraints.anchor = GridBagConstraints.CENTER;
		NuevaCiudadPanel.add(buttonIngresar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 4;
		constraints.anchor = GridBagConstraints.CENTER;
		NuevaCiudadPanel.add(buttonCancelar, constraints);

		NuevaCiudadPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la Ciudad"));

		frame.add(NuevaCiudadPanel);

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

		// Si alguno es vacío, mostramos una ventana de mensaje
		if (fieldCodigo.equals("") || fieldNombre.equals("")) {
			JOptionPane.showMessageDialog(frame, "Debe completar todos los datos solicitados.", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);

			return;
		}

		// Valiamos ahora, que no exista un Ciudad con dicha Codigo
		boolean existe = ControladorCiudades.existeCiudades(fieldCodigo);

		if (existe) {
			JOptionPane.showMessageDialog(frame, "La Ciudad con dicho  codigo ya se ecuentra registrado.",
					"Ciudad Existente!", JOptionPane.WARNING_MESSAGE);

			return;
		}
		
		// Si estamos aquí,..quiere decir que no hay errores. Almacenamos el
		// Ciudad y volvemos al menu
		boolean almacenado = ControladorCiudades.ingresarNuevaCiudad(fieldCodigo, fieldNombre);

		if (almacenado) {
			JOptionPane.showMessageDialog(frame, "La Ciudad ha sido registrado con éxito.",
					"Ciudad Registrado!", JOptionPane.INFORMATION_MESSAGE);
			
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
