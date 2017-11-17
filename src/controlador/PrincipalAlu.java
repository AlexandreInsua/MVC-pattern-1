package controlador;



import modelo.LogicaAlu;
import vista.VentanaDepartamentosConsultarAlu;
import vista.VentanaDepartamentosEliminarAlu;
import vista.VentanaDepartamentosModificarAlu;
import vista.VentanaDepartamentosNuevoAlu;
import vista.VentanaEmpleadosDepartamentoAlu;
import vista.VentanaListadoDepartamentosAlu;
import vista.VentanaPrincipalAlu;

public class PrincipalAlu {

	// objetos para cada uno de los formularios
	VentanaPrincipalAlu miVentanaPrincipal;
	VentanaDepartamentosNuevoAlu miVentanaDepartamentosNuevo;
	VentanaDepartamentosModificarAlu miVentanaDepartamentosModificar;
	VentanaDepartamentosEliminarAlu miVentanaDepartamentosEliminar;
	VentanaDepartamentosConsultarAlu miVentanaDepartamentosConsultar;
	VentanaListadoDepartamentosAlu miVentanaListadoDepartamentos;
	VentanaEmpleadosDepartamentoAlu miVentanaEmpleadosDepartamentos;
	

	// objetos para el controlador y la logica
	ControladorAlu miControlador;
	LogicaAlu miLogica;


	public static void main(String[] args) {
		PrincipalAlu principal = new PrincipalAlu();
		principal.iniciar();
		
	}
	
	public void iniciar(){
		//instanciamos los objetos
		miVentanaPrincipal = new VentanaPrincipalAlu();
		miVentanaDepartamentosNuevo = new VentanaDepartamentosNuevoAlu();
		miVentanaDepartamentosModificar = new VentanaDepartamentosModificarAlu();
		miVentanaDepartamentosEliminar = new VentanaDepartamentosEliminarAlu();
		miVentanaDepartamentosConsultar = new VentanaDepartamentosConsultarAlu();
		miVentanaListadoDepartamentos = new VentanaListadoDepartamentosAlu();
		miVentanaEmpleadosDepartamentos = new VentanaEmpleadosDepartamentoAlu();
		
		miControlador = new ControladorAlu();
		miLogica = new LogicaAlu();
		
		//creamos las relaciones entre la clase Controlador y los formularios
		//en los formularios necesitamos un atributos Coordiandor y un metodo set
		miVentanaPrincipal.setMiControlador(miControlador);
		miVentanaDepartamentosNuevo.setControlador(miControlador);
		miVentanaDepartamentosModificar.setControlador(miControlador);
		miVentanaDepartamentosEliminar.setMiControlador(miControlador);
		miVentanaDepartamentosConsultar.setMiControlador(miControlador);
		miVentanaListadoDepartamentos.setControlador(miControlador);
		miVentanaEmpleadosDepartamentos.setControlador(miControlador);
		
		miLogica.setMiControlador(miControlador);
		
		/*Se establecen relaciones con la clase coordinador y los formularios*/
		// en la clase Controlador necesitamos como atributos a los formularios
		miControlador.setMiVentanaPrincipal(miVentanaPrincipal);
		miControlador.setMiVentanaDepartamentosNuevo(miVentanaDepartamentosNuevo);
		miControlador.setMiVentanaDepartamentosModificar(miVentanaDepartamentosModificar);
		miControlador.setMiVentanaDepartamentosEliminar(miVentanaDepartamentosEliminar);
		miControlador.setMiVentanaDepartamentosConsultar(miVentanaDepartamentosConsultar);
		miControlador.setMiVentanaListadoDepartamentos(miVentanaListadoDepartamentos);
		miControlador.setMiVentanaEmpleadosDepartamento(miVentanaEmpleadosDepartamentos);
		
		miControlador.setMiLogica(miLogica);
			
		miVentanaPrincipal.setVisible(true);

	}
}
