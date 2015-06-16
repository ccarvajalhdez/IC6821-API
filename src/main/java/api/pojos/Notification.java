package api.pojos;

public final class Notification {
	
	private String content;
	private User user;
	private boolean seen;
	
	public Notification(String content, User user) {
		this.content = content;
		this.user = user;
		this.seen = false; }

	public final String getContent() {
		return content; }

	public final void setContent(String content) {
		this.content = content; }

	public final User getUser() {
		return user; }

	public final void setUser(User user) {
		this.user = user; }

	public final boolean isSeen() {
		return seen; }

	public final void setSeen(boolean seen) {
		this.seen = seen; }

	@Override
	public String toString() {
		return "Notification [content=" + content + ", user=" + user.getUsername()
				+ ", seen=" + seen + "]"; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Notification)) {
			return false; }
		Notification other = (Notification) obj;
		if (content == null) {
			if (other.content != null) {
				return false; } }
		else if (!content.equals(other.content)) {
			return false; }
		if (user == null) {
			if (other.user != null) {
				return false; } }
		else if (!user.equals(other.user)) {
			return false; }
		return true; }
}