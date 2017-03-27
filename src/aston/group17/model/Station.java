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
	* Returns the shortest shop queue available
	*/
	public Till getShortestShopQueue(){
		Till shortestShop = tills.get(0);
		for (int i = 1; i<tills.size();i++){
			if(tills.get(i).getQueueTill() > shortestShop.getQueueTill()){
				shortestShop = tills.get(i);
			}
		}
		return shortestShop;
	}
	
	/**
	* Sends customer to the shortest shop queue
	*/
	/*public void addDriverToShopQueue(Driver driver){
	
		getShortestShopQueue().addCustomerToShop(driver);
		
	}*/
	
	/**
	* Returns the shortest pump queue
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
