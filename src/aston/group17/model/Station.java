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
		
		//create new arrayList of Pump and create pumos inside depending on how many pumps were specified in pAmount
		pumps = new ArrayList<Pump>();
		
		for(int i = 0; i < sAmount; i++)
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
			if(tills.get(i).getQueueShop() > shortestShop.getQueueShop()){
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
	public Pump getShortestPumpQueue(){
		Pump shortestPump = pumps.get(0);
		for (int i = 1; i<pumps.size();i++){
			if(pumps.get(i).getQueueFree() > shortestPump.getQueueFree()){
				shortestPump = pumps.get(i);
			}
		}
		return shortestPump;
	}
	
	public Pump getPump(int pump)
	{
		return pumps.get(pump);
	}
	
	/**
	* Adds vehicle to the shortest pump queue.
	*/
	public void addVehicleToPumpQueue(Vehicle vehicle){
		getShortestPumpQueue().addVehicleToPumpQueue(vehicle);
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
