package api.views;

import api.pojos.Notification;

public final class NotificationView {
	
	private String content;
	private String user;
	private String seen;
	
	public NotificationView(Notification notification) {
		this.content = notification.getContent();
		this.user = notification.getUser().getUsername();
		this.seen = String.valueOf(notification.isSeen()); }
	
	public NotificationView() {
		this.content = null;
		this.user = null;
		this.seen = null; }

	public final String getContent() {
		return content; }

	public final void setContent(String content) {
		this.content = content; }

	public final String getUser() {
		return user; }

	public final void setUser(String user) {
		this.user = user; }

	public final String getSeen() {
		return seen; }

	public final void setSeen(String seen) {
		this.seen = seen; }
}