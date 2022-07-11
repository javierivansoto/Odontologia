package Proyecto;
import java.util.List;
public class Paciente {
	private int id;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private int dni;
	private int edad;
	private List<Tratamiento> tratamientos;
	//constructor
	public Paciente() {
		
	}
	public Paciente(int id, String nombre, String apellido, String domicilio, int telefono, int dni, int edad,
			List<Tratamiento> tratamientos) {
		super(); 
		this.id= id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.dni = dni;
		this.edad = edad;
		this.tratamientos = tratamientos;
	}
	
	//get y set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public List<Tratamiento> getTratamientos() {
		return tratamientos;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	//MOSTRAR TRATAMIENTOS DE UN PACIENTE
	public void mostrarTratamientos() {
		for (Tratamiento t : tratamientos) {
            t.toString();
        }
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ ", telefono=" + telefono + ", dni=" + dni + ", edad=" + edad + ", tratamientos=" + tratamientos + "]";
	}
	
	
	
}
