package demo.app.demoweb.mvc.data;

public abstract class ServiceResponse {
	private Status status;
	private String message;
	private Long elapsedTimeMs;

	public ServiceResponse() {
		super();
	}

	public ServiceResponse(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public ServiceResponse(Status status, String message, Long elapsedTimeMs) {
		super();
		this.status = status;
		this.message = message;
		this.elapsedTimeMs = elapsedTimeMs;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getElapsedTimeMs() {
		return elapsedTimeMs;
	}

	public void setElapsedTimeMs(Long elapsedTimeMs) {
		this.elapsedTimeMs = elapsedTimeMs;
	}

	@Override
	public String toString() {
		return "ServiceResponse [status=" + status + ", message=" + message + ", elapsedTimeMs=" + elapsedTimeMs + "]";
	}
	
}
