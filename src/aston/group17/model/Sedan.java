package aston.group17.model;
import java.util.Random;
/**
 * A Sedan vehicle, child class of Vehicle
 * 
 * @author Kieran Gates
 * @author Mitch Feaver
 *
 * @version 2017.4.28
 */
public class Sedan extends Vehicle {

	private static final double UNIT_SIZE = 1.5;
	private Random rand;

	public Sedan(int globalSeed){
		super(7, 12, globalSeed);
		vehicleType = "Sedan";
		rand = new Random(globalSeed);
	}
	
	public double getUnitSize() {
		return UNIT_SIZE;
	}

	public int timeToSpendShopping(){
		int timeSpent = rand.nextInt(4)+2;
		return timeSpent * 6;	
	}
	
	public double moneySpentForShopping(){
		double moneySpent = rand.nextInt(9)+8;
		return moneySpent;
	}
	
}
