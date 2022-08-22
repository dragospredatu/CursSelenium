package curs2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {
	
	// 1. SoftAssertion
	// 2. HardAssertion
	
	//@Test
	public void softAssertion() {
		
		System.out.println("SoftAssertion incepe aici!");
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(false);
		System.out.println("SoftAssertion continua aici!");
		sa.assertEquals("12", "123");
		System.out.println("SoftAssertion se termina aici!");
		sa.assertAll();
	}
	
	@Test
	public void hardAssertion() {
		
		System.out.println("HardAssertion incepe aici!");
		assertTrue(false);
		System.out.println("HardAssertion continua aici");
		assertEquals("23", "234");
		System.out.println("HardAssertion se termina aici!");
	}

}
