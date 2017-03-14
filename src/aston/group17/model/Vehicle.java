package aston.group17.model;

import java.util.Random;

public class Vehicle {
	
	protected int tankSize;
	private int gallonsFilled;
	private Random rand;
	
	/**
	 * Constructor for Vehicles with one tankSize (motorbike)
	 */
	public Vehicle(int tankSize)
	{
		this.tankSize = tankSize;
	}
	
	/**
	 * Constructor for Vehicles with a variable tankSize
	 * @param range = range from minimum value to max value (inclusive)
	 * @param minTank = minimum size of Vehicle tank
	 */
	public Vehicle(int range, int minTank)
	{
		tankSize = rand.nextInt(range) + minTank;
	}
	
	/**
	 * Fills the tank of the vehicle and will return how many gallons were used
	 */
	 public int FillTank()
	 {
		 int fillAmount = tankSize - gallonsFilled;
		 gallonsFilled = tankSize;
		 
		 return fillAmount;
	 }
	 
	 /**
	 * Returns the value of gallonsFilled (how much of the vehicle's tank is currently filled)
	 */
	 public int getGallonsFilled()
	 {
		 return gallonsFilled;
	 }
	 
	 /**
	 * Returns the value of tankSize (size of vehicle tank)
	 */
	 public int getTankSize()
	 {
		 return tankSize;
	 }
	 
}
