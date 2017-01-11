package demo.app.demoweb.mvc.data;

public class DataMapResponse extends ServiceResponse {

	public DataMapResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DataMapResponse [status=" + getStatus() + ", message=" + getMessage()
				+ ", elapsedTimeMs=" + getElapsedTimeMs() + "]";
	}

	
}
