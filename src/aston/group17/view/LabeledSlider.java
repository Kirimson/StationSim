package aston.group17.view;

import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.*;

/**
 * Enhanced version of standard Swing JSlider widget
 *
 * @author Ian T. Nabney
 * @version 13/03/2005
 */


public class LabeledSlider extends JComponent {
	
	private static final long serialVersionUID = 6511929653284188062L;
	private String labelString;
	private JLabel label;
	private JSlider slider;
	private int divider;
	private boolean reversed;
	
	public LabeledSlider(String text, int min, int max, int value, int divider, boolean reversed) {
		this.setDoubleBuffered(true);
		this.reversed = reversed;
		this.divider = divider;
		
		label = new JLabel();
		labelString = new String(text);
		
		setCustomLabel(value);
		
		slider = new JSlider(min, max, value);
		
		// Set slider properties
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.addChangeListener(new SliderListener());
		
		this.setLayout(new BorderLayout());
		this.add(label, BorderLayout.NORTH);
		this.add(slider, BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createEtchedBorder());
		
	}
	
	public void setMajorTickSpacing(int spacing) {
		slider.setMajorTickSpacing(spacing);
		repaint();
	}
	
	public int getValue() {
		return slider.getValue();
	}
	
	private class SliderListener implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			if (!slider.getValueIsAdjusting()) {
				int number = slider.getValue();
				setCustomLabel(number);
			}
		}
	}
	
	public void changeLabels(Hashtable<Integer, JLabel> labelTable)
	{
		slider.setLabelTable( labelTable );
	}
	
	private void setCustomLabel(int value)
	{
		if(divider != 1)
		{
			if(reversed)
			{
				label.setText((double)value/divider+labelString);
			}
			else
			{
				label.setText(labelString + (double)value/divider);
			}
			
		}
		else
		{
			if(reversed)
			{
				label.setText(value + labelString);
			}
			else
			{
				label.setText(labelString + value);
			}
		}
	}
}
