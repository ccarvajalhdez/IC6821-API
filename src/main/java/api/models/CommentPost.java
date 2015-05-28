package api.models;

public class CommentPost {
	
	private String username;
	private String comment;
	
	public CommentPost() {}

	public final String getUsername() {
		return username; }

	public final void setUsername(String username) {
		this.username = username; }

	public final String getComment() {
		return comment; }

	public final void setComment(String comment) {
		this.comment = comment; }
}