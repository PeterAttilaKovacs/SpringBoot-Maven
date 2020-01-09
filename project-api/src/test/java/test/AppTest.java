/**
 * Basic AppTest on TesztController
 * Result: 1/1 - Ok
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.TesztController;

public class AppTest {

	/**
	 * Test for TesztController
	 */
	@Test
	public void test() {
		TesztController testController = new TesztController();
		String resault = testController.controllerTest();
		assertEquals(resault, "Controller works.");
		//fail("Not yet implemented");
	}

}
