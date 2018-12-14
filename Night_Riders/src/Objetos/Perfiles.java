package Objetos;

public class Perfiles {
	private int Perf_Codigo;
	private String Perf_Nombre;
	public Perfiles(int perf_Codigo, String perf_Nombre) {
		super();
		Perf_Codigo = perf_Codigo;
		Perf_Nombre = perf_Nombre;
	}
	public int getPerf_Codigo() {
		return Perf_Codigo;
	}
	public void setPerf_Codigo(int perf_Codigo) {
		Perf_Codigo = perf_Codigo;
	}
	public String getPerf_Nombre() {
		return Perf_Nombre;
	}
	public void setPerf_Nombre(String perf_Nombre) {
		Perf_Nombre = perf_Nombre;
	}
	@Override
	public String toString(){
		return this.Perf_Codigo + "," + this.Perf_Nombre;
	}

}
