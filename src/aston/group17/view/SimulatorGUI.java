package aston.group17.view;
import aston.group17.simulator.*;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.border.*;

public class SimulatorGUI {
	
	private JFrame menuFrame;
	private JTextArea log;
	private Simulator simulator;
	
	//parameter
	private LabeledSlider priceSlider;
	private JComboBox<Double> pChoice = new JComboBox<Double>();
	private JComboBox<Double> qChoice = new JComboBox<Double>();
	private	JComboBox<Integer> pumpChoice = new JComboBox<Integer>();
	private JComboBox<Integer> tillChoice = new JComboBox<Integer>();
	private LabeledSlider periodSlider;
	private JCheckBox truckBox = new JCheckBox();
	
	//mainframe
	private final JLabel titleLabel = new JLabel("Group 17. Kieran, Mitchell, Zak, Harleen and Mo");
	private JButton startButton = new JButton();
	private JButton quitButton = new JButton();
	
	//log fields
	private DecimalFormat df = new DecimalFormat("####0.00");
	private double[] moneyTakenArray, moneyLostArray, moneyLostSalesArray;
	
	public static void main(String[] args)
	{
		new SimulatorGUI();
	}
	
	/**
	 * Constructor for SimulatorGUI, creates the main window, containing the log, start and quit buttons
	 * Also creates drop down fields for the parameters, to prevent adding options multiple times by
	 * multiple clicks of the start button
	 */
	public SimulatorGUI() {
		
		JFrame firstFrame = new JFrame();
		
//		firstFrame.getRootPane().setDefaultButton(startButton);
		
		final int blankSpace = 6;  // blank at edge of panels
		
		moneyTakenArray = new double[10];
		moneyLostArray = new double[10];
		moneyLostSalesArray = new double[10];
		
//		 Step 1: create the components
		
			//mainframe
			log = new JTextArea();
			log.setEditable(false);
			JScrollPane actionList = new JScrollPane(log);
			actionList.setPreferredSize(new Dimension(300, 300));
			actionList.setMinimumSize(new Dimension(200,200));
			
			//parameters			
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
			
			priceSlider = new LabeledSlider("Price of fuel: £", "", 100, 400, 120, 100);
			priceSlider.setMajorTickSpacing(100);
			createSliderLabels(priceSlider, 100, 400, 100, 100, true);
			
			periodSlider = new LabeledSlider("Duration: ", " Hours", 1, 8, 4, 1);
			periodSlider.setMajorTickSpacing(1);
			
			pumpChoice.addItem(1);
			pumpChoice.addItem(2);
			pumpChoice.addItem(4);
			
			tillChoice.addItem(1);
			tillChoice.addItem(2);
			tillChoice.addItem(4);
			
//		 Step 2: Set the properties of the components
			
			//mainframe
			startButton.setText("Start");
			startButton.setToolTipText("Start the simulation");
			quitButton.setText("Quit");
			quitButton.setToolTipText("Quit application");
			
//		 Step 3: Create containers to hold the components
			
			//mainframe
			firstFrame = new JFrame("Fuelling Station Simulator");
			firstFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			
			JPanel buttons = new JPanel();
			JPanel title = new JPanel();
			
//		 Step 4: Specify LayoutManagers
			
			//mainframe
			firstFrame.setLayout(new BorderLayout());
			((JPanel)firstFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
			
			buttons.setLayout(new FlowLayout());
			buttons.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
					
			log.setLayout(new FlowLayout());
			log.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
					
			title.setLayout(new FlowLayout());
			title.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
			
//		 Step 5: Add components to containers 
			
			//mainframe
			buttons.add(startButton);
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
				
			startButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
				setParameters();
				}
			});
			
