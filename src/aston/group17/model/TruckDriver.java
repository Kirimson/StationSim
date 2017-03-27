package aston.group17.model;

public class TruckDriver extends Driver{
	
	private double happiness;
	
	public TruckDriver()
	{
		super();
		happiness = 0.8;
		
	}

	public double getHappiness() {
		return happiness;
	}

	public void setHappiness(Boolean happy) {
		if(happy == false){
			happiness = happiness * 0.8;
		}else if (happiness < 0.8){
			happiness = happiness * 1.05;
		}
		
	}
}
