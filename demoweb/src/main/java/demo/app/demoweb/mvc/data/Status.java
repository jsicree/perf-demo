package demo.app.demoweb.mvc.data;

public enum Status {
	
	OK("OK"), 
	ERROR("Error");
	
	private final String statusName;
    Status(String statusName) {
        this.statusName = statusName;
    }
    
    public String statusName() { return statusName; }
		
}
