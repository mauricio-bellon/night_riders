package Objetos;
import java.util.Date;
import Objetos.Productos;
public class PedidoProducto {
	private Productos productos;
	private Date Fecha;
	private Date FechaEstimadaRecibido;
	private double EstadoPedidoProducto;
	private long Cantidad;
	private Date FechaEstimadaEntrega;
	public PedidoProducto(Productos productos, Date fecha, Date fechaEstimadaRecibido, double estadoPedidoProducto,
			long cantidad, Date fechaEstimadaEntrega) {
		super();
		this.productos = productos;
		Fecha = fecha;
		FechaEstimadaRecibido = fechaEstimadaRecibido;
		EstadoPedidoProducto = estadoPedidoProducto;
		Cantidad = cantidad;
		FechaEstimadaEntrega = fechaEstimadaEntrega;
	}
	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Date getFechaEstimadaRecibido() {
		return FechaEstimadaRecibido;
	}

	public void setFechaEstimadaRecibido(Date fechaEstimadaRecibido) {
		FechaEstimadaRecibido = fechaEstimadaRecibido;
	}

	public double getEstadoPedidoProducto() {
		return EstadoPedidoProducto;
	}

	public void setEstadoPedidoProducto(double estadoPedidoProducto) {
		EstadoPedidoProducto = estadoPedidoProducto;
	}

	public long getCantidad() {
		return Cantidad;
	}

	public void setCantidad(long cantidad) {
		Cantidad = cantidad;
	}

	public Date getFechaEstimadaEntrega() {
		return FechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		FechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	@Override
	public String toString(){
		return this.productos.getCodigo() + "," + this.Fecha + "," + this.FechaEstimadaRecibido + "," + this.EstadoPedidoProducto + "," + this.Cantidad + "," + this.FechaEstimadaEntrega;
	}
}
