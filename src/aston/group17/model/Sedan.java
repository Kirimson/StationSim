package aston.group17.model;
import java.util.Random;

public class Sedan extends Vehicle {

	private static final double UNIT_SIZE = 1.5;
	private Random rand;

	public Sedan(){
		super(7, 12);
		vehicleType = "Sedan";
		rand = new Random();
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
	
	@Override
	public boolean willShop(int driverTime) {
		int chance = rand.nextInt(10)+1;
		if(driverTime < 60)
			{
//				if(chance <= 4){
				return true;
//			}
		}
		return false;
	}
}
