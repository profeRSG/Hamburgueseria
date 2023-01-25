package modelo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Complemento;
import modelo.MenuCompleto;
import modelo.MenuPrincipal;

/**
 * Test unitarios de la clase MenuCompleto
 * 
 * @author Raul Sanchez
 *
 */
class TestMenuCompleto {
	private MenuCompleto classicCompleto;
	private MenuCompleto americanoCompleto;

	@BeforeEach
	void setUp() throws Exception {
			//Creamos el caso de prueba del menu classic
			classicCompleto=new MenuCompleto();
			MenuPrincipal classicPrincipal=new MenuPrincipal(MenuPrincipal.NOMBRE_CLASSIC, MenuPrincipal.PRECIO_MENU_CLASSIC);
			classicCompleto.setMenu(classicPrincipal);
		
			//Creamos el caso de prueba del menu americano
			americanoCompleto=new MenuCompleto();
			MenuPrincipal americanoPrincipal=new MenuPrincipal(MenuPrincipal.NOMBRE_AMERICANO, MenuPrincipal.PRECIO_MENU_AMERICANO);
			americanoCompleto.setMenu(americanoPrincipal);
			
			
		}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	//Comprobamos como se añade un complemento al menu completo
	void testAddPosibleComplementoClassic() {
		Complemento patatas=new Complemento(Complemento.NOMBRE_PATATAS, Complemento.PRECIO_PATATAS);
		classicCompleto.addPosibleComplemento(patatas);
		
		assertEquals(patatas, classicCompleto.getPosiblesComplementos()[0]);
		assertEquals(null, classicCompleto.getPosiblesComplementos()[1]);
	}
	
	@Test
	//Comprobamos como se añade dos complementos al menu completo
	void testAddPosibleComplementoAmericano() {
		Complemento patatas=new Complemento(Complemento.NOMBRE_PATATAS, Complemento.PRECIO_PATATAS);
		americanoCompleto.addPosibleComplemento(patatas);
		Complemento salsaEspecial=new Complemento(Complemento.NOMBRE_SALSA_ESPECIAL, Complemento.PRECIO_SALSA_ESPECIAL);
		americanoCompleto.addPosibleComplemento(salsaEspecial);
		
		assertEquals(patatas, americanoCompleto.getPosiblesComplementos()[0]);
		assertEquals(salsaEspecial, americanoCompleto.getPosiblesComplementos()[1]);
	}

}
