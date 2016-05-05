
import java.util.ArrayList;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class ShoppingCartTest {
	
	private ShoppingCart carrito;
	private Product[] productos;
	private int elementos;
	private double total;
		
	public ShoppingCartTest(Product[] datosiniciales, int numElementos,double total){
		super();
		carrito= new ShoppingCart();
		productos= datosiniciales;
		elementos= numElementos;
		this.total=total;
		for (int i = 0; i < productos.length; i++) {
			carrito.addItem(productos[i]);
		}

		
	}
	
	@Parameters
	public static ArrayList<Object []> parametrosCarro(){
		ArrayList<Object []> parametros = new ArrayList<Object[]>();
		
		Product p1 = new Product("Zapatos", 33);
		Product p2 = new Product("Zapatos2", 32);
		Product p3 = new Product("Zapatos3", 35);
		Product[] productos= new Product[3];
		productos[0]= p1;
		productos[1]= p2;
		productos[2]= p3;		
		
		Object [] datos= new Object[3];
		
		datos[0]=productos;
		datos[1]=3;
		datos[2]=100.0;
		
		parametros.add(datos);
		
		return parametros;
	}

	@Test
	public void testGetBalance() {

		Assert.assertEquals(total,carrito.getBalance(),0);
	}

	@Test
	public void testAddItem() {
		
	}

	@Test
	public void testRemoveItem() {
		System.out.println("numero elementos:"+carrito.getItemCount());
		int unidadesAntes=carrito.getItemCount();
		carrito.addItem(productos[0]);
		try {
			carrito.removeItem(productos[0]);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int unidadesDespues=carrito.getItemCount();
		Assert.assertEquals(unidadesDespues,unidadesAntes);

		carrito.addItem(productos[0]);
		carrito.addItem(productos[0]);
		try {
			carrito.removeItem(productos[0]);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carrito.addItem(productos[0]);
		Assert.assertEquals(unidadesDespues+2,unidadesAntes+2);
	}
	
	@Test(expected=ProductNotFoundException.class)
	public void testRemoveItemExcepcion() throws ProductNotFoundException {
		carrito.removeItem(new Product("Mesa", 22));
		
	}
	@Test
	public void testGetItemCount() {

	}

	@Test
	public void testEmpty() {

	}

	@Test
	public void testIsEmpty() {
		Assert.assertEquals(carrito.getItemCount(), 0);
	}

}
