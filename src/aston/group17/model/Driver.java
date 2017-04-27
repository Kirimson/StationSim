package aston.group17.model;
import java.util.Random;

public class Driver {

	private boolean shopping, wait, done, doneRefilling, didShop, atPump;
	protected int  totalTime;
	private int shoppingTime;
	private int tillTime;
	private int pump;
	private int tillNumber;
	private double moneySpentPump, moneySpentShop;
	private Vehicle vehicle;
	private String vehicleType;
	private Random rnd;
	
	/**
	 * A Driver who will interact with the Station and it's children objects and spend money at the Station.
	 * A Driver has-a Vehicle
	 * @param type Type of vehicle the Driver owns. Legal values are: "Car", "Sedan", "Bike", "Truck"
	 */
	public Driver(String type)
	{
		tillNumber = -1;
		tillTime = 0;
		totalTime = 0;
		moneySpentPump = 0;
		moneySpentShop = 0;
		shopping = false;
		wait = true;
		setAtPump(true);
		rnd = new Random();
		
		switch(type){
			case "Car":
				vehicle = new Car();
				vehicleType = "Car";
				break;
			case "Sedan":
				vehicle = new Sedan();
				vehicleType = "Sedan";
				break;
			case "Truck":
				vehicle = new Truck();
				vehicleType = "Truck";
				break;
			case "Bike":
				vehicle = new Bike();
				vehicleType = "Bike";
				break;
			default:
				vehicle = new Car();
				vehicleType = "Car";
		}
	}
	
	/**
	 * What the driver will do at the pump, either refill their vehicle, wait, or signify they want to go to the shop
	 * @param fuelCost price the driver spends per tick
	 */
	public void act(double fuelCost)
	{
		if(wait)
		{
			wait = !wait;
		}
		else if(!isAtShop())
		{
			if(!getVehicle().isFull())
			{
				vehicle.fill();
				moneySpentPump += fuelCost;
			}
			else
			{
				wait = true;
				doneRefilling = true;
				setShopSpendingAmount();
				setShoppingTime();
			}
		}
		incrementTotalTime();
	}
	
	/**
	 * What the driver will do at the shop/till, where fuelCost is not needed this method overrides the original method,
	 * as the driver now either shops or waits at the till
	 */
	public void act()
	{
		if(shopping)
		{
			if(stillShopping())
			{
				shoppingTime--;
			}
			else
			{
				shopping = false;
				setTillTime();
			}
		}
		else
		{
			if(isDonePaying())
			{
				done = true;
			}
			else
			{
				tillTime--;
			}
		}
		incrementTotalTime();
	}
	
	/**
	 * This returns the vehicle the driver is driving.
	 * @return Driver's Vehicle object
	 */
	public Vehicle getVehicle()
	{	
		return vehicle;
	}
	
	/**
	 * This calculates the money a driver could spend shopping.
	 * @return Amount of money the Driver has spent at the station
	 */
	public double getShopMoney()
	{
		return moneySpentShop;
	}
	
	/**
	 * Returns the amount of money spent at the Pump
	 * @return Double of how much money the Driver spent at the Pump
	 */
	public double getPumpMoney()
	{
		return moneySpentPump;	
	}

	/**
	 * Returns the amount of money spent at the Shop
	 * @return Double of how much money the Driver spent at the Shop
	 */
	private void setShopSpendingAmount()
	{
		moneySpentShop = vehicle.moneySpentForShopping();
	}
	
	/**
	 * Calculates the time a driver could potentially spend shopping.
	 * @return Int of the amount of time the driver would spend shopping
	 */
	private void setShoppingTime()
	{		
		if(willShop(totalTime))
		{
//			System.out.println("Did shop: "+ vehicleType);
			didShop = true;
			shoppingTime = vehicle.timeToSpendShopping();
		}
		else
		{
//			System.out.println("Didn't shop: "+vehicleType);
			didShop = false;
			shoppingTime = 0;
		}
	}

