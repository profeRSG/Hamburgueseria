package modelo;


/**
 * Clase que representa un menu completo. Los menus completos se van a componer de un menu principal, y un listado
 * de posibles complementos que se pueden elegir para dicho menu.
 * Por ejemplo, para el menu americano, sus posibles complementos van a  ser patatas y salsa especial.
 * Los metodos basicos no se comentan.
 * @author Raul SG
 *
 */
public class MenuCompleto {
	
	//ATRIBUTOS
	private MenuPrincipal menu;
	private Complemento[] posiblesComplementos;//TODO Seria mejor utilizar ArrayList
	public static final int NUMERO_MAXIMO_COMPLEMENTOS=2;
	private int i;//Indice que apunta al hueco de la array posiblesComplementos donde se 
	//va a agregar el proximo complemento
	
	
	//Constructor
	public MenuCompleto() {
		this.posiblesComplementos=new Complemento[NUMERO_MAXIMO_COMPLEMENTOS];
		i=0;
	}


	public MenuPrincipal getMenu() {
		return menu;
	}


	public void setMenu(MenuPrincipal menu) {
		this.menu = menu;
	} 
	
	/**
	 * Metodo para agregar a un menu, un posible complemento para elegir en el menu
	 * @param complemento que se quiere añadir al listado de posibles complementos
	 * @return devuelve true si se ha añadido el complemento satisfactoriamente, y devuelve false si
	 * no se ha podido agregar el complemento. Esto puede pasar, si el menu completo tiene ya el maximo numero de 
	 * posibles complementos permitido, y por tanto no se pueden añadir mas complementos
	 */
	public boolean addPosibleComplemento(Complemento complemento) {
		boolean agregado=false;
		if(i<NUMERO_MAXIMO_COMPLEMENTOS) {
			this.posiblesComplementos[i]=complemento;//guardamos el nuevo complemento
			i++;//Incrementamos el indice, para que apunte al siguiente hueco de la array.
			agregado=true; //Se indica que se ha añadido el nuevo complemento
		}
		return agregado;//Se devuelve si se ha agregado el complemento o no.
	}


	public Complemento[] getPosiblesComplementos() {
		return posiblesComplementos;
	}


	public String getNombre() {
		return menu.getNombre();
	}
	
	
	
}
