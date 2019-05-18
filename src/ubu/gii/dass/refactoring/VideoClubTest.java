package ubu.gii.dass.refactoring;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1

 * 
 */
public class VideoClubTest {
	protected Movie m0, m11, m12, m2;
	protected Customer c1;
	protected Rental r1,r2,r3;
	
	@Before
	public void setUp() {
		m11 = new NewReleaseMovie("Sky Captain");
		m12 = new NewReleaseMovie("Alejandro Magno");
		m0 = new RegularMovie("Accion Mutante");
		m2 = new ChildrensMovie("Hermano Oso");

		c1 = new Customer("Manuel");
		
		r1 = new Rental(m11, 5);
		r2 = new Rental(m0, 1);
		r3 = new Rental(m2, 10);
		
		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testAlquiler() {
		String salida = c1.statement();

		String salidaEsperada = new String("Rental Record for Manuel\n"
				+ "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
				+ "\tHermano Oso\t12.0\n" + "Amount owed is 29.0\n"
				+ "You earned 4 frequent renter points");

		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));

	}
	
	@Test
	public void testAlquilerHtml() {
		String salida = c1.statementHtml();


		String salidaEsperada = new String("<H1>Rental Record for Manuel</H1>\n<P>\n"
				+ "\tSky Captain\t15.0<BR />\n" + "\tAccion Mutante\t2.0<BR />\n"
				+ "\tHermano Oso\t12.0<BR />\n</P>\n" + "<P>Amount owed is 29.0</P>\n"
				+ "<P>You earned 4 frequent renter points</P>");

		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));

	}

}
