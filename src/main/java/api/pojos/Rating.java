package api.pojos;

public final class Rating {
	
	private User user;
	private int score;
	
	public Rating(User user, int score) {
		this.user = user;
		this.score = score; }

	public final User getUser() {
		return user; }

	public final void setUser(User user) {
		this.user = user; }

	public final int getScore() {
		return score; }

	public final void setScore(int score) {
		this.score = score; }

	@Override
	public String toString() {
		return "Rating [user=" + user.getUsername() + ", score=" + score + "]"; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + score;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Rating)) {
			return false; }
		Rating other = (Rating) obj;
		if (score != other.score) {
			return false; }
		if (user == null) {
			if (other.user != null) {
				return false; } }
		else if (!user.equals(other.user)) {
			return false; }
		return true; }
}