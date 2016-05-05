

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class ShoppingCartTest {

	ShoppingCart carrito;
	

	public ShoppingCartTest(Product datosIniciales[],int numElemenAnadidos) {
		super();

	}
	
	@Parameters
	public static ArrayList<Object []> parametros()
	{
		ArrayList<Object []> parametrosDelConstructor=new ArrayList<Object []>();
		Object [] primerTesteo=new Object [2];
		Product p1=new Product("gorras1", 33);
		Product p2=new Product("peines1", 34);
		Product p3=new Product("peinetas1", 35);
		Product productosIniciales[]=new Product[4];
		productosIniciales[0]=p1;
		productosIniciales[1]=p2;
		productosIniciales[2]=p3;
		primerTesteo[0]=productosIniciales;
		primerTesteo[1]=3;
		
		return parametrosDelConstructor;
		
	}
	

	@Test
	public void testGetBalance() {

	}
	
	@Before
	public void inicializacionPersonalizadaPorMi()
	{
		carrito=new ShoppingCart();
		Product p1=new Product("gorras", 33);
		Product p2=new Product("peines", 34);
		Product p3=new Product("peinetas", 35);
		Product p4=new Product("zapatos", 35);
		carrito.addItem(p1);
		carrito.addItem(p2);
		carrito.addItem(p3);
		carrito.addItem(p4);
	}
	
	@Test
	public void testAddItem() {
		Product p1=new Product("zapatillas", 33);
		Product p2=new Product("zapatillas2", 34);
		Product p3=new Product("zapatillas3", 35);
		
		int numProductosInicial=carrito.getItemCount();
		carrito.addItem(p1);
		carrito.addItem(p2);
		carrito.addItem(p3);
		int numProductosActual=carrito.getItemCount();
		Assert.assertEquals(numProductosInicial+3, numProductosActual);
		
		try {
			carrito.removeItem(p2);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(numProductosInicial+2, numProductosActual);
		
		
	}
	


	

	@Test
	public void testRemoveItem() {

	}

	@Test
	public void testGetItemCount() {

	}

	@Test
	public void testEmpty() {

	}

	@Test
	public void testIsEmpty() {

	}

}
