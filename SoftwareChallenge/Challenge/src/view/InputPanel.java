package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	
	private JLabel lengthLabel, widthLabel, depthLabel;
	private JTextField lengthEntry, widthEntry, depthEntry;
	private JButton submitButton, resetButton;
	
	public InputPanel() {
		/*Panel Initiation and Constraint Initiation*/
		JPanel inputPanelPane = new JPanel();
		inputPanelPane.setLayout(new GridBagLayout());
		GridBagConstraints inputPanelGridBag = new GridBagConstraints();
		inputPanelGridBag.fill = GridBagConstraints.VERTICAL;
		
		/*Initialise Temporary JPanel*/
		JPanel inputTempPanel;
		
		/*Length Entry*/
		inputTempPanel = new JPanel();
		//Label
		lengthLabel = new JLabel("Length (in Meters):");
		inputPanelGridBag.gridx = 0;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.anchor = GridBagConstraints.LINE_START;
		inputTempPanel.add(lengthLabel, inputPanelGridBag);
		//TextField
		lengthEntry = new JTextField();
		lengthEntry.setPreferredSize(new Dimension(174, 25));
		inputPanelGridBag.gridx = 1;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.anchor = GridBagConstraints.LINE_END;
		inputTempPanel.add(lengthEntry, inputPanelGridBag);
		//Add Panel to Pane
		inputPanelGridBag.gridx = 0;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.ipadx = 50;
		inputPanelGridBag.ipady = 15;
		inputPanelPane.add(inputTempPanel, inputPanelGridBag);
		
		/*Width Entry*/
		inputTempPanel = new JPanel();
		//Label
		widthLabel = new JLabel("Width (in Meters):");
		inputPanelGridBag.gridx = 0;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.anchor = GridBagConstraints.LINE_START;
		inputTempPanel.add(widthLabel, inputPanelGridBag);
		//TextField
		widthEntry = new JTextField();
		widthEntry.setPreferredSize(new Dimension(174, 25));
		inputPanelGridBag.gridx = 1;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.anchor = GridBagConstraints.LINE_END;
		inputTempPanel.add(widthEntry, inputPanelGridBag);
		//Add Panel to Pane
		inputPanelGridBag.gridx = 0;
		inputPanelGridBag.gridy = 1;
		inputPanelGridBag.ipadx = 50;
		inputPanelGridBag.ipady = 15;
		inputPanelPane.add(inputTempPanel, inputPanelGridBag);
		
		/*Depth Entry*/
		inputTempPanel = new JPanel();
		//Label
		depthLabel = new JLabel("Depth (in Meters):");
		inputPanelGridBag.gridx = 0;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.anchor = GridBagConstraints.LINE_START;
		inputTempPanel.add(depthLabel, inputPanelGridBag);
		//TextField
		depthEntry = new JTextField();
		depthEntry.setPreferredSize(new Dimension(174, 25));
		inputPanelGridBag.gridx = 1;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.anchor = GridBagConstraints.LINE_END;
		inputTempPanel.add(depthEntry, inputPanelGridBag);
		//Add Panel to Pane
		inputPanelGridBag.gridx = 0;
		inputPanelGridBag.gridy = 2;
		inputPanelGridBag.ipadx = 50;
		inputPanelGridBag.ipady = 15;
		inputPanelPane.add(inputTempPanel, inputPanelGridBag);
		
		/*Buttons*/
		inputTempPanel = new JPanel();
		
		//Submit Button
		submitButton = new JButton("Submit");
		inputPanelGridBag.gridx = 0;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.gridwidth = 1;
		//Add Button to Panel
		inputPanelGridBag.fill = GridBagConstraints.HORIZONTAL;
		inputTempPanel.add(submitButton, inputPanelGridBag);
		
		//Reset Button
		resetButton = new JButton("Reset");
		inputPanelGridBag.gridx = 1;
		inputPanelGridBag.gridy = 0;
		inputPanelGridBag.gridwidth = 1;
		//Add Button to Panel
		inputPanelGridBag.ipadx = 25;
		inputPanelGridBag.fill = GridBagConstraints.HORIZONTAL;
		inputTempPanel.add(resetButton, inputPanelGridBag);
		
		//Add Panel to Pane
		inputPanelGridBag.gridx = 0;
		inputPanelGridBag.gridy = 3;
		inputPanelGridBag.gridwidth = 2;
		inputPanelPane.add(inputTempPanel, inputPanelGridBag);
		
		inputPanelPane.setBorder(new TitledBorder("User Input"));
		
		this.add(inputPanelPane);
	}
	
	/*Functions*/
	public void resetAction() {
		lengthEntry.setText("");
		widthEntry.setText("");
		depthEntry.setText("");
	}
	
	public double getLengthInput() {
		if (lengthEntry.getText().equals("")) {
			return 0;
		}
		else {
			double conversion = Double.parseDouble(lengthEntry.getText());
			return conversion;
		}
	}
	
	public double getWidthInput() {
		if (widthEntry.getText().equals("")) {
			return 0;
		}
		else {
			double conversion = Double.parseDouble(widthEntry.getText());
			return conversion;
		}
	}
	
	public double getDepthInput() {
		if (depthEntry.getText().equals("")) {
			return 0;
		}
		else {
			double conversion = Double.parseDouble(depthEntry.getText());
			return conversion;
		}
	}
	
	/*Listeners*/
	public void addSumbitActionListener(ActionListener submitAL) {
		submitButton.addActionListener(submitAL);
	}
	
	public void addResetActionListener(ActionListener resetAL) {
		resetButton.addActionListener(resetAL);
	}
}
