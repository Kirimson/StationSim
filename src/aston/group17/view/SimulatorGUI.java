package aston.group17.view;
import aston.group17.simulator.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class SimulatorGUI {
	
	private JFrame menuFrame;
	private Simulator s;
	private JTextArea log;
	private Simulator simulator;
	
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
	
	private void resetApp(){
		setParameters();
	}
	private void setParameters(){
		
		final int blankSpace = 6;  // blank at edge of panels


		LabelledSlider pSlider; 
		LabelledSlider qSlider;
		LabelledSlider priceSlider;
		JTextField periodTime;
	
		
//	Step 1: create the components for the 
		JButton startButton = new JButton();
		JButton resetButton = new JButton();
		JButton quitButton = new JButton();
		
		pSlider = new LabelledSlider("Set probability of P ", 0, 5, 0);
		pSlider.setMajorTickSpacing(1);
		
		qSlider = new LabelledSlider("Set probability of Q ", 0, 5, 0);
		qSlider.setMajorTickSpacing(1);
		
		priceSlider = new LabelledSlider("Set price ", 0, 2, 0);
		priceSlider.setMajorTickSpacing(1);
		
		periodTime = new JTextField();
		periodTime.setPreferredSize(new Dimension(100,20));
		
		JLabel sliderLabel1 = new JLabel();
		JLabel sliderLabel2 = new JLabel();
		JLabel sliderLabel3 = new JLabel();
		JLabel timeLabel= new JLabel();
//		 Step 2: Set the properties of the components
		startButton.setText("Start");
		startButton.setToolTipText("Start the simulation");
		resetButton.setText("Reset");
		resetButton.setToolTipText("Reset the simulation");
		quitButton.setText("Quit");
		quitButton.setToolTipText("Quit application");
		
		sliderLabel1.setText("Set probability of P ");
		sliderLabel2.setText("Set probability of Q ");
		sliderLabel3.setText("Set Price");
		timeLabel.setText("Set the time");
//	 Step 3: Create containers to hold the components
		
		
		
//	Step 3: Create containers to hold the components
		menuFrame = new JFrame("Fuelling Station Simulator");
		menuFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		menuFrame.setSize(1000, 800);
		JPanel sliders = new JPanel();
		JPanel textArea = new JPanel();
		JPanel buttons = new JPanel();
		
		JPanel individualSlider1 = new JPanel();
		JPanel individualSlider2 = new JPanel();
		JPanel individualSlider3 = new JPanel();

//	 Step 4: Specify LayoutManagers
	
				
//	 Step 4: Specify LayoutManagers
		menuFrame.setLayout(new BorderLayout());
		((JPanel)menuFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		
		buttons.setLayout(new FlowLayout());
		buttons.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		
		
		sliders.setLayout(new GridLayout(3,2));
	
		
		
		textArea.setLayout(new FlowLayout());
		textArea.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		individualSlider1.setLayout(new FlowLayout());
		individualSlider2.setLayout(new FlowLayout());
		individualSlider3.setLayout(new FlowLayout());
		
		
//	 Step 5: Add components to containers 
		buttons.add(startButton);
		buttons.add(resetButton);
		buttons.add(quitButton);
		/*mainFrame.add(buttons, BorderLayout.SOUTH);
		mainFrame.add(actionList, BorderLayout.CENTER);
		mainFrame.add(titleLabel, BorderLayout.NORTH);*/
		
//	  Step 5: Add components to containers 		
		buttons.add(startButton);
		buttons.add(resetButton);
		buttons.add(quitButton);
		individualSlider1.add(sliderLabel1);
		individualSlider2.add(sliderLabel2);
		individualSlider3.add(sliderLabel3);

		individualSlider1.add(pSlider);
		individualSlider2.add(qSlider);
		individualSlider3.add(priceSlider);
		
		
		
		sliders.add(pSlider);
		sliders.add(qSlider);
		sliders.add(priceSlider);
		menuFrame.add(buttons, BorderLayout.SOUTH);
		menuFrame.add(sliders, BorderLayout.NORTH);
		
		textArea.add(periodTime);
		menuFrame.add(periodTime,BorderLayout.WEST);
		
		
//	 Step 6: Arrange to handle events in the user interface
		
		menuFrame.addWindowListener(new WindowAdapter() {
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
}


