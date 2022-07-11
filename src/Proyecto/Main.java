package Proyecto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
public class Main {
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
			//System.out.println("conectado");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//4 ejecutar consulta sql
			//System.out.println("****Creando Statement****");
			stmt = conn.createStatement();
			String sql;
			//5-probar consultas
		
			
			
		//creo un recepcionista y lo cargo en la tabla de recepcionista
			/*
			Recepcionista r1 = new Recepcionista(1, "admin", "admin",null,null);
			//cargo en la tabla recepcionista
			
			String nombre="javier";
			String apellido="1234";
			sql = insertRecepcionista(nombre, apellido);//insertar
			stmt.executeUpdate(sql);
		*/	
			int numeroorden=0;
			int opc;
			do {
				Scanner entradaEscaner = new Scanner(System.in);
	            System.out.println("*.- INGRESE UNA OPCION-*");
	            System.out.println("1.- REGISTRARSE-Paciente");
	            System.out.println("2.- INICIAR SESION");
	            System.out.println("3.- SALIR");
	            System.out.println("");
	            opc = entradaEscaner.nextInt();


	            switch (opc) {
	                case 1:
	                	Scanner entrada = new Scanner(System.in);
	                    Paciente p1= new Paciente();
	                    String nombre, apellido,nombreusuario, password;
	                    int telefono,edad;
	                    int id=0;
	                    String rolp="paciente";
	                  //datos para insertar fila en usuario
	                    System.out.println ("Ingresar Nombre de usuario");
	                    nombreusuario = entrada.nextLine ();
	                    
	                    
	                    System.out.println ("Ingresar password");
	                    password = entrada.nextLine ();
	                 
	                    sql = insertUsuario(nombreusuario, password, rolp);//insertar
	            		stmt.executeUpdate(sql);
	                    
	            		//buscar el id del usuario cargado
	            		sql=findAllXNombreXPassword(nombreusuario,password);
	            		ResultSet res = stmt.executeQuery(sql);
	            		//extraer datos
	            		while(res.next()) {
	            			id = res.getInt("id");
	            		}
	            		res.close();
	            		entradaEscaner.nextLine ();
	                    //datos para insertar fila en paciente
	                    System.out.println ("Ingresar Nombre");
	                    nombre = entradaEscaner.nextLine ();
	                    p1.setNombre(nombre);//---ver clase
	                    
	                    
	                    System.out.println ("Ingresar Apellido");
	                    apellido = entradaEscaner.nextLine ();
	                    p1.setApellido(apellido);//---ver clase
	                    
	                    
	                    System.out.println ("Ingresar Telefono");
	                    telefono = entradaEscaner.nextInt();
	                    p1.setTelefono(telefono);//---ver clase

	                    System.out.println ("Ingresar edad");
	                    edad = entradaEscaner.nextInt();
	                    p1.setDni(edad);//---ver clase
	                    
	                    
	                    //Insertar paciente en tabla paciente
	                   sql = insertPaciente(id, nombre, apellido, telefono, edad);//insertar una fila en tabla paciente
	            	   stmt.executeUpdate(sql);
	            	   System.out.println ("PACIENTE REGISTRADO");                            
	                    break;
	                case 2:
	                	int idusu=-1;
	                	String rol="nada";
	                	Scanner ent= new Scanner(System.in);
	                	System.out.println ("Ingresar Nombre de usuario");
	                    String nombreu = ent.nextLine();
	                    
	                    System.out.println ("Ingresar contraseña");
	                    String apellidou = ent.nextLine ();
	                    
	                   // SELECT * FROM pacientes where nombre='juan'and apellido='rueda';
	            		sql=findAllXNombreXPassword(nombreu,apellidou);
	            		ResultSet rs = stmt.executeQuery(sql);
	            		//extraer datos
	            		while(rs.next()) {
	            			idusu=rs.getInt("id");
	            			
	            			String nomb = rs.getString("nombreusuario");
	            			String apell = rs.getString("password");
	            			rol = rs.getString("rol");
	            			System.out.println("id:" + idusu);
	            			System.out.println("nombre de usuario:" + nomb);
	            			System.out.println("password:" + apell);
	            			System.out.println("rol:" + rol);
	            			System.out.println("");
	            		
	            		}
	            		rs.close();
	            		
	                    if(idusu==-1) {
	                    	System.out.println("Usuario o Password incorrecto");
	                    }else {
	                    	if(rol.equals("administrador")) {
	                    		System.out.println("MENU ADMINISTRADOR");
	                    		
	                    		int opcad;
	                    		do{
	                    			Scanner tec = new Scanner(System.in);
	                	            System.out.println("*.- INGRESE UNA OPCION-*");
	                	            System.out.println("1.- VER FICHA DE TODOS LOS PACIENTES REGISTRADOS");
	                	            System.out.println("2.- CARGAR UN PACIENTE EN LA SALA DE EMERGENCIA");
	                	            System.out.println("3.- Ver informe de cuantos paciente atendieron en el mes y diferenciar por rango de edad o si fueron atendidos en sala de emergencia");
	                	            System.out.println("4.- SALIR");
	                	            System.out.println("");
	                	            opcad = tec.nextInt();
	                	            switch(opcad){
	             	               		case 1:
	             	               		
	             	               			sql="SELECT tratamientos.*,pacientes.id as idpaciente, pacientes.nombre as nombrepaciente\r\n"
	             	               					+ "FROM tratamientos\r\n"
	             	               					+ "INNER JOIN pacientes ON\r\n"
	             	               					+ "tratamientos.id_pacientes=pacientes.id\r\n"
	             	               					+ "order by idpaciente;";
	             	               			ResultSet result=stmt.executeQuery(sql);
	             	               			while(result.next()) {
	             	               				int i= result.getInt("id");
	             	               			    int idpaciente= result.getInt("id_paciente");
	             	               			    String medicnombre= result.getString("mediconombre");
	             	               			    int m= result.getInt("mes");
	             	               			    int d= result.getInt("dia");		
	             	               			    String sect= result.getString("sector");
	             	               			    String desc= result.getString("descripcion");
	             	               			    int idpac= result.getInt("idpaciente");
	             	               			    String nombpa= result.getString("nombrepaciente");
	             	               			    System.out.println("id"+i+"id_paciente"+idpaciente+"mediconombre"+medicnombre+"mes"+m+"dia"+d+"sector"+sect+"descripcion"+desc+"idpaciente"+idpac+"nombrepaciente"+nombpa);
	             	               			}
	             	               			rs.close();
	             	               			break;
	             	               		case 2:
	             	               			
	             		                	int idu=-1;
	             		                	Scanner e= new Scanner(System.in);
	             		                	System.out.println ("Ingresar Nombre");
	             		                    String n = e.nextLine();
	             		                    
	             		                    System.out.println ("Ingresar apellido");
	             		                    String a = e.nextLine ();
	             		                    
	             		                   // SELECT * FROM pacientes where nombre='juan'and apellido='rueda';
	             		            		sql=findAllXNombreApellido(n,a);
	             		            		ResultSet r = stmt.executeQuery(sql);
	             		            		//extraer datos
	             		            		while(r.next()) {
	             		            			idu=rs.getInt("id");
	             		            		}
	             		            		           		            		
	             		            		rs.close();
	             		            		System.out.println ("Ingresar Nombre del medico");
	             		                    String me = e.nextLine();
	             		                    String emergencia="emergencia";   
	             		                    String estadoactual="ocupado";
	               		                    numeroorden++;
	       
	             		            		sql=insertTurno(idu, me, numeroorden, emergencia, estadoactual);
	             		            		stmt.executeUpdate(sql);
	             	               			break;
	             	               		case 3:
	             	               			System.out.println("Has seleccionado la opcion 3");
	             	               			break;            	                
	             	               		default:
	             	               			System.out.println("Saliste del Menu Administrador");
	                	            }
	                    		}while(opcad!=4);
	                    	}else {
	                    		System.out.println("MENU PACIENTE");
	                    		int opcad;
	                    		do{
	                    			Scanner tec = new Scanner(System.in);
	                	            System.out.println("*.- INGRESE UNA OPCION-*");
	                	            System.out.println("1.- CREAR TURNO");
	                	            System.out.println("2.- DAR DE BAJA TURNO");
	                	            System.out.println("3.- SALIR");
	                	            System.out.println("");
	                	            opcad = tec.nextInt();
	                	            switch(opcad){
	             	               		case 1:
	             	               			System.out.println ("Crear Turno");
	             	               			
	             	               			break;
	             	               		case 2:
	             	               			Scanner escan= new Scanner(System.in);
	             	               			System.out.println ("Ingresar id del turno");
	             		                	int idturn=escan.nextInt();
	             		                	sql = delete(idturn);
	             		          		    stmt.executeUpdate(sql);
	             		          		    System.out.println ("Turno Eliminado");
	             		          		    break;            	                
	             	               		default:
	             	               			System.out.println("Saliste del Menu Paciente");
	                	            }
	                    		}while(opcad!=3);
	                    	}
	                    }
	                    
	                    break;
	                    
	                default:
	                	System.out.println("Saliste");
	            }

	        } while (opc != 3);
			
			
			
			
		
		
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("algun error al conectar");
		}
		System.out.println("****termino****");
        
       

        
		
		
		
	}
	//mostrar datos de un paciente
	public static String findAllXNombreApellido(String nombre, String apellido) {
		/*
		 sql = indAllXNombreApellido("Pedro","Casas");
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
		
		return "SELECT * from usuarios where nombreusuario='"+nombre+"'and password='"+apellido+"'";
	}
	
	//mostrar todos los pacientes
	public static String findAll() {
		/*
		 sql = findAll();
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
		
		return "SELECT * from pacientes";
	}
	
	public static String findAllXNombreXPassword(String nombre, String password) {
		/*
		sql=findAllXNombreXPassword("admin","admin");
		ResultSet rs = stmt.executeQuery(sql);
		//extraer datos
		while(rs.next()) {
			String nombre = rs.getString("nombreusuario");
			String apellido = rs.getString("password");
			System.out.println("nombre de usuario:" + nombre);
			System.out.println("password:" + apellido);
			System.out.println();
		}
		rs.close();
		*/
		return "SELECT * from usuarios where nombreusuario='"+nombre+"'and password='"+password+"'";
	}
	
	
	public static String insertRecepcionista(String nombre, String apellido) { //insertar en tabla de recepcionista  sin enviar el id ya que es auto incremental
		/*
		sql = insert("Emanuel", "Lopez");//insertar
		stmt.executeUpdate(sql);
		*/
		return "INSERT INTO recepcionistas (id, nombre, apellido) VALUES (NULL, '"+ nombre +"','"+ apellido +"');";
	}
	public static String insertUsuario(String nombreusuario, String password, String rol) { 
		/*
		sql = insertUsuario(nombreusuario, password, rol);//insertar
		stmt.executeUpdate(sql);
		*/
		return "INSERT INTO usuarios (id, nombreusuario, password, rol) VALUES (NULL, '"+ nombreusuario +"','"+ password +"','"+ rol +"');";
	}
	public static String insertPaciente(int id, String nombre, String apellido, int telefono, int edad) { 
		/*
		sql = insert("Emanuel", "Lopez", 4879, "protesis");//insertar
		stmt.executeUpdate(sql);
		*/
		return "INSERT INTO pacientes (id, id_usuarios, nombre, apellido, telefono, edad) VALUES (NULL,"+id+", '"+ nombre +"','"+ apellido +"',"+ telefono +", "+ edad +");";
	}
	public static String update(int id, String nombre, double precio, int id_cat) {
		/*
		 sql = update(10,"nuevo_algo");
		 stmt.executeUpdate(sql);
		 */
		return "UPDATE turnos SET nombre='" +nombre+"', precio= "+ precio +", c_categoria = "+ id_cat +"";
	}
	public static String delete(int id) {//verificar si elimina un turno
		/*
		 sql = delete(5);
		 stmt.executeUpdate(sql);
		 */
		return "delete from turnos where id="+ id;
	}
	//insertar un turno emergencia
	public static String insertTurno(int id, String mediconombre, int numeroorden, String sector, String estadoturno) { 
		/*
		sql = insert("Emanuel", "Lopez", 4879, "protesis");//insertar
		stmt.executeUpdate(sql);
		*/
		return "INSERT INTO turnos (id, id_pacientes, mediconombre, numeroorden, sector, mes, dia, hora, minuto, estadoturno) VALUES (NULL,"+ id+", '" +mediconombre+"',"+ numeroorden +", '"+ sector +"',NULL, NULL,NULL,NULL,'" +estadoturno+"');";
	}

	
}
