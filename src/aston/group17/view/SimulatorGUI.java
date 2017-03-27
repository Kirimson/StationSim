package aston.group17.view;
import aston.group17.simulator.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class SimulatorGUI {
	private JFrame mainFrame;
	private JTextArea log;
	
	public SimulatorGUI() {
		
		final int blankSpace = 6;  // blank at edge of panels

//	 Step 1: create the components
		JButton startButton = new JButton();
		JButton resetButton = new JButton();
		JButton quitButton = new JButton();
		final JLabel titleLabel = new JLabel("Group 17. Kieran Gates, Mitchell Feaver, Zak, Harleen and Mo");
		
		log = new JTextArea();
		log.setEditable(false);
		JScrollPane actionList = new JScrollPane(log);
		actionList.setPreferredSize(new Dimension(300, 300));
		actionList.setMinimumSize(new Dimension(200,200));
		
//	 Step 2: Set the properties of the components
		startButton.setText("Start");
		startButton.setToolTipText("Start the simulation");
		resetButton.setText("Reset");
		resetButton.setToolTipText("Reset the simulation");
		quitButton.setText("Quit");
		quitButton.setToolTipText("Quit application");
		
//	 Step 3: Create containers to hold the components
		mainFrame = new JFrame("Fuelling Station Simulator");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JPanel buttons = new JPanel();
		JPanel log = new JPanel();
		JPanel title = new JPanel();
		
//	 Step 4: Specify LayoutManagers
		mainFrame.setLayout(new BorderLayout());
		((JPanel)mainFrame.getContentPane()).setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		buttons.setLayout(new FlowLayout());
		buttons.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
				
		log.setLayout(new FlowLayout());
		log.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
				
		title.setLayout(new FlowLayout());
		title.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
//	 Step 5: Add components to containers 
		buttons.add(startButton);
		buttons.add(resetButton);
		buttons.add(quitButton);
		mainFrame.add(buttons, BorderLayout.SOUTH);
		mainFrame.add(actionList, BorderLayout.CENTER);
		mainFrame.add(titleLabel, BorderLayout.NORTH);
		
		
		
//	 Step 6: Arrange to handle events in the user interface
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//			exitApp();
			}
		});    
			
			quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			exitApp();
			}
		});
		
			startButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
//			setParameters();
			}
		});
			
//	Step 7: Display GUI
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}

