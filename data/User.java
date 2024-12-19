package coursework.data;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class User {

	private String fullName;
	private float baseIncome;
	private List<Transaction> transactions;
	
	public User(String fullName, float baseIncome) {
		this.fullName = fullName;
		this.baseIncome = baseIncome;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public void addDebit(String description, float value) {
		this.transactions.add(new Transaction("debit", description, value));
	}
	
	public void addCredit(String description, float value) {
		this.transactions.add(new Transaction("credit", description, value));
	}
	
	public float calculateFinalBalance() {
		float deductable = 0f;
		for (Transaction transaction : transactions) {
			float value = transaction.getValue();
			if (transaction.getType().equals("credit")) deductable -= value;
			else deductable += value;
		}
		return (baseIncome + deductable);
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setBaseIncome(float baseIncome) {
		this.baseIncome = baseIncome;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return (ArrayList<Transaction>) transactions;
	}
	
}
