package aston.group17.model;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * JUnit test case for Pump class. Filling the pump queue, removing Drivers and testing if a Diver will fit
 * @author Kieran Gates
 *
 *@version 2017.5.4
 */
public class PumpTest {
	
	@Test
	public void testFillQueue()
	{
		Driver carDriver1 = new Driver("Car", 0);
		Driver carDriver2 = new Driver("Car", 0);
		Driver carDriver3 = new Driver("Car", 0);
		
		Pump pump = new Pump(1.2, 1);
		
		pump.addToPumpQueue(carDriver1);
		assertEquals(2.0, pump.getQueueFree(), 0.01);
		pump.addToPumpQueue(carDriver2);
		assertEquals(1.0, pump.getQueueFree(), 0.01);
		pump.addToPumpQueue(carDriver3);
		assertEquals(0.0, pump.getQueueFree(), 0.01);
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
