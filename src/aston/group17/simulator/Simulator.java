package aston.group17.simulator;
import aston.group17.model.*;
import aston.group17.view.*;

import java.util.ArrayList;

import java.util.Random;

public class Simulator {
	private double p;
	private double q;
	private double t; //truck probability
	
	private Driver tempDriver;
	private Station station;
	private Station updatedStation;
	private int step, seed;
	private Random rnd;
	
	private static SimulatorGUI simGUI;
	
	public static void main(String[] args)
	{
		simGUI = new SimulatorGUI();
	}
	
	public Simulator(int numSteps, int p, int q, int pumps, int tills)
	{
		t = 0.02;
		station = new Station(pumps, tills);
	}
	
	private void simulate(int numSteps)
	{
		for(int i = 0; i < numSteps; i++)
		{
			//Simulation code
		}
	}
}
