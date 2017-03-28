package aston.group17.model;

import java.util.ArrayList;

public class Station {
	private ArrayList<Till> tills;
	private ArrayList<Pump> pumps;
	
	private double moneyEarnt;
//  	private Driver tempDriver;
	
	/*
	 * @Param: pump amount
	 * @Param: till amount
	 */
	public Station(int pAmount, int sAmount)
	{
		//create new arrayList of Shop and create shops inside depending on how many shops were specified in sAmount
		tills = new ArrayList<Till>();
		
		for(int i = 0; i < sAmount; i++)
		{
			tills.add(new Till());
		}
		
		//create new arrayList of Pump and create pumps inside depending on how many pumps were specified in pAmount
		pumps = new ArrayList<Pump>();
		
		for(int i = 0; i < pAmount; i++)
		{
			pumps.add(new Pump());
		}
	}
	
	public void act()
	{
		for(Pump p : pumps)
		{
			
		
		}
	}
	
	/**
	* Returns a till that is not in use, first till that is free will be used, if any
	* @return
	* Returns the first Till object in tills that is not in sue. If all tills are in use, it returns null
	*/
	public Till getFreeTill(){
		Till freeTill = tills.get(0);
		for(Till t : tills){
			if(!t.isTillInUse())
			{
				return t;
			}
		}
		return null;
	}
	
	/**
	* Sends customer to the shortest till queue
	*/
	/*public void addDriverToShopQueue(Driver driver){
	
		getShortestShopQueue().addCustomerToShop(driver);
		
	}*/
	
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
		if(shortestPump.willVehicleFit(v))
		{
			return shortestPump;
		}
		return null;
	}
	
	public Pump getPump(int pump)
	{
		return pumps.get(pump);
	}
	
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
			
			return true;
		}
		return false;
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
	
//	public void addCustomer()
//	{
//		
//		for(Pump p: pumps)
//		{
//			if (!p.isFull(tempVehicle))
//			{
//				p.addVehicleToPumpQueue(tempVehicle);
//			}
//			
//		}
//	}
}
