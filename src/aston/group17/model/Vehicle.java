package aston.group17.model;

import java.util.Random;

public abstract class Vehicle {
	
	protected Driver driver;
	protected int tankSize;
	private int gallonsFilled;
	private Random rand;
	protected String vehicleType;
	private boolean inQueue;
	
	/**
	 * Constructor for Vehicles, sets their tank size and amount filled on creation
	 * @param range = range from minimum value to max value (inclusive)
	 * @param minTank = minimum size of Vehicle tank
	 */
	public Vehicle(int range, int minTank)
	{
		/*
		*Example: smallCar| range = 3 & minTank = 7
		*Generates random number from 0-2 (3 possible values) adds minTank(7) to it
		*Lowest possible value 7(0+7) highest possible value 9(2+7)
		*/
		rand = new Random();
		tankSize = rand.nextInt(range) + minTank;
		
		/*
		*Generates a possible number for the tank to filled.
		*Will not be higher or lower than tankSize
		*random number is between (0)-(tankSize - 1)
		*/
		gallonsFilled = tankSize - rand.nextInt(tankSize);
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
	 
	 public Driver getDriver()
	 {
		 return driver;
	 }
	 
	 public String toString()
	 {
		 return "Type: " + vehicleType + ". Tank Size: " + tankSize + ". Amount Filled: " + gallonsFilled + ". In Queue: " + inQueue;
	 }
	 
	 public void toggleQueueStatus()
	 {
		 inQueue = !inQueue;
	 }
	 
	 public abstract double getUnitSpace();
}
