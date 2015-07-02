package controller;

import view.ChallengeFrame;
import view.ChallengeMenuBar;
import view.InputPanel;
import view.ResultsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.Room;

public class ChallengeController {
	
	private ChallengeFrame view;
	private ChallengeMenuBar menuPanel;
	private InputPanel inputPanel;
	private ResultsPanel resultsPanel;
	
	private Room model;
	
	private String resultsString;
	
	public ChallengeController(ChallengeFrame view, Room model) {
		
		/*Initialisation of View and Model*/
		this.view = view;
		this.model = model;
		
		/*Initialisation of View Assets*/
		menuPanel = view.getChallengeMenuBar();
		inputPanel = view.getInputPanel();
		resultsPanel = view.getResultsPanel();
		
		/*Input Panel Listeners*/
		inputPanel.addSumbitActionListener(new submitInputHandler());
		inputPanel.addResetActionListener(new resetInputHandler());
		
		/*Results Panel Listeners*/
		resultsPanel.addSaveActionListener(new saveResultsHandler());
		resultsPanel.addCloseActionListener(new closeResultsHandler());
		
		/*Menu Bar Listeners*/
		menuPanel.addSaveActionListener(new saveMenuBarHandler());
		menuPanel.addExitActionListener(new exitMenuBarHandler());
		menuPanel.addAboutActionListener(new aboutMenuBarHandler());
	}
	
	public class submitInputHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			/*Validation*/
			if ((inputPanel.getLengthInput() <= 0) || (inputPanel.getWidthInput() <= 0) || (inputPanel.getDepthInput() <= 0)) {
				JOptionPane.showMessageDialog(null, "Either no value has been entered or the value is inappropriate (less than or equal to zero).", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				/*Write to Data Model*/
				model.setLength(inputPanel.getLengthInput());
				model.setWidth(inputPanel.getWidthInput());
				model.setDepth(inputPanel.getDepthInput());
				
				/*Switch to Next Tab*/
				view.changeTabs(1);
				
				/*Populate Second Tab*/
				resultsPanel.setAreaDisplay(model.getFloorArea());
				resultsPanel.setPaintDisplay(model.getPaintRequired());
				resultsPanel.setVolumeDisplay(model.getVolume());
				
				/*Write to String*/
				resultsString = new String();
				resultsString = "Room Information: Length - " + model.getLength() + ", Width - " + model.getWidth() + ", Depth - " + model.getDepth() + ", Floor Area (in Meters^2) - " + model.getFloorArea() + ", Paint Needed to Paints Walls (in Litres) - " + model.getPaintRequired() + ", Volume of Room (in Meters^3) - " + model.getVolume();
			}
		}
	}
	
	public class resetInputHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			inputPanel.resetAction();
		}
	}
	
	public class saveResultsHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			/* Initiate File Chooser */
			JFileChooser saveChooser = new JFileChooser();
			saveChooser.setDialogTitle("Save As");
			saveChooser.setSelectedFile(new File(".txt"));
			int returnValue = saveChooser.showSaveDialog(view);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				try {
					File roomData = saveChooser.getSelectedFile();
					FileWriter fileWriter = new FileWriter(roomData.getAbsoluteFile());
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(resultsString);
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public class closeResultsHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	public class saveMenuBarHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			/* Initiate File Chooser */
			JFileChooser saveChooser = new JFileChooser();
			saveChooser.setDialogTitle("Save As");
			saveChooser.setSelectedFile(new File(".txt"));
			int returnValue = saveChooser.showSaveDialog(view);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				try {
					File roomData = saveChooser.getSelectedFile();
					FileWriter fileWriter = new FileWriter(roomData.getAbsoluteFile());
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(resultsString);
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public class exitMenuBarHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	public class aboutMenuBarHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "My submission for the Borwell Software Challenge!\nMade in Java using Eclipse.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
