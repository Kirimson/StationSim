package aston.group17.model;


//import java.util.ArrayList;

public class Till {
	private double moneyTaken;
	private Driver currentDriver;
//	private ArrayList<Driver> shoppingCustomer;
//	private ArrayList<Driver> idleCustomer;
	private boolean tillInUse;
	
	public Till(){
		moneyTaken = 0;
//		shoppingCustomer = new ArrayList<Driver>();
//		idleCustomer = new ArrayList<Driver>();
		tillInUse = false;	
	}
	
	/**
	* Returns the queue at the till
	* @return
	* returns a boolean of the till status
	*/
	public boolean isTillInUse(){
		return tillInUse;
	}

	/**
	* Gets the current shopping Driver
	* @return
	* Driver object
	*/
	public Driver getShoppingDriver(){
			return currentDriver;
		}

	/**
	* Returns the total money taken in from that till
	* @return
	* returns the amount of money the till has taken
	*/
	public double getMoneyTaken(){

		return moneyTaken;
	}
	/**
	 *  Toggles the status of the till, wither in use or free
	 */
	public void toggleTillInUse(){
		tillInUse = !tillInUse;
	}
	
	/**
	 * Adds money taken at till to total
	 * @param money
	 * The amount of money the driver gives the till, includes both shop purchase and pump purchase
	 */
	public void addMoneyTaken(double money){
		moneyTaken += money;
	}
}
