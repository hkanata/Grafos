package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Routers;

import org.junit.Before;
import org.junit.Test;

/*
 * Alguns testes da classe routers
 * */

public class TestRouters {

	Routers routers;

	@Before
	public void setUp() throws Exception {
		routers = new Routers();
	}

	/*
	 * Teste de distancia
	 * */
	@Test
	public void testCheckDistanceAtoB() {

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("AB");
		arrayList.add("BC");

		String ret = routers.checkDistance(arrayList);
		assertEquals(
				"Rota: AB Distance: 5 Rota: BC Distance: 4 Total: 9".trim(),
				ret.trim());
	}

	/*
	 * Distancia vazia
	 * */
	@Test
	public void testCheckDistanceAtoEmpty() {

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("CC");
		arrayList.add("");

		String ret = routers.checkDistance(arrayList);
		assertEquals("no such ROUTE".trim(), ret.trim());
	}

	/*
	 * Limite de viagem
	 * */
	@Test
	public void testTripLimit() {

		String ret = routers.tripLimit("C", "C", 3);
		assertEquals(
				"Number of Trips is: 2 :::  Rota: CE Distance: 2 Rota: EB Distance: 3 Rota: BC Distance: 4 Total: 9"
						.trim(), ret.trim());
	}
	
	/*
	 * maior Viagem limit alto
	 * */
	@Test
	public void testTripLimitStrongestLimit() {

		String ret = routers.tripLimit("C", "C", 300);
		assertEquals(
				"Number of Trips is: -1 :::  Total: 0"
						.trim(), ret.trim());
	}
	
	/*
	 * Outros destinos
	 * */
	@Test
	public void testTripLimitAnotherLetter() {

		String ret = routers.tripLimit("A", "C", 2);
		assertEquals(
				"Number of Trips is: -1 :::  Total: 0"
						.trim(), ret.trim());
	}
	
	/*
	 * String do teste muito extensa
	@Test
	public void testMostShortest() {

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("CC");
		arrayList.add("DC");
		
		String ret = routers.mostShortest("T", "C");
		System.out.println(ret);
		assertEquals(
				" Rota: AB Distance: 5 Rota: BC Distance: 4 Total: 9"+
				" Rota: AD Distance: 5 Rota: DC Distance: 8 Total: 13"+
				" Rota: AE Distance: 7 Rota: EB Distance: 3 Rota: BC Distance: 4 Total: 14"
						.trim(), ret.trim());
	}*/
	
	/*
	 * String do teste muito extensa
	@Test
	public void testTripStartsEnds() {

		String ret = routers.tripStartsEnds("A", "C", 3);
		System.out.println(ret);
		assertEquals(
				" Rota: AB Distance: 5 Rota: BC Distance: 4 Total: 9"+
				" Rota: AD Distance: 5 Rota: DC Distance: 8 Total: 13"+
				" Rota: AE Distance: 7 Rota: EB Distance: 3 Rota: BC Distance: 4 Total: 14"
						.trim(), ret.trim());
	}
	*/
	
	/*
	 * String do teste muito extensa
	@Test
	public void testGetRouterLessThan() {

		String ret = routers.getRouterLessThan("C", "C", 30);
		System.out.println(ret);
		assertEquals(
				" Rota: AB Distance: 5 Rota: BC Distance: 4 Total: 9"+
				" Rota: AD Distance: 5 Rota: DC Distance: 8 Total: 13"+
				" Rota: AE Distance: 7 Rota: EB Distance: 3 Rota: BC Distance: 4 Total: 14"
						.trim(), ret.trim());
	}
	*/
	
	
	
}
