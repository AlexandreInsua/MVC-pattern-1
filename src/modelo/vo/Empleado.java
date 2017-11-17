package modelo.vo;

import java.util.Date;

public class Empleado {
	/*	CREATE TABLE  `empleados`.`empleados` (
	  `CodEmpleado` smallint(5) unsigned NOT NULL,
	  `Nombre` varchar(30) NOT NULL,
	  `Puesto` varchar(25) DEFAULT NULL,
	  `Dir` smallint(5) unsigned DEFAULT NULL,
	  `FechaAlta` date DEFAULT NULL,
	  `Salario` float(6,2) DEFAULT NULL,
	  `Comision` float(6,2) DEFAULT NULL,
	  `CodDepartamento` int(11) DEFAULT NULL,*/
	
	private int codEmpleado;
	private String nombre; // longitud 30
	private String puesto; // longitud 25
	private int dir;
	private Date fechaAlta;
	private float salario; 
	private float comision;
	private short codDepartamento;

	public Empleado() {
		super();
	}
	
	public short getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(short codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public Empleado(int codEmpleado, String nombre, String puesto, int dir, Date fechaAlta, float salario,
			float comision, short codDepartamento) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.puesto = puesto;
		this.dir = dir;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.comision = comision;
		this.codDepartamento = codDepartamento;
	}
	
	
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
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
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
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
	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
