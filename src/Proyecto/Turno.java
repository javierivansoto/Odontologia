package Proyecto;

public class Turno {
	private int id;
	private Paciente paciente;
	private String sector;
	private int numeroorden;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int estadoturno;
	

	//constructor
	public Turno() {
		
	}

	public Turno(int id, Paciente paciente, String sector, int numeroorden, int mes, int dia, int hora, int minuto,
			int estadoturno) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.sector = sector;
		this.numeroorden = numeroorden;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.estadoturno = estadoturno;
	}



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

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getNumeroorden() {
		return numeroorden;
	}

	public void setNumeroorden(int numeroorden) {
		this.numeroorden = numeroorden;
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

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getEstadoturno() {
		return estadoturno;
	}

	public void setEstadoturno(int estadoturno) {
		this.estadoturno = estadoturno;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", paciente=" + paciente + ", sector=" + sector + ", numeroorden=" + numeroorden
				+ ", mes=" + mes + ", dia=" + dia + ", hora=" + hora + ", minuto=" + minuto + ", estadoturno="
				+ estadoturno + "]";
	}

	


}
