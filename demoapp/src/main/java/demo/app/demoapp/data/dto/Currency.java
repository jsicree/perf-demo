package demo.app.demoapp.data.dto;

public enum Currency {
	
	CAD("Dollar (CANADA)"), 
	EUR("Euro (EU)"), 
	USD("Dollar (United States)"), 
	JPY("Yen (JAPAN)");
	
	private final String ccyName;

	Currency(String ccyName) {
        this.ccyName = ccyName;
    }
    
    public String ccyName() { return ccyName; }
		
}
