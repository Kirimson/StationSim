package aston.group17.model;
import java.util.Random;

class Truck extends Vehicle{
	
	private static final double UNIT_SIZE = 2.0;
	private Random rand;
	
	public Truck(int globalSeed){
		super(10, 30, globalSeed);
		vehicleType = "Truck";
		rand = new Random(globalSeed);
	}

	public double getUnitSize() {
		return UNIT_SIZE;
	}

	public int timeToSpendShopping() {
		int timeSpent = rand.nextInt(2)+4;
		return timeSpent * 6;
	}

	public double moneySpentForShopping() {
		double moneySpent = rand.nextInt(5)+15;
		return moneySpent;
	}

}
