package aston.group17.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testVehicleUnitSize() {
		//TODO add testing code that better tests a driver
		
		Driver carDriver = new Driver("Car",0);
		assertEquals(1.0 ,carDriver.getVehicle().getUnitSize(), 0.01);

		Driver bikeDriver = new Driver("Bike",0);
		assertEquals(0.75 ,bikeDriver.getVehicle().getUnitSize(), 0.01);

		Driver sedanDriver = new Driver("Sedan",0);
		assertEquals(1.5 ,sedanDriver.getVehicle().getUnitSize(), 0.01);

		Driver truckDriver = new Driver("Truck",0);
		assertEquals(2.0 ,truckDriver.getVehicle().getUnitSize(), 0.01);
	}
	
	@Test
	public void testRefillVehicle()
	{
		Driver carDriver = new Driver("Car",0);
		int bound = carDriver.getVehicle().getTankSize() - carDriver.getVehicle().getTankFilled() + 2;
		for(int i = 0; i < bound; i++)
		{
			carDriver.act(1.2);
		}
		assertEquals(true, carDriver.isDoneRefilling());
	}
	
	@Test
	public void testStillShoppingBike()
	{
		Driver bikeDriver = new Driver("Car", 0);
		int bound = bikeDriver.getVehicle().getTankSize() - bikeDriver.getVehicle().getTankFilled() + 2;
		for(int i = 0; i < bound; i++)
		{
			bikeDriver.act(1.2);
		}
		bikeDriver.act();
		assertEquals(true, bikeDriver.isDone());
	}
	
	@Test
	public void testStillShoppingCar()
	{
		Driver carDriver = new Driver("Car", 0);
		int bound = carDriver.getVehicle().getTankSize() - carDriver.getVehicle().getTankFilled() + 2;
		for(int i = 0; i < bound; i++)
		{
			carDriver.act(1.2);
		}
		carDriver.act();
		assertEquals(true, carDriver.isDone());
	}
	
}