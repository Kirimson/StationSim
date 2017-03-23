package aston.group17.model;

import java.util.ArrayList;

public class Station {
	private ArrayList<Till> tills;
	private ArrayList<Pump> pumps;
	
	private double moneyEarnt;
  	private Vehicle tempVehicle;
	
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
			//check if the driver is shopping or not
			if(p.isdriverShopping() == false)
			{
				//check if the Driver done filling the vehicle. So they may enter the shop
				p.fillFirstVehicle();
			}
			else if(p.isdriverShopping() == true) //The driver is in the shop and does shop stuff
			{
				//do some shop stuff, like set driver in shopping state and entering them into a shop
			}
			else //The driver is done and will now leave the pump
			{
				p.removeVehicleFromPumpQueue();
			}
		
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
		//create temp pump that will be used to track best pump for vehicle (shortest queue)
		Pump shortestPump = pumps.get(0);
		//loop through pumps, using p as each pump
		for(Pump p : pumps)
		{
			//compare how much is free in both temp pump and 'p'
			if(p.getQueueFree() > shortestPump.getQueueFree())
			{
				//if 'p' pump is shorter than temp pump, temp pump becomes p
				shortestPump = p;
			}
		}
		//checks if vehicle can fit in the shortest pump queue
		if(shortestPump.willVehicleFit(v))
		{
			//if it can, return the pump
			return shortestPump;
		}
		//if not, return null
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
	public boolean addVehicleToPumpQueue(Vehicle vehicle){
		//find the shortest pump queue for the vehicle to go in, if there is any
		Pump shortestPump = getShortestPumpQueue(vehicle);
		
		//if there is a pump the vehicle can go into
		if(shortestPump != null)
		{
			//add the vehicle to this pump queue
			shortestPump.addVehicleToPumpQueue(vehicle);
			return true;
		}
		// return false to the simulator class
		return false;
	}
	
	/*
	 * adds all money gained from each pump and shop and adds it to moneyEarnt
	 * Might just be called at the end of simulation to get all money in one central place, not sure yet
	 */
	public double countMoney()
	{
		for(Pump p : pumps)
		{
			moneyEarnt += p.getMoneyTaken();
		}
		
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
