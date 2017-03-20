package aston.group17.model;

import java.util.ArrayList;

public class Station {
	private ArrayList<Shop> shops;
	private ArrayList<Pump> pumps;
	private Vehicle tempVehicle;
	
	/**
	* Returns the shortest shop queue available
	*/
	public Shop getShortestShopQueue(){
		Shop shortestShop = shops.get(0);
		for (int i = 1; i<shops.size();i++){
			if(shops.get(i).getQueueShop() > shortestShop.getQueueShop()){
				shortestShop = shops.get(i);
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
	
	
	/**
	* Adds driver to the shortest pump queue.
	*/
	public void addDriverToPumpQueue(Driver driver){
		Vehicle vehicle = driver.getVehicle();
		getShortestPumpQueue().addVehicleToPump(vehicle);
		
	}*/
	
	public void addCustomer()
	{
		
		for(Pump p: pumps)
		{
			if (!p.isFull(tempVehicle))
			{
				p.addVehicleToPumpQueue(tempVehicle);
			}
			
		}
	}
}
