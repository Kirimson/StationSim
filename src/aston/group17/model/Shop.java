package aston.group17.model;


import java.util.ArrayList;

public class Shop {
	private int moneyTaken;
	private Driver currentCustomer;
	private int currentCustomerPrice;
	private ArrayList<Driver> waitingCustomer;
	private ArrayList<Driver> idleCustomer;
	private int noOfCustomers;
	
	public Shop(){
		moneyTaken = 0;
		waitingCustomer = new ArrayList<Driver>();
		idleCustomer = new ArrayList<Driver>();
		noOfCustomers = 0;
		
	}
	
	/**
	* Returns the queue at the till
	*/
	public int getQueueShop(){
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
	public int getMoneyTaken(){
		
		return moneyTaken;
	}








}