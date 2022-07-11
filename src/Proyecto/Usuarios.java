package Proyecto;

public class Usuarios {
	private String nombreusuario;
	private String password;
	private int rol;
	
	public Usuarios() {
		
	}

	public Usuarios(String nombreusuario, String password, int rol) {
		super();
		this.nombreusuario = nombreusuario;
		this.password = password;
		this.rol = rol;
	}


	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuarios [nombreusuario=" + nombreusuario + ", password=" + password + ", rol=" + rol + "]";
	}

		
	
}
