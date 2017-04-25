package aston.group17.model;

import java.util.ArrayList;

public class Till {
	private double moneyTaken;
	private double moneyLost;
	private ArrayList<Driver> drivers;
	private boolean tillInUse;
	private int tillNumber;

	/**
	 * A Till which contains a queue of Drivers and keeps track of money made from
	 * Pumps and Shops well as money lost from unhappy Drivers
	 * @param number Number Till this is in the Shop. Purely used for Console output. Can be made redundant
	 */
	public Till(int number)
	{
		moneyTaken = 0;
		tillInUse = false;
		drivers = new ArrayList<Driver>();
		tillNumber = number;
	}

	/**
	 * Till allows the first Driver in the queue to act,
	 * and adds their money to the Till's moneyEarnt if they have finished paying
	 */
	public void act()
	{
		// gets current driver and its money adds it to tills total
		if(getFirstDriver() != null){
			
			getFirstDriver().act();
			
			if(getFirstDriver().isDone()){
				addMoneyTaken(getFirstDriver().getPumpMoney() + getFirstDriver().getShopMoney());
								
				System.out.println("NEW TOTAL MONEY TAKEN: "+moneyTaken);
				
				if(drivers.size() - 1 == 0){
				tillInUse = false;
				}else{
					tillInUse = true;
				}
				removeDriver();
			}
		}
	}
	

	/**
	 * Returns the Till's current use status
	 * @return True if the Till has an empty queue
	 */
	public boolean isTillInUse()
	{
		return tillInUse;
	}

	/**
	 * Adds a Driver to the Till
	 * @param d Driver to be added to the Till queue
	 */
	public void addDriver(Driver d)
	{
		d.setTillNumber(tillNumber);
		drivers.add(d);
		
		if(!d.didShop())
		{
			moneyLost += d.getShopMoney();
		}
		
		setTillInUse();
	}

	/**
	 * Gets the current shopping Driver
	 * @return Driver object at the 0th index of the driver ArrayList
	 */
	public Driver getFirstDriver()
	{
		if(drivers.size() != 0){
			return drivers.get(0);
		}
		return null;
	}

	/**
	 * Returns the total money taken in from that till
	 * @return The amount of money the till has taken
	 */
	public double getMoneyTaken()
	{
		return moneyTaken;
	}
	
	/**
	 * Returns the total money lost from potential sales
	 * @return The amount of money the till has lost
	 */
	public double getMoneyLost()
	{
		return moneyLost;
	}

	/**
	 *  Toggles the status of the till, wither in use or free
	 */
	public void setTillInUse()
	{
		tillInUse = true;
	}

	/**
	 * Adds money taken at till to total
	 * @param money The amount of money the driver gives the till
	 */
	public void addMoneyTaken(double money)
	{
		moneyTaken += money;
	}

	/**
	 * Returns the size of the Tiil's queue
	 * @return Int of the Till's queue size
	 */
	public int getQueueLength() {
		if(!tillInUse)
		{
			return 0;
		}
		return drivers.size();
	}
	
	/**
	 * Removes the front Driver of the queue
	 */
	public void removeDriver()
	{
		drivers.remove(getFirstDriver());
	}
}
