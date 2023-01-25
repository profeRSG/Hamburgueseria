package gestion;

import java.util.Scanner;

/**
 * Clase utiliada para crear menus de los usuarios
 * 
 * @author Raul SG
 *
 */
public class MenuUsuario {

	//ATRIBUTOS
	private String pregunta;
	private String[] opciones;//TODO seria mejor hacerlo con un List, pero no lo utilizo porque 
	//no lo hemos dado aun. Con List, seria mas simple.

	private int i; //Indice por donde vamos añadiendo las opciones en el array de opciones. Inicialmente vale 0.
	public static final  int TAM_MAX=20;//Hemos considerado que el numero maximo de opciones en un menu va a ser 20
	//Usando List, no existiria un limite.


	//METODOS

	//Constructor
	/**
	 * Constructor de la clase MenuUsuario. Es utilizado para crear un objeto menu de usuario
	 * indicandole la pregunta principal del menu
	 * 
	 * @param pregunta principal del menu
	 */
	public MenuUsuario(String pregunta) {
		this.pregunta = pregunta;
		this.opciones=new String[TAM_MAX];
		this.i=0;
	}

	/**
	 * Metodo utilizado para añadir las posibles opciones que se van a presentar en el menu
	 * 
	 * @param opcionNueva que se quiere agregar a las opciones ya existentes
	 * @return devuelve true si se ha podiso agregar, devuelve false, si se ha llegado al
	 * limite de opciones posibles, y por tanto no se pueden agregar mas opciones 
	 */
	public  boolean addOpcion(String opcionNueva) {
		boolean agregado=false;
		if(i<TAM_MAX) {//Si no se ha llegado al limite
			opciones[i]=opcionNueva;//guardamos la nueva opcion
			i++;//Incrementamos el indice, para que apunte al siguiente hueco de la array.
			agregado=true; //Se indica que se ha añadido la nueva opcion
		}
		return agregado;//Devolvenos si hemos agregado la opcion o no
	}

	/**
	 * Metodo utilizado para mostrar el menu
	 */
	public String toString() {
		String resultado="\n";
		resultado+=pregunta;//Mostramos la pregunta
		for(int i=0;i<this.i;i++) {//Mostramos todas las opciones, numeradas
			resultado+="\n\t"+(i+1)+".- "+opciones[i];
		}
		return resultado;
	}

	/**
	 * Metodo utilizado para leer la opcion elegida por el usuario desde teclado.
	 * Se controla que la eleccion este dentro del numero de opciones disponibles, en caso contrario se le avisara al usuario y 
	 * tendra que introducir un numero de nuevo.
	 * TODO Este metodo se podria unir con el metodo toString.
	 * @return devuelve la eleccion seleccionada por el usuario, la cual siempre estara entre 1 , y el numero de opciones disponibles
	 */
	public int elegirOpcion() {
		int inicio=1;//Las opciones posibles estan entre 1
		int fin=i;//Y el numero de opciones añadidas
		int eleccion;
		Scanner sc=new Scanner(System.in);
		eleccion=sc.nextInt();//Leemos un entero por teclado
		while(eleccion<inicio || eleccion>fin) {//Si elegimos un valor fuera del rango posible
			System.out.println("Eleccion incorrecta. Se debe seleccionar un numero entre "+inicio+" y "+fin);
			eleccion=sc.nextInt();//Volvemos a leer un valor por teclado
		}
		return eleccion;
	}
}


