package aston.group17.model;


import java.util.ArrayList;

public class Pump {

	
	private static final int GALLONTICK = 1;
	private double unitSpaceAvailable;
	private int queue;
	private static final double MAXQUEUE = 3.0;
	private Vehicle currentVehicle;
	private ArrayList<Vehicle> vehicleQueue;
	private static final double PRICEOFFUEL = 1.2;
	private double moneyTaken;
	
	private boolean justArrived, justFilled;
	private int driverShopping = 0;
	
	public Pump(){
		queue = 0;
		unitSpaceAvailable = 3;
		vehicleQueue = new ArrayList<Vehicle>();
		
	}
	
	/**
	* Checks to see if the pump is currently occupied. If the pump has less than the MAXQUEUE, it is available to use.
	* Else it is unavailable and the vehicle wouldn't be able to enter the queue.
	*/
	public double isFull(Vehicle v){;
		if (unitSpaceAvailable >= 0 && unitSpaceAvailable <= MAXQUEUE){
			if(v.getUnitSpace() < unitSpaceAvailable){
			return unitSpaceAvailable - v.getUnitSpace();
			}
		}
		return 0.0;
	}
	
	
	/**
	* Returns the number of spaces in the queue.
	*/
	public double getQueueFree(){
		return unitSpaceAvailable;
	}
	
	
	/**
	* Fills up the tank of the vehicle up one tick (1 gallon). If the vehicle has just arrived it wont fill and turn "justArrived" off
	*/
	public void fillFirstVehicle(){
		//If the driver hasn't justArrived (second tick of them being there and the tank isn't full yet
		if(justArrived == false && justFilled == false)
		{
			justFilled = vehicleQueue.get(0).FillTankOneTick();
		}
		
		//if driver is waiting before shopping they will now need to shop
		if(driverShopping == 1)
		{
			driverShopping = 2;
		}
		
		//if the car has just filled the vehicle set shopping to 1 (waiting before shopping)
		if(justFilled == true)
		{
			driverShopping = 1;
		}

	}
	
	/**
	* Increases the queue length free by the length of the current vehicle.
	* This means it has left the queue. The next vehicle will use the pump.
	*/
	public void freeUpQueue(Vehicle v){
		queue--;
		unitSpaceAvailable += v.getUnitSpace();
	}
	
	/**
	* Decreases the queue length free by the length of the current vehicle.
	* This means it has entered the queue
	*/
	public void fillUpQueue(Vehicle v){
		queue++;
		unitSpaceAvailable -= v.getUnitSpace();
	}
	
	/**
	* Adds a vehicle to the pump
	*/
	public void addVehicleToPumpQueue(Vehicle vehicle){
		vehicleQueue.add(vehicle);
		fillUpQueue(vehicle);
		vehicle.toggleQueueStatus();
	}
	
	/**
	* A pump will have several vehicles. removeVehicleFromPumpQueue method will iterate through those vehicles.
	* This means that when a vehicle leaves the queue, the next vehicle arrives at the pump. 
	* The next Vehicle in the queue is specified by this method.
	*/
	
	public void removeVehicleFromPumpQueue(){
		vehicleQueue.remove(getFirstVehicle());
		freeUpQueue(getFirstVehicle());
	}
	
	/**
	* Returns queue
	*/
	public int getQueue(){
		return queue;
	}
	
	/**
	* Returns list of vehicles. mainly used for testing
	*/
	public ArrayList<Vehicle> getVehicleQueue()
	{
		return vehicleQueue;
	}
	
	public Vehicle getFirstVehicle()
	{
		return vehicleQueue.get(0);
	}
	
	public double getMoneyTaken()
	{
		return moneyTaken;
	}
	
	public boolean isdriverShopping()
	{
		if(driverShopping == 2)
		{
			return true;
		}
		return false;
	}
	
	public boolean isJustFilled()
	{
		return justFilled;
	}
	
	public boolean willVehicleFit(Vehicle v)
	{
		if(unitSpaceAvailable - v.getUnitSpace() >= 0)
		{
			return true;
		}
		return false;
	}
	
}
