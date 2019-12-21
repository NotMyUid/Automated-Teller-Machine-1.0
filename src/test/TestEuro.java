package test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Euro;

class TestEuro {
	Euro amount1,amount2;
	
	@BeforeEach
	public void initializedTest(){
		amount1 = new Euro(1);
		amount2 = new Euro(2,50);		
	}
	
	@Test
	public void getValore1Test() {
		assertEquals(amount1.getValore(),100);
	}
	
	@Test
	public void getValore2Test() {
		assertEquals(amount2.getValore(),250);
	}
	
	@Test
	public void sumTest() {
		assertEquals((amount1.somma(amount2)).getValore(),350);
	}
	
	@Test
	public void subTest() {
		assertEquals((amount2.sottrai(amount1)).getValore(),150);
	}
	
	@Test
	public void equalsTest() {
		assertTrue(amount1.ugualeA(new Euro(1)));
	}
	
	@Test
	public void lessTest() {
		assertTrue(amount1.minoreDi(amount2));
	}
	
	@Test
	public void printTest() {
		assertEquals(amount1.stampa(),"1.0 euro");
	}

}
