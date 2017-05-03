package aston.group17.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testJoinQueue() {
		int globalSeed = 0;
		Station s = new Station(3, 3, 1.2);
		
		Driver carDriver = new Driver("Car", globalSeed);
		
		s.addDriverToPumpQueue(carDriver);
		
		ArrayList<Driver> driverQueue1 = s.getPump(0).getVehicleQueue();
		
		System.out.println("c1:"+carDriver.getVehicle().toString());
		System.out.println("v1:"+driverQueue1.get(0).getVehicle().toString());
		
		
		Driver sedanDriver = new Driver("Sedan", globalSeed);
		
		s.addDriverToPumpQueue(sedanDriver);
		
		ArrayList<Driver> DriverQueue2 = s.getPump(1).getVehicleQueue();
		
		if(!driverQueue1.get(0).getVehicle().toString().equals(carDriver.getVehicle().toString()))
		{
			fail();
		}
		
		if(!DriverQueue2.get(0).getVehicle().toString().equals(sedanDriver.getVehicle().toString()))
		{
			fail();
		}
		
	}
	
	@Test
	public void testFullQueue()
	{
		int globalSeed = 0;
		Station s = new Station(1, 1, 1.2);

		ArrayList<Driver> carDrivers = new ArrayList<Driver>();
		
		for(int i = 0; i < 4; i++)
		{
			carDrivers.add(new Driver("Car", globalSeed));
		}
		
		for(Driver d: carDrivers)
		{
			s.addDriverToPumpQueue(d);
		}
	}
	
	@Test
	public void testMultiplePumpFull()
	{
		int globalSeed = 0;
		Station s = new Station(2, 1, 1.2);
		
		ArrayList<Driver> sedanDrivers = new ArrayList<Driver>();
		
		for(int i = 0; i < 5; i++)
		{
			sedanDrivers.add(new Driver("Sedan", globalSeed));
		}
		
		for(Driver d: sedanDrivers)
		{
			s.addDriverToPumpQueue(d);
			System.out.println(findVehicle(s, d));
			}
		}
	
	private String findVehicle(Station s, Driver d)
	{
		int i = 0;
		for(Pump p : s.getPumpArray())
		{
			if(p.getVehicleQueue().contains(d))
			{
				return "pump: "+i;
			}
			i++;
		}
		return "Not in pump";
	}
}
