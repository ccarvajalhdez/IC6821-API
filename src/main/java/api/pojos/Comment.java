package api.pojos;

public final class Comment {
	
	private User user;
	private String content;
	
	public Comment(User user, String content) {
		this.user = user;
		this.content = content; }

	public final User getUser() {
		return user; }

	public final void setUser(User user) {
		this.user = user; }

	public final String getContent() {
		return content; }

	public final void setContent(String content) {
		this.content = content; }

	@Override
	public String toString() {
		return "Comment [user=" + user + ", content=" + content + "]"; }

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
		if (!(obj instanceof Comment)) {
			return false; }
		Comment other = (Comment) obj;
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