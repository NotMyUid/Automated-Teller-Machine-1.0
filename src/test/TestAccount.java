package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Account;
import code.Euro;

class TestAccount {
	Account toTest;

	@BeforeEach
	public void initializedTest() {
		toTest = new Account(0000,1111,new Euro (1000),new Euro (1200));
	}
	
	@Test
	public void validatePINTest() {
		assertTrue(toTest.validatePIN(1111));
	}
	
	@Test
	public void creditTest() {
		toTest.credit(new Euro (1000));
		assertTrue(toTest.getTotalBalance().ugualeA(new Euro(2200)));
	}
	
	@Test
	public void debitTest() {
		toTest.debit(new Euro (1000));
		assertTrue(toTest.getAvailableBalance().ugualeA(new Euro(0)));
		assertTrue(toTest.getTotalBalance().ugualeA(new Euro(200)));
	}
	
	/////////////////////////////GETTERS/////////////////////////////////
	
	@Test
	public void getAvailableBalanceTest() {
		assertTrue(toTest.getAvailableBalance().ugualeA(new Euro(1000)));
	}
	
	@Test
	public void getTotalBalanceTest() {
		assertTrue(toTest.getTotalBalance().ugualeA(new Euro(1200)));
	}
	
	@Test
	public void getAccountNumberTest() {
		assertEquals(toTest.getAccountNumber(),0000);
	}

	/////////////////////////////////////////////////////////////////////
}
