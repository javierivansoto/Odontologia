package Proyecto;

import java.util.*;

public class Recepcionista {
	private int id;
	private String nombre;
	private String apellido;
	private ArrayList<Paciente> pacientes; 
	private ArrayList<Turno> turnos; 
	
	public Recepcionista() {
	}
	
	public Recepcionista(int id, String nombre, String apellido, ArrayList<Paciente> pacientes, ArrayList<Turno> turnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pacientes = pacientes;
		this.turnos = turnos;
	}

	//Metodo Mostrar todos los Pacientes
	public void mostrarPacientes() {
		 for (Paciente p : pacientes) {
	            p.toString();
	        }
	}
	
	//Cargar Paciente en sala de emergencia
	public void CargarPacienteEmergencia(Paciente p, Turno t) {
		t.setPaciente(p);
		t.setSector("emergencia");
	}

	//Cargar un turno
	public void CargarTurno(Turno t) {
		turnos.add(t);
		System.out.println("Se a cargado el Turno");
	}
	//Dar de Baja un turno
	
	public void BajaTurno(int id_turno) {
		int elimina;
		for (Turno t : turnos) {
            if(t.getId()==id_turno) {
            	elimina=turnos.indexOf(t);
            	turnos.remove(elimina);
            }
        }	
	}
	//devolver posicion del elemento a eliminar de la lista de Turnos..si no esta devuelve un numero negativo
	public int PosicionTurno(Turno t) {
		 return turnos.indexOf(t);	
	}

	
	/*
	public static int buscarTurno(ArrayList<Turno> turnos, int dato) {
		 int inicio = 0;
		 int fin = turnos.size() - 1;
		 int pos;
		 while (inicio <= fin) {
		     pos = (inicio+fin) / 2;
		     if ( turnos[pos] == dato )
		       return pos;
		     else if ( turnos[pos] < dato ) {
		  inicio = pos+1;
		     } else {
		  fin = pos-1;
		     }
		 }
		 return -1;
  }
*/
	


	@Override
	public String toString() {
		return "Recepcionista [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", pacientes=" + pacientes
				+ ", turnos=" + turnos + "]";
	}



}
