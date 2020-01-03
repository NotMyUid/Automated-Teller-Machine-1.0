package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Account;
import code.Euro;

class TestAccount {
	Account toTest;
	Euro avl,tot;

	@BeforeEach
	public void initializedTest() {
		avl = new Euro (2222);
		tot = new Euro (3333);
		toTest = new Account(0000,1111,avl,tot);
	}
	
	@Test
	public void validatePINTest() {
		assertTrue(toTest.validatePIN(1111));
	}
	
	@Test
	public void creditTest() {
		toTest.credit(avl);
		assertEquals(toTest.getTotalBalance().getValore(),555500);
	}
	
	@Test
	public void debitTest() {
		toTest.debit(avl);
		assertEquals(toTest.getAvailableBalance().getValore(),0);
		assertEquals(toTest.getTotalBalance().getValore(),333300);
	}
	
	/////////////////////////////GETTERS/////////////////////////////////
	
	@Test
	public void getAvailableBalanceTest() {
		assertEquals(toTest.getAvailableBalance().getValore(),222200);
	}
	
	@Test
	public void getTotalBalanceTest() {
		assertEquals(toTest.getTotalBalance().getValore(),333300);
	}
	
	@Test
	public void getAccountNumberTest() {
		assertEquals(toTest.getAccountNumber(),0000);
	}

	/////////////////////////////////////////////////////////////////////
}
