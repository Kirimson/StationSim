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
		Car carTest = new Car();
		assertEquals("Check unit space is correct", 1.0, carTest.getUnitSize(), 1e-4);
		
		Sedan sedanTest = new Sedan();
		assertEquals("Check unit space is correct", 1.5, sedanTest.getUnitSize(), 1e-4);
		
		Bike bikeTest = new Bike();
		assertEquals("Check unit space is correct", 0.75, bikeTest.getUnitSize(), 1e-4);
	}
	
	@Test
	public void testTankSize() {
		System.out.println("TANK SIZE TEST:");
		System.out.println("CAR:");
		for(int i = 0; i < 10; i++)
		{
			Car carTest = new Car();
			System.out.println(carTest.getTankSize());
			if(!(carTest.getTankSize() >= 7 && carTest.getTankSize() <= 9))
			{
				fail("Not within correct bounds");
			}
		}
		
		System.out.println("SEDAN:");
		for(int i = 0; i < 10; i++)
		{
			Sedan sedanTest = new Sedan();
			System.out.println(sedanTest.getTankSize());
			if(!(sedanTest.getTankSize() >= 12 && sedanTest.getTankSize() <= 18))
			{
				fail("Not within correct bounds");
			}
		}
		
		System.out.println("BIKE:");
		for(int i = 0; i < 10; i++)
		{
			Bike bikeTest = new Bike();
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
		System.out.println("TANK FILLED TEST:");
		System.out.println("CAR:");
		for(int i = 0; i < 15; i++)
		{
			Car carTest = new Car();
			System.out.println(carTest.getGallonsFilled());
			if(!(carTest.getGallonsFilled() >= 1 && carTest.getGallonsFilled() <= carTest.getTankSize()))
			{
				fail("Not within correct bounds");
			}
		}
		
		System.out.println("SEDAN:");
		for(int i = 0; i < 15; i++)
		{
			Sedan sedanTest = new Sedan();
			System.out.println(sedanTest.getGallonsFilled());
			if(!(sedanTest.getGallonsFilled() >= 1 && sedanTest.getGallonsFilled() <= sedanTest.getTankSize()))
			{
				fail("Not within correct bounds");
			}
		}
		
		System.out.println("BIKE:");
		for(int i = 0; i < 15; i++)
		{
			Bike bikeTest = new Bike();
			System.out.println(bikeTest.getGallonsFilled());
			if(!(bikeTest.getGallonsFilled() >= 1 && bikeTest.getGallonsFilled() <= bikeTest.getTankSize()))
			{
				fail("Not within correct bounds");
			}
		}
	}

}
