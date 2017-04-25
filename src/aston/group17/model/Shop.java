package aston.group17.model;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Driver> shoppingDrivers;
	private ArrayList<Till> tills;

	/**
	 * Creates a new Shop object with the specified amount of Tills
	 * @param amount Amount of tills wanted
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
	 * Gets all shopping Drivers to act while in Shop.
	 * If Driver is done shopping they are moved into a Till and removed from the Shop
	 */
	public void act()
	{
		ArrayList<Driver> doneDrivers = new ArrayList<Driver>();
		for(Driver shoppingDriver : shoppingDrivers)
		{
			shoppingDriver.act();
			
			if(!shoppingDriver.isAtShop())
			{
				doneDrivers.add(shoppingDriver);
			}
		}
		
		for(Driver doneDriver : doneDrivers)
		{
			addDriverToTillQueue(doneDriver);
			removeDriver(doneDriver);
		}
		
		doneDrivers.clear();
		
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
	 * @param d Driver to add to the shop
	 */
	public void addNewDriver(Driver d)
	{
		shoppingDrivers.add(d);
	}
	
	/**
	 * Removes a Driver from the Shop
	 * @param d Driver to be removed
	 */
	private void removeDriver(Driver d)
	{
		shoppingDrivers.remove(d);
	}
	
	/**
	* Adds a Driver d to the shortest Till queue
	* @param d Driver to add to the Till queue
	*/
	private void addDriverToTillQueue(Driver d){
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
	 * Adds all money gained from each till and adds it to moneyEarnt
	 * @return The amount of money made at all tills as of calling the method
	 */
	public double countMoney()
	{	
		double moneyEarnt = 0;
		for(Till t : tills)
		{
			moneyEarnt += t.getMoneyTaken();
		}
		
		return moneyEarnt;
	}
	
	/**
	 * Adds all money lost from lost sales from each till and adds it to moneyLost
	 * @return The amount of money lost in extra shop sales
	 */
	public double countMoneyLost()
	{	
		double moneyLost = 0;
		for(Till t : tills)
		{
			moneyLost += t.getMoneyLost();
		}
		
		return moneyLost;
	}
	
}
