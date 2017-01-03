package demo.app.demoapp.data.domain;

public enum AccountStatus {
	
	ACTIVE("Active"), 
	INACTIVE("Inactive"),
	CLOSED("Closed");
	
	private final String statusName;

	AccountStatus(String statusName) {
        this.statusName = statusName;
    }
    
    public String statusName() { return statusName; }
		
}
