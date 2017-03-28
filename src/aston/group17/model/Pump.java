package aston.group17.model;


import java.util.ArrayList;

public class Pump {

	private static final int GALLON_TICK = 1;
	private double unitSpaceAvailable;
	private int queueSize;
	private static final double MAX_QUEUE = 3.0;
	private Vehicle currentVehicle;
	private ArrayList<Driver> queue;
	private double priceOfFuel = 1.2;
	
	public Pump(){
		queueSize = 0;
		unitSpaceAvailable = 3;
		queue = new ArrayList<Driver>();
	}
	
	/**
	* Checks to see if the pump is currently occupied. If the pump has less than the MAXQUEUE, it is available to use.
	* Else it is unavailable and the vehicle wouldn't be able to enter the queue.
	*/
	public double isFull(double size){;
		if (unitSpaceAvailable >= 0 && unitSpaceAvailable <= MAX_QUEUE){
			if(size < unitSpaceAvailable){
			return unitSpaceAvailable - size;
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
	* Adds a vehicle to the pump
	*/
	public void addToPumpQueue(Driver driver){
		queue.add(driver);
		queueSize++;
		unitSpaceAvailable -= driver.getVehicle().getUnitSize();
	}
	
	/**
	* A pump will have several vehicles. removeVehicleFromPumpQueue method will iterate through those vehicles.
	* This means that when a vehicle leaves the queue, the next vehicle arrives at the pump. 
	* The next Vehicle in the queue is specified by this method.
	* 
	* A
	*/
	public void removeVehicleFromPumpQueue(){
		unitSpaceAvailable += getFirstDriver().getVehicle().getUnitSize();
		queue.remove(getFirstDriver());
		queueSize--;
	}
	
	/**
	* Returns queue
	*/
	public int getQueue(){
		return queueSize;
	}
	
	/**
	* Returns list of vehicles in the pumps queue
	* @return
	* returns the queue
	*/
	public ArrayList<Driver> getVehicleQueue()
	{
		return queue;
	}
	
	/**
	 * Returns the first driver in the pump queue (the one at the pump itself)
	 * @return
	 * returns the first driver in queue
	 */
	public Driver getFirstDriver()
	{
		return queue.get(0);
	}
	
	/**
	 * Checks if the vehicle will fit inside the queue
	 * @return
	 * returns boolean, true if vehicle can fit in pump queue, false if not
	 */
	public boolean willVehicleFit(Vehicle v)
	{
		if(unitSpaceAvailable - v.getUnitSize() >= 0)
		{
			return true;
		}
		return false;
	}
	
}
