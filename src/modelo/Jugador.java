package modelo;

public class Jugador {
	
	private int ID;
	private String nombre;
	private int dorsal;
	private double altura;
	
	
	
	
	

	public Jugador(int iD, String nombre, int dorsal, double altura) {
		super();
		this.ID = iD;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.altura = altura;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	

}
