package aston.group17.simulator;
import aston.group17.model.*;
import aston.group17.view.*;

import java.util.ArrayList;

import java.util.Random;

public class Simulator {
	private double t, p, q; //truck probability

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

	}
	
	public void simulate()
	{
		for(int i = 0; i < numSteps; i++)
		{
			System.out.println("Step: "+i);
			//Simulation code
//			tempDriver = new Driver("Car");
			if(!station.addDriverToPumpQueue(generateDriver()))
			{
				System.out.println("Couldn't Fit in pumps. Driver leaving");
			}
			station.act();
			System.out.println();
		}
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
}
