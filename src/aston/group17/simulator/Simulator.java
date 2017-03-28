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
	
	private static SimulatorGUI simGUI;
	
	public static void main(String[] args)
	{
		simGUI = new SimulatorGUI();
	}
	
	public Simulator(int numSteps, double p, double q, int pumps, int tills)
	{
		t = 0.02;
		this.p = p;
		this.q = q;
		this.numSteps = numSteps;
		this.pumps = pumps;
		this.tills = tills;
		station = new Station(pumps, tills);
		tempDriver = new Driver("");

	}
	
	private void simulate(int numSteps)
	{
		for(int i = 0; i < numSteps; i++)
		{
			//Simulation code
			station.addDriverToPumpQueue(tempDriver);
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
