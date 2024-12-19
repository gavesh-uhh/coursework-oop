package coursework.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coursework.gui.Dashboard;
import coursework.util.Colors;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("all")
public class Login extends JFrame {


	private HashMap<String, String> loginSet = new HashMap<>();
	
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel errorLabel;


	public Login() {
		
		// Since there is no database we manually add a set of logins
		this.loginSet.put("gavesh", "12345678");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Fintel • Login Page");
		setSize(602, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font(Colors.FONT_NAME, Font.PLAIN, 10));
		usernameField.setToolTipText("Type your username");
		usernameField.setBounds(272, 171, 306, 30);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font(Colors.FONT_NAME, Font.PLAIN, 10));
		passwordField.setBounds(272, 232, 306, 30);
		contentPane.add(passwordField);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font(Colors.FONT_NAME, Font.PLAIN, 16));
		usernameLabel.setBounds(272, 142, 118, 30);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font(Colors.FONT_NAME, Font.PLAIN, 16));
		passwordLabel.setBounds(272, 204, 118, 30);
		contentPane.add(passwordLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Geist", Font.PLAIN, 12));
		errorLabel.setBounds(272, 267, 306, 20);
		errorLabel.setForeground(Color.red);
		contentPane.add(errorLabel);
				
		JButton btnLoginButton = new JButton("Login");
		btnLoginButton.setFont(new Font(Colors.FONT_NAME, Font.PLAIN, 14));
		btnLoginButton.setBounds(272, 338, 262, 38);
		btnLoginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userField = usernameField.getText();
				String passField = String.valueOf(passwordField.getPassword());
				if (userField.isEmpty() || passField.isEmpty()) return;
				boolean authorized = authenticateUser(userField, passField);
				if (!authorized) {
					showError("Invalid Username or Password"); 
					return;
				}
				openDashboard();
			}
		});
		contentPane.add(btnLoginButton);
		
		JPanel heroPanelLeft = new JPanel();
		heroPanelLeft.setBackground(Colors.ACCENT_GREEN);
		heroPanelLeft.setBounds(0, 0, 262, 386);
		contentPane.add(heroPanelLeft);
		
		JLabel pageTitleLabel = new JLabel("FINTEL");
		pageTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pageTitleLabel.setFont(new Font(Colors.FONT_NAME, Font.BOLD, 33));
		pageTitleLabel.setBounds(272, 52, 306, 38);
		contentPane.add(pageTitleLabel);
		
		JLabel pageDescLabel = new JLabel("All-In-One Financial Helper");
		pageDescLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pageDescLabel.setFont(new Font(Colors.FONT_NAME, Font.PLAIN, 15));
		pageDescLabel.setBounds(272, 88, 306, 30);
		contentPane.add(pageDescLabel);
		
		JButton btnLoginButton_1 = new JButton("?");
		btnLoginButton_1.setFont(new Font("Geist", Font.PLAIN, 14));
		btnLoginButton_1.setBounds(536, 338, 42, 38);
		contentPane.add(btnLoginButton_1);

	}
	
	/**
	 * Simply opens the Dashboard JFrame.
	 */
	public void openDashboard() {
		this.dispose();
		Dashboard d = new Dashboard();
		d.setVisible(true);
	}
	
	/**
	 * Checks whether user exists in the current HashMap returns null if dosen't exist
	 * if exists, check password with the stored one and returns accordingly.
	 * @author Gavesh Saparamadu
	 * @param user - Username <Type String>
	 * @param password - Password <Type String>
	 * @return true or false 
	 */
	public boolean authenticateUser(String user, String password) {
		if (!loginSet.containsKey(user)) return false;
		String hashedPassword = loginSet.get(user);
		if (password.equals(hashedPassword)) return true;
		else return false;
	}
	
	public void showError(String message) {
		this.errorLabel.setText(message);
		new Timer().schedule( 
		        new TimerTask() {
		            @Override
		            public void run() {
		                errorLabel.setText("");
		            }
		        }, 
		        5000 
		);
	}
	
}
