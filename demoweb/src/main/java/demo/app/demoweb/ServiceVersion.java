package demo.app.demoweb;

public enum ServiceVersion {
	VERSION_1("v1"), 
	VERSION_2("v2");
	
	private final String versionName;

	ServiceVersion(String versionName) {
        this.versionName = versionName;
    }
    
    public String versionName() { return versionName; }


}
