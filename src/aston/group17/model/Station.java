package aston.group17.model;

import java.util.ArrayList;

public class Station {
	private Shop shop;
	private ArrayList<Pump> pumps;
	
	/**
	 * Constructs a new Station class
	 * @param pAmount
	 * Amount of pumps the Station will have
	 * @param tAmount
	 * Amount of shops the Station will have
	 */
	public Station(int pAmount, int tAmount, double price)
	{
		//create a Shop and create tills inside depending on how many tills were specified in tAmount
		shop = new Shop(tAmount);
		
		//create new arrayList of Pump and create pumps inside depending on how many pumps were specified in pAmount
		pumps = new ArrayList<Pump>();
		
		for(int i = 0; i < pAmount; i++)
		{
			pumps.add(new Pump(price));
		}
	}
	
	/**
	 * What will happen at the station each tick
	 */
	public void act()
	{
		int i = 0;
		for(Pump p : pumps)
		{
			if(p.getFirstDriver() != null)
			{
				System.out.println("Pump " + i+":");
				if(!p.getFirstDriver().wantsToShop())
				{
					System.out.println("Driver is refilling. Fuel currently at: " + p.getFirstDriver().getVehicle().getGallonsFilled());
					p.act();
				}
				else if(!p.getFirstDriver().isInShop())
				{
					System.out.println("Driver spent " + p.getFirstDriver().getMoneySpent() + " at pump");
					System.out.println("Driver going to shop");
					
					addDriverToShop(p.getFirstDriver());
				}
			}
			i++;
		}
		shop.act();
	}
	
	/**
	* Sends customer to the shortest till queue
	*/
	public void addDriverToShop(Driver driver){
		driver.toggleShopping();
		shop.addNewDriver(driver);
	}
	
	/**
	 * Returns the shortest pump queue, checks all pumps for the one with the shortest queue, then checks if the vehicle will fit in the shortest queue
	 * @param v
	 * a vehicle that will be checked against the queue to see if it can fit in any queue
	 * @return
	 * returns the pump object the vehicle will go in to. Returns null if v cannot fit in any pump queue
	 */
	public Pump getShortestPumpQueue(Vehicle v){
		Pump shortestPump = pumps.get(0);
		for(Pump p : pumps)
		{
			if(p.getQueueFree() > shortestPump.getQueueFree())
			{
				shortestPump = p;
			}
		}
		if(shortestPump.willVehicleFit(v.getUnitSize()))
		{
			return shortestPump;
		}
		return null;
	}
	
	/**
	 * Gets a specified pump
	 * @param pump
	 * the pump number you want to return
	 * @return
	 * Pump object
	 */
	public Pump getPump(int pump)
	{
		return pumps.get(pump);
	}
	
	/**
	 * Gets the ArrayList of Pump
	 * @return
	 * ArrayList of Pump
	 */
	public ArrayList<Pump> getPumpArray()
	{
		return pumps;
	}
	
	/**
	 * Adds vehicle to the shortest pump queue.
	 * @param driver
	 * the driver to be added to the pump queue
	 * @return
	 * a true or false value, depending on whether the driver could join a queue or not
	 */
	public boolean addDriverToPumpQueue(Driver driver){
		Pump shortestPump = getShortestPumpQueue(driver.getVehicle());
		
		if(shortestPump != null)
		{
			shortestPump.addToPumpQueue(driver);
			System.out.println(findVehicle(driver)+" ");
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the Station's Shop
	 * @return
	 * Shop
	 */
	public Shop getShop()
	{
		return shop;
	}
	
	private String findVehicle(Driver d)
	{
		int i = 0;
		for(Pump p : getPumpArray())
		{
			if(p.getVehicleQueue().contains(d))
			{
				return "In pump "+i;
			}
			i++;
		}
		return "Not in pump";
	}
}
