package night_riders;

public class Usuario {

	private String codigo;
	private String nombre;
	private String apellido;
	private String nombreAcceso;
	private String correo;
	private String contraseña;
	
	public Usuario(String codigo, String nombre, String apellido, String nombreAcceso, String correo,
			String contraseña) {
		super();
		this.codigo = codigo;
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

}
