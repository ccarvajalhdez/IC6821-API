package api.pojos;

public final class Notification {
	
	private String content;
	private boolean seen;
	
	public Notification(String content) {
		this.content = content;
		this.seen = false; }

	public final String getContent() {
		return content; }

	public final void setContent(String content) {
		this.content = content; }

	public final boolean isSeen() {
		return seen; }

	public final void setSeen(boolean seen) {
		this.seen = seen; }

	@Override
	public String toString() {
		return "Notification [content=" + content + ", seen=" + seen + "]"; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (seen ? 1231 : 1237);
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
		if (seen != other.seen) {
			return false; }
		return true; }
}