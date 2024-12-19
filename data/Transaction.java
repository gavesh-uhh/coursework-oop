package coursework.data;

public class Transaction {
	
	private final String type;
	private final String description;
	private float value;
	
	public Transaction(String type, String description, float value) {
		if (type.toLowerCase().equals("debit")) this.type = "debit";
		else this.type = "credit";
		this.description = description;
		this.value = value;
	}

	public String getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public float getValue() {
		return value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	
}
