package Objetos;
import Objetos.Perfiles;

public class Usuario {
	private String codigo;
	private Perfiles perfiles;
	private String nombre;
	private String apellido;
	private String nombreAcceso;
	private String correo;
	private String contraseña;
	public Usuario(String codigo, Perfiles perfiles, String nombre, String apellido, String nombreAcceso, String correo,
			String contraseña) {
		super();
		this.codigo = codigo;
		this.perfiles = perfiles;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreAcceso = nombreAcceso;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Perfiles getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(Perfiles perfiles) {
		this.perfiles = perfiles;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreAcceso() {
		return nombreAcceso;
	}
	public void setNombreAcceso(String nombreAcceso) {
		this.nombreAcceso = nombreAcceso;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public String toString() {
		return this.codigo + "," + this.perfiles.getPerf_Codigo() + "," + this.nombre + "," + this.apellido + "," + this.nombreAcceso + "," + this.correo + "," + this.contraseña;
	}
	
}
