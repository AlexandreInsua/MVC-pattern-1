package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	static String bd = "ud02bd01empleados";
	static String login = "SegundoDAM";
	static String password = "SegundoDAM";
	static String url = "jdbc:mysql://localhost/"+bd;

	Connection connection = null;

	/** Constructor de DbConnection */
	public Conexion() {
		try{
			//obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
			//obtenemos la conexión
			connection = DriverManager.getConnection(url,login,password);

			if (connection!=null){
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
		return connection;
	}

	public void desconectar(){
		connection = null;
	}
	public static void main(String[] args) {
		Conexion c = new Conexion();
		c.getConnection();
	}
}


