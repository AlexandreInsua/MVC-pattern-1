package modeloAlu.vo;

public class Departamento {
	private short codigo;
	private String departamento; //longitud 20
	private String localidad; //longitud 20
	
	
	public Departamento() {
		super();
	}

	public Departamento(short codigo, String departamento, String localidad) {
		super();
		this.codigo = codigo;
		this.departamento = departamento;
		this.localidad = localidad;
	}

	public short getCodigo() {
		return codigo;
	}

	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
		return departamento;
	}

}
