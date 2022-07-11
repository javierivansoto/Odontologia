package Proyecto;
import java.util.Date;
public class Tratamiento {
	private int id;
	private Paciente paciente;
	private String mediconombre;
	private int mes;
	private int dia;
	private String sector;
	private String descripcion;
	//constructor
	public Tratamiento() {
		
	}

	public Tratamiento(int id, Paciente paciente, String mediconombre, int mes, int dia, String sector,
			String descripcion) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.mediconombre = mediconombre;
		this.mes = mes;
		this.dia = dia;
		this.sector = sector;
		this.descripcion = descripcion;
	}
	
	//get y set
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getMediconombre() {
		return mediconombre;
	}

	public void setMediconombre(String mediconombre) {
		this.mediconombre = mediconombre;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Tratamiento [id=" + id + ", paciente=" + paciente + ", mediconombre=" + mediconombre + ", mes=" + mes
				+ ", dia=" + dia + ", sector=" + sector + ", descripcion=" + descripcion + "]";
	}

		
}
