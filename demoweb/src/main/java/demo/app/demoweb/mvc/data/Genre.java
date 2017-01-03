package demo.app.demoweb.mvc.data;

public enum Genre {
	
	ROCK("Rock"), 
	HARD_ROCK("Hard Rock"),	
	HEAVY_METAL("Heavy Metal"),			
	ALT_ROCK("Alternative Rock"),	
	PROG_ROCK("Progressive Rock");
	
	private final String bandName;
    Genre(String bandName) {
        this.bandName = bandName;
    }
    
    public String bandName() { return bandName; }
		
}
