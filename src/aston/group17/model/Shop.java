package aston.group17.model;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Driver> shoppingDrivers;
	private ArrayList<Till> tills;

	/**
	 * Creates a new Shop object with the specified amount of Tills
	 * @param amount
	 * Amount of tills wanted
	 */
	public Shop(int amount){
		tills = new ArrayList<Till>();
		for(int i = 0; i < amount; i++)
		{
			tills.add(new Till(i));
		}
		shoppingDrivers = new ArrayList<Driver>();
	}
	
	/**
	 * 
	 */
	public void act()
	{
		for(Driver shoppingDriver : shoppingDrivers)
		{
			shoppingDriver.act();
			
			if(!shoppingDriver.stillShopping() && !shoppingDriver.isQueueing())
			{
				addDriverToTillQueue(shoppingDriver);
				if(shoppingDriver.getVehicleType().equals("Bike"))
				{
					shoppingDriver.toggleQueueing();
				}
			}
		}
		
		for(Till t : tills)
		{
			if(t.isTillInUse())
			{
				t.act();
			}
		}
	}
	
	/**
	 * Adds a driver to the shop, who will begin shopping
	 * @param d
	 * Driver to add to the shop
	 */
	public void addNewDriver(Driver d)
	{
		shoppingDrivers.add(d);
	}
	
	public void removeDriver(Driver d)
	{
		shoppingDrivers.remove(d);
	}
	
	/**
	* Returns a till that is not in use, first till that is free will be used, if any
	* @return
	* Returns the first Till object in tills that is not in sue. If all tills are in use, it returns null
	*/
	public void addDriverToTillQueue(Driver d){
		Till shortestTill = tills.get(0);
		for(Till t : tills)
		{
			if(t.getQueueLength() < shortestTill.getQueueLength())
			{
				shortestTill = t;
			}
		}
		shortestTill.addDriver(d);
	}
	
	/**
	 * adds all money gained from each pump and shop and adds it to moneyEarnt
	 * Might just be called at the end of simulation to get all money in one central place, not sure yet
	 * @return
	 * the amount of money made at all tills as of calling the method
	 */
	public double countMoney()
	{	
		double moneyEarnt = 0;
		for(Till s : tills)
		{
			moneyEarnt += s.getMoneyTaken();
		}
		
		return moneyEarnt;
	}
	
	public ArrayList<Till> getTills()
	{
		return tills;
	}
	
	public boolean isEmpty()
	{
		if(shoppingDrivers.size() == 0)
		{
			return true;
		}
		return false;
	}
}
