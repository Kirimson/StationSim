package aston.group17.simulator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimulatorTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testUnitSize() {
		Simulator s = new Simulator(0.01, 0.01, 1, 1, 1.20, true, 0); // int numSteps, double p, double q, int pumps, int tills, double price
		
//		assertEquals("Check unit space is correct", 1.0, carTest.getUnitSize(), 1e-4);

		
	}
}