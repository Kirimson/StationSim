package aston.group17.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testUnitSize() {
		Driver carDriver = new Driver("Car");
		assertEquals("Check the drivers vehicle is correct", "Car", carDriver.getVehicleType());
		
		Driver sedanDriver = new Driver("Sedan");
		assertEquals("Check the drivers vehicle is correct", "Sedan", sedanDriver.getVehicleType());
		
		Driver bikeDriver = new Driver("Bike");
		assertEquals("Check the drivers vehicle is correct", "Bike", bikeDriver.getVehicleType());
		
		Driver truckDriver = new Driver("Truck");
		assertEquals("Check the drivers vehicle is correct", "Truck", truckDriver.getVehicleType());
	}
	
	
}