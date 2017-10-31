package model;

public class Deparment {
	private short codigo;
	private String departmento; // lonxitude 20
	private String localidade; // lonxitude 20

	public Deparment() {
		super();
	}

	public Deparment(short codigo, String departmento, String localidade) {
		super();
		this.codigo = codigo;
		this.departmento = departmento;
		this.localidade = localidade;
	}

	public short getCodigo() {
		return codigo;
	}

	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}

	public String getDepartmento() {
		return departmento;
	}

	public void setDepartmento(String departmento) {
		this.departmento = departmento;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

}
