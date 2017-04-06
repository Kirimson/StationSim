package aston.group17.simulator;
import aston.group17.model.*;
import aston.group17.view.*;

import java.util.ArrayList;

import java.util.Random;

public class Simulator {
	private double t, p, q; //truck probability
	
	private Driver tempDriver;
	private Station station;
	private Station updatedStation;
	private int numSteps, tills, pumps;
	private Random rnd;
	

	
	public Simulator(int numSteps, double p, double q, int pumps, int tills, double price)
	{
		t = 0.02;
		this.p = p;
		this.q = q;
		this.numSteps = numSteps;
		this.pumps = pumps;
		this.tills = tills;
		station = new Station(pumps, tills, price);
		tempDriver = null;

	}
	
	public void simulate()
	{
		for(int i = 0; i < numSteps; i++)
		{
			System.out.println("Step: "+i);
			//Simulation code
			tempDriver = new Driver("Car");
			if(!station.addDriverToPumpQueue(tempDriver))
			{
				System.out.println("Couldn't Fit in pumps. Driver leaving");
			}
			station.act();
			System.out.println();
		}
	}
	
	private String generateVehicleType(){
		String vehicleType = "";
		double random = rnd.nextDouble();
		if(random <= p){
			vehicleType = "Car";
		}else if(random <= 2*p){
			vehicleType = "Bike";
		}else if(random <= 2*p + q){
			vehicleType = "Sedan";
		}else if(random <= 2*p + q + t){
			vehicleType = "Truck";
		}		
		return vehicleType;
	}
}
