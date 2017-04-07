package aston.group17.simulator;
import aston.group17.model.*;


import java.util.Random;

public class Simulator {
	private double t, p, q; //truck probability
	private Station station;
	private Random rnd;
	private boolean newVehicle;
	private Driver newDriver;

	
	public Simulator(double p, double q, int pumps, int tills, double price)
	{
		t = 0.02;
		station = new Station(pumps, tills, price);
	}
	
	public void simulate()
	{
		
		newDriver = generateDriver();
		
		if(newDriver == null)
		{
			newVehicle = false;
		}
		else
		{

			//Simulation code


			if(!station.addDriverToPumpQueue(newDriver))
			{
				System.out.println("Couldn't Fit in pumps. Driver leaving");
			}
			else
			{
				newVehicle = true;
			}
		}
		
		station.act();
		System.out.println();
	}
	
	private Driver generateDriver(){
		Driver tempDriver = null;
		double random = rnd.nextDouble();
		
		if(random <= p){
			tempDriver = new Driver("Car");
		}else if(random <= 2*p){
			tempDriver = new Driver("Bike");
		}else if(random <= 2*p + q){
			tempDriver = new Driver("Sedan");
		}else if(random <= 2*p + q + t){
			tempDriver = new Driver("Truck");
		}else{
			return tempDriver;
		}
		return tempDriver;
	}
	
	public String toString()
	{
		if(newVehicle)
		{
			return "A new vehicle has entered";
		}
		else
		{
			return "";
		}
	}
}
