package aston.group17.model;
import java.util.Random;

public class Driver {
	private boolean shopping;
	private int minRefill, minShop, seed, totalTime;
	private double moneySpent;
	private Random rnd;
	
	public Driver()
	{
		shopping = false;
		rnd = new Random();
	}
	
	public String getVehicleType(){
		return "";
	}
	public void toggleShopping(){
		shopping = !shopping;
	}
}
