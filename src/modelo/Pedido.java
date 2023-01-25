package modelo;

/**
 * Clase utilizada para representar el pedido de un usuario. El pedido de un usuario
 * va a constar de un menuprincipal, y una lista de complementos. Inicialmente
 * el máximo de complementos sera 2, pero se ha creado una constante, por si se 
 * quiere modificar dicho numero en el futuro.
 * 
 * @author Raul SG
 *
 */
public class Pedido {

	//ATRIBUTOS
	private MenuPrincipal menuPrincipalSolicitado;
	private Complemento[] complementosSolicitados;
	public static final int NUMERO_MAXIMO_COMPLEMENTOS=2;
	private int i;//Indice que apunta al hueco de la array posiblesComplementos donde se 
	//va a agregar el proximo complemento
	//TODO seria mas interesante sustituir la array de complementos, por un arraylist. En dicho caso
	//no haria falta el atributo i.
	
	
	
	//METODOS
	
	/**
	 *  Constructor sin parametros. Crea un pedido sin menu principal
	 *  y sin complementos.
	 */
	public Pedido() {
		this.complementosSolicitados=new Complemento[NUMERO_MAXIMO_COMPLEMENTOS];
		i=0;
	}


	/**
	 * Get del menu principal solicitado
	 * @return devuelve el menu principal del pedido
	 */
	public MenuPrincipal getMenuSolicitado() {
		return menuPrincipalSolicitado;
	}


	/**
	 * Set del menu principal
	 * @param menu establevce como menu principal, el menu pasado como parametro.
	 */
	public void setMenuSolicitado(MenuPrincipal menu) {
		this.menuPrincipalSolicitado = menu;
	} 
	
	
	/**
	 * Metodo utilizado para añadir complementos a un pedido. 
	 * 
	 * @param complemento Se añadira al pedido
	 * @return devuelve true si se ha añadido el complemento satisfactoriamente, y devuelve false si
	 * no se ha podido agregar el complemento. Esto puede pasar, si el pedido tiene ya el maximo numero de 
	 * complementos permitido, y por tanto no se pueden añadir mas complementos
	 */
	public boolean addComplementoSolictado(Complemento complemento) {
		boolean agregado=false;
		if(i<NUMERO_MAXIMO_COMPLEMENTOS) {//Si la array no esta completa
			this.complementosSolicitados[i]=complemento;//guardamos el nuevo complemento
			i++;//Incrementamos el indice, para que apunte al siguiente hueco de la array.
			agregado=true; //Se indica que se ha añadido el nuevo complemento
		}
		return agregado;//Se devuelve si se ha agregado el complemento o no.
	}


	/**
	 * Get del complemento solicitado
	 * @return el atributo complemento solicitado
	 */
	public Complemento[] getComplementosSolicitados() {
		return complementosSolicitados;
	}
	
	/**
	 * Metodo que devuelve el coste total del pedido, sumando el precio del menu principal
	 * y de los complementos agregados.
	 * 
	 * @return precio del pedido
	 */
	public double getPrecio() {
		
		double precioTotal=menuPrincipalSolicitado!=null?menuPrincipalSolicitado.getPrecio():0;
		//El precio es igual al precio del pedido solictado, si el pedido es igual a null, el valor devuelto es cero.
		for(int i=0;i<this.i;i++) {//REcorremos los complementos que tiene el pedido
			//y por cada complemento del pedido
			Complemento complementoSolicitado=complementosSolicitados[i];//Obtenemos el complemento
			precioTotal+=complementoSolicitado.getPrecio();//Sumamos su precio al total
		}
		return precioTotal;//devolvemos el precio calculado.
	}


	/**
	 * Metodo utilizado para resetear un pedido, dejandolo sin items seleccionados.
	 * El menu principal sera igual a null, y los complementos solicitados, igual a una array vacia.
	 */
	public void resetearValores() {
		menuPrincipalSolicitado=null;
		this.complementosSolicitados=new Complemento[NUMERO_MAXIMO_COMPLEMENTOS];
		i=0;
		
	}


	/**
	 * Metodo utilizado para resetear los complementos de un pedido.
	 */
	public void resetComplementos() {
		complementosSolicitados=new Complemento[NUMERO_MAXIMO_COMPLEMENTOS];//Se crea una array
		//nueva de complementos, con el tamaño maximo indicado por la constante.
		i=0;//El indice se reinicia a cero
	}
	
	
}
