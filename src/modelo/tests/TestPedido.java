package modelo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Complemento;
import modelo.MenuPrincipal;
import modelo.Pedido;

/**
 * Test unitarios de la clase Pedido
 * 
 * @author Raul Sanchez
 *
 */
class TestPedido {
	private Pedido testPedidoAmericano;
	private Pedido testPedidoVacio;

	@BeforeEach
	void setUp() throws Exception {
		//Creamos un menu americano con patatas y salsa
		MenuPrincipal americanoPrincipal=new MenuPrincipal(MenuPrincipal.NOMBRE_AMERICANO, MenuPrincipal.PRECIO_MENU_AMERICANO);
		Complemento patatas=new Complemento(Complemento.NOMBRE_PATATAS, Complemento.PRECIO_PATATAS);
		Complemento salsa=new Complemento(Complemento.NOMBRE_SALSA_ESPECIAL, Complemento.PRECIO_SALSA_ESPECIAL);
		
		testPedidoAmericano=new Pedido();
		testPedidoAmericano.addComplementoSolictado(patatas);
		testPedidoAmericano.setMenuSolicitado(americanoPrincipal);
		testPedidoAmericano.addComplementoSolictado(salsa);
		
		//Creamos un pedido vacio
		testPedidoVacio=new Pedido();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	//Queremos comprobar si el precio de un pedido al que no se le ha 
	//añadido ningun item es igual a cero
	void testGetPrecioPedidoVacio() {
		assertEquals(0, testPedidoVacio.getPrecio());
	}
	
	@Test
	//Queremos comprobar si el precio de un pedido al que se le ha añadido un
	//menu americano y patatas es el correcto
	void testGetPrecioPedidoAmericanoConPatatas() {
		assertEquals(MenuPrincipal.PRECIO_MENU_AMERICANO+Complemento.PRECIO_PATATAS+Complemento.PRECIO_SALSA_ESPECIAL, testPedidoAmericano.getPrecio());
	}
	

	
	@Test
	//Queremos comprobar si el precio se resetea con el metodo resetear valores
	void testResetearValores() {
		testPedidoAmericano.resetearValores();
		assertEquals(0, testPedidoAmericano.getPrecio());
		assertEquals(null, testPedidoAmericano.getMenuSolicitado());
	}
	
	@Test
	//Queremos comprobar si los complementos se resetean
	//No sumandose su valor al precio,
	//y quedando la array complementos con valores null
	void testResetComplementos() {
		
		testPedidoAmericano.resetComplementos();
		assertEquals(null, testPedidoAmericano.getComplementosSolicitados()[0]);//Comprobamos que el primer complemento
		//de la lista es null
		assertEquals(MenuPrincipal.PRECIO_MENU_AMERICANO, testPedidoAmericano.getPrecio());//
		//Al resetear la lista de complementos, el precio es igual al del menu solo.
	}
	
	@Test
	//Queremos comprobar si se añade correctamente un complemento
	void testAddComplemento()
	{
		
		Complemento patatas=new Complemento(Complemento.NOMBRE_PATATAS, Complemento.PRECIO_PATATAS);
		testPedidoVacio.addComplementoSolictado(patatas);
		
		assertEquals(null, testPedidoVacio.getComplementosSolicitados()[1]);
		assertEquals(Complemento.PRECIO_PATATAS, testPedidoVacio.getPrecio());
	}
}
