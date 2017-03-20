package aston.group17.model;


import java.util.ArrayList;

public class Pump {

	
	private static final int GALLONTICK = 10;
	private double unitSpaceAvailable;
	private int queue;
	private static final double MAXQUEUE = 3.0;
	private Vehicle currentVehicle;
	private ArrayList<Vehicle> vehiclesInQueue;
	private static final double PRICEOFFUEL = 1.2;
	
	public Pump(){
		queue = 0;
		unitSpaceAvailable = 3;
		vehiclesInQueue = new ArrayList<Vehicle>();
		
	}
	
	/**
	* Checks to see if the pump is currently occupied. If the pump has less than the MAXQUEUE, it is available to use.
	* Else it is unavailable and the vehicle wouldn't be able to enter the queue.
	*/
	public boolean isFull(Vehicle v){
		if (unitSpaceAvailable >= 0 && unitSpaceAvailable <= MAXQUEUE){
			if(v.getUnitSpace() > unitSpaceAvailable){
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
	* Increases the queue length by the length of the current vehicle.
	* This means it has left the queue. The next vehicle will use the pump.
	*/
	public void increaseQueueUnit(){
		unitSpaceAvailable += currentVehicle.getUnitSpace();
	}
	
	/**
	* Decreases the queue length by the length of the current vehicle.
	* This means it has entered the queue
	*/
	public void decreaseQueueUnit(Vehicle v){
		unitSpaceAvailable -= currentVehicle.getUnitSpace();
	}
	
	
	/**
	* A pump will have several vehicles. NextVehicle method will iterate through those vehicles.
	* This means that when a vehicle leaves the queue, the next vehicle arrives at the pump. 
	* The next Vehicle in the queue is specified by this method.
	*/
	public void nextVehicle(){
		
	
	}
	
	/**
	* Adds a vehicle to the pump
	*/
	public void addVehicleToPumpQueue(Vehicle vehicle){
		vehiclesInQueue.add(vehicle);
		decreaseQueueUnit(vehicle);
		queue++;
	}
	
	/**
	* Adds a vehicle to the pump
	*/
	
	public void removeVehicleFromPumpQueue(Vehicle vehicle){
		vehiclesInQueue.remove(vehicle);
		queue--;
		
	}
	
	/**
	* Returns queue
	*/
	public int getQueue(){
		return queue;
	}
	
}
