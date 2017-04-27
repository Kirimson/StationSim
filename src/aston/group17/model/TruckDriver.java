package aston.group17.model;

public class TruckDriver extends Driver{
	
	private static double probability = 0.02;
	public TruckDriver()
	{
		super("Truck");
	}

	public double getProbability() {
		return probability;
	}

	/**
	 * Sets the probability for future truckDrivers arriving depending on time spent
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
	 * Set the value of truckDriver's probability to its original
	 * @param resetValue the value 
	 */
	public void setProbability(double resetValue)
	{
		probability = resetValue;
	}
}
