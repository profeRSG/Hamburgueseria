package modelo;

/**
 * Clase utilizada para representar un complemento.
 * 
 * @author Raul SG
 *
 */
public class Complemento {
	
	//Constantes
	public static final double PRECIO_PATATAS = 2;//Precio de las patatas
	public static final double PRECIO_SALSA_ESPECIAL = 2.5;//Precio de la salsa especial
	public static final String NOMBRE_PATATAS="patatas";//nombre del complemento patatas
	public static final String NOMBRE_SALSA_ESPECIAL="Salsa especial";//nombre del complemento salsa especial
	
	//ATRIBUTOS
	private String nombre;
	private double precio;
	
	
	//METODOS
	
	//Constructor
	public Complemento(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	//Setters y Getters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	

}
