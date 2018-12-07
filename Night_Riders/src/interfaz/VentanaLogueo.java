package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VentanaLogueo {

	private JFrame frmLogueo;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBounds(148, 31, 160, 20);
		frmLogueo.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblContrasea.setBounds(30, 62, 100, 20);
		frmLogueo.getContentPane().add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 62, 160, 20);
		frmLogueo.getContentPane().add(textField_1);
		
		JButton btnIngresar = new JButton("ingresar");
		btnIngresar.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnIngresar.setBounds(28, 93, 280, 23);
		frmLogueo.getContentPane().add(btnIngresar);
	}
}
