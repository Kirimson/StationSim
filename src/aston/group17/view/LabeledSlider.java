package aston.group17.view;

import java.awt.*;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.*;

/**
 * Enhanced version of standard Swing JSlider widget.
 * Edited by Kieran Gates to improve labels and add floating point support
 *
 * @author Ian T. Nabney
 * @author Kieran Gates
 * @version 2017.5.1
 */


public class LabeledSlider extends JComponent {
	
	private static final long serialVersionUID = 6511929653284188062L;
	private String labelLString, labelRString;
	private JLabel label;
	private JSlider slider;
	private int divider;
	
	public LabeledSlider(String lText, String rText, int min, int max, int value, int divider) {
		this.setDoubleBuffered(true);
		this.divider = divider;
		
		label = new JLabel();
		labelLString = lText;
		labelRString = rText;
		
		setCustomLabel(value);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		slider = new JSlider(min, max, value);
		
		// Set slider properties
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.addChangeListener(new SliderListener());
		
		this.setLayout(new GridLayout(1, 1, 10, 10));
		this.add(label);
		this.add(slider);
		
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
	
	public void createCustomLabel(int min, int max, int tick, int divider, boolean beDouble)
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
		slider.setLabelTable( labelTable );
	}
	
	private void setCustomLabel(int value)
	{
		if(divider != 1)
		{
				label.setText(labelLString + (double)value/divider + labelRString);
		}
		else
		{
				label.setText(labelLString + value + labelRString);
		}
	}
}
