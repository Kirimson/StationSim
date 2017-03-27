package aston.group17.model;
import java.util.Random;

public class Driver {
	private boolean shopping;
	private int minRefill, minShop, seed, totalTime, shoppingTime;
	private double moneySpent;
	private Random rnd;
	private Station station;
	private Vehicle vehicle;
	private String vehicleType;
	
	public Driver(String type)
	{
		totalTime = 0;
		moneySpent = 0;
		rnd = new Random();
		shopping = false;
		
		switch(type){
			case "Car":
				vehicle = new Car();
				vehicleType = "Car";
				break;
			case "Sedan":
				vehicle = new Sedan();
				vehicleType = "Sedan";
				break;
			case "Truck":
				vehicle = new Truck();
				vehicleType = "Truck";
				break;
			case "Bike":
				vehicle = new Bike();
				vehicleType = "Bike";
				break;
			default:
				vehicle = new Car();
				vehicleType = "Car";
		}
	}
	
	/**
	 * This returns the vehicle the driver is driving.
	 */
	public Vehicle getVehicle(){	
		return vehicle;
	}
	
	/**
	 * This calculates the money a driver could spend shopping.
	 */
	
	public double moneySpent(){
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
	 * changes the driver's shopping state
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

	/*
	 * Calls the vehicle fill tank method
	 */
	public void fillTank() {
		vehicle.fill();
	}
}
