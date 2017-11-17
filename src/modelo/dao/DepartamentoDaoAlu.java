package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.Conexion;
import modelo.vo.Departamento;


public class DepartamentoDaoAlu {
	Departamento departamento = null;
	

	public DepartamentoDaoAlu() {
		super();
	}

	public void nuevoDepartamento(Departamento depar){
		//creamos la conexion
		Conexion conexion = new Conexion();

		//Preparamos la consulta de actualizacion
		PreparedStatement ps=null;

		// creamos el string con la consulta
		String sql = "INSERT INTO Departamentos (CodDepartamento, DepNombre, Localidad) "
				+ "VALUES (?, ?, ?)";

		try{
			ps=(PreparedStatement) conexion.getConnection().prepareStatement(sql);
			//pasamos los parametros
			ps.setShort(1, depar.getCodigo());
			ps.setString(2, depar.getDepartamento());
			ps.setString(3, depar.getLocalidad());
		
			//ejecutamos la consulta	
			int filas = ps.executeUpdate();
			if(filas != 0){
				JOptionPane.showMessageDialog(null, "Inserción correcta");
			}


		} catch (SQLException sqle) {
			if (sqle.getErrorCode() == 1062)
				JOptionPane.showMessageDialog(null, "Departamento ya existe", "Error", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}finally{
			conexion.desconectar();
		}
	}// fin metodo nuevoDepartamento
	
	public void modificarDepartamento(Departamento depar){
		Conexion conexion = new Conexion();
		
		//Preparamos la consulta de actualizacion
		PreparedStatement ps=null;

		// creamos el string con la consulta
		String sql = "UPDATE Departamentos SET DepNombre = ?, Localidad = ?"
				+ " WHERE CodDepartamento = ?";

		try{
			ps=(PreparedStatement) conexion.getConnection().prepareStatement(sql);
			//pasamos los parametros
			ps.setString(1, depar.getDepartamento());
			ps.setString(2, depar.getLocalidad());
			ps.setShort(3, depar.getCodigo());

			//ejecutamos la consulta	
			int filas = ps.executeUpdate();
			if(filas != 0){
				JOptionPane.showMessageDialog(null, "Actualización correcta");
			}
			//cerramos la conexion
			conexion.desconectar();

		} catch (SQLException sqle) {
			if (sqle.getErrorCode() == 1064)
				JOptionPane.showMessageDialog(null, "Departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}// fin del metodo actualizarDepartamento
	

	

	

	public void eliminarDepartamento(short codigo){
		Conexion conexion = new Conexion();
		
		//Preparamos la consulta de actualizacion
		PreparedStatement ps=null;

		// creamos el string con la consulta
		String sql = "DELETE FROM Departamentos WHERE CodDepartamento = ?";

		try{
			ps=(PreparedStatement)conexion.getConnection().prepareStatement(sql);
			//pasamos los parametros
			ps.setShort(1, codigo);

			//ejecutamos la consulta	
			int filas = ps.executeUpdate();
			if(filas != 0){
				JOptionPane.showMessageDialog(null, "Eliminación correcta");
			}
			//cerramos la conexion
			conexion.desconectar();

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error SQL Delete.");
		}
	} // fin del metodo eliminarDepartamento

	public Departamento buscarDepartamento(short codDepar){
		//creamos la conexion
		Conexion conexion = new Conexion();


		//Preparamos la consulta de actualizacion
		PreparedStatement ps = null;
		ResultSet resultado = null;

		// objeto donde se guarda el resultado de la consulta
		Departamento depar = null;

		// creamos el string con la consulta
		String sql = "SELECT CodDepartamento, DepNombre, Localidad FROM Departamentos"
				+ " WHERE CodDepartamento = ?";

		try{
			ps=(PreparedStatement) conexion.getConnection().prepareStatement(sql);

			//pasamos los parametros
			ps.setShort(1, codDepar);

			//ejecutamos la consulta	
			// creamos el resultado de la consulta
			resultado = ps.executeQuery();

			if(resultado.next() ){
				depar = new Departamento();

				depar.setCodigo(resultado.getShort("CodDepartamento"));
				depar.setDepartamento(resultado.getString("DepNombre"));
				depar.setLocalidad(resultado.getString("Localidad"));
			
			// otra forma de recuperar los datos de la consulta es poniendo el indice de la 
			// columna con respecto a la consulta
				
			/*	depar.setCodigo(resultado.getShort(1));
				depar.setDepartamento(resultado.getString(2));
				depar.setLocalidad(resultado.getString(3));*/
			}
			//cerramos la conexion
			conexion.desconectar();

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error SQL Select.");
		}
		return depar;
	}// fin metodo buscarDepartamento
	

	
	public Departamento primerDepartamento(){
		Conexion conexion = new Conexion();
		
		//Preparamos la consulta de actualizacion
		PreparedStatement ps = null;
		ResultSet resultado = null;

		// objeto donde se guarda el resultado de la consulta
		Departamento depar = null;

		// creamos el string con la consulta
		String sql = "SELECT CodDepartamento, DepNombre, Localidad FROM Departamentos"
				+ " ORDER BY CodDepartamento limit 1";

		try{
			ps=(PreparedStatement) conexion.getConnection().prepareStatement(sql);

			//ejecutamos la consulta	
			// creamos el resultado de la consulta
			resultado = ps.executeQuery();

			if(resultado.next() ){
				depar = new Departamento();

				depar.setCodigo(resultado.getShort("CodDepartamento"));
				depar.setDepartamento(resultado.getString("DepNombre"));
				depar.setLocalidad(resultado.getString("Localidad"));
			}


			//cerramos la conexion
			conexion.desconectar();

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error SQL Select.");
		}
		return depar;
	}// fin metodo primerDepartamento

	
	public Departamento ultimoDepartamento(){
		Conexion conexion = new Conexion();
	

		//Preparamos la consulta de actualizacion
		PreparedStatement ps = null;
		ResultSet resultado = null;

		// objeto donde se guarda el resultado de la consulta
		Departamento depar = null;

		// creamos el string con la consulta
		String sql = "SELECT CodDepartamento, DepNombre, Localidad FROM Departamentos"
				+ " ORDER BY CodDepartamento DESC limit 1";

		try{
			ps=(PreparedStatement) conexion.getConnection().prepareStatement(sql);

			//ejecutamos la consulta	
			// creamos el resultado de la consulta
			resultado = ps.executeQuery();

			if(resultado.next() ){
				depar = new Departamento();

				depar.setCodigo(resultado.getShort("CodDepartamento"));
				depar.setDepartamento(resultado.getString("DepNombre"));
				depar.setLocalidad(resultado.getString("Localidad"));
			}


			//cerramos la conexion
			conexion.desconectar();

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error SQL Select.");
		}
		return depar;
	}// fin metodo ultimoDepartamento
	
	public Departamento anteriorDepartamento(short codDepar){
		Conexion conexion = new Conexion();
		
		//Preparamos la consulta de actualizacion
		PreparedStatement ps = null;
		ResultSet resultado = null;

		// objeto donde se guarda el resultado de la consulta
		Departamento depar = null;

		// creamos el string con la consulta
		String sql = "SELECT CodDepartamento, DepNombre, Localidad FROM Departamentos"
				+ " WHERE CodDepartamento < ? ORDER BY CodDepartamento DESC LIMIT 0, 1";

		try{
			ps=(PreparedStatement) conexion.getConnection().prepareStatement(sql);

			//pasamos los parametros 
			ps.setShort(1, codDepar);

			//ejecutamos la consulta	
			// creamos el resultado de la consulta
			resultado = ps.executeQuery();

			if(resultado.next() ){
				depar = new Departamento();

				depar.setCodigo(resultado.getShort("CodDepartamento"));
				depar.setDepartamento(resultado.getString("DepNombre"));
				depar.setLocalidad(resultado.getString("Localidad"));
			}


			//cerramos la conexion
			conexion.desconectar();

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error SQL Select.");
		}
		return depar;			

	}// fin metodo anteriorDepartamento
	
	public ArrayList <Departamento> cargarDepartamentos(){
		Conexion conexion = new Conexion();

		//Preparamos la consulta de actualizacion
		PreparedStatement ps = null;
		ResultSet resultado = null;

		Departamento departamento = null;
		ArrayList <Departamento> lista = new ArrayList<Departamento>();
		
		// limpiamos los datos
		lista.clear();

		String consultaSQL = "SELECT * from Departamentos ORDER BY DepNombre";

		try{

			//preparo la ejecucion de la consulta
			ps =  conexion.getConnection().prepareStatement(consultaSQL);				
			resultado = ps.executeQuery();
			while(resultado.next()){
				departamento = new Departamento();

				departamento.setCodigo(resultado.getShort("CodDepartamento"));
				departamento.setDepartamento(resultado.getString("DepNombre"));
				departamento.setLocalidad(resultado.getString("Localidad"));
				lista.add(departamento);

			}
			ps.close();
			resultado.close();
			conexion.desconectar();


		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}

		return lista;
	}// fin cargarDepartamento

	public Departamento siguienteDepartamento(short codDepar){
		Conexion conexion = new Conexion();
		
		//Preparamos la consulta de actualizacion
		PreparedStatement ps = null;
		ResultSet resultado = null;

		// objeto donde se guarda el resultado de la consulta
		Departamento depar = null;

		// creamos el string con la consulta
		String sql = "SELECT CodDepartamento, DepNombre, Localidad FROM Departamentos"
				+ " WHERE CodDepartamento > ? ORDER BY CodDepartamento LIMIT 0, 1";

		try{
			ps=(PreparedStatement) conexion.getConnection().prepareStatement(sql);

			//pasamos los parametros
			ps.setShort(1, codDepar);

			//ejecutamos la consulta	
			// creamos el resultado de la consulta
			resultado = ps.executeQuery();

			if(resultado.next() ){
				depar = new Departamento();

				depar.setCodigo(resultado.getShort("CodDepartamento"));
				depar.setDepartamento(resultado.getString("DepNombre"));
				depar.setLocalidad(resultado.getString("Localidad"));
			}


			//cerramos la conexion
			conexion.desconectar();

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error SQL Select.");
		}
		return depar;			

	}// fin metodo siguienteDepartamento

	


	




}// fin de la clase
