package modeloAlu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.Conexion;
import modeloAlu.vo.Empleado;

public class EmpleadoDao {
	Connection conexion = null;
	ArrayList <Empleado> datos = new ArrayList <Empleado>() ;
	
	//selecciona los empleados de un departamento
	public ArrayList<Empleado> cargarEmpleadosDepartamento(int codigo){
		 // creamos un objeto de la clase Empleados
		Empleado empleado = new Empleado();
				
		// establecemos la conexion
		Conexion ec = new Conexion();
		conexion = ec.getConnection();
						
		// instaciamos el PreparedStatement
		PreparedStatement ps = null; 
		// creamos el ResultSet
		ResultSet rs = null;
		// creamos la consulta
		String sql = "SELECT CodEmpleado, Nombre, Puesto, Dir, FechaAlta, Salario, Comision "
				+ "FROM Empleados WHERE CodDepartamento = ?";					 
		
		try{
			//comprueba si existe el PreparedStatment
					
			ps = (PreparedStatement)conexion.prepareStatement(sql);
			//pasamos los parametros
			ps.setInt(1, codigo);
					
			// limpiamos los datos
			datos.clear();
			// ejecutamos la consulta
			rs = ps.executeQuery();
			while(rs.next()){
				//creamos un objeto empleado y le asignamos los valores de la tabla
				empleado =  new Empleado();
				empleado.setCodEmpleado(rs.getInt("CodEmpleado"));
				empleado.setNombre(rs.getString("Nombre"));
				empleado.setPuesto(rs.getString("Puesto"));
				empleado.setDir(rs.getInt("Dir"));
				empleado.setFechaAlta(rs.getDate("FechaAlta"));
				empleado.setSalario(rs.getFloat("Salario"));
				empleado.setComision(rs.getFloat("Comision"));
							
				//  añadimos el objeto creado al arrayList
				datos.add(empleado);
			}// fin del while
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Error: " +ex.getMessage());
			ex.printStackTrace();
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(conexion != null){
					conexion.close();
				}
			}catch(SQLException ex){
				JOptionPane.showMessageDialog(null, "Error: " +ex.getMessage());
				ex.printStackTrace();
			}
				}
		return datos;
	}

	//selecciona todos los empleados la empresa 
	public ArrayList<Empleado> cargarEmpleadosDepartamento(){
		 // creamos un objeto de la clase Empleados
		Empleado empleado = new Empleado();
				
		// establecemos la conexion
		Conexion ec = new Conexion();
		conexion = ec.getConnection();
						
		// instaciamos el PreparedStatement
		PreparedStatement ps = null; 
		// creamos el ResultSet
		ResultSet rs = null;
		// creamos la consulta
		String sql = "SELECT CodEmpleado, Nombre, Puesto, Dir, FechaAlta, Salario, Comision "
				+ "FROM Empleados";					 
		
		try{
			//comprueba si existe el PreparedStatment
					
			ps = (PreparedStatement)conexion.prepareStatement(sql);
								
			// limpiamos los datos
			datos.clear();
			// ejecutamos la consulta
			rs = ps.executeQuery();
			while(rs.next()){
				//creamos un objeto empleado y le asignamos los valores de la tabla
				empleado =  new Empleado();
				empleado.setCodEmpleado(rs.getInt("CodEmpleado"));
				empleado.setNombre(rs.getString("Nombre"));
				empleado.setPuesto(rs.getString("Puesto"));
				empleado.setDir(rs.getInt("Dir"));
				empleado.setFechaAlta(rs.getDate("FechaAlta"));
				empleado.setSalario(rs.getFloat("Salario"));
				empleado.setComision(rs.getFloat("Comision"));
							
				//  añadimos el objeto creado al arrayList
				datos.add(empleado);
			}// fin del while
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Error: " +ex.getMessage());
			ex.printStackTrace();
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(conexion != null){
					conexion.close();
				}
			}catch(SQLException ex){
				JOptionPane.showMessageDialog(null, "Error: " +ex.getMessage());
				ex.printStackTrace();
			}
				}
		return datos;
	}



}
