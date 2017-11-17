package modelo.vo;

import java.util.Date;

public class EmpleadosSalarioAlu {
	private String nombre; // longitud 30
	private String puesto; // longitud 25
	private Date fechaAlta;
	private float salario; 
	private float comision;
	private float suma;
	public EmpleadosSalarioAlu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpleadosSalarioAlu(String nombre, String puesto,  Date fechaAlta, float salario, float comision,
			float suma) {
		super();
		this.nombre = nombre;
		this.puesto = puesto;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.comision = comision;
		this.suma = suma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public float getSuma() {
		return suma;
	}
	public void setSuma(float suma) {
		this.suma = suma;
	}
	
	
}
