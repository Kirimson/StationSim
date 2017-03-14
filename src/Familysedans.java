import java.util.Random;

public class Familysedans implements Vehicle {

	private int gallons;
	private double unitSpace;
	private Random rand;

	public Familysedans(){
		gallons = 12;
		unitSpace= 1.5;
		rand = new Random();

		
	}
	
	public void setGallons(int gallons) {
		int a = rand.nextInt(6 + 1 - 0);
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
