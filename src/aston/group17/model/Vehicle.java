package aston.group17.model;

import java.util.Random;

public abstract class Vehicle {
	
	protected int tankSize;
	private int gallonsFilled;
	private Random rand;
	protected String vehicleType;
	
	/**
	 * A Vehicle with a tankSize, amountFilled on creation. Will be filled at the Pump.
	 * A Driver has-a Vehicle
	 * @param range
	 * range from minimum value to max value (inclusive)
	 * @param minTank
	 * minimum size of Vehicle tank
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
		if(gallonsFilled == tankSize)
		{
			gallonsFilled--;
		}
	}
	
	/**
	 * Fills the tank of the vehicle by one, once per tick
	 */
	 public void fill()
	 {
		 if(gallonsFilled < tankSize)
		 {
//			 System.out.println("MaxFuel: "+ tankSize);
			 gallonsFilled++;
		 }
	 }
	 
	 /**
	 * Returns how much of the tank is filled
	 * @return
	 * gallonsFilled of the Vehicle
	 */
	 public int getTankFilled()
	 {
		 return gallonsFilled;
	 }
	 
	 /**
	 * Returns the size of the Vehicle's tank
	 * @return
	 * tankSize of the Vehicle
	 */
	 public int getTankSize()
	 {
		 return tankSize;
	 }
	 
	 /**
	  * Generates a string to describe the Vehicle
	  * @return
	  * String description of Vehicle
	  */
	 public String toString()
	 {
		 return "Type: " + vehicleType + ". Tank Size: " + tankSize + ". Amount Filled: " + gallonsFilled;
	 }
	 
	 public boolean isFull()
	 {
		 if(gallonsFilled == tankSize)
		 {
			 return true;
		 }
		 return false;
	 }
	 
	 /**
	 * Returns the unitSize of the vehicle
	 * @return
	 * Vehicle's UNIT_SIZE
	 */
	 public abstract double getUnitSize();
	 
	 /**
	 * returns how many ticks the driver of this vehicle will spend shopping
	 * @return
	 * Vehicle's time to spend shopping
	 */
	 public abstract int timeToSpendShopping();
	 
	 /**
	 * returns how much the driver of this vehicle will spend in the shop
	 * @return
	 * Vehicle's amount of money to spend in Shop
	 */
	 public abstract double moneySpentForShopping();
}
