package aston.group17.model;


import java.util.ArrayList;

/**
 * @author Kieran Gates
 *
 */
public class Pump {

	private double unitSpaceAvailable;
	private int pumpNumber;
	private static final double MAX_QUEUE = 3.0;
	private ArrayList<Driver> queue;
	private double priceOfFuel = 1.2;
	
	/**
	 * A pump which will contain a queue of Drivers and will be used to fill vehicles using fuel, set to a price by the Station
	 * @param price Price of fuel
	 * @param pumpNumber Number pump at the Station
	 */
	public Pump(double price, int pumpNumber){
		priceOfFuel = price;
		this.pumpNumber = pumpNumber;
		unitSpaceAvailable = 3;
		queue = new ArrayList<Driver>();
	}
	
	/**
	 * Allows the first Driver in the Pump's queue to act
	 * if the Driver is still at the pump and needs to refuel
	 * If the Driver is done they will be removed from the Pump's queue
	 */
	public void act()
	{
		System.out.println(toString());
		if(getFirstDriver().isAtPump())
		{
			if(!getFirstDriver().isDoneRefilling())
			{
				getFirstDriver().act(priceOfFuel);
			}
		}
		else if(getFirstDriver().isDone())
		{
			removeDriver();
		}
	}
	
	/**
	* Checks that the pump is not full and can fit the Vehicle, denoted by its size.
	* @param size Size of the Vehicle that is being compared against the queue
	* @return Size of the queue if the Vehicle entered it. returns 0.0 if Vehicle will not fit
	*/
	public double isFull(double size){;
		if (unitSpaceAvailable > 0 && unitSpaceAvailable <= MAX_QUEUE){
			if(size < unitSpaceAvailable){
			return unitSpaceAvailable - size;
			}
		}
		return 0.0;
	}
	
	/**
	* Returns the value of unitSpaceAvailable. The amount of space left at the Pump's queue
	* @return value of unitSpaceAvailable
	*/
	public double getQueueFree(){
		return unitSpaceAvailable;
	}
	
	/**
	 * Adds a driver to the pump queue, assigns the Driver their pump number
	 * and reduces the Pump's unitSpaceAvailable according to the Driver's Vehicle's unitSize
	 * @param driver The driver to be added
	 */
	public void addToPumpQueue(Driver driver){
		queue.add(driver);
		driver.assignPump(pumpNumber);
		unitSpaceAvailable -= driver.getVehicle().getUnitSize();
	}
	
	/**
	* Removes a Driver from the Pump's queue, adding to the Pumps unitSpaceAvaiable
	* according to the Driver's Vehicle's unitSize
	*/
	public void removeDriver(){
		unitSpaceAvailable += getFirstDriver().getVehicle().getUnitSize();
		queue.remove(0);
	}
	
	/**
	* Returns list of vehicles in the pumps queue
	* @return Queue field, containing ArrayList of Drivers
	*/
	public ArrayList<Driver> getVehicleQueue()
	{
		return queue;
	}
	
	/**
	 * Returns the first driver in the pump queue (the one at the pump itself)
	 * @return First driver in queue
	 */
	public Driver getFirstDriver()
	{
		if(unitSpaceAvailable == MAX_QUEUE){return null;}
		return queue.get(0);
	}
	
	/**
	 * Checks if the vehicle will fit inside the queue
	 * @param size Vehicle size that will be compared against the queue
	 * @return Boolean which is true if vehicle can fit in pump queue, false if not
	 */
	public boolean willVehicleFit(double size)
	{
		if(unitSpaceAvailable - size >= 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * toString method overwriting the original toString
	 */
	public String toString()
	{
		String list = new String();
		list += "Pump: "+(pumpNumber + 1)+"\n";
		list += "Queue size is: " + queue.size()+" Queue Free is: "+unitSpaceAvailable+"\n";
		for(int i = 0; i < queue.size(); i++){
			list += queue.get(i).toString()+"\n";
		}
		if(list.equals(""))
		{
			return "Empty";
		}
		return list;
	}
}
