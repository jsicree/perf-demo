package demo.app.demoapp.data.dto;

import java.util.Date;

public class Account {
	private Integer id;
	private String identifier;
	private AccountType type;
	private Date createDate;
	private Double balance;
	private Date asOfDate;
	private AccountStatus status;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer id, String identifier, AccountType type, Date createDate, Double balance, Date asOfDate,
			AccountStatus status) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.type = type;
		this.createDate = createDate;
		this.balance = balance;
		this.asOfDate = asOfDate;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getAsOfDate() {
		return asOfDate;
	}

	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", identifier=" + identifier + ", type=" + type + ", createDate=" + createDate
				+ ", balance=" + balance + ", asOfDate=" + asOfDate + ", status=" + status + "]";
	}
	
}
