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
		System.out.println();
		System.out.println("c2:"+sedan.toString());
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
	
	@Test
	public void testFullQueue()
	{
		Station s = new Station(1, 1);
		
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		if(s.addVehicleToPumpQueue(c1))
		{System.out.println("c1 in");}
		else
		{System.out.println("c1 not in");fail();}
		
		if(s.addVehicleToPumpQueue(c2))
		{System.out.println("c2 in");}
		else
		{System.out.println("c2 not in");fail();}
		
		if(s.addVehicleToPumpQueue(c3))
		{System.out.println("c3 in");}
		else
		{System.out.println("c3 not in");fail();}
		
		Station st2 = new Station(1, 1);
		
		Sedan s1 = new Sedan();
		Sedan s2 = new Sedan();
		Sedan s3 = new Sedan();
		
		if(st2.addVehicleToPumpQueue(s1))
		{System.out.println("s1 in");}
		else
		{System.out.println("s1 not in");fail();}
		
		if(st2.addVehicleToPumpQueue(s2))
		{System.out.println("s2 in");}
		else
		{System.out.println("s2 not in");fail();}
		
		if(st2.addVehicleToPumpQueue(s3))
		{System.out.println("s3 in");fail();}
		else
		{System.out.println("s3 not in");}
		
		
		
	}
	
	@Test
	public void testMultiplePumpFull()
	{
		Station s = new Station(2, 1);
		
		Sedan s1 = new Sedan();
		Sedan s2 = new Sedan();
		Sedan s3 = new Sedan();
		Sedan s4 = new Sedan();
		Sedan s5 = new Sedan();
		
		if(s.addVehicleToPumpQueue(s1))
		{System.out.println("s1 in");}
		else
		{System.out.println("s1 not in");fail();}
		
		if(s.addVehicleToPumpQueue(s2))
		{System.out.println("s2 in");}
		else
		{System.out.println("s2 not in");fail();}
		
		if(s.addVehicleToPumpQueue(s3))
		{System.out.println("s3 in");}
		else
		{System.out.println("s3 not in");fail();}
		
		if(s.addVehicleToPumpQueue(s4))
		{System.out.println("s4 in");}
		else
		{System.out.println("s4 not in");fail();}
		
		if(s.addVehicleToPumpQueue(s5))
		{System.out.println("s5 in");fail();}
		else
		{System.out.println("s5 not in");}
	}

}
