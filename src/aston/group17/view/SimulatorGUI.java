package aston.group17.view;
import aston.group17.simulator.*;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
	private JButton startButton = new JButton("Start");
	private JButton autoButton = new JButton("Auto Run");
	private JButton quitButton = new JButton("Quit");
	
	//log fields
	private DecimalFormat df = new DecimalFormat("####0.00");
	private double[] moneyTakenArray, moneyLostArray, moneyLostSalesArray;
	private ArrayList<Double> configNetIncome = new ArrayList<Double>();
	
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
			priceSlider.createCustomLabel(100, 400, 100, 100, true);
			
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
			startButton.setToolTipText("Start the simulation using custom parameters");
			quitButton.setToolTipText("Quit application");
			autoButton.setToolTipText("Start the simulation with preset parameters to find perfect configuration");
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
			buttons.add(autoButton);
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
				setParameters(false);
				}
			});
			
			autoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setParameters(true);
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
	private void setParameters(boolean auto){
		
		final int blankSpace = 2;  // blank at edge of panels
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
//		menuFrame.setPreferredSize(new Dimension(375,400));
		
		
		buttons.setLayout(new FlowLayout());
		buttons.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		sliders.setLayout(new GridLayout(2, 1, 0, 10));

		combos.setLayout(new GridLayout(5, 1, 0, 10));
		combos.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
//	 Step 5: Add components to containers 
		buttons.add(runButton);
		buttons.add(closeWindowButton);
		
		if(!auto)
		{
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
			sliders.add(periodSlider);
		}
		sliders.add(priceSlider);
		
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
			setUpSimulation(auto);
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
	private void setUpSimulation(boolean auto){
		startButton.setText("Reset");
		startButton.setToolTipText("Reset the simualtion");
		
		double p, q, price;
		int pumps, tills, ticks;
		boolean trucks;
		
		closeWindow(menuFrame);
		if(!auto)
		{
			
			p = (Double)pChoice.getSelectedItem();
			q = (Double)qChoice.getSelectedItem();
			pumps = (Integer)pumpChoice.getSelectedItem();
			tills = (Integer)tillChoice.getSelectedItem();
			ticks = periodSlider.getValue()*360;
			price = (double)priceSlider.getValue() / 100;
			trucks = truckBox.isSelected();
			
			runSimulation(p,q,pumps,tills,ticks,price,trucks, false);
		}
		else
		{
			price = (double)priceSlider.getValue() / 100;
			for(p = 0.01; p <=0.05; p = p + 0.01)
			{
				for(q = 0.01; q <=0.05; q = q + 0.01)
				{
					for(pumps = 1; pumps <= 3; pumps++)
					{
						if(pumps==3){pumps=4;};
						for(tills = 1; tills <= 3; tills++)
						{
							if(tills==3){tills=4;};
							for(int tAllowed = 0; tAllowed <= 1; tAllowed++)
							{
								if(tAllowed == 0)
								{
									trucks = false;
								}
								else
								{
									trucks = true;
								}
								runSimulation(p,q,pumps,tills,1440,price,trucks, true);
							}
						}
					}
				}
			}
		}
	}
	

	private void runSimulation(double p, double q, int pumps, int tills, int ticks, double price, boolean trucks, boolean auto) {
		for(int i = 0; i < 10; i++)
		{
			simulator = new Simulator (p , q, pumps, tills, price, trucks);
			simulator.simulate(p,q,pumps,tills,1440,price,trucks, true);
			
			if(!auto)
			{
				listDataToLog(i);
				sysoutData();
			}
			
			setRunMoney(i);
			
			log.append(outputRunConfig(pumps, tills, p, q, price, trucks));
			System.out.println(outputRunConfig(pumps, tills, p, q, price, trucks));
			findAverages();
		}
	}

	private void sysoutData() {
		System.out.println("Money Taken: £" + df.format(simulator.countTakenMoney()));
		System.out.println("Money Lost: £" + df.format(simulator.countLostMoney()));
		System.out.println("Money Lost in Sales: £" + df.format(simulator.countLostSales()));
		System.out.println("");
		System.out.println("Net Income: £"+ df.format(simulator.countTakenMoney() - (simulator.countLostMoney() + simulator.countLostSales())));
	}
	
	/**
	 * outputs the configuration of the simulation to the GUI log
	 * @param pumps
	 * @param tills
	 * @param p
	 * @param q
	 * @param price
	 */
	private String outputRunConfig(int pumps, int tills, double p, double q, double price, boolean trucks) {
		//appends the configuration of the ten runs to the GUI's log
		StringBuffer sb = new StringBuffer();
		sb.append("Configuration:\n");
		sb.append("Pumps: "+pumps+"\n");
		sb.append("Tills: "+tills+"\n");
		sb.append("P: "+p+"\n");
		sb.append("Q: "+q+"\n");
		sb.append("Price: £"+df.format(price)+"\n");
		sb.append("Trucks allowed: "+trucks+"\n");
		sb.append("\n");
		return sb.toString();
	}
	/**
	 * finds averages of all data from all 10 runs and outputs to the GUI's log
	 */
	private void findAverages() {
		double totalMoneyTaken = 0.0;
		double totalLostMoney = 0.0;
		double totalLostSalesMoney = 0.0;
		
		for(int i = 0; i < 10; i++)
		{
			totalMoneyTaken += moneyTakenArray[i];
			totalLostMoney += moneyLostArray[i];
			totalLostSalesMoney += moneyLostSalesArray[i];
		}
		
		double avgMoneyLost = (totalLostMoney+totalLostSalesMoney)/10;
		
		double avgMoneyTaken = totalMoneyTaken/10;
		
		//appends the averages for money lost and money gained to the GUI's log
		log.append("Money Lost average: £"+df.format((totalLostMoney/10))+"\n");
		log.append("Money Lost in Sales average: £" + df.format((totalLostSalesMoney/10))+"\n");
		log.append("\n");
		log.append("Total Money Lost average: £" + df.format(avgMoneyLost)+"\n");
		log.append("Money Taken average: £"+df.format(avgMoneyTaken)+"\n");
		log.append("\n");
		log.append("Total Net Income average: £"+df.format(avgMoneyTaken - avgMoneyLost)+"\n");
		log.append("-------------------------------------------------------------------------");
		log.append("\n");
		configNetIncome.add(avgMoneyTaken - avgMoneyLost);
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
		log.append("Net Income: £" + df.format(simulator.countTakenMoney() - (simulator.countLostMoney() + simulator.countLostSales()))+"\n");
		
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

}


