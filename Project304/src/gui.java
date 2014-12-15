
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class gui extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		
		gui movieDB = new gui();

		movieDB.setLocation(250, 64);
		movieDB.setSize(1024, 768);
		movieDB.setVisible(true);
		
	}

	//Buttons
	JButton managerButton = new JButton ("Manager");
	JButton boxOfficeButton = new JButton ("Box-Office Employee");
	JButton onlineButton = new JButton ("Online");
	JButton kioskButton = new JButton ("Self-Serve Kiosk");
	JButton closeWindowButton = new JButton ("Close Window");

	//Menu Text
	JTextArea selectedInterface = new JTextArea ("Please select an available interface on the left.");

	//Panels
	JPanel navMenuPanel = new JPanel();
	
	//Welcome Information to be displayed on Home Page
	JTextArea welcomeInfoText = new JTextArea("Welcome to movieDB!!   \n" +
			"A Comprehensive Solution for all the database needs that a multiplex could have! \n" +
			"\n" +
			"Brought to you by:  50 SHADES OF DATA \n" +
			"Bryan Hsu 34532127 \n" +
			"Gautam Bellary 26898106 \n" +
			"Spencer Cheung 36273118 \n" +
			"\n" +
			"\n" +
			"To get started, select an interface that you wish to explore. \n" +
			"Available SQL queries will be shown. \n" +
			"\n" +
			"Enjoy!");


	//constructor
	public gui() {
		
		navMenuPanel.setLayout(new FlowLayout());
		navMenuPanel.add(managerButton);
		navMenuPanel.add(boxOfficeButton);
		navMenuPanel.add(onlineButton);
		navMenuPanel.add(kioskButton);
		navMenuPanel.add(selectedInterface);
		navMenuPanel.add(closeWindowButton);

		getContentPane().add(navMenuPanel, BorderLayout.NORTH);
		getContentPane().add(welcomeInfoText, BorderLayout.CENTER);

		closeWindowButton.addActionListener(this);
		managerButton.addActionListener(this);
		boxOfficeButton.addActionListener(this);
		kioskButton.addActionListener(this);
		onlineButton.addActionListener(this);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
	}

	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() == managerButton) {
			
			selectedInterface.setText("Manager Interface Selected");
			managerinterface manager = new managerinterface();
			manager.setLocation(250, 64);
			manager.setSize(1024, 768);
			manager.setVisible(true);
			setVisible(false);
			dispose();
			
		}
		
		else if (e.getSource() == boxOfficeButton) {
			
			selectedInterface.setText("Box Office Employee Interface Selected");
			boxofficeinterface boxOffice = new boxofficeinterface();
			boxOffice.setLocation(250, 64);
			boxOffice.setSize(1024, 768);
			boxOffice.setVisible(true);
			setVisible(false);
			dispose();
		
		}
		
		else if (e.getSource() == onlineButton) {
			
			selectedInterface.setText("Online Interface Selected");
			onlineinterface online = new onlineinterface();
			online.setLocation(250, 64);
			online.setSize(1024, 768);
			online.setVisible(true);
			setVisible(false);
			dispose();
		
		}
		
		else if (e.getSource() == kioskButton) {
			
			selectedInterface.setText("Self-Serve Kiosk Interface Selected");
			kioskinterface kiosk = new kioskinterface();
			kiosk.setLocation(250, 64);
			kiosk.setSize(1024, 768);
			kiosk.setVisible(true);
			setVisible(false);
			dispose();
		
		}
		
		else if (e.getSource() == closeWindowButton) {
			
			System.exit(0);
			
		}
		
	}
	
}
