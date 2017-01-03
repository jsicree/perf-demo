package demo.app.demoapp.data.domain;

public enum Frequency {
	
	MONTHLY("Monthly"), 
	YEARLY("Yearly");
	
	private final String typeName;

	Frequency(String typeName) {
        this.typeName = typeName;
    }
    
    public String typeName() { return typeName; }
		
}
