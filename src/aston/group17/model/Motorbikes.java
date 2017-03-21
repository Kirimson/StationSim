package aston.group17.model;
import java.util.Random;

public class Motorbikes implements Vehicle {

	private int gallons;
	private double unitSpace;
	private Random rand;

	public Motorbikes(){
		gallons =5;
		unitSpace=0.75;
		rand = new Random();
	
	}
	
	public void setGallons(int gallons) {
		this.gallons = gallons;
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
