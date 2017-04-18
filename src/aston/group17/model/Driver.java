package aston.group17.model;
import java.util.Random;

public class Driver {

	private boolean shopping, wait, done, doneRefilling, didShop, atPump;
	private int  totalTime, shoppingTime, tillTime, pump, tillNumber;
	private double moneySpentPump, moneySpentShop, totalSpent;
	private Vehicle vehicle;
	private String vehicleType;
	private Random rnd;
	
	/**
	 * constructs a new Driver object
	 * @param type
	 * the type of vehicle the Driver owns: "Car", "Sedan", "Bike", "Truck"
	 */
	public Driver(String type)
	{
		tillNumber = -1;
		tillTime = 0;
		totalTime = 0;
		moneySpentPump = 0;
		moneySpentShop = 0;
		totalSpent = 0;
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
	 * What the driver will do each tick
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
						fillTank();
						moneySpentPump += fuelCost;
				}
				else
				{
					wait = true;
					doneRefilling = true;
					setShoppingTime();
				}
		}
		incrementTotalTime();
	}
	
	public void act()
	{
		if(isAtShop())
		{
			if(stillShopping())
			{
				shop();
			}
			else
			{
//				if(vehicleType != "Bike"){
//				toggleQueueing();
//				}
				shopping = false;
			}
		}
		incrementTotalTime();
	}
	
	/**
	 * This returns the vehicle the driver is driving.
	 * @return
	 * Returns the Driver's Vehicle object
	 */
	public Vehicle getVehicle()
	{	
		return vehicle;
	}
	
	/**
	 * This calculates the money a driver could spend shopping.
	 * @return
	 * returns the amount of money the Driver has spent at the station
	 */
	public double getMoneySpentPump()
	{
		return moneySpentPump;	
	}
	
	// returns the amount of money spent at shop
	public double getPumpMoney()
	{
		totalSpent = moneySpentPump + moneySpentShop;
		return totalSpent;	
	}
	
	// returns the total amount of money spent
	public double getShopSpendingAmount()
	{
		return vehicle.moneySpentForShopping();
	}
	
	/**
	 * This calculates the time a driver could potentially spend shopping.
	 * @return
	 * returns int of the amount of time the driver would spend shopping
	 */
	private void setShoppingTime()
	{		
		if(willShop(totalTime))
		{
			System.out.println("Did shop");
			didShop = true;
			shoppingTime = vehicle.timeToSpendShopping();
		}
		else
		{
			System.out.println("Didn't shop");
			didShop = false;
			shoppingTime = 0;
		}
	}

	private boolean willShop(int time){
		return vehicle.willShop(totalTime);
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
	 * Returns true if the Driver is still shopping
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
	 * Returns if the Driver is in the Shop
	 * @return True if the driver is shopping
	 */
	public boolean isAtShop()
	{
		return shopping;
	}
	
	/**
	 * Returns if the Driver is in the Shop
	 * @return True if the driver is done shopping
	 */
	public boolean isDone()
	{
		return done;
	}
	
	/**
	 * Simulates the Driver shopping, incrementing shoppingTime by one
	 */
	private void shop()
	{
		shoppingTime--;
	}
	
	/**
	 * Returns vehicle type the driver owns
	 * @return String for vehicle type the driver owns
	 */
	public String getVehicleType()
	{
		return vehicleType;
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
	 * Returns length of shopping in ticks
	 * @return Value of shoppingTime
	 */
	public int getShoppingTime()
	{
		return shoppingTime;
	}

	/**
	 * Calls the vehicle fill tank method
	 */
	private void fillTank()
	{
		vehicle.fill();
	}
	
	/**
	 * Returns a text representation of Driver
	 * @return Text representation of Driver
	 */
	public String toString()
	{
		return "Driver of: " + getVehicleType() + " | Vehicle Tank Size: "+ vehicle.getTankSize() +" | Gallons to fill: "+ (vehicle.getTankSize() - vehicle.getTankFilled()) +" | in shop: "+shopping+" | shoppingTime: "+shoppingTime+" | Till Number: "+(tillNumber + 1)+" | tillTime: "+ tillTime +" | Done: "+done;
	}
	
	/**
	 * Toggles the Driver's 'done' status, meaning they are ready to leave the station
	 */
	public void toggleDone()
	{
		done = !done;
	}
	
	/**
	 * Sets the time that the driver will spend paying at the till. This is only called when the driver is at the front of the queue
	 */
	public void setTillTime()
	{
		tillTime = rnd.nextInt(6)+12;
	}

	/**
	 * Simulates the driver paying at the till, reducing the amount they have left to wait at the till by one tick
	 */
	public void waitAtTill() {
		tillTime--;
	}
	
	/**
	 * Checks if the Driver is done paying at the till (checks if tillTime == 0)
	 * @return true if tillTime is equal to zero
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
	public void setAtPump(boolean atPump) {
		this.atPump = atPump;
	}
}
