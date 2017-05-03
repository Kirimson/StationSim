package aston.group17.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PumpTest {
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testFillQueue()
	{
		Driver carDriver1 = new Driver("Car", 0);
		Driver carDriver2 = new Driver("Car", 0);
		Driver carDriver3 = new Driver("Car", 0);
		
		Pump pump = new Pump(1.2, 1);
		
		pump.addToPumpQueue(carDriver1);
		assertEquals(pump.getQueueFree(), 2.0, 0.01);
		pump.addToPumpQueue(carDriver2);
		assertEquals(pump.getQueueFree(), 1.0, 0.01);
		pump.addToPumpQueue(carDriver3);
		assertEquals(pump.getQueueFree(), 0.0, 0.01);
	}
	
	@Test
	public void testRemoveDriver()
	{
		Driver carDriver1 = new Driver("Car", 0);
		Driver carDriver2 = new Driver("Car", 0);
		Driver carDriver3 = new Driver("Car", 0);
		
		Pump pump = new Pump(1.2, 1);
		
		pump.addToPumpQueue(carDriver1);
		pump.addToPumpQueue(carDriver2);
		pump.addToPumpQueue(carDriver3);
		
		pump.removeDriver();
		assertEquals(pump.getFirstDriver(), carDriver2);
		pump.removeDriver();
		assertEquals(pump.getFirstDriver(), carDriver3);
		pump.removeDriver();
		assertEquals(pump.getFirstDriver(), null);
	}

	@Test
	public void testWillFit()
	{
		Driver carDriver = new Driver("Car", 0);
		Driver truckDriver = new Driver("Truck", 0);
		Driver bikeDriver = new Driver("Bike", 0);
		Pump pump = new Pump(1.2, 1);
		
		assertEquals(true, pump.willVehicleFit(truckDriver.getVehicle().getUnitSize()));
		pump.addToPumpQueue(truckDriver);
		System.out.println("b"+pump.getQueueFree());
		assertEquals(true, pump.willVehicleFit(bikeDriver.getVehicle().getUnitSize()));
		pump.addToPumpQueue(carDriver);
		System.out.println("a"+pump.getQueueFree());
		assertEquals(false, pump.willVehicleFit(bikeDriver.getVehicle().getUnitSize()));
	}
}
