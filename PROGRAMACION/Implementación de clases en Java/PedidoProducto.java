import java.util.Date;

public class PedidoProducto {
	private long Codigo;
	private Date Fecha;
	private Date FechaEstimadaRecibido;
	private double EstadoPedidoProducto;
	private long Cantidad;
	private Date FechaEstimadaEntrega;
	public PedidoProducto(long codigo, Date fecha, Date fechaEstimadaRecibido, double estadoPedidoProducto,
			long cantidad, Date fechaEstimadaEntrega) {
		super();
		Codigo = codigo;
		Fecha = fecha;
		FechaEstimadaRecibido = fechaEstimadaRecibido;
		EstadoPedidoProducto = estadoPedidoProducto;
		Cantidad = cantidad;
		FechaEstimadaEntrega = fechaEstimadaEntrega;
	}
	public long getCodigo() {
		return Codigo;
	}
	public void setCodigo(long codigo) {
		Codigo = codigo;
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

}
