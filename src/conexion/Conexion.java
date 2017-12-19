package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion  {
	
	static String bd = "ud02bd01empleados";
	static String login = "SegundoDAM";
	static String password = "randulfolupe";
	static String url = "jdbc:mysql://localhost/"+bd;

	Connection conn = null;

	/** Constructor de DbConnection */
	public Conexion() {
		try{
			//obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
			//obtenemos la conexión
			conn = DriverManager.getConnection(url,login,password);

			if (conn!=null){
				System.out.println("Conexión a base de datos "+bd+" OK");
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	/**Permite retornar la conexión*/
	public Connection getConnection(){
		return conn;
	}

	public void desconectar(){
		conn = null;
	}
}
