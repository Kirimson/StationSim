package aston.group17.model;
import java.util.Random;
/**
 * A Car vehicle, child class of Vehicle
 * 
 * @author Kieran Gates
 * @author Mitch Feaver
 *
 * @version 2017.4.28
 */
public class Car extends Vehicle {

	private static final double UNIT_SIZE = 1.0;
	private Random rand;

	public Car(int globalSeed)
	{
		super(3, 7, globalSeed);
		vehicleType = "Car";
		rand = new Random(globalSeed);
	}
	
	public double getUnitSize() {
		return UNIT_SIZE;
	}
	
	public int timeToSpendShopping(){
		int timeSpent = rand.nextInt(2)+2;
		return timeSpent * 6;
	}
	
	public double moneySpentForShopping(){
		double moneySpent = rand.nextInt(5)+5;
		return moneySpent;
	}

}