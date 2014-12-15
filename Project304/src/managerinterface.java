
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class managerinterface extends JFrame implements ActionListener {

	// Buttons
	JButton getMovieButton = new JButton("Get Movie Information");
	JButton getFoodButton = new JButton("Get Food Information");
	JButton getEmpInfoButton = new JButton("Get Employee Information");
	JButton buyTicketButton = new JButton("Buy Movie Tickets");
	JButton insertButton = new JButton("SQL insert");
	JButton updateButton = new JButton("SQL update");
	JButton deleteButton = new JButton("SQL delete");
	JButton closeWindowButton = new JButton ("Close Window");
	JButton backButton = new JButton ("Go Back");
	JButton textQuery = new JButton ("GO!");

	// Panels
	JPanel window = new JPanel();
	JPanel navMenuPanel = new JPanel();
	JPanel textInputPanel = new JPanel();
	JPanel movieSort = new JPanel();
	JPanel input2panel = new JPanel();

	// Result Text Field
	JTextArea resultArea = new JTextArea();

	//Input Text Field
	JTextField input1 = new JTextField();
	JTextField input2 = new JTextField();
	JTextField input3 = new JTextField();
	JTextField input4 = new JTextField();
	JTextField input5 = new JTextField();
	JTextField input6 = new JTextField();
	JTextField input7 = new JTextField();
	JTextField input8 = new JTextField();

	//Input Text Field Labels
	JTextArea inputLabel1 = new JTextArea("");
	JTextArea inputLabel2 = new JTextArea("");
	JTextArea inputLabel3 = new JTextArea("");

	// Boolean values to keep track of queries requiring more than one input (text or additional buttons)
	boolean movie = false;
	boolean food = false;
	boolean movietix = false;
	boolean insert = false;
	boolean update = false;
	boolean delete = false;


	//Sort Buttons
	JButton sort1 = new JButton ("");
	JButton sort2 = new JButton ("");
	JButton sort3 = new JButton ("");
	JButton sort4 = new JButton ("");
	JButton sort5 = new JButton ("");
	JButton sort6 = new JButton ("");
	JButton sort7 = new JButton ("");


	// constructor
	public managerinterface() {

		movieSort.setLayout(new GridLayout(0, 7));
		movieSort.add(sort1);
		movieSort.add(sort2);
		movieSort.add(sort3);
		movieSort.add(sort4);
		movieSort.add(sort5);
		movieSort.add(sort6);
		movieSort.add(sort7);
		
		input2panel.setLayout(new GridLayout(0, 6));
		input2panel.add(input2);
		input2panel.add(input4);
		input2panel.add(input5);
		input2panel.add(input6);
		input2panel.add(input7);
		input2panel.add(input8);

		textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));
		textInputPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		textInputPanel.add(inputLabel1);
		textInputPanel.add(input1);
		textInputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		textInputPanel.add(inputLabel2);
		textInputPanel.add(input2panel);
		textInputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		textInputPanel.add(inputLabel3);
		textInputPanel.add(input3);
		textInputPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		textInputPanel.add(textQuery);
		textInputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		textInputPanel.add(movieSort);

		window.setLayout(new BorderLayout());
		window.add(resultArea, BorderLayout.CENTER);
		window.add(textInputPanel, BorderLayout.NORTH);

		navMenuPanel.setLayout(new GridLayout(0, 6));
		navMenuPanel.add(backButton);
		navMenuPanel.add(getMovieButton);
		navMenuPanel.add(getFoodButton);
		navMenuPanel.add(getEmpInfoButton);
		navMenuPanel.add(buyTicketButton);
		navMenuPanel.add(closeWindowButton);
		navMenuPanel.add(insertButton);
		navMenuPanel.add(updateButton);
		navMenuPanel.add(deleteButton);

		getContentPane().add(navMenuPanel, BorderLayout.NORTH);
		getContentPane().add(window, BorderLayout.CENTER);

		getMovieButton.addActionListener(this);
		getFoodButton.addActionListener(this);
		getEmpInfoButton.addActionListener(this);
		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		closeWindowButton.addActionListener(this);
		buyTicketButton.addActionListener(this);
		backButton.addActionListener(this);
		textQuery.addActionListener(this);
		sort1.addActionListener(this);
		sort2.addActionListener(this);
		sort3.addActionListener(this);
		sort4.addActionListener(this);
		sort5.addActionListener(this);
		sort6.addActionListener(this);
		sort7.addActionListener(this);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args) {

		managerinterface gui = new managerinterface();

		gui.setLocation(250, 64);
		gui.setSize(1024, 768);
		gui.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == textQuery) {
			if (insert) {
				String string1 = input2.getText();
				String string2 = input4.getText();
				String string3 = input5.getText();
				String string4 = input6.getText();
				String string5 = input7.getText();
				String string6 = input8.getText();
				
				int int3 = Integer.parseInt(string3);
				double double4 = Double.parseDouble(string4);
				int int5 = Integer.parseInt(string5);
		
				String readout = "Here is the updated Movie relation table " +
						"including the record you have just added:\r\n\r\n";
				
				InsertInto i = new InsertInto();
				
				i.insert(string1, string2, int3, double4, int5, string6);
				
				ArrayList<String> results = Q1.query1();
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);

				inputLabel1.setText("");
				inputLabel2.setText("");
				inputLabel3.setText("");
				input1.setText("");
				input2.setText("");
				input3.setText("");
				input4.setText("");
				input5.setText("");
				input6.setText("");
				input7.setText("");
				input8.setText("");
				insert = false;
			}

			else if (update) {
				String rating = input2.getText();
				String moviename = input3.getText();
				String readout = "Here is the updated Movie relation table " +
						"including the updates you just made:\r\n\r\n";
				double doubleRating = Double.parseDouble(rating);
				
				
				
				Update.update(doubleRating, moviename);
				
				ArrayList<String> results = Q1.query1();
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);

				inputLabel1.setText("");
				inputLabel2.setText("");
				inputLabel3.setText("");
				input1.setText("");
				input2.setText("");
				input3.setText("");
				input4.setText("");
				input5.setText("");
				input6.setText("");
				input7.setText("");
				input8.setText("");
				update = false;
			}

			else if (delete) {
				String moviename = input2.getText();
				String readout = "Here is the updated Movie relation table " +
						"without the record you have just deleted:\r\n\r\n";
				
				Delete d = new Delete();
				d.delete(moviename);
				
				ArrayList<String> results = Q1.query1();
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);

				inputLabel1.setText("");
				inputLabel2.setText("");
				inputLabel3.setText("");
				input1.setText("");
				input2.setText("");
				input3.setText("");
				input4.setText("");
				input5.setText("");
				input6.setText("");
				input7.setText("");
				input8.setText("");
				delete = false;
			}

			else if (movietix) {
				String moviename = input1.getText();
				String readout = "";

				if (moviename.matches("Alien")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else if (moviename.matches("Fifty Shades of Grey")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else if (moviename.matches("Godzilla")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else if (moviename.matches("Jaws")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else if (moviename.matches("Spider-Man")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else if (moviename.matches("Stars War")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else if (moviename.matches("The Matrix")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else if (moviename.matches("Titanic")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else if (moviename.matches("X-men")) {
					readout = "Congratulations!\r\n" +
							"You have just purchased a ticket for " +
							moviename + "!\r\n" +
							"Enjoy the show!\r\n\r\n" +
							"Your confirmation number is: CS304";
					movietix = false;

					inputLabel1.setText("");
					inputLabel2.setText("");
					inputLabel3.setText("");
					input1.setText("");
					input2.setText("");
					input3.setText("");
					input4.setText("");
					input5.setText("");
					input6.setText("");
					input7.setText("");
					input8.setText("");
				}
				else {
					readout = "Sorry, we dont have any showtimes of that particular movie.\r\n" +
							"You entered: ";
					readout += moviename;
					readout += "\r\n";
					readout += "It is possible that you made spelling mistakes.\r\n";
					readout += "Please select from the following options and try again: \r\n\r\n";
					ArrayList<String> results = Q11.query11();
					for (String result : results) {
						readout += result + "\r\n";
					}
				}
				resultArea.setText(readout);
			}

		}

		else {
			insert = false;
			update = false;
			delete = false;
			movietix = false;
			inputLabel1.setText("");
			inputLabel2.setText("");
			inputLabel3.setText("");
			input1.setText("");
			input2.setText("");
			input3.setText("");
			input4.setText("");
			input5.setText("");
			input6.setText("");
			input7.setText("");
			input8.setText("");
		}

		if (e.getSource() == sort1) {
			if (food) {
				ArrayList<String> results = Q6.query6();
				String readout = "";
				for (String result : results) {
					readout += result + "\r\n";
				}
				readout += "\r\n\r\n";
				readout += "The following customers purchased popcorn at the concession stand:\r\n";
				results = q9.query9();
				for (String result : results) {
					readout += result + "\r\n";
				}	
				resultArea.setText(readout);
				food = false;
			}
			else if (movie) {
				ArrayList<String> results = Q2.query2();
				String readout = "";
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);
				movie = false;
			}
		}

		else {
			sort1.setText("");
			food = false;
		}

		if (e.getSource() == sort2) {

			if (movie) {
				ArrayList<String> results = q5.query5();
				String readout = "";
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);
				movie = false;
			}
		}

		else {
			sort2.setText("");
		}

		if (e.getSource() == sort3) {

			if (movie) {
				ArrayList<String> results = Q43.query43();
				String readout = "";
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);
				movie = false;
			}
		}

		else {
			sort3.setText("");
		}

		if (e.getSource() == sort4) {

			if (movie) {
				ArrayList<String> results = Q4.query4();
				String readout = "";
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);
				movie = false;
			}
		}

		else {
			sort4.setText("");
		}

		if (e.getSource() == sort5) {

			if (movie) {
				ArrayList<String> results = Q42.query42();
				String readout = "";
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);
				movie = false;
			}
		}

		else {
			sort5.setText("");
		}

		if (e.getSource() == sort6) {

			if (movie) {
				ArrayList<String> results = Q41.query41();
				String readout = "";
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);
				movie = false;
			}
		}

		else {
			sort6.setText("");
		}

		if (e.getSource() == sort7) {

			if (movie) {
				ArrayList<String> results = TopFive.topfive();
				String readout = "";
				for (String result : results) {
					readout += result + "\r\n";
				}
				resultArea.setText(readout);
				movie = false;
			}
		}

		else {
			sort7.setText("");
		}

		movie = false;

		if (e.getSource() == getMovieButton) {
			movie = true;
			ArrayList<String> results = Q1.query1();
			String readout = "";
			for (String result : results) {
				readout += result + "\r\n";
			}
			resultArea.setText(readout);
			sort1.setText("SORT: Release");
			sort2.setText("SORT: Rating");
			sort3.setText("FILTER: Action");
			sort4.setText("FILTER: SciFi");
			sort5.setText("FILTER: Romance");
			sort6.setText("FILTER: Horror");
			sort7.setText("SHOW: Top 5");
		}    

		else if (e.getSource() == insertButton) {
			insert = true;

			ArrayList<String> results = Q1.query1();
			String readout = "";
			for (String result : results) {
				readout += result + "\r\n";
			}
			resultArea.setText(readout);

			inputLabel1.setText("INSERT INTO:");
			input1.setText("Movies");
			inputLabel2.setText("Please fillout the field below using the following format:");
			inputLabel3.setText("");
			input2.setText("MName");
			input4.setText("Genre");
			input5.setText("MID");
			input6.setText("Rating");
			input7.setText("MovieLength");
			input8.setText("ReleaseDate");

		}

		else if (e.getSource() == updateButton) {
			update = true;

			ArrayList<String> results = Q1.query1();
			String readout = "";
			for (String result : results) {
				readout += result + "\r\n";
			}
			resultArea.setText(readout);

			inputLabel1.setText("UPDATE: ");
			input1.setText("Movies");
			inputLabel2.setText("SET RATING: (Please enter the value of the new rating.)");
			inputLabel3.setText("Movie Name: (Please enter the name of the movie that you wish to update.)");


		}

		else if (e.getSource() == deleteButton) {
			delete = true;

			ArrayList<String> results = Q1.query1();
			String readout = "";
			for (String result : results) {
				readout += result + "\r\n";
			}

			resultArea.setText(readout);
			inputLabel1.setText("DELETE FROM:");
			input1.setText("Movies");
			inputLabel2.setText("MovieName: (Please enter the name of the movie you wish to delete.)");

		}

		else if (e.getSource() == buyTicketButton) {
			movietix = true;
			ArrayList<String> results = Q11.query11();
			String readout = "";
			for (String result : results) {
				readout += result + "\r\n";
			}
			resultArea.setText(readout);
			inputLabel1.setText("Type the name of the movie you wish to purchase a ticket for and press GO!");

		}

		else if (e.getSource() == getFoodButton) {
			food = true;
			ArrayList<String> results = Q6.query6();
			String readout = "";
			for (String result : results) {
				readout += result + "\r\n";
			}
			resultArea.setText(readout);
			sort1.setText("Popcorn Purchases");

		}

		else if (e.getSource() == getEmpInfoButton) {
			ArrayList<String> results = Q8.query8();
			String readout = "";
			for (String result : results) {
				readout += result + "\r\n";
			}
			resultArea.setText(readout);

		}

		else if (e.getSource() == closeWindowButton) {
			System.exit(0);
		}

		else if (e.getSource() == backButton) {
			window.removeAll();
			gui movieDB = new gui();
			movieDB.setLocation(250, 64);
			movieDB.setSize(1024, 768);
			movieDB.setVisible(true);
			setVisible(false);
			dispose();
		}

	}

}