//				Step 7: Display GUI
				firstFrame.pack();
				firstFrame.setVisible(true);
	}
	
	/**
	 * Creates and displays the set parameter window,
	 * where all simulation parameters will be set by the user
	 */
	private void setParameters(){
		
		final int blankSpace = 6;  // blank at edge of panels
		log.setText("");
//	Step 1: create the components for the
		
		JButton runButton = new JButton("Run");
		JButton closeWindowButton = new JButton("Close");
		
		JLabel pLabel = new JLabel("Probability of P:  ", SwingConstants.RIGHT);
		JLabel qLabel = new JLabel("Probability of Q:  ", SwingConstants.RIGHT);
		JLabel pumpLabel = new JLabel("Amount of pumps:  ", SwingConstants.RIGHT);
		JLabel tillLabel = new JLabel("Amount of tills:  ", SwingConstants.RIGHT); 
		JLabel truckLabel = new JLabel("Include Trucks:  ", SwingConstants.RIGHT);
		
//		 Step 2: Set the properties of the components
	
		runButton.setToolTipText("Run the simulation");
		closeWindowButton.setToolTipText("Close window");
		truckBox.setSelected(true);
		
//	Step 3: Create containers to hold the components
		menuFrame = new JFrame("Set Parameters");
		menuFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JPanel sliders = new JPanel();
		JPanel combos = new JPanel();
		JPanel buttons = new JPanel();

//	 Step 4: Specify LayoutManagers
		menuFrame.setLayout(new BorderLayout());
		((JPanel)menuFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		menuFrame.setPreferredSize(new Dimension(375,400));
		
		
		buttons.setLayout(new FlowLayout());
		buttons.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		sliders.setLayout(new GridLayout(2, 1, 0, 10));

		combos.setLayout(new GridLayout(5, 1, 0, 10));
		combos.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
//	 Step 5: Add components to containers 
		buttons.add(runButton);
		buttons.add(closeWindowButton);
		
		combos.add(pLabel);
		combos.add(pChoice);
		
		combos.add(qLabel);
		combos.add(qChoice);
				
		combos.add(pumpLabel);
		combos.add(pumpChoice);
		
		combos.add(tillLabel);
		combos.add(tillChoice);
		
		combos.add(truckLabel);
		combos.add(truckBox);
		
		sliders.add(priceSlider);
		
		sliders.add(periodSlider);
		
		menuFrame.add(combos, BorderLayout.NORTH);
		menuFrame.add(sliders, BorderLayout.CENTER);
		menuFrame.add(buttons, BorderLayout.SOUTH);
	
//	 Step 6: Arrange to handle events in the user interface
		
			menuFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			closeWindow(menuFrame);
			}
		});    
			
			closeWindowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			closeWindow(menuFrame);
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
	
	/**
	 * Closes the JFrame passes as a parameter
	 * @param frame a JFrame object that will be closed
	 */
	private void closeWindow(JFrame frame) {
		frame.dispose();
	}

	/**
	 * Disposes of the parameter window and sets all variables to be used in the Simulator constructor
	 * Then loops through all 10 runs and finds averages of data.
	 */
	private void runSimulation(){
		startButton.setText("Reset");
		startButton.setToolTipText("Reset the simualtion");
		
		double p = (Double)pChoice.getSelectedItem();
		double q = (Double)qChoice.getSelectedItem();
		double price = (double)priceSlider.getValue() / 100;
		int pumps = (Integer)pumpChoice.getSelectedItem();
		int tills = (Integer)tillChoice.getSelectedItem();
		int ticks = periodSlider.getValue()*360;
		boolean trucks = truckBox.isSelected();
		
		closeWindow(menuFrame);
		
		for(int i = 0; i < 10; i++){ //To simulate the 10 runs through
			System.out.println("Run: " + (i + 1));
			simulator = new Simulator (p , q, pumps, tills, price, trucks);
			for(int k = 0; k < ticks; k++) //To simulate the amount of ticks
			{
				System.out.println("\nStep: "+ k +"\n");
			
				simulator.simulate();
			
				//console log. to be removed
				System.out.println("Money Taken: £" + df.format(simulator.countTakenMoney()));
				System.out.println("Money Lost: £" + df.format(simulator.countLostMoney()));
				System.out.println("Money Lost in Sales: £" + df.format(simulator.countLostSales()));
			}
			simulator.resetTruck();
			//lists the currents run data to the GUI's log
			listDataToLog(i);
			
			//set money taken/lost for this run
			setRunMoney(i);
		}
		
		outputRunConfig(pumps, tills, p, q, price);

		findAverages();
	}
	
	/**
	 * outputs the configuration of the simulation to the GUI log
	 * @param pumps
	 * @param tills
	 * @param p
	 * @param q
	 * @param price
	 */
	private void outputRunConfig(int pumps, int tills, double p, double q, double price) {
		//appends the configuration of the ten runs to the GUI's log
		log.append("Configuration:\n");
		log.append("Pumps: "+pumps+"\n");
		log.append("Tills: "+tills+"\n");
		log.append("P: "+p+"\n");
		log.append("Q: "+q+"\n");
		log.append("Price: £"+df.format(price)+"\n");
		log.append("\n");
	}
	/**
	 * finds averages of all data from all 10 runs and outputs to the GUI's log
	 */
	private void findAverages() {
		double avgTakenMoney = 0.0;
		double avgLostMoney = 0.0;
		double avgLostSalesMoney = 0.0;
		
		for(int i = 0; i < 10; i++)
		{
			avgTakenMoney += moneyTakenArray[i];
			avgLostMoney += moneyLostArray[i];
			avgLostSalesMoney += moneyLostSalesArray[i];
		}
		
		//appends the averages for money lost and money gained to the GUI's log
		log.append("Money Taken average: £"+df.format((avgTakenMoney/10))+"\n");
		log.append("Money Lost average: £"+df.format((avgLostMoney/10))+"\n");
		log.append("Money Lost in Sales average: £" + df.format((avgLostSalesMoney/10))+"\n");
		log.append("Total Money Lost average: £" + df.format((avgLostSalesMoney/10)+(avgLostMoney/10))+"\n");
	}

	/**
	 * Outputs field data to the GUI log, such as:
	 * run number, money taken/lost, total vehicles, total vehicles lost
	 * @param i current run number
	 */
	private void listDataToLog(int i) {
		//list the data of each run to the log
		log.append("Run: "+(i+1)+"\n");
		log.append("Money Taken: £" + df.format(simulator.countTakenMoney())+ "\n");
		log.append("Money Lost: £" + df.format(simulator.countLostMoney())+ "\n");
		log.append("Money Lost in Sales: £" + df.format(simulator.countLostSales())+"\n");
		log.append("Total money lost: £"+ df.format(simulator.countLostMoney() + simulator.countLostSales())+"\n");
		log.append("\n");
		
		log.append("Total Vehicles: "+simulator.getTotalVehicles()+"\n");
		log.append("Total Lost Vehicles: "+simulator.getTotalLostVehicles()+"\n");
		log.append("\n\n");
	}
	
	/**
	 * sets the value of moneyTakenArray and moneyLostArray in the 
	 * respective array index according to the current run
	 * @param i run number
	 */
	private void setRunMoney(int i){
		moneyTakenArray[i] = simulator.countTakenMoney();
		moneyLostArray[i] = simulator.countLostMoney();
		moneyLostSalesArray[i] = simulator.countLostSales();
	}
	
	private void createSliderLabels(LabeledSlider slider, int min, int max, int tick, int divider, boolean beDouble)
	{
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		
		for(int i = min; i <= max; i=i+tick)
		{
			if(beDouble)
			{
				labelTable.put(new Integer(i), new JLabel(String.valueOf((double)i/divider)));
			}
			else
			{
				labelTable.put(new Integer(i), new JLabel(String.valueOf(i/divider)));
			}
		}
		slider.changeLabels(labelTable);
	}

}


