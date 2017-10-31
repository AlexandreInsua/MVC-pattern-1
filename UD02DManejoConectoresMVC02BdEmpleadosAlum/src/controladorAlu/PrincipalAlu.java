package controladorAlu;



import modeloAlu.LogicaAlu;
import vistaAlu.VentanaDepartamentosNuevoAlu;
import vistaAlu.VentanaPrincipalAlu;

public class PrincipalAlu {

	// objetos para cada uno de los formularios
	VentanaPrincipalAlu miVentanaPrincipal;
	VentanaDepartamentosNuevoAlu miVentanaDepartamentosNuevo;

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
		
		miControlador = new ControladorAlu();
		miLogica = new LogicaAlu();
		
		//creamos las relaciones entre la clase Controlador y los formularios
		//en los formularios necesitamos un atributos Coordiandor y un metodo set
		miVentanaPrincipal.setMiControlador(miControlador);
		miVentanaDepartamentosNuevo.setControlador(miControlador);
	
		miLogica.setMiControlador(miControlador);
		
		/*Se establecen relaciones con la clase coordinador y los formularios*/
		// en la clase Controlador necesitamos como atributos a los formularios
		miControlador.setMiVentanaPrincipal(miVentanaPrincipal);
		miControlador.setMiVentanaDepartamentosNuevo(miVentanaDepartamentosNuevo);
		
		miControlador.setMiLogica(miLogica);
		
		
		
		
		miVentanaPrincipal.setVisible(true);

	}
}
