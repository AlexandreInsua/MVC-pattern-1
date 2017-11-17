package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.Conexion;
import modelo.vo.Empleado;
import modelo.vo.EmpleadosSalarioAlu;

public class EmpleadoDaoAlu {
	Connection conexion = null;
	ArrayList <Empleado> datos = new ArrayList <Empleado>() ;
	
	public ArrayList<EmpleadosSalarioAlu> cargarEmpleadosSalarios(int codigo) {
		
		Conexion conexion = new Conexion();
		
		//Preparamos la consulta de actualizacion
		PreparedStatement ps = null;
		ResultSet resultado = null;
		
		String consulta = "SELECT Nombre, Puesto, Fechaalta, Salario, IFNULL(Comision, 0),"
				+ " Salario + IFNULL(Comision, 0) FROM Empleados WHERE codDepartamento = ?";
		
		ArrayList <EmpleadosSalarioAlu> datos = new ArrayList<EmpleadosSalarioAlu>();
		
		datos.clear();
		try{
			ps = (PreparedStatement )conexion.getConnection().prepareStatement(consulta);
			ps.setInt(1, codigo);
			
			resultado = ps.executeQuery();
			
			while(resultado.next()){
				EmpleadosSalarioAlu emple = new EmpleadosSalarioAlu();
				emple.setNombre(resultado.getString("Nombre"));
				emple.setPuesto(resultado.getString("Puesto"));
				emple.setFechaAlta(resultado.getDate("FechaAlta"));
				emple.setSalario(resultado.getFloat("Salario"));
				emple.setComision(resultado.getFloat(5));
				emple.setSuma(resultado.getFloat(6));
				
				datos.add(emple);
				
			}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "Error SQL Select.");
			}
		conexion.desconectar();
		return datos;
	}// fin cargarEmpleadosSalarios()
}
