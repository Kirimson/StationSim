package aston.group17.model;

import java.util.ArrayList;

public class Station {
	private ArrayList<Shop> shops;
	private ArrayList<Pump> pumps;
//	private Vehicle tempVehicle;
	
	public Station(int pAmount, int sAmount)
	{
		//create new arrayList of Shop and create shops inside depending on how many shops were specified in sAmount
		shops = new ArrayList<Shop>();
		
		for(int i = 0; i < sAmount; i++)
		{
			shops.add(new Shop());
		}
		
		//create new arrayList of Pump and create pumos inside depending on how many pumps were specified in pAmount
		pumps = new ArrayList<Pump>();
		
		for(int i = 0; i < sAmount; i++)
		{
			pumps.add(new Pump());
		}
	}
	
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
