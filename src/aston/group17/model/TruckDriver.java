package aston.group17.model;

/**
 * A Driver for the Truck class, sub class of Driver. Adds functionality for changing probability for all TruckDrivers
 * 
 * @author Kieran Gates
 * @author Mitch Feaver
 * 
 * @version 2017.5.3
 */
public class TruckDriver extends Driver{
	
	private static double probability = 0.02;
	public TruckDriver(int globalSeed)
	{
		super("Truck", globalSeed);
	}

	public double getProbability() {
		return probability;
	}

	/**
	 * Sets the probability for future truckDrivers arriving depending on time spent, by changing the static probability field
	 */
	public void setProbability() {
		if(totalTime <= 48)
		{
			if(probability != 0.02)
			{
				probability = probability * 1.05;
			}
		}
		else
		{
			probability = probability * 0.8;
		}
		
	}
	
	/**
	 * Set the value of truckDriver's probability 
	 * @param resetValue the value 
	 */
	public void setProbability(double resetValue)
	{
		probability = resetValue;
	}
}
