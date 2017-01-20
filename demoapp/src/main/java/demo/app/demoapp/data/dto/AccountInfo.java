package demo.app.demoapp.data.dto;

public class AccountInfo {
	private String identifier;
	private Money balance;
	private Double rate;
	
	public AccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountInfo(String identifier, Money balance, Double rate) {
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

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
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
