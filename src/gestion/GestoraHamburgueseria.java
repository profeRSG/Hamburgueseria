package gestion;

import modelo.Complemento;
import modelo.MenuCompleto;
import modelo.MenuPrincipal;
import modelo.Pedido;

/**
 * Clase utilizada para controlar el programa de gestion de una hamburgueseria
 * 
 * @author Raul SG
 *
 */
public class GestoraHamburgueseria {

	
	private static Pedido pedidoSolicitado=new Pedido();//En este atributo almacenamos el pedido solicitado por el usuario
	//inicialmente es un pedido vacio
	private static MenuCompleto[] menusDeLaCartaDeLaHamburgueseria=inicializaMenusCompletosDeLaHamburgueseria();
	//Atributo en el que se almacena la carta de la hamburgueseria, es decir, el listado de menus
	//de la hamburgueseria que hay para elegir.

	/**
	 * Programa utilizado para comenzar el programa
	 */
	public static void iniciarPrograma() {
		int opcion;
		MenuUsuario menuPrincipal=new MenuUsuario("Elige una opcion");//Creamos el menu de usuario principal, con sus 4 opciones.
		menuPrincipal.addOpcion("Elegir Menu principal");//Agregamos una opcion
		menuPrincipal.addOpcion("Elegir Complementos");//Agregamos una opcion
		menuPrincipal.addOpcion("Pagar");//Agregamos una opcion
		menuPrincipal.addOpcion("Salir");//Agregamos una opcion

		do {
			System.out.println(menuPrincipal);//Mostramos el menu principal
			opcion=menuPrincipal.elegirOpcion();//El usuario elige una opcion del menu principal

			switch (opcion) {
			case 1-> 
			seleccionarMenuPrincipal();//Si se elige la primera opcion, se elige un menu principal
			case 2-> 
			seleccionarComplementos();//Si se elige un 2, se seleccionara los complementos
			case 3-> 
			pagar();//La opcion 3, es para pagar
			}
		}while(opcion!=4);//Si se elige la opcion 4, se acaba el programa
	}

	/**
	 * Metodo utilizado para seleccionar los complementos
	 */
	private static void seleccionarComplementos() {
		if(pedidoSolicitado.getMenuSolicitado()==null) {//Si no se ha elegido un menu previamente
			System.out.println("Se debe elegir un menu principal, antes de los complementos");
		}			
		else{//Se ha elegido un menu previamente
			pedidoSolicitado.resetComplementos();//Se resetea lo que se habia seleccionado anteriormente
			Complemento[] complementosQueSePuedenElegir=getComplementosDelMenu();//Se obtiene los complementos
			//que tiene el menu principal solicitado
			boolean seguirMostrando=true;
			for(int i=0;i<complementosQueSePuedenElegir.length && seguirMostrando;i++) {//Para cada complemento
				Complemento complementoQueSePuedeElegir=complementosQueSePuedenElegir[i];
				if(complementoQueSePuedeElegir!=null) {//Si hay un complemento
					seleccionarComplemento(complementosQueSePuedenElegir[i]); //Se pregunta al usuario si quiere 
					//elegir el complemento
				}
				else {
					seguirMostrando=false;//Si no hay mas complementos, se detiene el bucle.
				}
			}
		}
	}

	/**
	 * Metodo que devuelve los posibles complementos que hay para el menu principal elegido por el usuario
	 * @return arrays con los complementso disponibles para el menu principal que se ha seleccionado
	 */
	private static Complemento[] getComplementosDelMenu() {
		boolean encontrado=false;
		Complemento[] resultado=null;
		for(int i=0;i<menusDeLaCartaDeLaHamburgueseria.length && !encontrado;i++) {//Se examinan todos los menus de la carta,
			//para buscar cual es el que es igual al menu principal que tenemos en el pedido 
			MenuPrincipal menuDeLaCarta=menusDeLaCartaDeLaHamburgueseria[i].getMenu();//Se ve el menu de la carta
			MenuPrincipal menuSolicitado=pedidoSolicitado.getMenuSolicitado();//Se obtiene el menu del pedido
			if(menuDeLaCarta.equals(menuSolicitado)) {//Si son el mismo menu
				resultado=menusDeLaCartaDeLaHamburgueseria[i].getPosiblesComplementos();//Obtenemos los posibles complementos para dicho menu
				encontrado=true;//Utilizamos esta variable para detener el bucle, y dejar de buscar
			}
		}
		return resultado;//Devolvemos el listado de posibles complementos
	}

	/**
	 * El metodo permite mostrar el menu de usuario, y elegir si se quiere un complemento
	 * @param complemento sobre el que se va a preguntar, si se quiere seleccionar
	 */
	private static void seleccionarComplemento(Complemento complemento) {
		int opcion;
		//Creamos el menu para el complemento pasado como parametro
		MenuUsuario menuParaElegirComplemento=new MenuUsuario("¿Quieres "+complemento.getNombre()+"?");
		menuParaElegirComplemento.addOpcion("Si");
		menuParaElegirComplemento.addOpcion("No");
		System.out.println(menuParaElegirComplemento);//Mostramos el menu
		opcion=menuParaElegirComplemento.elegirOpcion();//El usuario elige una de las dos opciones
		if(opcion==1)//Si elegie que quiere el complemento
			pedidoSolicitado.addComplementoSolictado(complemento);//Se agrega el complemento al pedido

	}

