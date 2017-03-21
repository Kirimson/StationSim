package aston.group17.simulator;
import aston.group17.model.*;
import aston.group17.view.*;

import java.util.ArrayList;

public class Simulator {
	private double p;
	private double q;
	private double t;
	
	private ArrayList<Vehicle> vehicles;
	private Station station;
	private Station updatedStation;
	private int step, seed;
	
	private SimulatorGUI simGUI;
	
	public static void main(String[] args)
	{	
		Simulator s = new Simulator();
	}
	
	public Simulator()
	{
		t = 0.02;
		simGUI = new SimulatorGUI();
	}
}
