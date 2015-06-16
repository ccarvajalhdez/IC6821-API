package api.views;

import api.pojos.Comment;

public final class CommentView {
	
	private String user;
	private String content;

	public CommentView(Comment comment) {
		this.user = comment.getUser().getUsername();
		this.content = comment.getContent(); }
	
	public CommentView() {
		this.user = null;
		this.content = null; }

	public final String getUser() {
		return user; }

	public final void setUser(String user) {
		this.user = user; }

	public final String getContent() {
		return content; }

	public final void setContent(String content) {
		this.content = content; }
}
