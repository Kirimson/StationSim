package aston.group17.view;
import aston.group17.simulator.*;

import javax.swing.*;
import java.awt.*;

public class SimulatorGUI extends JFrame {
	private JFrame mainFrame;
	private Simulator s;
	
	public SimulatorGUI()
	{
		// Step 1: create the components
		JLabel pump1Label = new JLabel("Pump 1: ");
		// Step 2: Set the properties of the components
		
		// Step 3: Create containers to hold the components
		mainFrame = new JFrame("StationSim");
		
		// Step 4: Specify LayoutManagers
		
		// Step 5: Add components to containers
		
		// Step 6: Arrange to handle events in the user interface
		
		// Step 7: Display the GUI
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}

}
