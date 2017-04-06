package aston.group17.model;

import java.util.ArrayList;

public class Till {
	private double moneyTaken;
	private ArrayList<Driver> drivers;
	private boolean tillInUse;
	private int driverTicksAtTill;
	private Driver currentDriver;
	private boolean newDriver;

	public Till()
	{
		moneyTaken = 0;
		tillInUse = false;
	}

	public void act()
	{
		// if the till is not being used get next driver

		if(!tillInUse)
		{
			// gets current driver and its money adds it to tills total

			if(getFirstDriver().getTillTime() == getFirstDriver().getCurrentTillTime()){

				addMoneyTaken(getFirstDriver().getTotalMoney());
				getFirstDriver().toggleDone();
				drivers.remove(getFirstDriver());
				System.out.println("Driver is leaving the till.");
			}
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
		//		toggleTillInUse();
		//		toggleNewDriver();
	}

	/**
	 * Gets the current shopping Driver
	 * @return
	 * Driver object
	 */
	public Driver getFirstDriver()
	{
		Driver tempDriver = null;

		if(drivers.get(0) != null){
			tempDriver = drivers.get(0);
		}
		return tempDriver;
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

	public int getQueueLength() {
		return drivers.size();
	}
}