	/**
	 * Checks if the Driver will shop or not, using total time spent and a random chance value, depending on vehicle type
	 * @param time How long the Driver has been at the Station for
	 * @return true if the Driver will shop
	 */
	private boolean willShop(int time){
		int minTime = 0, chance = 0;
		switch (vehicleType) {
		case "Car":
			minTime = 30;
			chance = 3;
			break;
		case "Bike":
			return false;
		case "Sedan":
			minTime = 60;
			chance = 4;
			break;
		case "Truck":
			minTime = 80;
			chance = 11;
			break;
		}
		
		int randomChance = rnd.nextInt(10)+1;
		
		if(time < minTime)
		{
			if(randomChance <= chance){
				return true;
			}
			
		}
		return false;
	}

	/**
	 * Checks if the driver wants to shop, only true if wait is false and shopping is true
	 * @return True if the Driver is done refilling their Vehicle
	 */
	public boolean isDoneRefilling()
	{
		return doneRefilling;
	}
	
	/**
	 * Checks if the Driver is still shopping
	 * @return true if Driver is still shopping
	 */
	private boolean stillShopping()
	{
		if(shoppingTime == 0)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if the Driver is at the Shop
	 * @return True if the driver is currently shopping
	 */
	public boolean isAtShop()
	{
		return shopping;
	}
	
	/**
	 * Checks if the Driver is done at the Station
	 * @return True if the Driver's done field is true
	 */
	public boolean isDone()
	{
		return done;
	}
	
	/**
	 * Changes the driver's shopping state
	 */
	public void toggleShopping()
	{
		shopping = !shopping;
		setAtPump(!atPump);
	}
	
	/**
	 * Returns length of time shopping in ticks
	 * @return Value of shoppingTime
	 */
	public int getShoppingTime()
	{
		return shoppingTime;
	}

	/**
	 * Returns a text representation of Driver
	 * @return String representation of Driver
	 */
	public String toString()
	{
		return "Driver of: " + vehicleType + " | Vehicle Tank Size: "+ vehicle.getTankSize() +" | Gallons to fill: "+ (vehicle.getTankSize() - vehicle.getTankFilled()) +" | in shop: "+shopping+" | shoppingTime: "+shoppingTime+" | Till Number: "+(tillNumber + 1)+" | tillTime: "+ tillTime +" | Done: "+done;
	}
	
	/**
	 * Sets the time that the driver will spend paying at the till. This is only called when the driver is at the front of the queue
	 */
	private void setTillTime()
	{
		tillTime = rnd.nextInt(6)+12;
	}
	
	/**
	 * Checks if the Driver is done paying at the till (checks if tillTime == 0)
	 * @return True if tillTime is equal to zero
	 */
	public boolean isDonePaying(){
		if(tillTime == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the Driver's pump number, the pump their vehicle is at
	 * @return integer for the Driver's pump number
	 */
	public int getPumpNumber()
	{
		return pump;
	}

	/**
	 * assigns the driver to a specific pump, used to find the driver when leaving the station
	 * @param pumpNumber the index number for the pump the driver is at
	 */
	public void assignPump(int pumpNumber) {
		pump = pumpNumber;
	}

	/**
	 * Returns the total time the Driver has spent at the station thus far
	 * @return field totalTime
	 */
	public int getTotalTime() {
		return totalTime;
	}

	/**
	 * Adds one tick to the total time the Driver has spent at the station. 
	 */
	private void incrementTotalTime() {
		totalTime++;
	}
	
	/**
	 * Sets the Driver's till number they are at while paying
	 * @param tillNumber the index number for the till the Driver is at
	 */
	public void setTillNumber(int tillNumber){
		this.tillNumber = tillNumber;
	}

	/**
	 * Checks if the driver did shop 
	 * @return True if the Driver went shopping
	 */
	public boolean didShop() {
		return didShop;
	}

	/**
	 * Returns whether the Driver is at the Pump or not
	 * @return True if Driver s currently at the pump
	 */
	public boolean isAtPump() {
		return atPump;
	}

	/**
	 * Sets the value for atPump
	 * @param atPump Boolean, true or false depending on the driver's state
	 */
	private void setAtPump(boolean atPump) {
		this.atPump = atPump;
	}
	
	/**
	 * Used for truckDriver's probability
	 * @return always resets probability 
	 */
	public double getProbability()
	{
		return 0;
	}
}
