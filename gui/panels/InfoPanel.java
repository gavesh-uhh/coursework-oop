package coursework.gui.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coursework.data.Transaction;
import coursework.data.User;
import coursework.gui.Dashboard;
import coursework.util.Colors;

public class InfoPanel extends JPanel {

	private JLabel welcomeLabel;
	private JLabel baseIncomeLabel;

	private Color debitColor = new Color(76, 187, 23);
	private Color creditColor = new Color(215, 0, 64);
	private final float STARTING_Y = 192;

	private float transactionLastY = STARTING_Y;
	private User currentUser;
	private Dashboard parentPanel;

	public InfoPanel(Dashboard dashboard, User user) {
		this.parentPanel = dashboard;
		this.currentUser = user;
		this.setLayout(null);
		welcomeLabel = new JLabel("Hi, User!");
		welcomeLabel.setFont(new Font("Geist", Font.PLAIN, 25));
		welcomeLabel.setBounds(25, 25, 612, 43);
		this.add(welcomeLabel);

		JButton changeBaseSalaryButton = new JButton("Change Base Income");
		changeBaseSalaryButton.setBounds(25, 130, 200, 25);
		changeBaseSalaryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String newValueString = JOptionPane.showInputDialog("Enter new base salary?");
				if (newValueString == null) return;
				if (newValueString.isEmpty())
					return;
				try {
					float newBaseValue = Float.parseFloat(newValueString);
					user.setBaseIncome(newBaseValue);
					parentPanel.refreshEverything();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid value", "Something Happened",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		this.add(changeBaseSalaryButton);

		baseIncomeLabel = new JLabel("Your Base Income - Rs. 0.0");
		baseIncomeLabel.setBorder(new EmptyBorder(0, 15, 0, 0));
		baseIncomeLabel.setForeground(new Color(0, 0, 0));
		baseIncomeLabel.setBackground(new Color(0, 204, 102));
		baseIncomeLabel.setFont(new Font("Geist", Font.PLAIN, 14));
		baseIncomeLabel.setBounds(25, 78, 612, 43);
		baseIncomeLabel.setOpaque(true);
		this.add(baseIncomeLabel);

		JLabel recentTransactionTitle = new JLabel("Recent Transactions");
		recentTransactionTitle.setFont(new Font("Geist", Font.PLAIN, 12));
		recentTransactionTitle.setBounds(26, 170, 182, 24);
		this.add(recentTransactionTitle);

	}

	/**
	 * Adds transaction to the info panel using JLabels with Borders and Background Colors
	 * @param transaction - Transaction object
	 * @author - Gavesh Saparamadu
	 */
	public void addTransaction(Transaction transaction) {
		String type = transaction.getType();
		switch (type.toLowerCase()) {
		case "debit": {
			JLabel transactionLabel = new JLabel(
					"+ " + transaction.getDescription() + ": Rs." + transaction.getValue());
			transactionLabel.setBackground(debitColor);
			transactionLabel.setOpaque(true);
			transactionLabel.setFont(new Font("Geist", Font.PLAIN, 12));
			transactionLabel.setBorder(new EmptyBorder(0, 15, 0, 0));
			transactionLabel.setBounds(26, (int) transactionLastY, 610, 40);
			transactionLabel.setName("transaction");
			this.add(transactionLabel);
			transactionLastY += 50;
			break;
		}
		case "credit": {
			JLabel transactionLabel = new JLabel(
					"- " + transaction.getDescription() + ": Rs." + transaction.getValue());
			transactionLabel.setBackground(creditColor);
			transactionLabel.setOpaque(true);
			transactionLabel.setFont(new Font("Geist", Font.PLAIN, 12));
			transactionLabel.setBorder(new EmptyBorder(0, 15, 0, 0));
			transactionLabel.setForeground(Color.white);
			transactionLabel.setBounds(26, (int) transactionLastY, 610, 40);
			transactionLabel.setName("transaction");
			this.add(transactionLabel);
			transactionLastY += 50;
			break;
		}
		}
	}

	/***
	 * Updates Welcome Label to display the corresponding names, Updates the balance
	 * text to display the final balance of the account and colors it green and red
	 * accordingly
	 * 
	 * @author - Gavesh Saparamadu
	 */
	public void updateDetails() {
		this.welcomeLabel.setText("Hi! " + currentUser.getFullName());
		float lastBalance = currentUser.calculateFinalBalance();
		this.baseIncomeLabel.setText("Your Final Balance is Rs. " + lastBalance);
		if (lastBalance > 0) {
			this.baseIncomeLabel.setBackground(new Color(0, 204, 102));
		} else {
			baseIncomeLabel.setBackground(Colors.ACCENT_RED);
		}
	}

	public void clearButtons() {
		for (Component c : this.getComponents()) {
			if (c instanceof JLabel) {
				JLabel button = (JLabel) c;
				if (button.getName() == "transaction") {
					this.remove(button);
				}
			}
		}
		this.transactionLastY = this.STARTING_Y;
		repaint();
	}

}