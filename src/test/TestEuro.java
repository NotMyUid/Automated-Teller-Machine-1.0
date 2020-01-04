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
	public void getValoreTest() {
		assertEquals(amount1.getValore(),100);
		assertEquals(amount2.getValore(),250);
	}
	
	@Test
	public void equalsTest() {
		assertTrue(amount1.ugualeA(new Euro(1)));
		assertTrue(amount2.ugualeA(new Euro(2,50)));
	}
	
	@Test
	public void sumTest() {
		amount1.somma(amount2);
		assertTrue(amount1.ugualeA(new Euro(3,50)));
	}
	
	@Test
	public void subTest() {
		amount2.sottrai(amount1);
		assertTrue(amount2.ugualeA(new Euro(1,50)));
	}
	
	@Test
	public void lessTest() {
		assertTrue(amount1.minoreDi(amount2));
	}
	
	@Test
	public void printTest() {
		assertEquals(amount1.stampa(),"1.0 euro");
		assertEquals(amount2.stampa(),"2.5 euro");

	}

}
