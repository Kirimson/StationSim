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
		Station s = new Station(3, 3);
		
		Driver carDriver = new Driver("Car");
		
		s.addDriverToPumpQueue(carDriver);
		
		ArrayList<Vehicle> vp1 = s.getPump(0).getVehicleQueue();
		
		System.out.println("c1:"+carDriver.getVehicle().toString());
		System.out.println("v1:"+vp1.get(0).toString());
		
		
		Driver sedanDriver = new Driver("Sedan");
		
		s.addDriverToPumpQueue(sedanDriver);
		
		ArrayList<Vehicle> vp2 = s.getPump(1).getVehicleQueue();
		System.out.println();
		System.out.println("c2:"+sedanDriver.getVehicle().toString());
		System.out.println("v2:"+vp2.get(0).toString());
		
		if(!vp1.get(0).toString().equals(carDriver.getVehicle().toString()))
		{
			fail();
		}
		
		if(!vp2.get(0).toString().equals(sedanDriver.getVehicle().toString()))
		{
			fail();
		}
		
	}
	
	@Test
	public void testFillTank() {
		Station s = new Station(3, 3);
		
		Driver carDriver = new Driver("Car");
		
		s.addDriverToPumpQueue(carDriver);
		
		Vehicle vp1 = s.getPump(0).getFirstVehicle();
		
		System.out.println("v1:"+vp1.toString());
		
		while(s.getPump(0).getFirstVehicle().getGallonsFilled() < s.getPump(0).getFirstVehicle().getTankSize())
		{
			s.getPump(0).fillFirstVehicle();
			System.out.println("v1:"+s.getPump(0).getFirstVehicle().toString());
		}
		vp1 = s.getPump(0).getFirstVehicle();
		
		System.out.println("v1:"+vp1.toString());
		
		System.out.println("\n");
		
		if(vp1.getGallonsFilled() != vp1.getTankSize())
		{
			fail();
		}
	}
	
	@Test
	public void testFullQueue()
	{
		Station s = new Station(1, 1);

		ArrayList<Driver> carDrivers = new ArrayList<Driver>();
		
		for(int i = 0; i < 4; i++)
		{
			carDrivers.add(new Driver("Car"));
		}
		
		int p = 0;
		for(Driver d: carDrivers)
		{
			if(s.addDriverToPumpQueue(d))
			{System.out.println("c"+ p + " in");}
			else
			{
				System.out.println("c"+p +" not in");
				if(p != 3)
				{
					fail();
				}
			}
			System.out.println(findVehicle(s, d));
			p++;
			}
		}
	
	
	@Test
	public void testMultiplePumpFull()
	{
		Station s = new Station(2, 1);
		
		ArrayList<Driver> sedanDrivers = new ArrayList<Driver>();
		
		for(int i = 0; i < 5; i++)
		{
			sedanDrivers.add(new Driver("Sedan"));
		}
		
		int p = 0;
		for(Driver d: sedanDrivers)
		{
			if(s.addDriverToPumpQueue(d))
			{System.out.println("s"+p +" in");}
			else
			{
				System.out.println("s"+p +" not in");
				if(p != 4)
				{
					fail();
				}
			}
			System.out.println(findVehicle(s, d));
			p++;
			}
		}
	
	private String findVehicle(Station s, Driver d)
	{
		int i = 0;
		for(Pump p : s.getPumpArray())
		{
			if(p.getVehicleQueue().contains(d.getVehicle()))
			{
				return "pump: "+i;
			}
			i++;
		}
		return "Not in pump";
	}

}
