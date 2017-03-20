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
		
		Car car = new Car();
		
		s.addVehicleToPumpQueue(car);
		
		ArrayList<Vehicle> vp1 = s.getPump(0).getVehicleQueue();
		
		System.out.println("c1:"+car.toString());
		System.out.println("v1:"+vp1.get(0).toString());
		
		
		Sedan sedan = new Sedan();
		
		s.addVehicleToPumpQueue(sedan);
		
		ArrayList<Vehicle> vp2 = s.getPump(1).getVehicleQueue();
		
		System.out.println("sedan:"+sedan.toString());
		System.out.println("v2:"+vp2.get(0).toString());
		
		if(!vp1.get(0).toString().equals(car.toString()))
		{
			fail();
		}
		
		if(!vp2.get(0).toString().equals(sedan.toString()))
		{
			fail();
		}
		
	}
	
	@Test
	public void testFillTank() {
		Station s = new Station(3, 3);
		
		Car car = new Car();
		
		s.addVehicleToPumpQueue(car);
		
		ArrayList<Vehicle> vp1 = s.getPump(0).getVehicleQueue();
		
		System.out.println("v1:"+vp1.get(0).toString());
		
		s.getPump(0).fillFirstVehicle();
		
		vp1 = s.getPump(0).getVehicleQueue();
		
		System.out.println("v1:"+vp1.get(0).toString());
		
		System.out.println("\n");
		
		if(vp1.get(0).getGallonsFilled() != vp1.get(0).getTankSize())
		{
			fail();
		}
	}

}
