package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.BankDatabase;
import code.Euro;

class TestBankDatabase {
	BankDatabase bdb;
	
	@BeforeEach
	public void initializedTest(){
		bdb = new BankDatabase();		
	}

	@Test
	public void authenticateUserTest() {
		assertTrue(bdb.authenticateUser(12345, 54321));
		assertTrue(bdb.authenticateUser(98765, 56789));
	}
	
	@Test
	public void getAvailableBalanceTest() {
		assertTrue(bdb.getAvailableBalance(12345).ugualeA(new Euro(1000)) );
		assertTrue(bdb.getAvailableBalance(98765).ugualeA(new Euro(200)) );
	}
	
	@Test
	public void getTotalBalanceTest() {
		assertTrue(bdb.getTotalBalance(12345).ugualeA(new Euro(1200)) );
		assertTrue(bdb.getTotalBalance(98765).ugualeA(new Euro(200)) );
	}
	
	@Test
	public void creditTest() {
		bdb.credit(12345, new Euro(150));
		bdb.credit(98765, new Euro(200));
		assertTrue(bdb.getTotalBalance(12345).ugualeA(new Euro(1350)) );
		assertTrue(bdb.getTotalBalance(98765).ugualeA(new Euro(400)) );
	}
	
	@Test
	public void debitTest() {
		bdb.debit(12345, new Euro(150));
		bdb.debit(98765, new Euro(200));
		assertTrue(bdb.getTotalBalance(12345).ugualeA(new Euro(1050)) );
		assertTrue(bdb.getAvailableBalance(12345).ugualeA(new Euro(850)) );

		assertTrue(bdb.getTotalBalance(98765).ugualeA(new Euro(0)) );
		assertTrue(bdb.getAvailableBalance(98765).ugualeA(new Euro(0)) );

	}

}
