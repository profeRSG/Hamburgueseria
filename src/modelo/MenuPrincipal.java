package modelo;

import java.util.Objects;

/**
 * Clase utilizada para represetar un menu principal.
 * Los metodos basicos no se comentan (Constructores, getters y setters).
 * @author Raul SG
 *
 */
//TODO Si nos fijamos la clase MenuCompleto y Complemento, son muy parecidas. Usando herencia, 
//por lo que seria conveniente usar herencia. No lo he hecho, porque no lo hemos dado aun.
public class MenuPrincipal {
	
		//Constantes de la clase
		public static final double PRECIO_MENU_CLASSIC = 17;//Precio del menu classic
		public static final double PRECIO_MENU_AMERICANO = 18.5;//Precio del menu americano
		public static final String NOMBRE_AMERICANO="Americano";//Nombre del menu americano
		public static final String NOMBRE_CLASSIC="Classic";//Nombre del menu classic
		
		//ATRIBUTOS
		private String nombre;
		private double precio;
		
		
		//METODOS
		
		//Constructor con parametros
		public MenuPrincipal(String nombre, double precio) {
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



		/**
		 * Metodo para comparar un menu principal, con otro, y ser si son el mismo mennu o no.
		 * Se considera que un menu principal es igual que otro si su nombre es el mismo.
		 */
		@Override
		public boolean equals(Object obj) {
			boolean iguales=false;
			if (this == obj)
				iguales= true;
			else if (obj == null)
				iguales= false;
			else
				if (getClass() != obj.getClass())
				iguales= false;
				else {
					MenuPrincipal other = (MenuPrincipal) obj;
					iguales=nombre.equals(other.nombre);
				}
			return iguales;
		}
		
		

}
