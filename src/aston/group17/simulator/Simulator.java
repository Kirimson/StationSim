package aston.group17.simulator;
import aston.group17.model.*;
import aston.group17.view.*;

import java.util.ArrayList;

import java.util.Random;

public class Simulator {
	private double p;
	private double q;
	private double t;
	
	private ArrayList<Vehicle> vehicles;
	private Station station;
	private Station updatedStation;
	private int step, seed;
	private Random rnd;
	
	private SimulatorGUI simGUI;
	
	public static void main(String[] args)
	{	
		int numSteps = 1; //default amount of steps
		
		if(args.length >= 1)
		{
			numSteps = Integer.parseInt(args[0]);
		}
		
		if(numSteps <= 0)
		{
			numSteps = 1;
		}
		
		int seed = 42;
		
		if(args.length >= 2)
		{
			seed = Integer.parseInt(args[1]);
		}
		
		Simulator s = new Simulator(seed);
		
		s.simulate(numSteps);
	}
	
	public Simulator(int seed)
	{
		t = 0.02;
		this.seed = seed;
		simGUI = new SimulatorGUI();
	}
	
	private void simulate(int numSteps)
	{
		
	}
}
