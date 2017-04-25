package aston.group17.model;

public class TruckDriver extends Driver{
	
	private static double probability = 0.02;
	private static int aa;
	public TruckDriver()
	{
		super("Truck");
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability() {
		if(totalTime <= 6*8)
		{
			if(probability != 0.02)
			{
				probability = probability * 1.05;
				System.out.println("increased t");
				aa=aa+5;
			}
			System.out.println("no chnage to t");
		}
		else
		{
			probability = probability * 0.8;
			aa=aa-20;
			System.out.println("decreased t");
		}

		System.out.println("woo2 "+probability + " aa: "+aa);
	}
	
	public void setProbability(double i)
	{
		probability = i;
		aa=0;
	}
	
	public int getAa()
	{
		return aa;
	}
}