	/**
	 * Metodo utilizado para pagar. Cuando se paga se muestra por pantalla el 
	 * coste del pedido, y el pedido se deja vacio, para poder empezar de nuevo.
	 */
	private static void pagar() {
		System.out.println("El coste de su pedido es: "+pedidoSolicitado.getPrecio());//Se muestra el coste total
		pedidoSolicitado.resetearValores();//Se resetea el pedido para poder volver a empezar
	}

	/**
	 * Metodo utilizado para crear la carta completa de la hamburgueseria, es decir, el listado de menus
	 * que hay disponibles para que los pueda seleccionar el usuario. Inicialmente tenemos el 
	 * menu amerciano, con patatas y salsa especial como complementos
	 * y el menu clasico, con patatas como complemento.
	 * @return devuelve un array con los menus completos creados
	 */
	private static MenuCompleto[] inicializaMenusCompletosDeLaHamburgueseria() {
		MenuCompleto[] menus=new MenuCompleto[2];//Creamos una array de menus completos, con tamaño 2
		MenuCompleto americano;//Declaramos una variable para guardar los datos del menu americano
		MenuCompleto classic;//Declaramos una variable para guardar los datos del menu classic
		americano=creaMenuAmericano();//Creamos el menu americano
		classic=crearMenuClassic();//Creamos el menu clasico
		menus[0]=americano;//Añadimos el menu americano en la primera posicion
		menus[1]=classic;//Añadimos el menu clasico en la segunda posicion
		return menus;
	}



	/**
	 * El metodo devuelve un menu completo con los datos del menu classic
	 * 
	 * @return Menu con los datos del menu classic
	 */
	private static MenuCompleto crearMenuClassic() {
		MenuCompleto classicCompleto=new MenuCompleto();
		MenuPrincipal classicPrincipal=new MenuPrincipal(MenuPrincipal.NOMBRE_CLASSIC, MenuPrincipal.PRECIO_MENU_CLASSIC);
		Complemento patatas=new Complemento(Complemento.NOMBRE_PATATAS, Complemento.PRECIO_PATATAS);
		classicCompleto.setMenu(classicPrincipal);
		classicCompleto.addPosibleComplemento(patatas);
		return classicCompleto;
	}
	
	/**
	 * El metodo devuelve un menu completo con los datos del menu americano
	 * 
	 * @return Menu con los datos del menu classic
	 */
	private static MenuCompleto creaMenuAmericano() {
		MenuCompleto americanoCompleto=new MenuCompleto();
		MenuPrincipal americanoPrincipal=new MenuPrincipal(MenuPrincipal.NOMBRE_AMERICANO, MenuPrincipal.PRECIO_MENU_AMERICANO);
		Complemento patatas=new Complemento(Complemento.NOMBRE_PATATAS, Complemento.PRECIO_PATATAS);
		Complemento salsaEspecial=new Complemento(Complemento.NOMBRE_SALSA_ESPECIAL, Complemento.PRECIO_SALSA_ESPECIAL);
		americanoCompleto.setMenu(americanoPrincipal);
		americanoCompleto.addPosibleComplemento(patatas);
		americanoCompleto.addPosibleComplemento(salsaEspecial);
		return americanoCompleto;
	}

	/**
	 * Metodo que permite al usuario elegir el menu principal
	 */
	private static void seleccionarMenuPrincipal() {
		int opcion;
		if(pedidoSolicitado.getMenuSolicitado()!=null) {//Si ya se ha elegido un menu anteriormente
			System.out.println("Ya se ha seleccionado un menu");
		}
		else {//Si es la primera vez que se elige un usuario
			MenuUsuario menuParaElegirMenu=new MenuUsuario("¿Que menu quiere?");//Creamos un objeto menu de usuario
			//para elegir el menu principal
			for(int i=0;i<menusDeLaCartaDeLaHamburgueseria.length;i++) {//Como opciones posibles agregamos los menus  que
				//hay en la carta
				MenuCompleto menuDeLaHamburgueseria=menusDeLaCartaDeLaHamburgueseria[i];//Obtenemos un menu
				menuParaElegirMenu.addOpcion(menuDeLaHamburgueseria.getNombre());//y lo agregamos como
				//una opcion del menu a elegir
			}//fin del bucle
			System.out.println(menuParaElegirMenu);//mostramos el menu
			opcion=menuParaElegirMenu.elegirOpcion();//El usuario elige un menu entre los que se les muestra por pantalla
			pedidoSolicitado.setMenuSolicitado(menusDeLaCartaDeLaHamburgueseria[opcion-1].getMenu());
			//El menu seleccionado se agrega al pedido solicitado. El menu seleccionado estara en la carta, en la posicion
			//igual a la opcion seleccionada - 1. Del menu completo, se obtiene el menu princpal, y se guarda en el pedido.
		}
	}

}
