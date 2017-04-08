package aston.group17.simulator;
import aston.group17.model.*;


import java.util.Random;

public class Simulator {
	private double t, p, q; //truck probability
	private Station station;
	private Random rnd;
	private boolean newVehicle, vehicleLeft;
	private Driver newDriver;
	private double moneyGained, moneyLost, price;
	
	public Simulator(double p, double q, int pumps, int tills, double price)
	{
		t = 0.02;
		this.p = p;
		this.q = q;
		this.price = price;
		station = new Station(pumps, tills, price);
		rnd = new Random();
	}
	
	public void simulate()
	{
		
		newDriver = generateDriver();
		if(newDriver != null){
			System.out.println("New Driver of "+newDriver.getVehicleType()+" approaching");
			if(!station.addDriverToPumpQueue(newDriver))
			{
				vehicleLeft = true;
				setLost();
				System.out.println("Couldn't Fit in pumps. Driver leaving");
			}
			else
			{
				vehicleLeft = false;
				newVehicle = true;
			}
			System.out.println();
		}
		else
		{
			newVehicle = false;
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
		String text = new String();
		if(newVehicle && !vehicleLeft)
		{
			text += "A new vehicle has entered";
		}
		else if(newVehicle)
		{
			text += "A vehicle couldn't fit.\n";
		}

		text += "\n";
		return text;
	}
	
	private void setLost()
	{
		moneyLost += (newDriver.getVehicle().getTankSize() - newDriver.getVehicle().getTankFilled()) * price;
	}
	
	public double countMoney(){
		return station.countMoney();
	}
	
	public double countLostMoney()
	{
		return moneyLost;
	}
	
	public void resetStats(){
		moneyLost = 0;
		// moneyTaken = 0;
	}
}
