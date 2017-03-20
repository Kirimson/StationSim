package aston.group17.simulator;
import aston.group17.model.*;
import aston.group17.view.*;

import java.util.ArrayList;

public class Simulator {
	private int p;
	private int q;
	private int t;
	
	private ArrayList<Vehicle> vehicles;
	private Station station;
	private Station updatedStation;
	private int step;
	
	private SimulatorGUI simGUI;
	
	public static void main(String[] args)
	{
		Simulator s = new Simulator();
	}
	
	public Simulator()
	{
		simGUI = new SimulatorGUI();
	}
}
