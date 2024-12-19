package coursework.gui.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import coursework.data.User;
import coursework.gui.Dashboard;
import coursework.util.Colors;

public class BudgetPanel extends JPanel {

	private JTextField foodBudgetInput;
	private JTextField foodSpentInput;
	private JTextField transportBudgetInput;
	private JTextField transportSpentInput;
	private JTextField housingBudgetInput;
	private JTextField housingSpentInput;
	private JTextField healthBudgetInput;
	private JTextField healthSpentInput;
	private JTextField entertainmentBudgetInput;
	private JTextField entertainmentSpentInput;

	private JProgressBar foodBudgetProgress;
	private JProgressBar transportBudgetProgress;
	private JProgressBar housingBudgetProgress;
	private JProgressBar healthBudgetProgress;
	private JProgressBar entertainmentBudgetProgress;

	private User currentUser;
	private Dashboard parentPanel;


	public void handleUI() {

		setLayout(null);

		JLabel budgetTitleLabel = new JLabel("Budget");
		budgetTitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		budgetTitleLabel.setFont(new Font("Geist", Font.BOLD, 30));
		budgetTitleLabel.setBounds(25, 25, 616, 38);
		this.add(budgetTitleLabel);

		JLabel foodLabel = new JLabel("Food");
		foodLabel.setFont(new Font("Geist", Font.BOLD, 16));
		foodLabel.setBounds(25, 73, 616, 21);
		this.add(foodLabel);

		JLabel lblBudgetAmount = new JLabel("Budget Amount");
		lblBudgetAmount.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBudgetAmount.setFont(new Font("Geist", Font.PLAIN, 12));
		lblBudgetAmount.setBounds(25, 94, 156, 21);
		this.add(lblBudgetAmount);

		JLabel lblSpentAmount = new JLabel("Spent Amount");
		lblSpentAmount.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpentAmount.setFont(new Font("Geist", Font.PLAIN, 12));
		lblSpentAmount.setBounds(235, 94, 156, 21);
		this.add(lblSpentAmount);

		JLabel lblRent = new JLabel("Housing");
		lblRent.setFont(new Font("Geist", Font.BOLD, 16));
		lblRent.setBounds(25, 244, 616, 21);
		this.add(lblRent);

		JLabel lblBudgetAmount_1_1 = new JLabel("Budget Amount");
		lblBudgetAmount_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBudgetAmount_1_1.setFont(new Font("Geist", Font.PLAIN, 12));
		lblBudgetAmount_1_1.setBounds(25, 265, 156, 21);
		this.add(lblBudgetAmount_1_1);

		JLabel lblSpentAmount_1_1 = new JLabel("Spent Amount");
		lblSpentAmount_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpentAmount_1_1.setFont(new Font("Geist", Font.PLAIN, 12));
		lblSpentAmount_1_1.setBounds(235, 265, 156, 21);
		this.add(lblSpentAmount_1_1);

		JLabel lblBudgetAmount_1_1_1 = new JLabel("Budget Amount");
		lblBudgetAmount_1_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBudgetAmount_1_1_1.setFont(new Font("Geist", Font.PLAIN, 12));
		lblBudgetAmount_1_1_1.setBounds(25, 351, 156, 21);
		this.add(lblBudgetAmount_1_1_1);

		JLabel lblHealth = new JLabel("Health");
		lblHealth.setFont(new Font("Geist", Font.BOLD, 16));
		lblHealth.setBounds(25, 330, 616, 21);
		this.add(lblHealth);

		JLabel lblBudgetAmount_1_1_1_1 = new JLabel("Budget Amount");
		lblBudgetAmount_1_1_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBudgetAmount_1_1_1_1.setFont(new Font("Geist", Font.PLAIN, 12));
		lblBudgetAmount_1_1_1_1.setBounds(25, 437, 156, 21);
		this.add(lblBudgetAmount_1_1_1_1);

		JLabel lblEntertainment = new JLabel("Entertainment");
		lblEntertainment.setFont(new Font("Geist", Font.BOLD, 16));
		lblEntertainment.setBounds(25, 416, 616, 21);
		this.add(lblEntertainment);

		JLabel lblSpentAmount_1_1_1_1 = new JLabel("Spent Amount");
		lblSpentAmount_1_1_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpentAmount_1_1_1_1.setFont(new Font("Geist", Font.PLAIN, 12));
		lblSpentAmount_1_1_1_1.setBounds(235, 437, 156, 21);
		this.add(lblSpentAmount_1_1_1_1);

		JLabel lblSpentAmount_1_1_1 = new JLabel("Spent Amount");
		lblSpentAmount_1_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpentAmount_1_1_1.setFont(new Font("Geist", Font.PLAIN, 12));
		lblSpentAmount_1_1_1.setBounds(235, 351, 156, 21);
		this.add(lblSpentAmount_1_1_1);

		JLabel lblBudgetAmount_1 = new JLabel("Budget Amount");
		lblBudgetAmount_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBudgetAmount_1.setFont(new Font("Geist", Font.PLAIN, 12));
		lblBudgetAmount_1.setBounds(25, 180, 156, 21);
		this.add(lblBudgetAmount_1);

		JLabel transportLabel = new JLabel("Transport");
		transportLabel.setFont(new Font("Geist", Font.BOLD, 16));
		transportLabel.setBounds(25, 159, 616, 21);
		this.add(transportLabel);

		JLabel lblSpentAmount_1 = new JLabel("Spent Amount");
		lblSpentAmount_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpentAmount_1.setFont(new Font("Geist", Font.PLAIN, 12));
		lblSpentAmount_1.setBounds(235, 180, 156, 21);
		this.add(lblSpentAmount_1);

		foodBudgetInput = new JTextField();
		foodBudgetInput.setBounds(25, 118, 200, 31);
		this.add(foodBudgetInput);
		foodBudgetInput.setColumns(10);

		foodSpentInput = new JTextField();
		foodSpentInput.setColumns(10);
		foodSpentInput.setBounds(235, 118, 200, 31);
		this.add(foodSpentInput);

		foodBudgetProgress = new JProgressBar();
		foodBudgetProgress.setStringPainted(true);
		foodBudgetProgress.setValue(0);
		foodBudgetProgress.setBounds(441, 118, 200, 31);
		this.add(foodBudgetProgress);

		transportBudgetInput = new JTextField();
		transportBudgetInput.setColumns(10);
		transportBudgetInput.setBounds(25, 204, 200, 31);
		this.add(transportBudgetInput);

		transportSpentInput = new JTextField();
		transportSpentInput.setColumns(10);
		transportSpentInput.setBounds(235, 204, 200, 31);
		this.add(transportSpentInput);

		transportBudgetProgress = new JProgressBar();
		transportBudgetProgress.setValue(0);
		transportBudgetProgress.setStringPainted(true);
		transportBudgetProgress.setBounds(441, 204, 200, 31);
		this.add(transportBudgetProgress);

		housingBudgetInput = new JTextField();
		housingBudgetInput.setColumns(10);
		housingBudgetInput.setBounds(25, 289, 200, 31);
		this.add(housingBudgetInput);

		housingSpentInput = new JTextField();
		housingSpentInput.setColumns(10);
		housingSpentInput.setBounds(235, 289, 200, 31);
		this.add(housingSpentInput);

		housingBudgetProgress = new JProgressBar();
		housingBudgetProgress.setValue(0);
		housingBudgetProgress.setStringPainted(true);
		housingBudgetProgress.setBounds(441, 289, 200, 31);
		this.add(housingBudgetProgress);

		healthBudgetInput = new JTextField();
		healthBudgetInput.setColumns(10);
		healthBudgetInput.setBounds(25, 375, 200, 31);
		this.add(healthBudgetInput);

		healthSpentInput = new JTextField();
		healthSpentInput.setColumns(10);
		healthSpentInput.setBounds(235, 375, 200, 31);
		this.add(healthSpentInput);

		healthBudgetProgress = new JProgressBar();
		healthBudgetProgress.setValue(0);
		healthBudgetProgress.setStringPainted(true);
		healthBudgetProgress.setBounds(441, 375, 200, 31);
		this.add(healthBudgetProgress);

		entertainmentBudgetInput = new JTextField();
		entertainmentBudgetInput.setColumns(10);
		entertainmentBudgetInput.setBounds(25, 461, 200, 31);
		this.add(entertainmentBudgetInput);

		entertainmentSpentInput = new JTextField();
		entertainmentSpentInput.setColumns(10);
		entertainmentSpentInput.setBounds(235, 461, 200, 31);
		this.add(entertainmentSpentInput);

		entertainmentBudgetProgress = new JProgressBar();
		entertainmentBudgetProgress.setValue(0);
		entertainmentBudgetProgress.setStringPainted(true);
		entertainmentBudgetProgress.setBounds(441, 461, 200, 31);
		this.add(entertainmentBudgetProgress);

		JButton calculateButton = new JButton("Calculate");
		calculateButton.setBounds(25, 540, 200, 31);
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateInput();
			}
		});
		this.add(calculateButton);

		// Set Default to 0;
		this.foodSpentInput.setText("0");
		this.housingSpentInput.setText("0");
		this.healthSpentInput.setText("0");
		this.transportSpentInput.setText("0");
		this.entertainmentSpentInput.setText("0");
			
	}
	
	public void handleDefaultPrices() {
		float finalBalance = currentUser.calculateFinalBalance();
		this.foodBudgetInput.setText(finalBalance > 0 ? String.valueOf(finalBalance * 0.10f) : "0");
		this.housingBudgetInput.setText(finalBalance > 0 ? String.valueOf(finalBalance * 0.25f) : "0");
		this.healthBudgetInput.setText(finalBalance > 0 ? String.valueOf(finalBalance * 0.15f) : "0");
		this.transportBudgetInput.setText(finalBalance > 0 ? String.valueOf(finalBalance * 0.15f) : "0");
		this.entertainmentBudgetInput.setText(finalBalance > 0 ? String.valueOf(finalBalance * 0.5f) : "0");
	}

	public void calculateInput() {
		float foodBudget_Budget = Float.parseFloat(this.foodBudgetInput.getText());
		float houseBudget_Budget = Float.parseFloat(this.housingBudgetInput.getText());
		float healthBudget_Budget = Float.parseFloat(this.healthBudgetInput.getText());
		float transportBudget_Budget = Float.parseFloat(this.transportBudgetInput.getText());
		float enterainmentBudget_Budget = Float.parseFloat(this.entertainmentBudgetInput.getText());

		float foodBudget_Spent = Float.parseFloat(this.foodSpentInput.getText());
		float houseBudget_Spent = Float.parseFloat(this.housingSpentInput.getText());
		float healthBudget_Spent = Float.parseFloat(this.healthSpentInput.getText());
		float transportBudget_Spent = Float.parseFloat(this.transportSpentInput.getText());
		float enterainmentBudget_Spent = Float.parseFloat(this.entertainmentSpentInput.getText());

		setProgress(foodBudgetProgress, foodBudget_Spent, foodBudget_Budget);
		setProgress(transportBudgetProgress, transportBudget_Spent, transportBudget_Budget);
		setProgress(housingBudgetProgress, houseBudget_Spent, houseBudget_Budget);
		setProgress(healthBudgetProgress, healthBudget_Spent, healthBudget_Budget);
		setProgress(entertainmentBudgetProgress, enterainmentBudget_Spent, enterainmentBudget_Budget);
	}

	public void setProgress(JProgressBar bar, float spent, float budget) {
		float delta = ((spent / budget) * 100);
		if (delta >= 75)
			bar.setForeground(Colors.ACCENT_RED);
		if (delta <= 25)
			bar.setForeground(Colors.ACCENT_GREEN);
		bar.setValue((int) delta);
	}

	public BudgetPanel(Dashboard dashboard, User user) {
		this.parentPanel = dashboard;
		this.currentUser = user;
		this.handleUI();
	}

}
