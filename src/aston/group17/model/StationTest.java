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
		System.out.println("\n CARS");
		//create new station
		Station s = new Station(1, 1);
		
		//create arraylist of cars
		ArrayList<Car> cars = new ArrayList<Car>();
		
		//add cars to arraylist
		for(int i = 0; i<3; i++)
		{
			cars.add(new Car());
		}
		
		//used to check what car we are on in the for each loop
		int i = 0;
		//loop through each car
		for(Car car : cars)
		{
			//try and add car to pump
			if(s.addVehicleToPumpQueue(car))
			{System.out.println("c"+i+" in");}
			else //if any car cant enter the queue, test fails. all 2 cars should be able to enter
			{System.out.println("c"+i+" not in");fail();}
			
			//check what pump the car is in (should always be 0 for this test)
			System.out.println(findVehicle(s, car));
			//increment i to keep count of what car we are on
			i++;
		}
		
		System.out.println("\n SEDANS");
		
		//new station
		Station st2 = new Station(1, 1);
		
		//sedans
		ArrayList<Sedan> sedans = new ArrayList<Sedan>();
		
		
		//add sedans to list
		for(int i1 = 0; i1 < 3; i1++)
		{
			sedans.add(new Sedan());
		}
		
		//second i
		int i1 = 0;
		
		//loop through sedans, adding them to pump
		for(Sedan sed : sedans)
		{
			if(st2.addVehicleToPumpQueue(sed))
			{
				System.out.println("s"+i1+" in");
				//third sedan shouldnt be able to join the queue
				if(i1 == 2)
				{
					fail();
				}
			}
			else
			{System.out.println("s"+i1+" not in");}
			
			System.out.println(findVehicle(st2, sed));
			
			i1++;
		}
	}
	
	@Test
	public void testMultiplePumpFull()
	{
		Station s = new Station(2, 1);
		
		ArrayList<Sedan> sedans = new ArrayList<Sedan>();
		
		for(int i = 0; i < 5; i++)
		{
			sedans.add(new Sedan());
		}
		
		int i = 0;
		for(Sedan sed : sedans)
		{
			if(s.addVehicleToPumpQueue(sed))
			{
				System.out.println("s"+i+" in");
				//fith sedan (fourth index) shouldnt be able to join the queue
				if(i == 4)
				{
					fail();
				}
			}
			else
			{System.out.println("s"+i+" not in");}
			
			System.out.println(findVehicle(s, sed));
			i++;
		}
		
	}
	
	//checks if a vehicle is in a pump in a station
	private String findVehicle(Station s, Vehicle v)
	{
		int i = 0;
		for(Pump p : s.getPumpArray())
		{
			if(p.getVehicleQueue().contains(v))
			{
				return "pump: "+i;
			}
			i++;
		}
		return "Not in pump";
	}

}
