package aston.group17.model;
import java.util.Random;

public class Driver {

	private boolean shopping, wait, queueing, done, wantsToShop;
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
		setTotalTime(0);
		moneySpentPump = 0;
		moneySpentShop = 0;
		totalSpent = 0;
		shopping = false;
		wait = true;
		queueing = true;
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
		setTotalTime(getTotalTime() + 1);
		if(wait)
		{
			wait = !wait;
		}
		else if(!shopping)
		{
			if(!queueing)
			{
				if(!getVehicle().isFull())
				{
						fillTank();
						moneySpentPump += fuelCost;
				}
				else
				{
					wait = true;
					wantsToShop = true;
					setShoppingTime();
				}
			}
		}
	}
	
	public void act()
	{
		setTotalTime(getTotalTime() + 1);
		if(!queueing)
		{
			if(stillShopping())
			{
//				System.out.println("Driver is shopping");
				shop();
			}
			else
			{
//				System.out.println("Driver wants to join queue");
				if(vehicleType != "Bike"){
				toggleQueueing();
				}
			}
//			System.out.println(toString());
		}
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
	
	// returns the amount of money spent at pump
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
	public void setShoppingTime()
	{
		shoppingTime = vehicle.timeToSpendShopping();
	}
	
	/**
	 * Checks if the driver wants to shop, only true if wait is false and shopping is true
	 * @return
	 * Boolean
	 */
	public boolean wantsToShop()
	{
		return wantsToShop;
	}
	
	/**
	 * Returns if the Driver is queueing or not
	 * @return
	 * true if driver is still queueing
	 */
	public boolean isQueueing()
	{
		return queueing;
	}
	
	/**
	 * Returns true if the Driver is still shopping
	 * @return
	 * true if driver is still shopping
	 */
	public boolean stillShopping()
	{
		if(shoppingTime == 0)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Returns if the Driver is in the Shop
	 * @return
	 * Boolean true if the driver is shopping
	 */
	public boolean isInShop()
	{
		return shopping;
	}
	
	/**
	 * Returns if the Driver is in the Shop
	 * @return
	 * true if the driver is done shopping
	 */
	public boolean isDone()
	{
		return done;
	}
	
	/**
	 * The driver shops, incrementing shoppingTime
	 */
	private void shop()
	{
		shoppingTime--;
	}
	
	/**
	 * Returns vehicle type the driver owns
	 * @return
	 * vehicle type the driver owns
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
	}
	
	/**
	 * Changes the Driver's queueing state
	 */
	public void toggleQueueing()
	{
		queueing = !queueing;
	}
	
	/**
	 * Returns length of shopping in ticks
	 * @return
	 * shoppingTime
	 */
	public int getShoppingTime()
	{
		return shoppingTime;
	}

	/**
	 * Calls the vehicle fill tank method
	 */
	public void fillTank()
	{
		vehicle.fill();
	}
	
	/**
	 * Returns a text representation of Driver
	 * @return
	 * Text representation of Driver
	 */
	public String toString()
	{
		return "Driver of: " + getVehicleType() + " | Vehicle Tank Size: "+ vehicle.getTankSize() +" | Gallons to fill: "+ (vehicle.getTankSize() - vehicle.getTankFilled()) +" | in shop: "+shopping+" | shoppingTime: "+shoppingTime+" | Till Number: "+(tillNumber + 1)+" | tillTime: "+ tillTime +" | Done: "+done;
	}
	
	public void toggleDone()
	{
		done = !done;
	}
	
	public void setTillTime()
	{
		tillTime = rnd.nextInt(6)+12;
	}

	public int waitAtTill() {
		return tillTime--;
	}
	
	public boolean donePaying(){
		if(tillTime == 0)
		{
			return true;
		}
		return false;
	}
	
	public int getPumpNumber()
	{
		return pump;
	}

	public void assignPump(int pumpNumber) {
		pump = pumpNumber;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
	public void setTillNumber(int tillNumber){
		this.tillNumber = tillNumber;
	}
}
