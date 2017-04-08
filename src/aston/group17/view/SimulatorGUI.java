package aston.group17.view;
import aston.group17.simulator.*;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.*;

public class SimulatorGUI {
	
	private JFrame menuFrame;
	private JTextArea log;
	private Simulator simulator;
	

	private LabeledSlider priceSlider;
	private JComboBox<Double> pChoice = new JComboBox<Double>();
	private JComboBox<Double> qChoice = new JComboBox<Double>();
	private	JComboBox<Integer> pumpChoice = new JComboBox<Integer>();
	private JComboBox<Integer> tillChoice = new JComboBox<Integer>();
	private LabeledSlider periodTime;
	private final JLabel titleLabel = new JLabel("Group 17. Kieran, Mitchell, Zak, Harleen and Mo");
	private JButton startButton = new JButton();
	private JButton resetButton = new JButton();
	private JButton quitButton = new JButton();
	private DecimalFormat df = new DecimalFormat("####0.00");

	
	public static void main(String[] args)
	{
		new SimulatorGUI();
	}
	
	public SimulatorGUI() {
		
		JFrame firstFrame;
		
		final int blankSpace = 6;  // blank at edge of panels
		
//		 Step 1: create the components	
			log = new JTextArea();
			log.setEditable(false);
			JScrollPane actionList = new JScrollPane(log);
			actionList.setPreferredSize(new Dimension(300, 300));
			actionList.setMinimumSize(new Dimension(200,200));
			
//		 Step 2: Set the properties of the components
			startButton.setText("Start");
			startButton.setToolTipText("Start the simulation");
			resetButton.setText("Reset");
			resetButton.setToolTipText("Reset the simulation");
			quitButton.setText("Quit");
			quitButton.setToolTipText("Quit application");
			
//		 Step 3: Create containers to hold the components
			firstFrame = new JFrame("Fuelling Station Simulator");
			firstFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			
			JPanel buttons = new JPanel();
			JPanel title = new JPanel();
			
//		 Step 4: Specify LayoutManagers
			firstFrame.setLayout(new BorderLayout());
			((JPanel)firstFrame.getContentPane()).setBorder(new 
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
			
//		 Step 5: Add components to containers 
			buttons.add(startButton);
			buttons.add(resetButton);
			buttons.add(quitButton);
			firstFrame.add(buttons, BorderLayout.SOUTH);
			firstFrame.add(actionList, BorderLayout.CENTER);
			firstFrame.add(titleLabel, BorderLayout.NORTH);
					
//		 Step 6: Arrange to handle events in the user interface
			
			firstFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
				exitApp();
				}
			});    
				
				quitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				exitApp();
				}
			});
				
			resetButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
				resetApp();
				}
			});
				
			startButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
				setParameters();
				}
			});
			
