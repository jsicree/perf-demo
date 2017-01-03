package demo.app.demoapp.data.domain;

public enum AccountType {
	
	BASIC("Basic"), 
	PREMIUM("Premium");
	
	private final String typeName;

	AccountType(String typeName) {
        this.typeName = typeName;
    }
    
    public String typeName() { return typeName; }
		
}
