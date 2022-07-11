package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionBD {
	
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/odontologia";
	public static String USER = "root";
	public static String PASS ="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		
		
		try {
			//2-registrar el driver
			Class.forName(JDBC_DRIVER);
			//3-abrir conexion
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//4 ejecutar consulta sql
			stmt = conn.createStatement();
			String sql;
			//5-probar consultas
			
			
			
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("algun error al conectar");
		}
		System.out.println("****termino****");
	}
	
	//traer toda la tabla entera
		public static String findAll() {
			/*
			 sql = findAll();
				ResultSet rs = stmt.executeQuery(sql);
				//5- extraer datos
				while (rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					System.out.print("id:"+ id);
					System.out.print(" ,nombre:"+ nombre);
					System.out.println();
				}
				rs.close();
			 */
			
			return "SELECT * from especialidades";
		}
		
		public static String findAllXNombre(String nombre) {
			/*
			 sql = findAllXNombre("Pedro");
				ResultSet rs = stmt.executeQuery(sql);
				//5- extraer datos
				while (rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					String domicilio = rs.getString("domicilio");
					int telefono = rs.getInt("telefono");
					int dni = rs.getInt("dni");
					int edad = rs.getInt("edad");
					System.out.print("id:"+ id);
					System.out.print(" ,nombre:"+ nombre);
					System.out.print(" ,apellido:"+ apellido);
					System.out.print(" ,domicilio:"+ domicilio);
					System.out.print(" ,telefono:"+ telefono);
					System.out.print(" ,dni:"+ dni);
					System.out.print(" ,edad:"+ edad);
					System.out.println();
				}
				rs.close();
			 */
			
			return "SELECT * from especialidades";
		}
		//Registra un nuevo paciente
		public static String insert(String nombre, String apellido, String domicilio, int telefono, int dni, int edad) { //insertar en tabla sin enviar el id ya que es auto incremental
			/*
			sql = insert("Emanuel", "Lopez", "B° Santa Lucia", 4254316, 32654237);//insertar
			stmt.executeUpdate(sql);
			*/
			return "INSERT INTO pacientes (id, nombre, apellido, domicilio, telefono, dni, edad) VALUES (NULL, '"+ nombre +"','"+ apellido +"','"+ domicilio +"',"+ telefono +","+ dni +","+ edad +");";
		}
		//Crear Turno
		public static String insertTurno(int id_paciente, String mediconombre, int numeroorden, int mes, int dia, int hora, int minuto, String estadoturno) { //insertar en tabla sin enviar el id ya que es auto incremental
			/*
			sql = insertTurno(1, "Luis Romero", 1, 7, 7, 10, 30,"ocupado");//insertar
			stmt.executeUpdate(sql);
			*/
			return "INSERT INTO turnos (id_paciente, mediconombre, numeroorden, mes, dia, hora, minuto, estadoturno) VALUES ("+ id_paciente +", '"+ mediconombre +"',"+ numeroorden +","+ mes +","+ dia +","+ hora +","+ minuto +",'"+ estadoturno +"', );";
		}
		
		public static  String get(int id) {
			/*
			 sql= get(1);
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt("id");
					String nombre= rs.getString("nombre");
					String apellido= rs.getString("apellido");
					int matricula = rs.getInt("matricula");
					String especialidad = rs.getString("especialidad");
					System.out.print("id:"+id);
					System.out.print(", nombre: "+nombre);
					System.out.print(", apellido: "+apellido);
					System.out.print(", matricula: "+matricula);
					System.out.print(", especialidad: "+especialidad);
					System.out.println();
				}
				rs.close();
			 */
			return "SELECT * from medicos where id= " +id;
		}
	
}
