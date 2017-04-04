package aston.group17.model;

import java.util.ArrayList;

public class Till {
	private double moneyTaken;
	private ArrayList<Driver> drivers;
	private boolean tillInUse;
	private int ticksAtTill;
	private boolean newDriver;
	
	public Till()
	{
		moneyTaken = 0;
		tillInUse = false;
	}
	
	public void act()
	{
		if(newDriver)
		{
			
		}
	}
	
	/**
	* Returns the queue at the till
	* @return
	* returns a boolean of the till status
	*/
	public boolean isTillInUse()
	{
		return tillInUse;
	}
	
	/**
	 * Adds a Driver to the Till
	 * @param d
	 * Driver to be added to the Till
	 */
	public void addDriver(Driver d)
	{
		drivers.add(d);
		toggleTillInUse();
		toggleNewDriver();
	}
	
	/**
	* Gets the current shopping Driver
	* @return
	* Driver object
	*/
	public Driver getShoppingDriver()
	{
			return drivers.get(0);
	}

	/**
	* Returns the total money taken in from that till
	* @return
	* returns the amount of money the till has taken
	*/
	public double getMoneyTaken()
	{
		return moneyTaken;
	}
	
	/**
	 *  Toggles the status of the till, wither in use or free
	 */
	public void toggleTillInUse()
	{
		tillInUse = !tillInUse;
	}
	
	/**
	 *  Toggles the status of the the driver. If they have just arrived at till
	 */
	public void toggleNewDriver()
	{
		newDriver = !newDriver;
	}
	
	/**
	 * Adds money taken at till to total
	 * @param money
	 * The amount of money the driver gives the till, includes both shop purchase and pump purchase
	 */
	public void addMoneyTaken(double money)
	{
		moneyTaken += money;
	}
}
