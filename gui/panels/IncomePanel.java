package coursework.gui.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import coursework.data.User;
import coursework.gui.Dashboard;

public class IncomePanel extends JPanel{
	
	private JTextField valueTextField;
	private Dashboard parentPanel;

	
	public IncomePanel(Dashboard dashboard, User user) {
		
		this.parentPanel = dashboard;
		this.setLayout(null);
		JLabel incomeTitleLabel = new JLabel("Incomes...");
		incomeTitleLabel.setFont(new Font("Geist", Font.BOLD, 25));
		incomeTitleLabel.setBounds(25, 25, 621, 48);
		this.add(incomeTitleLabel);
		
		JLabel descriptionLabel = new JLabel("Add Income Reference");
		descriptionLabel.setFont(new Font("Geist", Font.PLAIN, 14));
		descriptionLabel.setBounds(25, 321, 220, 18);
		this.add(descriptionLabel);
		
		JTextArea referenceTextArea = new JTextArea();
		referenceTextArea.setFont(new Font("Geist", Font.PLAIN, 13));
		referenceTextArea.setBounds(25, 339, 622, 151);
		this.add(referenceTextArea);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Geist", Font.PLAIN, 14));
		lblValue.setBounds(25, 260, 73, 18);
		this.add(lblValue);
		
		JLabel realTimeView = new JLabel("Rs. 0.0");
		realTimeView.setHorizontalAlignment(SwingConstants.CENTER);
		realTimeView.setFont(new Font("Geist", Font.BOLD, 30));
		realTimeView.setBounds(25, 101, 621, 108);
		this.add(realTimeView);;
		
		valueTextField = new JTextField();
		valueTextField.setFont(new Font("Geist", Font.PLAIN, 10));
		valueTextField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					float x = Float.parseFloat(valueTextField.getText());
					if (x >= 100000) x = 100000;
					realTimeView.setText("Rs. " + String.valueOf(x));
				} catch (Exception e2) {
					System.out.println("[Error] Cannot Parse String");
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {}
		});
		
		
		valueTextField.setBounds(25, 281, 621, 30);
		this.add(valueTextField);
		valueTextField.setColumns(10);
		JButton addIncomeButton = new JButton("+   Add Income");
		addIncomeButton.setFont(new Font("Geist", Font.PLAIN, 16));
		addIncomeButton.setBounds(25, 510, 621, 58);
		addIncomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float value = 0f;
				try {
					value = Float.parseFloat(valueTextField.getText());
					// Clamps the value to a max
					if (value >= 100000) value = 100000;
				} catch (Exception e2) {
					value = 0f;
				}
				if (value == 0) return;
				if (referenceTextArea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Write Income Name", "Something Happened", JOptionPane.ERROR_MESSAGE);
					return;
				}
				user.addDebit(referenceTextArea.getText(), value);
				JOptionPane.showMessageDialog(null, "Income Added!", "Done!", JOptionPane.INFORMATION_MESSAGE);
				valueTextField.setText("");
				referenceTextArea.setText("");
				parentPanel.refreshEverything();
			}
		
		});
		
		this.add(addIncomeButton);	
	}

}
