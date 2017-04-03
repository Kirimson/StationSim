package aston.group17.model;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Driver> shoppingDrivers;
	private ArrayList<Driver> idleDrivers;
	private ArrayList<Till> tills;
	private double moneyEarnt;
	
	/**
	 * Creates a new Shop object with the specified amount of Tills
	 * @param amount
	 * Amount of tills wanted
	 */
	public Shop(int amount){
		tills = new ArrayList<Till>();
		for(int i = 0; i < amount; i++)
		{
			tills.add(new Till());
		}
		shoppingDrivers = new ArrayList<Driver>();
		idleDrivers = new ArrayList<Driver>();
	}
	
	/**
	 * 
	 */
	public void act()
	{
		for(Driver shoppingDriver : shoppingDrivers)
		{
			if(!shoppingDriver.isQueueing())
			{
				if(shoppingDriver.stillShopping())
				{
					shoppingDriver.shop();
				}
				else
				{
					shoppingDriver.toggleQueueing();
				}
			}
		}
		
		for(Driver idleDriver : idleDrivers)
		{
			if(idleDriver.isInShop())
			{
				Till freeTill = getFreeTill();
				if(freeTill != null)
				{
					freeTill.addDriver(idleDriver);
				}
			}
			else
			{
				
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
	
	/**
	 * Removes a Driver from the shop
	 * @param d
	 * The Driver to be removed
	 */
	public void removeDriver(Driver d)
	{
		idleDrivers.remove(d);
	}
	
	/**
	 * Adds a driver to the idle list
	 * @param d
	 * Driver to add to the idle list
	 */
	public void makeDriverIdle(Driver d)
	{
		idleDrivers.add(d);
	}
	
	/**
	* Returns a till that is not in use, first till that is free will be used, if any
	* @return
	* Returns the first Till object in tills that is not in sue. If all tills are in use, it returns null
	*/
	public Till getFreeTill(){
		for(Till t : tills){
			if(!t.isTillInUse())
			{
				return t;
			}
		}
		return null;
	}
	
	/**
	 * adds all money gained from each pump and shop and adds it to moneyEarnt
	 * Might just be called at the end of simulation to get all money in one central place, not sure yet
	 * @return
	 * the amount of money made at all tills as of calling the method
	 */
	public double countMoney()
	{	
		for(Till s : tills)
		{
			moneyEarnt += s.getMoneyTaken();
		}
		
		return moneyEarnt;
	}
}
