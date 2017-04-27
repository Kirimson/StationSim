package aston.group17.simulator;
import aston.group17.model.*;


import java.util.Random;

public class Simulator {
	private double t, p, q;
	private Station station;
	private Random rnd;
	private Driver newDriver;
	private boolean trucks;
	
	public Simulator(double p, double q, int pumps, int tills, double price, boolean trucks)
	{
		t = 0.02;
		this.p = p;
		this.q = q;
		this.trucks = trucks;
		
		station = new Station(pumps, tills, price);
		rnd = new Random();
	}

	public void simulate(double p, double q, int pumps, int tills, int ticks, double price, boolean trucks, boolean auto) {
		//TODO make only 10 seeds for each run configuration
		for(int k = 0; k < ticks; k++) //To simulate the amount of ticks
		{
			newDriver = generateDriver();
			if(newDriver != null){
				station.addDriverToPumpQueue(newDriver);
			}
			
			station.act();
		}
		resetTruck();
		
		}
	
	private Driver generateDriver(){
		Driver tempDriver = null;
		double random = rnd.nextDouble();
		t = new TruckDriver().getProbability();
		
		if(random <= p){
			tempDriver = new Driver("Car");
		}else if(random <= 2*p){
			tempDriver = new Driver("Bike");
		}else if(random <= 2*p + q){
			tempDriver = new Driver("Sedan");
		}else if(random <= 2*p + q + t && trucks){
			tempDriver = new TruckDriver();
		}else{
			return tempDriver;
		}
		return tempDriver;
	}
	
	public double countTakenMoney(){
		return station.countMoney();
	}
	
	public double countLostMoney()
	{
		return station.getMoneyLost();
	}
	
	public double countLostSales()
	{
		return station.countLostSales();
	}

	public int getTotalVehicles() {
		return station.getTotalVehicles();
	}

	public int getTotalLostVehicles() {
		return station.getTotalLostVehicles();
	}

	public void resetTruck() {
		new TruckDriver().setProbability(0.02);
	}
}
