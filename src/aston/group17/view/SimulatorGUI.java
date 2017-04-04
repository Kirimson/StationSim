package aston.group17.view;
import aston.group17.simulator.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class SimulatorGUI {
	
	private JFrame menuFrame;
	private LabeledSlider pSlider;
	private LabeledSlider qSlider;
	private LabeledSlider priceSlider;
	private LabeledSlider pumpSlider;
	private LabeledSlider tillSlider;
	private LabeledSlider periodTime;
	private JTextArea log;
	private Simulator simulator;
	
	public static void main(String[] args)
	{
		new SimulatorGUI();
	}
	
	public SimulatorGUI() {
		
		JFrame firstFrame;
			
		final int blankSpace = 6;  // blank at edge of panels

//		 Step 1: create the components
			JButton startButton = new JButton();
			JButton resetButton = new JButton();
			JButton quitButton = new JButton();
			final JLabel titleLabel = new JLabel("Group 17. Kieran Gates, Mitchell Feaver, Zak, Harleen and Mo");
			
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
		
		LabeledSlider pSlider; 
		LabeledSlider qSlider;
		LabeledSlider priceSlider;
		LabeledSlider periodTime;
	
//	Step 1: create the components for the 
		JButton runButton = new JButton();
		JButton resetButton = new JButton();
		JButton closeWindowButton = new JButton();
		
		pSlider = new LabeledSlider("Set probability of P ", 0, 5, 0);
		pSlider.setMajorTickSpacing(1);
		
		qSlider = new LabeledSlider("Set probability of Q ", 0, 5, 0);
		qSlider.setMajorTickSpacing(1);
		
		priceSlider = new LabeledSlider("Set price ", 0, 2, 0);
		priceSlider.setMajorTickSpacing(1);
		
		pumpSlider = new LabeledSlider("Set the number of pumps ", 0, 10, 0);
		pumpSlider.setMajorTickSpacing(1);
		
		tillSlider = new LabeledSlider("Set the number of tills ", 0, 10, 0);
		tillSlider.setMajorTickSpacing(1);
		
		periodTime = new LabeledSlider("Set the time period of ticks ", 0, 1440, 0);
		tillSlider.setMajorTickSpacing(140);
		
		JLabel sliderLabel1 = new JLabel();
		JLabel sliderLabel2 = new JLabel();
		JLabel sliderLabel3 = new JLabel();
		JLabel timeLabel= new JLabel();
//		 Step 2: Set the properties of the components
	
		runButton.setText("Run");
		runButton.setToolTipText("Run the simulation");
		closeWindowButton.setText("Close");
		closeWindowButton.setToolTipText("Close window");
		
		sliderLabel1.setText("Set probability of P ");
		sliderLabel2.setText("Set probability of Q ");
		sliderLabel3.setText("Set Price");
		timeLabel.setText("Set the time");
		
//	Step 3: Create containers to hold the components
		menuFrame = new JFrame("Fuelling Station Simulator");
		menuFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		menuFrame.setSize(600, 400);
		JPanel sliders = new JPanel();
		JPanel textArea = new JPanel();
		JPanel buttons = new JPanel();
		
		JPanel individualSlider1 = new JPanel();
		JPanel individualSlider2 = new JPanel();
		JPanel individualSlider3 = new JPanel();
		JPanel individualSlider4 = new JPanel();
		JPanel individualSlider5 = new JPanel();
		JPanel individualSlider6 = new JPanel();

//	 Step 4: Specify LayoutManagers
		menuFrame.setLayout(new BorderLayout());
		((JPanel)menuFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		buttons.setLayout(new FlowLayout());
		buttons.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
			
		sliders.setLayout(new GridLayout(6,1));
	
		textArea.setLayout(new FlowLayout());
		textArea.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		individualSlider1.setLayout(new FlowLayout());
		individualSlider2.setLayout(new FlowLayout());
		individualSlider3.setLayout(new FlowLayout());
		individualSlider4.setLayout(new FlowLayout());
		individualSlider5.setLayout(new FlowLayout());
		individualSlider6.setLayout(new FlowLayout());

//	 Step 5: Add components to containers 
		buttons.add(runButton);
		buttons.add(closeWindowButton);

		buttons.add(runButton);
		buttons.add(closeWindowButton);
		individualSlider1.add(sliderLabel1);
		individualSlider2.add(sliderLabel2);
		individualSlider3.add(sliderLabel3);

		individualSlider1.add(pSlider);
		individualSlider2.add(qSlider);
		individualSlider3.add(priceSlider);
		individualSlider4.add(pumpSlider);
		individualSlider5.add(tillSlider);
		individualSlider6.add(periodTime);
		
		sliders.add(pSlider);
		sliders.add(qSlider);
		sliders.add(priceSlider);
		sliders.add(pumpSlider);
		sliders.add(tillSlider);
		sliders.add(periodTime);

		menuFrame.add(sliders, BorderLayout.NORTH);
		menuFrame.add(buttons, BorderLayout.SOUTH);
	
		//textArea.add(timeLabel);
		//textArea.add(periodTime);
		
		//menuFrame.add(textArea,BorderLayout.WEST);
				
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
			startSimulation();
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
	
	
	private void startSimulation(){
//		double p = pSlider.getValue()/100;
//		double q = qSlider.getValue()/100;
//		int price = priceSlider.getValue();
//		int pumps = pumpSlider.getValue();
//		int tills = tillSlider.getValue();
//		int ticks = periodTime.getValue();
//		simulator = new Simulator (ticks, p , q, pumps, tills, price);
	}
}


