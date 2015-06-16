package api.models;

public final class Commentary {
	
	private String userId;
	private String comment;

	public Commentary() { }

	public Commentary(String userId, String comment) {
		this.userId = userId;
		this.comment = comment; }

	public final String getUserId() {
		return userId; }

	public final void setUserId(String userId) {
		this.userId = userId; }

	public final String getComment() {
		return comment; }

	public final void setComment(String comment) {
		this.comment = comment; }
}