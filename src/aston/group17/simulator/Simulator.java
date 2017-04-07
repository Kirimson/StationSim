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
		Driver driver = new Driver("Car");
		return driver;
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
