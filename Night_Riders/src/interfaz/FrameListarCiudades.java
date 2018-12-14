package interfaz;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controladores.ControladorCiudades;
import Objetos.Ciudades;

public class FrameListarCiudades implements ActionListener {

	private Frame frame;
	
	private JTable tablaCiudades;
	
	private JButton botonFiltrar;
	private JButton botonLimpiar;
	
	public FrameListarCiudades(JFrame framePadre) {
		JButton botonFiltrar = new JButton("Filtrar");
		botonLimpiar.addActionListener(this);
		
		JButton botonLimpiar = new JButton("Limpiar Filtro");
		botonLimpiar.addActionListener(this);
		
		this.botonFiltrar = botonFiltrar;
		this.botonLimpiar = botonLimpiar;
		
		this.initalizeFrame(framePadre);
	}
	
	private void initalizeFrame(JFrame framePadre) {
		
		JFrame frame = new JFrame("Listado de Ciudades");
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel ListarCiudadesPanel = new JPanel (new GridBagLayout());
		ListarCiudadesPanel.setSize (600,600);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10,2,2,10);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		ListarCiudadesPanel.add(this.botonFiltrar, constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 0;
		ListarCiudadesPanel.add(this.botonLimpiar, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		this.tablaCiudades = this.cargarTablaCiudades();
		
		ListarCiudadesPanel.add(new JScrollPane(this.tablaCiudades), constraints);
		
		ListarCiudadesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lista de Ciudades"));
		
		frame.add(ListarCiudadesPanel);
		
		this.botonFiltrar.addActionListener(this);
		this.botonLimpiar.addActionListener(this);
		
		frame.setVisible(true);
		
		this.frame = frame;
	}
	
	private JTable cargarTablaCiudades() {
		ArrayList<Ciudades> ciudades = ControladorCiudades.obtenerTodosCiudades();
		
		String[] nombreColumnas = { "Codigo","Nombre"};
		
		Object[][] datos = new Object[ciudades.size()][3];
		
		int fila = 0;
		
		for (Ciudades p: ciudades) {
			datos[fila][0] = p.getCodigo();
			datos[fila][1] = p.getNombre();
			fila++;
		}
		DefaultTableModel model = new DefaultTableModel (datos, nombreColumnas) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}
		};
		
		JTable table = new JTable(model);
		table.setAutoscrolls(true);
		table.setCellSelectionEnabled(false);
		table.setSize(600,600);
		
		this.tablaCiudades = table;
		
		return table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.botonFiltrar) {
			this.accionFiltrar();
		}else {
			this.accionLimpiarFiltro();
		}
	}
	
	public void accionLimpiarFiltro() {
		this.tablaCiudades.setRowSorter(null);
	}
	
	private void accionFiltrar() {
		TableRowSorter<TableModel> filtro = new TableRowSorter<>(this.tablaCiudades.getModel());
		
	}

}
