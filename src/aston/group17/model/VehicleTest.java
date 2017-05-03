package aston.group17.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUnitSize() {
		int globalSeed = 0;
		Car carTest = new Car(globalSeed);
		assertEquals("Check unit space is correct", 1.0, carTest.getUnitSize(), 1e-4);
		
		Sedan sedanTest = new Sedan(globalSeed);
		assertEquals("Check unit space is correct", 1.5, sedanTest.getUnitSize(), 1e-4);
		
		Bike bikeTest = new Bike(globalSeed);
		assertEquals("Check unit space is correct", 0.75, bikeTest.getUnitSize(), 1e-4);
	}
	
	@Test
	public void testTankSize() {
		int globalSeed = 0;
		System.out.println("TANK SIZE TEST:");
		System.out.println("CAR:");
		for(int i = 0; i < 10; i++)
		{
			Car carTest = new Car(globalSeed);
			System.out.println(carTest.getTankSize());
			if(!(carTest.getTankSize() >= 7 && carTest.getTankSize() <= 9))
			{
				fail("Not within correct bounds");
			}
		}
		
		System.out.println("SEDAN:");
		for(int i = 0; i < 10; i++)
		{
			Sedan sedanTest = new Sedan(globalSeed);
			System.out.println(sedanTest.getTankSize());
			if(!(sedanTest.getTankSize() >= 12 && sedanTest.getTankSize() <= 18))
			{
				fail("Not within correct bounds");
			}
		}
		
		System.out.println("BIKE:");
		for(int i = 0; i < 10; i++)
		{
			Bike bikeTest = new Bike(globalSeed);
			System.out.println(bikeTest.getTankSize());
			if(!(bikeTest.getTankSize() == 5))
			{
				fail("Not within correct bounds");
			}
		}
	}
	
	@Test
	public void testTankFilledAmount()
	{
		int globalSeed = 0;
		System.out.println("TANK FILLED TEST:");
		System.out.println("CAR:");
		for(int i = 0; i < 15; i++)
		{
			Car carTest = new Car(globalSeed);
			System.out.println("Tank size: "+carTest.getTankSize()+"|Filled: "+carTest.getTankFilled());
			if(!(carTest.getTankFilled() >= 1 && carTest.getTankFilled() <= carTest.getTankSize()))
			{
				fail("Not within correct bounds");
			}
		}
		
		System.out.println("SEDAN:");
		for(int i = 0; i < 15; i++)
		{
			Sedan sedanTest = new Sedan(globalSeed);
			System.out.println("Tank size: "+sedanTest.getTankSize()+"|Filled: "+sedanTest.getTankFilled());
			if(!(sedanTest.getTankFilled() >= 1 && sedanTest.getTankFilled() <= sedanTest.getTankSize()))
			{
				fail("Not within correct bounds");
			}
		}
		
		System.out.println("BIKE:");
		for(int i = 0; i < 15; i++)
		{
			Bike bikeTest = new Bike(globalSeed);
			System.out.println("Tank size: "+bikeTest.getTankSize()+"|Filled: "+bikeTest.getTankFilled());
			if(!(bikeTest.getTankFilled() >= 1 && bikeTest.getTankFilled() <= bikeTest.getTankSize()))
			{
				fail("Not within correct bounds");
			}
		}
	}

}
