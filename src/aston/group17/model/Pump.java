package aston.group17.model;

import java.util.ArrayList;

public class Pump {

	
	private static final int GALLONTICK = 10;
	private double unitSpaceAvailable;
	private int queue;
	private static final double MAXQUEUE = 3.0;
	private Vehicle currentVehicle;
	private ArrayList<Vehicle> Vehicles;
	private static final double PRICEOFFUEL = 1.2;
	
	public Pump(){
		queue = 0;
		unitSpaceAvailable = 3;
		Vehicles = new ArrayList<Vehicle>();
		
	}
	
	/**
	* Checks to see if the pump is currently occupied. If the pump has less than the MAXQUEUE, it is available to use.
	* Else it is unavailable and the vehicle wouldn't be able to enter the queue.
	*/
	public boolean isOccupied(){
		if (unitSpaceAvailable >= 0 && unitSpaceAvailable <= MAXQUEUE){
			if(currentVehicle.getUnitSpace() > unitSpaceAvailable){
			return false;
			}
		}
		return true;
	}
	
	
	/**
	* Returns the number of spaces in the queue.
	*/
	public double getQueueFree(){
		return unitSpaceAvailable;
	}
	
	
	/**
	* Fills up the tank of the vehicle and returns the price of the fuel put into the vehicle
	*/
	public double vehicleCharge(){
		
		int fillAmount = currentVehicle.FillTank();
		double price = fillAmount * PRICEOFFUEL;
		
		return price;
	}
	
	/**
	* Decreases the queue length by the length of the current vehicle.
	* This means it has left the queue. The next vehicle will use the pump.
	*/
	public void decreaseQueue(){
		unitSpaceAvailable = unitSpaceAvailable - currentVehicle.getUnitSpace();
		nextVehicle();
	}
	
	
	/**
	* A pump will have several vehicles. NextVehicle method will iterate through those vehicles.
	* This means that when a vehicle leaves the queue, the next vehicle arrives at the pump. 
	* The next Vehicle in the queue is specified by this method.
	*/
	public void nextVehicle(){
		for (int i = 0; i<Vehicles.size(); i++){
			currentVehicle = Vehicles.get(i);
		}
		
	}
	
	/**
	* Adds a vehicle to the pump
	*/
	public void addVehicleToPump(Vehicle vehicle){
		Vehicles.add(vehicle);
		queue++;
		
	}
	
	/**
	* Returns queue
	*/
	public int getQueue(){
		return queue;
	}
	
}
