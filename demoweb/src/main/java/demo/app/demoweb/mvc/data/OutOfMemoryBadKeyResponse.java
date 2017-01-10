package demo.app.demoweb.mvc.data;

public class OutOfMemoryBadKeyResponse extends ServiceResponse {

	public OutOfMemoryBadKeyResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OutOfMemoryResponse [status=" + getStatus() + ", message=" + getMessage()
				+ ", elapsedTimeMs=" + getElapsedTimeMs() + "]";
	}

	
}
