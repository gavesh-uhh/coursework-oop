package coursework.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import coursework.data.Transaction;
import coursework.data.User;
import coursework.gui.panels.BudgetPanel;
import coursework.gui.panels.ConversionPanel;
import coursework.gui.panels.ExpensePanel;
import coursework.gui.panels.IncomePanel;
import coursework.gui.panels.InfoPanel;
import coursework.util.Colors;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Dashboard extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel cardPanel;

	private User user;
	private CardLayout cl_cardPanel = new CardLayout();

	private InfoPanel infoPanel;
	private BudgetPanel budgetPanel;
	private IncomePanel incomePanel;
	private ExpensePanel expensePanel;
	private ConversionPanel conversionPanel;

	private void handleUI() {
	
		// Window Icon 
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/coursework/assets/icon.png")));
		
		setTitle("Fintel • Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 631);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Colors.ACCENT_GREEN);
		contentPane.setLayout(null);

		cardPanel = new JPanel();
		cardPanel.setBounds(155, 0, 668, 594);
		contentPane.add(cardPanel);
		cardPanel.setLayout(cl_cardPanel);
	
		// #Tab Switcher - Info Button
		JButton infoPanelButton = new JButton("Home");
		infoPanelButton.setBackground(new Color(255, 255, 255));
		infoPanelButton.setFont(new Font("Geist", Font.PLAIN, 13));
		infoPanelButton.setBorder(null);
		infoPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "tab_info");
			}
		});
		infoPanelButton.setBounds(10, 159, 135, 40);
		contentPane.add(infoPanelButton);

		// #Tab Switcher - Dashboard Button
		JButton dashboardPanelButton = new JButton("Budget");
		dashboardPanelButton.setFont(new Font("Geist", Font.PLAIN, 13));
		dashboardPanelButton.setBorder(null);
		dashboardPanelButton.setBackground(new Color(255, 255, 255));
		dashboardPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "tab_budget");
			}
		});
		dashboardPanelButton.setBounds(10, 209, 135, 40);
		contentPane.add(dashboardPanelButton);

		JButton incomePanelButton = new JButton("Income");
		incomePanelButton.setFont(new Font("Geist", Font.PLAIN, 13));
		incomePanelButton.setBorder(null);
		incomePanelButton.setBackground(Color.WHITE);
		incomePanelButton.setBounds(10, 259, 135, 40);
		incomePanelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "tab_income");
			}
		});
		contentPane.add(incomePanelButton);

		JButton expensePanelButton = new JButton("Expenses");
		expensePanelButton.setFont(new Font("Geist", Font.PLAIN, 13));
		expensePanelButton.setBorder(null);
		expensePanelButton.setBackground(Color.WHITE);
		expensePanelButton.setBounds(10, 309, 135, 40);
		expensePanelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "tab_expense");
			}
		});
		contentPane.add(expensePanelButton);

		JButton convertPanelButton = new JButton("Conversions");
		convertPanelButton.setFont(new Font("Geist", Font.PLAIN, 13));
		convertPanelButton.setBorder(null);
		convertPanelButton.setBackground(Color.WHITE);
		convertPanelButton.setBounds(10, 359, 135, 40);
		convertPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "tab_conversions");
			}
		});
		contentPane.add(convertPanelButton);

		JLabel logoLabel = new JLabel("");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/coursework/assets/white_logo.png")));
		logoLabel.setBounds(10, 20, 135, 120);
		contentPane.add(logoLabel);
			
		infoPanel = new InfoPanel(this, user);
		cardPanel.add(infoPanel, "tab_info");

		budgetPanel = new BudgetPanel(this, user);
		cardPanel.add(budgetPanel, "tab_budget");
		
		incomePanel = new IncomePanel(this, user);
		cardPanel.add(incomePanel, "tab_income");
		
		expensePanel = new ExpensePanel(this, user);
		cardPanel.add(expensePanel, "tab_expense");
		
		conversionPanel = new ConversionPanel(this, user);
		cardPanel.add(conversionPanel, "tab_conversions");
	}
	
	
	public void refreshEverything() {
		this.infoPanel.clearButtons();
		this.infoPanel.updateDetails();
		for (Transaction t : user.getTransactions()) {
			infoPanel.addTransaction(t);
		}
		this.budgetPanel.handleDefaultPrices();
	}
	

	public Dashboard() {
		// Since, There is no Database we manually added a user
		user = new User("John Adams", 10000);
		user.addCredit("Paid Class Fees", 2500);
		user.addCredit("Paid Bills", 12500);
		user.addDebit("Pocket Money", 3500);
		this.handleUI();
		refreshEverything();	
	}
}
