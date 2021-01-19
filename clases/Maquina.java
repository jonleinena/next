package clases;

public class Maquina {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Maquina(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Maquina() {
		super();
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}
