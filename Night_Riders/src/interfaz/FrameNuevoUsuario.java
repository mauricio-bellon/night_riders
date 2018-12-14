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

import controladores.ControladorUsuario;

public class FrameNuevoUsuario implements ActionListener {
	/** Frame de la ventana */
	private JFrame frame;

	/** Atributos de labels */
	private JLabel labelCodigo;
	private JLabel labelPerfCod;
	private JLabel labelNombre;
	private JLabel labelapellido;
	private JLabel labelnombreAcceso;
	private JLabel labelcorreo;
	private JLabel labelcontraseña;
	

	/** Atributos de TexField */
	private JTextField textCodigo;
	private JTextField textPerfCod;
	private JTextField textNombre;
	private JTextField textapellido;
	private JTextField textnombreAcceso;
	private JTextField textcorreo;
	private JTextField textcontraseña;

	/** Atributos de Botones */
	private JButton buttonIngresar;
	private JButton buttonCancelar;

	public FrameNuevoUsuario (JFrame framePadre) {

		this.labelPerfCod = new JLabel("PerfCod:");
		this.labelCodigo = new JLabel("Codigo:");
		this.labelNombre = new JLabel("Nombre:");
		this.labelapellido = new JLabel("apellido:");
		this.labelnombreAcceso = new JLabel("nombreAcceso:");
		this.labelcorreo = new JLabel("correo:");
		this.labelcorreo = new JLabel("correo:");
		this.labelcontraseña = new JLabel("contraseña:");
		
		this.textCodigo = new JTextField(15);
		this.textPerfCod = new JTextField(15);
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

		JPanel NuevoUsuarioPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		constraints.gridx = 0;
		constraints.gridy = 0;
		NuevoUsuarioPanel.add(this.labelCodigo, constraints);

		constraints.gridx = 1;
		NuevoUsuarioPanel.add(this.textCodigo, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		NuevoUsuarioPanel.add(this.labelPerfCod, constraints);

		constraints.gridx = 1;
		NuevoUsuarioPanel.add(this.textPerfCod, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		NuevoUsuarioPanel.add(this.labelNombre, constraints);

		constraints.gridx = 1;
		NuevoUsuarioPanel.add(this.textNombre, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		NuevoUsuarioPanel.add(this.labelapellido, constraints);

		constraints.gridx = 1;
		NuevoUsuarioPanel.add(this.textapellido, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		NuevoUsuarioPanel.add(this.labelnombreAcceso, constraints);

		constraints.gridx = 1;
		NuevoUsuarioPanel.add(this.textnombreAcceso, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		NuevoUsuarioPanel.add(this.labelcorreo, constraints);

		constraints.gridx = 1;
		NuevoUsuarioPanel.add(this.textcorreo, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		NuevoUsuarioPanel.add(this.labelcontraseña, constraints);

		constraints.gridx = 1;
		NuevoUsuarioPanel.add(this.textcontraseña, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 3;
		constraints.anchor = GridBagConstraints.CENTER;
		NuevoUsuarioPanel.add(buttonIngresar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 4;
		constraints.anchor = GridBagConstraints.CENTER;
		NuevoUsuarioPanel.add(buttonCancelar, constraints);

		NuevoUsuarioPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del Nuevo Usuario"));

		frame.add(NuevoUsuarioPanel);

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
		String fieldPerfCod = this.textPerfCod.getText();
		String fieldNombre = this.textNombre.getText();
		String fieldapellido = this.textapellido.getText();
		String fieldnombreAcceso = this.textnombreAcceso.getText();
		String fieldcorreo = this.textcorreo.getText();
		String fieldcontraseña = this.textcontraseña.getText();

		// Si alguno es vacío, mostramos una ventana de mensaje
		if (fieldCodigo.equals("") || fieldPerfCod.equals("") || fieldNombre.equals("") || fieldapellido.equals("") || fieldnombreAcceso.equals("") || fieldcorreo.equals("") || fieldcontraseña.equals("")) {
			JOptionPane.showMessageDialog(frame, "Debe completar todos los datos solicitados.", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);

			return;
		}

		// Valiamos ahora, que no exista un Ciudad con dicha Codigo
		boolean existe = ControladorUsuario.existeUsuario(fieldCodigo);

		if (existe) {
			JOptionPane.showMessageDialog(frame, "La Ciudad con dicho  codigo ya se ecuentra registrado.",
					"Ciudad Existente!", JOptionPane.WARNING_MESSAGE);

			return;
		}
		
		// Si estamos aquí,..quiere decir que no hay errores. Almacenamos el
		// Ciudad y volvemos al menu
		boolean almacenado = ControladorUsuario.ingresarNuevoUsuario(fieldCodigo, fieldPerfCod, fieldNombre, fieldapellido, fieldnombreAcceso, fieldcorreo, fieldcontraseña);

		if (almacenado) {
			JOptionPane.showMessageDialog(frame, "El usuario ha sido registrado con éxito.",
					"Usuario Registrado!", JOptionPane.INFORMATION_MESSAGE);
			
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
