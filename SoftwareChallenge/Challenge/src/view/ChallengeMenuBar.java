package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class ChallengeMenuBar extends JMenuBar {
	
	private JMenuItem saveOption, exitOption, aboutOption;
	
	public ChallengeMenuBar() {
		
		JMenu challengeMenu;
		
		/*File Drop-Down*/
		challengeMenu = new JMenu("File");
		challengeMenu.setMnemonic(KeyEvent.VK_F);
		
		//Save
		saveOption = new JMenuItem("Save Results");
		saveOption.setMnemonic(KeyEvent.VK_S);
		saveOption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		challengeMenu.add(saveOption);
		
		//Exit
		exitOption = new JMenuItem("Exit");
		exitOption.setMnemonic(KeyEvent.VK_E);
		saveOption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		challengeMenu.add(exitOption);
		
		//Add Items
		this.add(challengeMenu);
		
		/*Help Drop-Down*/
		challengeMenu = new JMenu("Help");
		challengeMenu.setMnemonic(KeyEvent.VK_H);
		
		//About
		aboutOption = new JMenuItem("About");
		aboutOption.setMnemonic(KeyEvent.VK_A);
		aboutOption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		challengeMenu.add(aboutOption);
		
		//Add Items
		this.add(challengeMenu);
	}
	
	/*Listeners*/
	public void addSaveActionListener(ActionListener saveAL) {
		saveOption.addActionListener(saveAL);
	}
	
	public void addExitActionListener(ActionListener exitAL) {
		exitOption.addActionListener(exitAL);
	}
	
	public void addAboutActionListener(ActionListener aboutAL) {
		aboutOption.addActionListener(aboutAL);
	}
}
