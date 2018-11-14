package Objetos;
import java.util.Date;

public class Productos {
	private String Codigo;
	private String Nombre;
	private String stockTotal;
	private String stockMinimo;
	private String Segmentacion;
	private int Peso;
	private boolean tipoEstiba;
	private double volumen;
	private long precio;
	private Date fechaVencimiento;
	private Date fechaElaborado;
	private String Lote;
	public Productos(String codigo, String nombre, String stockTotal, String stockMinimo, String segmentacion, int peso,
			boolean tipoEstiba, double volumen, long precio, Date fechaVencimiento, Date fechaElaborado, String lote) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		this.stockTotal = stockTotal;
		this.stockMinimo = stockMinimo;
		Segmentacion = segmentacion;
		Peso = peso;
		this.tipoEstiba = tipoEstiba;
		this.volumen = volumen;
		this.precio = precio;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaElaborado = fechaElaborado;
		Lote = lote;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getStockTotal() {
		return stockTotal;
	}
	public void setStockTotal(String stockTotal) {
		this.stockTotal = stockTotal;
	}
	public String getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(String stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public String getSegmentacion() {
		return Segmentacion;
	}
	public void setSegmentacion(String segmentacion) {
		Segmentacion = segmentacion;
	}
	public int getPeso() {
		return Peso;
	}
	public void setPeso(int peso) {
		Peso = peso;
	}
	public boolean isTipoEstiba() {
		return tipoEstiba;
	}
	public void setTipoEstiba(boolean tipoEstiba) {
		this.tipoEstiba = tipoEstiba;
	}
	public double getVolumen() {
		return volumen;
	}
	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaElaborado() {
		return fechaElaborado;
	}
	public void setFechaElaborado(Date fechaElaborado) {
		this.fechaElaborado = fechaElaborado;
	}
	public String getLote() {
		return Lote;
	}
	public void setLote(String lote) {
		Lote = lote;
	}
	@Override
	public String toString(){
		return this.Codigo + "," + this.Nombre + "," + this.stockTotal + "," + this.stockMinimo + "," + this.Segmentacion + "," + this.Peso + "," + this.tipoEstiba + "," + this.volumen + "," + this.precio + "," + this.fechaVencimiento + "," + this.fechaElaborado + "," + this.Lote;
	}
	
}
