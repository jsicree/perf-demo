package demo.app.demoweb.mvc.data;

public abstract class ServiceResponse {
	private Status status;
	private String message;
	private String version;
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

	public ServiceResponse(Status status, String message, Long elapsedTimeMs, String version) {
		super();
		this.status = status;
		this.message = message;
		this.elapsedTimeMs = elapsedTimeMs;
		this.version = version;
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
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ServiceResponse [status=" + status + ", message=" + message + ", version=" + version
				+ ", elapsedTimeMs=" + elapsedTimeMs + "]";
	}

	
}
