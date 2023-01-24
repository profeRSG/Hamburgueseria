package main;

import java.util.Scanner;

/**
 * 
 * @author Raul Sanchez Galan
 * El siguiente programa sirve para gestionar una hamburgueseria.
 * No se han utilizado tildes, para no tener problemas con diferentes encondigs
 *
 */
public class Main {

	/**
	 * Metodo principal del programa. 
	 * 
	 */
	public static void main(String[] args) {
		menuInicial();

	}

	/**
	 * El siguiente metodo se encarga de mostrar el menu principal del 
	 * programa.
	 * Va a permitir si se elige 1, elegir un menu principal
	 * si se selecciona 2, se podra elegir los complementos
	 * la opcion 3 es para pagar lo seleccionado.
	 * Y finalmente la opcion 4 es para salir 
	 */
	private static void menuInicial() {
		String menuPrincipal="";//En esta variable vamos a almacenar el menu principal seleccionado
		boolean patatas=false;//Esta variable indica si se ha elegido como complemento las patatas
		boolean salsaEspecial=false;//Esta variable indica si se ha elegido como complemento la salsa especial	
		int opcion;//Variable utilizada para guardar lo que el usuario ha elegido por teclado

		do {
			mostrarOpciones();//Se le muestra al usuario el menu de usuario primero
			opcion=elegirOpcionPrincipal();//El usuario elige entre las 4 opciones disponibles

			switch (opcion) {
			case 1-> //Se desea elegir un menu principall
				menuPrincipal=menuMenuPrincipal(menuPrincipal);
			case 2-> {//Se desea elegir los complementos
				//Como el ejercicio no dice al respecto, permitimos que se pueda elegir varias
				//veces los complementos.
				patatas=menuPatatas(menuPrincipal);
				salsaEspecial=menuSalsa(menuPrincipal);
			}
			case 3-> {//Se quiere pagar
				mostraCoste(menuPrincipal, patatas, salsaEspecial);//Se muestra el coste del pedido
				menuPrincipal="";//Se reinicia el menu principal, para comenzar el proximo pedido
				patatas=false;//Se reinicia las patatas
				salsaEspecial=false;//Se reinicia la salsa especial
			}
			}
		}while(opcion!=4);//Hasta que no se seleccione la opcion salir, el programa seguira mostrandose
	}

	/**
	 * Metodo que muestra al usuario las opciones para poder elegir una salsa especial o no. Devolvera como
	 * resultado si se ha seleccionado o no como complemento.
	 * 
	 * @param menuPrincipal Se psa como parametro de entrada, el menu principal que ha seleccionado el usuario
	 * @return devuelve un booleano que indica si se ha elegido la salsa especial como complemento o no
	 */
	private static boolean menuSalsa(String menuPrincipal) {
		boolean salsa=false;

		if(menuPrincipal.equals("MENU_AMERICANO"))//Solo se puede elegir salsa especial, si
			//el menu principal solicitado es el menu americano
			//TODO crear una constante static para el nombre del menu.
		{
			mostrarMenuParaSalsa();//Se muestra el menu para elegir la salsa especial
			salsa=elegirSalsa();//El usuario elige si quiere o no la salsa
		}
		return salsa;// Se devuelve el resultado de la seleccion del usuario
	}

	/**
	 * Metodo utilizado para leer por teclado si el usuario quiere o no salsa
	 * @return
	 */
	private static boolean elegirSalsa() {
		int opcion=elegirEnteroEntre(1, 2);//El usuario debe elegir un numero entre 1, y 2.
		boolean salsa;

		if(opcion==1)//Si elige la opcion 1, significa que quiere salsa especial
			salsa=true;
		else//Si elige la opcion 2, significa que NO quiere salsa especial
			salsa=false;
		return salsa;
	}

	/**
	 * El metodo muestra el menu con las opciones disponibles para la seleccion
	 * de la salsa especial
	 */
	private static void mostrarMenuParaSalsa() {
		System.out.println("Quieres salsa especial");
		System.out.println("1. Si");
		System.out.println("2. No");

	}

	/**
	 * Metodo que muestra al usuario las opciones para poder elegir las patatas o no. Devolvera como
	 * resultado si se ha seleccionado o no como complemento.
	 * 
	 * @param menuPrincipal Se psa como parametro de entrada, el menu principal que ha seleccionado el usuario
	 * @return devuelve un booleano que indica si se ha elegido las patatas  como complemento o no
	 */
	private static boolean menuPatatas(String menuPrincipal) {
		boolean patatas=false;
		if(menuPrincipal.equals(""))//Si no se ha seleccionado un menu principal antes,
			System.out.println("Se debe elegir un menu principal, antes de los complementos");
		else {//En el caso de que se haya seleccionado un menu principal previamente
			mostrarMenuParaPatatas();//Se muestra el menu para elegir las patatas
			patatas=elegirPatatas();//El usuario elige si quiere o no patatas
		}
		return patatas;
	}

	/**
	 * Metodo utilizado para leer por teclado si el usuario quiere o no patatas
	 * @return
	 */
	private static boolean elegirPatatas() {
		int opcion=elegirEnteroEntre(1, 2);//El usuario debe elegir un numero entre 1, y 2.
		boolean patatas;

		if(opcion==1)//Si elige la opcion 1, significa que quiere patatas
			patatas=true;
		else//Si elige la opcion 2, significa que NO quiere patatas
			patatas=false;
		return patatas;
	}

