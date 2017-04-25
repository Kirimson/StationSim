package aston.group17.model;

import java.util.ArrayList;


public class Station {
	private Shop shop;
	private ArrayList<Pump> pumps;
	private int totalVehicles, totalLostVehicles;
	private double moneyLost, fuelPrice;
	
	/**
	 * Contains a Shop and an ArrayList of Pumps, manages where Drivers will go
	 * @param pAmount Amount of pumps the Station will have
	 * @param tAmount Amount of tills the Shop will have
	 * @param price Price of fuel at the Station
	 */
	public Station(int pAmount, int tAmount, double price)
	{
		fuelPrice = price;
		//create a Shop and create tills inside depending on how many tills were specified in tAmount
		shop = new Shop(tAmount);
		
		//create new arrayList of Pump and create pumps inside depending on how many pumps were specified in pAmount
		pumps = new ArrayList<Pump>();
		
		for(int i = 0; i < pAmount; i++)
		{
			pumps.add(new Pump(price, i));
		}
	}
	
	/**
	 * Runs act methods for each part of the station, the Shop and Pump.
	 * If Driver is done at the Pump they are added to the Shop
	 */
	public void act()
	{
		shop.act();
		
		for(Pump p : pumps)
		{
			System.out.println(p.toString());
			if(p.getFirstDriver() != null)
			{		
				if(p.getFirstDriver().isDoneRefilling() && p.getFirstDriver().isAtPump())
				{
					addDriverToShop(p.getFirstDriver());
				}
				
				p.act();
			}
		}
	}
	
	/**
	* Adds a Driver to the shortest till queue
	* @param d Driver to be added to Shop
	*/
	public void addDriverToShop(Driver d){
		d.toggleShopping();
		shop.addNewDriver(d);
	}
	
	/**
	 * Returns the shortest pump queue, checks all pumps for the one with the shortest queue, then checks if the vehicle will fit in the shortest queue
	 * @param v Vehicle that will be checked against the queue to see if it can fit in any queue
	 * @return The pump object the vehicle will go in to. Returns null if v cannot fit in any pump queue
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
		if(shortestPump.willVehicleFit(v.getUnitSize()))
		{
			return shortestPump;
		}
		return null;
	}
	
	/**
	 * Gets a specified pump
	 * @param pump Pump number you want to return
	 * @return Pump object
	 */
	public Pump getPump(int pump)
	{
		return pumps.get(pump);
	}
	
	/**
	 * Returns the ArrayList of Pumps
	 * @return ArrayList of Pump
	 */
	public ArrayList<Pump> getPumpArray()
	{
		return pumps;
	}
	
	/**
	 * Adds vehicle to the shortest pump queue.
	 * @param d The driver to be added to the pump queue
	 * @return True if the Driver joined the Pump queue
	 */
	public void addDriverToPumpQueue(Driver d){
		Pump shortestPump = getShortestPumpQueue(d.getVehicle());
		
		if(shortestPump != null)
		{
			shortestPump.addToPumpQueue(d);
			totalVehicles++;
		}
		else
		{
			System.out.println("Couldn't Fit in pumps. Driver leaving");
			moneyLost += (d.getVehicle().getTankSize() - d.getVehicle().getTankFilled()) * fuelPrice;
			totalLostVehicles++;
		}
	}
	
	/**
	 * Gets the Station's Shop object
	 * @return Shop object
	 */
	public Shop getShop()
	{
		return shop;
	}
	
	/**
	 * Returns the amount of money the Station has lost from Vehicles unable to fit in the Pump queues
	 * @return Integer for moneyLost
	 */
	public double getMoneyLost()
	{
		return moneyLost;
	}
	
	/**
	 * Returns the amount of money gained from the Shop
	 * @return Double of total money gained from the Shop's Tills
	 */
	public double countMoney(){
		return shop.countMoney();
	}

	/**
	 * Returns the amount of money lost from unhappy Drivers
	 * @return Double of total money lost from lost Driver sales
	 */
	public double countLostSales() {
		return shop.countMoneyLost();
	}

	/**
	 * Returns the number of vehicles that left the station due to it being full
	 * @return Integer of totalLostVehicles
	 */
	public int getTotalLostVehicles() {
		return totalLostVehicles;
	}

	/**
	 * Returns the number of vehicles that have entered the Station
	 * @return Integer of totalVehicles
	 */
	public int getTotalVehicles() {
		return totalVehicles;
	}
	
	
}
