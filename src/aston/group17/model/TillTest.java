package aston.group17.model;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * JUnit test case for the Till class. Tests money taken from Drivers and if the correct Driver is at the front of the queue
 * @author Kieran Gates
 * @author Mitch Feaver
 *
 *@version 2017.5.4
 */
public class TillTest {

	@Test
	public void testAddMoneyTaken() {
		Till till = new Till(1);
		
		till.addMoneyTaken(20.00);
		
		assertEquals(20.00, till.getMoneyTaken(), 0.01);
		
		till.addMoneyTaken(10.11);
		
		assertEquals(30.11, till.getMoneyTaken(), 0.01);
	}

	@Test
	public void testGetDriver()
	{
		Driver carDriver = new Driver("Car",0);
		Driver sedanDriver = new Driver("Sedan",0);
		
		Till till = new Till(1);
		
		till.addDriver(carDriver);
		
		assertEquals(carDriver, till.getFirstDriver());
		
		till.addDriver(sedanDriver);
		
		assertEquals(carDriver, till.getFirstDriver());
		
		till.removeDriver();
		
		assertEquals(sedanDriver, till.getFirstDriver());
	}
	
	@Test
	public void testGetQueueLength()
	{
		Driver carDriver = new Driver("Car",0);
		Driver sedanDriver = new Driver("Sedan",0);
		
		Till till = new Till(1);
		
		till.addDriver(carDriver);
		
		assertEquals(1, till.getQueueLength());
		
		till.addDriver(sedanDriver);
		
		assertEquals(2, till.getQueueLength());
		
		till.removeDriver();
		
		assertEquals(1, till.getQueueLength());
	}

}
