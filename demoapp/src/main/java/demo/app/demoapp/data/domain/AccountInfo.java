package demo.app.demoapp.data.domain;

public class AccountInfo {
	private String identifier;
	private Double balance;
	private Double rate;
	
	public AccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountInfo(String identifier, Double balance, Double rate) {
		super();
		this.identifier = identifier;
		this.balance = balance;
		this.rate = rate;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "AccountInfo [identifier=" + identifier + ", balance=" + balance + ", rate="
				+ rate + "]";
	}
	
}
