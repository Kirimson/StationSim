package aston.group17.model;
import java.util.Random;

public class Driver {
	private boolean shopping;
	private int minRefill, minShop, seed, totalTime, shoppingTime;
	private double moneySpent;
	private Random rnd;
	private Station station;
	private Vehicle vehicle;
	
	public Driver(String type)
	{
		totalTime = 0;
		moneySpent = 0;
		rnd = new Random();
		shopping = false;
		
		switch(type){
			case "Car":
				vehicle = new Car();
				break;
			case "Sedan":
				vehicle = new Sedan();
				break;
			case "Truck":
				vehicle = new Truck();
				break;
			case "Bike":
				vehicle = new Bike();
				break;
			default:
				vehicle = new Car();
		}
	}
	/**
	 * This sets a vehicle to each driver. 
	 */
//	public void setVehicleOfDriver(Vehicle v){
//		vehicle = v;
//		
//	}
	
	/**
	 * This returns the vehicle the driver is driving.
	 */
	public Vehicle getVehicle(){	
		return vehicle;
	}
	
	/**
	 * This adds the driver to the station and to the pump initially.
	 */
//	public void addVehicleToPump(){
//		station.addToPumpQueue(vehicle);	
//	}
		
	
	
	/**
	 * This calculates the money a driver could spend shopping.
	 */
	
	public double moneySpent(){
		moneySpent = vehicle.moneySpent();
		
		return moneySpent;
		
	}
	
	/**
	 * This calculates the time a driver could potentially spend shopping.
	 */
	public int shoppingTime(){
		
		totalTime = vehicle.timeSpent();
		
		return totalTime;	
	}
	
	/*
	 * Returns vehicle type
	 */
	public String getVehicleType(){
		return "";
	}
	
	/*
	 * chnages the driver's shopping state
	 */
	public void toggleShopping(){
		shopping = !shopping;
	}
	
	/*
	 * Returns length of shopping in ticks
	 */
	public int getShoppingTime(){
		return shoppingTime;
	}
}
