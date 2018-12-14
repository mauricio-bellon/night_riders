package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controladores.ControladorUsuario;

import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaLogueo {

	private JFrame frmLogueo;
	private JTextField campo_usuario;
	private JTextField campo_contra;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogueo window = new VentanaLogueo();
					window.frmLogueo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogueo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogueo = new JFrame();
		frmLogueo.setTitle("logueo");
		frmLogueo.setResizable(false);
		frmLogueo.setBounds(100, 100, 340, 180);
		frmLogueo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogueo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("usuario:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblNewLabel.setBounds(30, 31, 101, 20);
		frmLogueo.getContentPane().add(lblNewLabel);
		
		campo_usuario = new JTextField();
		campo_usuario.setBounds(148, 31, 160, 20);
		frmLogueo.getContentPane().add(campo_usuario);
		campo_usuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblContrasea.setBounds(30, 62, 100, 20);
		frmLogueo.getContentPane().add(lblContrasea);
		
		campo_contra = new JTextField();
		campo_contra.setColumns(10);
		campo_contra.setBounds(148, 62, 160, 20);
		frmLogueo.getContentPane().add(campo_contra);
		
		JButton btnIngresar = new JButton("ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			//ACA CREO LA FUNCIÓN QUE SE DISPARA CUANDO SE PRESIONA EL BOTÓN DE LOGUEAR
			public void actionPerformed(ActionEvent arg0) {
				
				
				/*
				// OBTENER DATOS INGRESADO POR EL USUARIO
				String user = campo_usuario.getText();
				String pass = campo_contra.getText();
					
				// COMPOBAR QUE EL USUARIO EXISTA EN LA BASE DE DATOS
				if (ControladorUsuario.existeUsuario(user) == true) {
						
					// POP UP DE PRUEBA (no funciona no se por que)
					JOptionPane.showMessageDialog(null,"el usuario está registrado!");
					// aquí habría que comparar que la contraseña ingresada coincida con la
					// contraseña correspondiente al usuario ingresado en la bd.
						
				} else {
						
					// POP UP DE PRUEBA
					JOptionPane.showMessageDialog(null,"usuario inexistente!");
						
				}*/
						
			}
		});
		
		btnIngresar.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnIngresar.setBounds(28, 93, 280, 23);
		frmLogueo.getContentPane().add(btnIngresar);
	}
}
