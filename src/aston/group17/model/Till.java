package aston.group17.model;


import java.util.ArrayList;

public class Till {
	private double moneyTaken;
	private Driver currentCustomer;
	private int currentCustomerPrice;
	private ArrayList<Driver> waitingCustomer;
	private ArrayList<Driver> idleCustomer;
	private int noOfCustomers;
	
	public Till(){
		moneyTaken = 0;
		waitingCustomer = new ArrayList<Driver>();
		idleCustomer = new ArrayList<Driver>();
		noOfCustomers = 0;	
	}
	
	/**
	* Returns the queue at the till
	*/
	public int getQueueTill(){
		return noOfCustomers;
		
	}

	/**
	* Moves along the queue and returns a driver.
	*/
	public void getNextDriver(){
		for (int i = 0; i< waitingCustomer.size(); i++){
			currentCustomer = waitingCustomer.get(i);
		}
		
	} 

	/**
	* Returns the total money taken in from that till
	*/
	public double getMoneyTaken(){

		return moneyTaken;
	}
	// adds one driver to till queue
	public void setQueueTill(){
		noOfCustomers++;
	}
	
	// adds money taken at till to total
	public void setMoneyTaken(double money){
		moneyTaken += money;
	}
}
