package aston.group17.model;


import java.util.ArrayList;

public class Pump {

	private double unitSpaceAvailable;
	private int pumpNumber;
	private static final double MAX_QUEUE = 3.0;
	private ArrayList<Driver> queue;
	private double priceOfFuel = 1.2;
	
	public Pump(double price, int pumpNumber){
		priceOfFuel = price;
		this.pumpNumber = pumpNumber;
		unitSpaceAvailable = 3;
		queue = new ArrayList<Driver>();
	}
	
	/**
	 * What the pump will do each tick
	 */
	public void act()
	{
		System.out.println(queue.size());
		for(int i = 0; i < queue.size(); i++){
//		System.out.println(queue.get(i).toString())
			System.out.println("anal" + queue.get(i).toString());

		}
		if(!getFirstDriver().isDone())
		{
			getFirstDriver().act(priceOfFuel);
		}
		else
		{
			System.out.println("Driver is leaving pump. Spent: " + getFirstDriver().getMoneySpentPump());
			removeDriverFromPumpQueue();
		}
	}
	
	/**
	* Checks if the pump is occupied. If unitSpaceAvailable is less then MAXQUEUE, it is available.
	* Otherwise it is unavailable and the vehicle can't enter the queue.
	* @param size
	* Size of the Vehicle that is being compared against the queue
	* @return
	* Size of the queue if the Vehicle entered it. returns 0.0 if Vehicle will not fit
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
	* @return
	* unitSpaceAvailable
	*/
	public double getQueueFree(){
		return unitSpaceAvailable;
	}
	
	/**
	 * Adds a driver to the pump queue
	 * @param driver 
	 * The driver to be added
	 */
	public void addToPumpQueue(Driver driver){
		queue.add(driver);
		driver.assignPump(pumpNumber);
		
		unitSpaceAvailable -= driver.getVehicle().getUnitSize();
		if(driver.equals(getFirstDriver()))
		{
			getFirstDriver().toggleQueueing();
		}
	}
	
	/**
	* A pump will have several vehicles. removeVehicleFromPumpQueue method will iterate through those vehicles.
	* This means that when a vehicle leaves the queue, the next vehicle arrives at the pump. 
	* The next Vehicle in the queue is specified by this method.
	*/
	public void removeDriverFromPumpQueue(){
		unitSpaceAvailable += getFirstDriver().getVehicle().getUnitSize();
		queue.remove(getFirstDriver());
		//new first driver is no longer queueing
		if(getFirstDriver() != null){
		getFirstDriver().toggleQueueing();
		}
	}
	
	/**
	* Returns list of vehicles in the pumps queue
	* @return
	* Queue field, containing ArrayList of Drivers
	*/
	public ArrayList<Driver> getVehicleQueue()
	{
		return queue;
	}
	
	/**
	 * Returns the first driver in the pump queue (the one at the pump itself)
	 * @return
	 * First driver in queue
	 */
	public Driver getFirstDriver()
	{
		if(unitSpaceAvailable == MAX_QUEUE){return null;}
		return queue.get(0);
	}
	
	/**
	 * Checks if the vehicle will fit inside the queue
	 * @param size
	 * Vehicle size that will be compared against the queue
	 * @return
	 * Boolean which is true if vehicle can fit in pump queue, false if not
	 */
	public boolean willVehicleFit(double size)
	{
		if(unitSpaceAvailable - size >= 0)
		{
			return true;
		}
		return false;
	}
	
	public double getUnitSpaceAvailable(){
		return unitSpaceAvailable;
		
	}
}