	/**
	 * El metodo muestra el menu con las opciones disponibles para la seleccion
	 * de las patatas
	 */
	private static void mostrarMenuParaPatatas() {
		System.out.println("¿Quieres patatas?");
		System.out.println("1. Si");
		System.out.println("2. No");
	}

	
	/**
	 * 
	 * @param menuPrincipal
	 * @return devuelve el menu que se ha elegido. En caso de no poder elegir ningun
	 * menu, devolvera una cadena vacia
	 */
	private static String menuMenuPrincipal(String menuPrincipal) {
		if(menuPrincipal.equals("")) {//Si no se ha seleccionado un menu anteriormente
			mostrarMenuParaMenuPrincipal();//Se muestra el menu
			menuPrincipal=elegirMenu();//Se elgie por teclado el menu
		}
		else {//Si ya se ha seleccionado un menu previamente
			System.out.println("Ya se ha seleccionado un menu");
		}
		return menuPrincipal;
	}

	/**
	 * El metodo lee porteclado la opcion del usuario, la cual sera
	 * 1 para el menu americano, y 2 para el classic
	 * 
	 * @return devuelve el nombre del menu elegido
	 */
	private static String elegirMenu() {
		int opcion=elegirEnteroEntre(1, 2);//Elegimos un numero entre 1 y 2
		String menuPrincipal;

		if(opcion==1)//Si se elige la primera opcion
			menuPrincipal="MENU_AMERICANO";
		else//Si se elige la segunda opcion
			menuPrincipal="MENU_CLASSIC";
		return menuPrincipal;
	}

	/**
	 * Mostramos por pantalla el menu para elegir el menu principal
	 */
	private static void mostrarMenuParaMenuPrincipal() {
		System.out.println("¿Que menú quiere?");
		System.out.println("1. Americano");
		System.out.println("2. Classic");

	}

	/**
	 * Metodo encargado de mostrar el coste del pedido selccionado
	 * 
	 * @param menuPrincipal contiene el nombre del menu principal seleccionado
	 * @param patatas booleano que sera verdadero si se ha elegido el menu con patatas
	 * @param salsaEspecial booleano que sera verdadero si se ha elegido el menu con salsa especial
	 */
	private static void mostraCoste(String menuPrincipal, boolean patatas, boolean salsaEspecial) {
		//DEfinimos los costes de los items como constantes
		final double PRECIO_MENU_AMERICANO=18.5;
		final double PRECIO_MENU_CLASSIC=17;
		final double PRECIO_PATATAS=2;
		final double PRECIO_SALSA_ESPECIAL=2.5;

		double costeTotal=0;
		if(menuPrincipal.equals("MENU_AMERICANO")) {//Si el menu es el menu americano
			costeTotal=PRECIO_MENU_AMERICANO;
		}else if(menuPrincipal.equals("MENU_CLASSIC")) {//Si el menu es el menu americano
			costeTotal=PRECIO_MENU_CLASSIC;
		}
		costeTotal+=patatas?PRECIO_PATATAS:0;//Si se ha elegido las patatas, se suma su coste, en caso contrario sumamos cero
		costeTotal+=salsaEspecial?PRECIO_SALSA_ESPECIAL:0;//Si se ha elegido la salsa, se suma su coste, en caso contrario sumamos cero

		System.out.println("El coste de su pedido es: "+costeTotal+"€");//Se muestra finalmente el coste del pedido del usuario
	}

	/**
	 * Metodo utilizado para elegir una opcion en el menu principal del usuario
	 */
	private static int elegirOpcionPrincipal() {
		return elegirEnteroEntre(1,4);//El usuario tiene que elegir una opcion entre 1 y 4
	}

	
	/**
	 * Metodo auxiliar que lee desde el teclado una opcion elegida por el usuario. Se comprueba que
	 * la eleccion elegida debe estar entre los parametros inicio y fin. Si la opcion no esta dentro
	 * del rango, se pregunta de nuevo al usuario. El valor inicio tiene que ser menor que fin.
	 * 
	 * @param inicio limite inferior del rango de valores permitido 
	 * @param fin limite superior del rango de valores permitido
	 * @return la eleccion seleccionada por el usuario. Sera un valor entre inicio y fin
	 */
	private static int elegirEnteroEntre(int inicio, int fin) {
		int eleccion;
		Scanner sc=new Scanner(System.in);
		eleccion=sc.nextInt();//Leemos por teclado la opcion del usuario
		while(eleccion<inicio || eleccion>fin) {//Mientras la eleccion este fuera del rango
			System.out.println("Eleccion incorrecta. Se debe seleccionar un numero entre "+inicio+" y "+fin);
			eleccion=sc.nextInt();//Se lee de nuevo la eleccion
		}
		return eleccion;
	}

	/**
	 * Metodo que muestra el menu principal del usuario
	 */
	private static void mostrarOpciones() {
		System.out.println("\nElige una opcion");
		System.out.println("\t1.- Elegir Menu principal");
		System.out.println("\t2.- Elegir Complementos");
		System.out.println("\t3.- Pagar");
		System.out.println("\t4.- Salir");

	}

}
