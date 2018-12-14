package interfaz;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import controladores.ControladoresPedidoProducto;
import Objetos.PedidoProducto;

public class FrameListarPedidos implements ActionListener {
	
	private Frame frame;
	/** Tabla */
	private JTable tablaPedidos;

	/** Date Picker */
	private JDatePickerImpl datePicker;

	/** Labels */
	private JLabel labelFecha;

	/** Buttons */
	private JButton botonFiltrar;
	private JButton botonLimpiar;

	public FrameListarPedidos(JFrame framePadre) {

		this.labelFecha = new JLabel("Fecha:");

		JButton botonFiltrar = new JButton("Filtrar");
		botonFiltrar.addActionListener(this);

		JButton botonLimpiar = new JButton("Limpiar Filtro");
		botonLimpiar.addActionListener(this);

		this.botonFiltrar = botonFiltrar;
		this.botonLimpiar = botonLimpiar;

		this.initalizeFrame(framePadre);
	}

	private void initalizeFrame(JFrame framePadre) {

		JFrame frame = new JFrame("Listado de Pedidos");
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel listarPedidosPanel = new JPanel(new GridBagLayout());
		listarPedidosPanel.setSize(600, 600);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 2, 2, 10);

		constraints.gridx = 0;
		constraints.gridy = 0;
		listarPedidosPanel.add(this.labelFecha, constraints);

		constraints.gridx = 1;
		this.datePicker = this.crearDatePicker();
		listarPedidosPanel.add(this.datePicker, constraints);

		constraints.gridx = 2;
		constraints.gridy = 0;
		listarPedidosPanel.add(this.botonFiltrar, constraints);

		constraints.gridx = 3;
		constraints.gridy = 0;
		listarPedidosPanel.add(this.botonLimpiar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		this.tablaPedidos = this.cargarTablaPedidos();
//		JScrollPane pane1 = new JScrollPane(this.tablaPedidos);
//		Dimension dim1 = this.tablaPedidos.getPreferredSize();
//		pane1.setPreferredSize(
//				new Dimension(600, 600));
		listarPedidosPanel.add(new JScrollPane(this.tablaPedidos), constraints);

		listarPedidosPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lista de Pedidos"));

		frame.add(listarPedidosPanel);

		this.botonFiltrar.addActionListener(this);
		this.botonLimpiar.addActionListener(this);

		// frame.pack();
		frame.setVisible(true);

		this.frame = frame;

	}

	private JTable cargarTablaPedidos() {

		ArrayList<PedidoProducto> pedidoproductos = ControladoresPedidoProducto.obtenerTodosPedidoProductos();

		String[] nombreColumnas = { "Codigo Pro", "Fecha", "FechaEstimadaRecibido","EstadoPedidoProducto","Cantidad","Fecha Estimada Entrega"};
		/*
		 * El tamaño de la tabla es, 4 columnas (cantidad de datos a mostrar) y
		 * la cantidad de filas depende de la cantida de Pedidos
		 */
		Object[][] datos = new Object[pedidoproductos.size()][6];

		/* Cargamos la matriz con todos los datos */
		int fila = 0;

		SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");

		for (PedidoProducto c : pedidoproductos) {

			datos[fila][0] = c.getProductos().getCodigo();
			datos[fila][1] = formateadorFecha.format(c.getFecha());
			datos[fila][2] = formateadorFecha.format(c.getFechaEstimadaRecibido());
			datos[fila][3] = c.getEstadoPedidoProducto();
			datos[fila][4] = c.getCantidad();
			datos[fila][5] = formateadorFecha.format(c.getFechaEstimadaEntrega());
			fila++;

		}

		/*
		 * Este codigo indica que las celdas no son editables y que son todas
		 * del tipos String
		 */
		DefaultTableModel model = new DefaultTableModel(datos, nombreColumnas) {

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
		table.setSize(600, 600);

		this.tablaPedidos = table;

		return table;

	}

	private JDatePickerImpl crearDatePicker() {

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		return datePicker;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.botonFiltrar) {
			this.accionFiltrar();
		} else {
			this.accionLimpiarFiltro();
		}

	}

	private void accionLimpiarFiltro() {

		this.tablaPedidos.setRowSorter(null);
		this.datePicker.getModel().setValue(null);
	}

	private void accionFiltrar() {

		TableRowSorter<TableModel> filtro = new TableRowSorter<>(this.tablaPedidos.getModel());

		Date fecha = (Date) this.datePicker.getModel().getValue();

		SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");

		if (fecha != null) {

			String fechaString = formateadorFecha.format(fecha);

			filtro.setRowFilter(RowFilter.regexFilter(fechaString, 0));

			this.tablaPedidos.setRowSorter(filtro);

		}
	}


}
