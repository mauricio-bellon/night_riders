package interfaz;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controladores.ControladorProductos;
import Objetos.Productos;

public class FrameListarProductos implements ActionListener{
	
	private Frame frame;
	
	private JTable tablaProductos;
	
	private JButton botonFiltrar;
	private JButton botonLimpiar;
	
	public FrameListarProductos(JFrame framePadre) {
		JButton botonFiltrar = new JButton("Filtrar");
		botonLimpiar.addActionListener(this);
		
		JButton botonLimpiar = new JButton("Limpiar Filtro");
		botonLimpiar.addActionListener(this);
		
		this.botonFiltrar = botonFiltrar;
		this.botonLimpiar = botonLimpiar;
		
		this.initalizeFrame(framePadre);
	}
	
	private void initalizeFrame(JFrame framePadre) {
		
		JFrame frame = new JFrame("Listado de Productos");
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel listarProductosPanel = new JPanel (new GridBagLayout());
		listarProductosPanel.setSize (600,600);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10,2,2,10);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		listarProductosPanel.add(this.botonFiltrar, constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 0;
		listarProductosPanel.add(this.botonLimpiar, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		this.tablaProductos = this.cargarTablaProductos();
		
		listarProductosPanel.add(new JScrollPane(this.tablaProductos), constraints);
		
		listarProductosPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lista de Productos"));
		
		frame.add(listarProductosPanel);
		
		this.botonFiltrar.addActionListener(this);
		this.botonLimpiar.addActionListener(this);
		
		frame.setVisible(true);
		
		this.frame = frame;
	}
	
	private JTable cargarTablaProductos() {
		ArrayList<Productos> productos = ControladorProductos.obtenerTodosProductos();
		
		String[] nombreColumnas = { "Codigo","Nombre", "Stock Total", "Stock Minimo" , "Segmentacion", "Peso", "Estiba","Volumen","Precio","Fecha Vencimiento","Fecha Elaboracion","Lote"};
		
		Object[][] datos = new Object[productos.size()][12];
		
		int fila = 0;
		
		for (Productos p: productos) {
			datos[fila][0] = p.getCodigo();
			datos[fila][1] = p.getNombre();
			datos[fila][2] = p.getStockTotal();
			datos[fila][3] = p.getStockMinimo();
			datos[fila][4] = p.getSegmentacion();
			datos[fila][5] = p.getPeso();
			datos[fila][6] = p.isTipoEstiba();
			datos[fila][7] = p.getVolumen();
			datos[fila][8] = p.getPrecio();
			datos[fila][9] = p.getFechaVencimiento();
			datos[fila][10] = p.getFechaElaborado();
			datos[fila][11] = p.getLote();
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
		
		this.tablaProductos = table;
		
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
		this.tablaProductos.setRowSorter(null);
	}
	
	private void accionFiltrar() {
		TableRowSorter<TableModel> filtro = new TableRowSorter<>(this.tablaProductos.getModel());
		
	}

}