//				Step 7: Display GUI
				firstFrame.pack();
				firstFrame.setVisible(true);
	}
	
	private void setParameters(){
		
		final int blankSpace = 6;  // blank at edge of panels
	
//	Step 1: create the components for the 
		JButton runButton = new JButton();
		JButton closeWindowButton = new JButton();
		
		pChoice.addItem(0.01);
		pChoice.addItem(0.02);
		pChoice.addItem(0.03);
		pChoice.addItem(0.04);
		pChoice.addItem(0.05);
		
		qChoice.addItem(0.01);
		qChoice.addItem(0.02);
		qChoice.addItem(0.03);
		qChoice.addItem(0.04);
		qChoice.addItem(0.05);
		
		priceSlider = new LabeledSlider("", 100, 400, 120);
		priceSlider.setMajorTickSpacing(50);
		
		pumpChoice.addItem(1);
		pumpChoice.addItem(2);
		pumpChoice.addItem(4);
		
		tillChoice.addItem(1);
		tillChoice.addItem(2);
		tillChoice.addItem(4);
	
		periodTime = new LabeledSlider("", 1440, 4230, 1440);
		periodTime.setMajorTickSpacing(800);
		
		JLabel pLabel = new JLabel();
		JLabel qLabel = new JLabel();
		JLabel pumpLabel = new JLabel();
		JLabel tillLabel = new JLabel(); 
		JLabel priceLabel = new JLabel();
		JLabel ticksLabel = new JLabel();
		
//		 Step 2: Set the properties of the components
	
		runButton.setText("Run");
		runButton.setToolTipText("Run the simulation");
		closeWindowButton.setText("Close");
		closeWindowButton.setToolTipText("Close window");
		
		pLabel.setText("Set probability of P: ");
		qLabel.setText("Set probability of Q: ");
		priceLabel.setText("Set price of fuel in pence: ");
		tillLabel.setText("Set number of Tills: ");
		pumpLabel.setText("Set number of Pumps: ");
		ticksLabel.setText("Set amount of ticks(1tick = 10s): ");
		
//	Step 3: Create containers to hold the components
		menuFrame = new JFrame("Set Parameters");
		menuFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JPanel sliders = new JPanel();
		JPanel buttons = new JPanel();

//	 Step 4: Specify LayoutManagers
		menuFrame.setLayout(new BorderLayout());
		((JPanel)menuFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		buttons.setLayout(new FlowLayout());
		buttons.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
			
		sliders.setLayout(new GridLayout(6, 1, 0, 10));

//	 Step 5: Add components to containers 
		buttons.add(runButton);
		buttons.add(closeWindowButton);
		
		sliders.add(pLabel);
		sliders.add(pChoice);
		
		sliders.add(qLabel);
		sliders.add(qChoice);
		
		sliders.add(priceLabel);
		sliders.add(priceSlider);
		
		sliders.add(pumpLabel);
		sliders.add(pumpChoice);
		
		sliders.add(tillLabel);
		sliders.add(tillChoice);
		
		sliders.add(ticksLabel);
		sliders.add(periodTime);
		
		menuFrame.add(sliders, BorderLayout.NORTH);
		menuFrame.add(buttons, BorderLayout.SOUTH);
	
//	 Step 6: Arrange to handle events in the user interface
		
			menuFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			closeWindow();
			}
		});    
			
			closeWindowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			closeWindow();
			}
		});
		
			runButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			runSimulation();
			}
		});
			
//	Step 7: Display GUI
		menuFrame.pack();
		menuFrame.setVisible(true);
	}
	
	private void exitApp() {
		int response = JOptionPane.showConfirmDialog(menuFrame, 
				"Do you wish to quit the application?",
				"Quit?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	private void closeWindow() {
		menuFrame.dispose();
	}
	
	private void resetApp(){
		setParameters();
	}

	private void runSimulation(){
		double p = (Double)pChoice.getSelectedItem();
		double q = (Double)qChoice.getSelectedItem();
		double price = (double)priceSlider.getValue() / 100;
		int pumps = (Integer)pumpChoice.getSelectedItem();
		int tills = (Integer)tillChoice.getSelectedItem();
		int ticks = periodTime.getValue();
		simulator = new Simulator (p , q, pumps, tills, price);
		menuFrame.dispose();
		
		for(int i = 0; i < 11; i++){ //To simulate the 10 runs through
			System.out.println("Run: " + (i + 1));
			int k;
			for(k = 0; k < ticks; k++) //To simulate the amount of ticks
			{
				System.out.println("Step: "+ k +"\n");
			
				simulator.simulate();
			
				System.out.println("Money Taken: £" + df.format(simulator.countMoney()));
				System.out.println("Money Lost: £" + df.format(simulator.countLostMoney()));
				listDataToLog();
				
			}
			k = 0;
			simulator.resetStats();
		}
	}
	
	private void listDataToLog() {
		log.append(simulator.toString());
		log.append("Money Taken: £" + df.format(simulator.countMoney())+ "\n");
		log.append("Money Lost: £" + df.format(simulator.countLostMoney())+ "\n");

	}

}


