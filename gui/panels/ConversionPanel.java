package coursework.gui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import coursework.data.User;
import coursework.gui.Dashboard;
import coursework.util.Rate;

@SuppressWarnings("all")
public class ConversionPanel extends JPanel {

    private JLabel localRateTextLabel;
    private JTextField localInputField;
    private JComboBox<String> rateComboBox;
    private JTextField conversionInputField;
    private float lastY = 175;
    private boolean isConverting = false; 
    private Dashboard parentPanel;
    
    public ConversionPanel(Dashboard dashboard, User user) {
		
		this.parentPanel = dashboard;
        setLayout(null);

        localInputField = new JTextField();
        localInputField.setFont(new Font("Geist", Font.PLAIN, 24));
        localInputField.setHorizontalAlignment(SwingConstants.CENTER);
        localInputField.setText("0");
        localInputField.setColumns(10);
        localInputField.setBounds(25, 25, 310, 71);
        localInputField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                convertLocalToForeign();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                convertLocalToForeign();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                convertLocalToForeign();
            }
        });
        this.add(localInputField);

        conversionInputField = new JTextField();
        conversionInputField.setText("0");
        conversionInputField.setHorizontalAlignment(SwingConstants.CENTER);
        conversionInputField.setFont(new Font("Geist", Font.PLAIN, 24));
        conversionInputField.setColumns(10);
        conversionInputField.setBounds(345, 25, 295, 71);
        conversionInputField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                convertForeignToLocal();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                convertForeignToLocal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                convertForeignToLocal();
            }
        });

        this.add(conversionInputField);

        String[] items = new String[] { "USD", "EURO", "GBP" };

        rateComboBox = new JComboBox<>(items);
        rateComboBox.setFont(new Font("Geist", Font.PLAIN, 16));
        rateComboBox.setBounds(345, 110, 295, 27);
        rateComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                convertForeignToLocal();
            }
        });
        this.add(rateComboBox);

        localRateTextLabel = new JLabel("Sri Lankan Rupee");
        localRateTextLabel.setOpaque(false);
        localRateTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        localRateTextLabel.setFont(new Font("Geist", Font.PLAIN, 16));
        localRateTextLabel.setBounds(25, 110, 310, 27);
        
        this.add(localRateTextLabel);

        for (String rateString : items) {
            JLabel label = new JLabel();
            float rate = getRate(rateString);
            label.setText("1 " + rateString + " = " + rate + " LKR");
            label.setBounds(25, (int) lastY, 615, 50);
            label.setOpaque(true);
            label.setForeground(Color.white);
            label.setBorder(new EmptyBorder(20, 20, 20, 20));
            label.setBackground(new Color(64, 130, 109));
            lastY += 55;
            add(label);
        }
    }

	/***
	 * Overloaded function used for getting the current rate of selected currency in the Combo Box
	 * @author Gavesh Saparamadu
	 * @return Converted Rate <Type Float>
	 */
    private float getRate() {
        return getRate(rateComboBox.getSelectedItem().toString());
    }

	/***
	 * 'getRate()' function to manually retreive a selected currency
	 * @author - Gavesh Saparamadu
	 * @param rateString - Currency type <Type String>
	 * @return convertedRate - Current Rate of the currency <Type Float>
	 */
    private float getRate(String rateString) {
        switch (rateString) {
            case "USD":
                return Rate.USD;
            case "EURO":
                return Rate.EURO;
            case "GBP":
                return Rate.GBP;
            default:
                return 1;
        }
    }

    /**
     * Converts Foriegn Currency to Local Currency
     * @special - IsConverting = Used to check if another process of conversion is currently running
     */
    public void convertForeignToLocal() {
        if (isConverting) return;
        try {
            isConverting = true;
            if (conversionInputField.getText().isEmpty()) return;
            float value = Float.parseFloat(conversionInputField.getText());
            float result = value * getRate();
            localInputField.setText(String.format("%.2f", result));
        } catch (Exception e) {
           
        } finally {
            isConverting = false;
        }
    }
    
    /**
     * Converts Local Currency to Foreign Currency
     * @special - IsConverting = Used to check if another process of conversion is currently running
     */
    public void convertLocalToForeign() {
        if (isConverting) return; 
        try {
            isConverting = true;
            if (localInputField.getText().isEmpty()) return;
            float value = Float.parseFloat(localInputField.getText());
            float result = value / getRate();
            conversionInputField.setText(String.format("%.2f", result));
        } catch (Exception e) {
          
        } finally {
            isConverting = false;
        }
    }
}
