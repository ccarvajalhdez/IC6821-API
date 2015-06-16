package api.views;

public final class GenericResponse {
	
	private final int status;
	private final String message;

	public GenericResponse(int status, String message) {
		this.status = status;
		this.message = message; }

	public final int getStatus() {
		return status; }

	public final String getMessage() {
		return message; }
}