package aston.group17.model;
import java.util.Random;


public class SmallCar implements Vehicle {

	private int gallons;
	private double unitSpace;
	private Random rand;
	
	
	public SmallCar(){
		gallons = 7;
		unitSpace = 1;
		rand = new Random();
	}
	
	
	
	public void setGallons(int gallons) {
		int a = rand.nextInt(2 + 1 - 0);
		gallons = gallons + a;
		
	}


/*	public void setUnitSpace(double unitSpace) {
		
	} */



	
	public int getGallons() {
		return gallons;
	}



	
	public double getUnitSpace() {
		return unitSpace;
	}

}
