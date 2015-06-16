package api.pojos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class Post {
	
	private static int sequence;
	private final String id;
	private String description;
	private Code code;
	private User user;
	private ArrayList<Rating> ratings;
	private ArrayList<User> shared;
	private ArrayList<Comment> comments;
	private Date createdDate;
	
	public Post(String description, Code code, User user) {
		sequence ++;
		this.id = String.valueOf(sequence);
		this.description = description;
		this.code = code;
		this.user = user;
		this.ratings = new ArrayList<Rating>();
		this.shared = new ArrayList<User>();
		this.comments = new ArrayList<Comment>();
		this.setCreatedDate(Calendar.getInstance().getTime()); }

	public final String getDescription() {
		return description; }

	public final void setDescription(String description) {
		this.description = description; }

	public final Code getCode() {
		return code; }

	public final void setCode(Code code) {
		this.code = code; }

	public final User getUser() {
		return user; }

	public final void setUser(User user) {
		this.user = user; }

	public final ArrayList<Rating> getRatings() {
		return ratings; }

	public final void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings; }

	public final ArrayList<User> getShared() {
		return shared; }

	public final void setShared(ArrayList<User> shared) {
		this.shared = shared; }

	public final ArrayList<Comment> getComments() {
		return comments; }

	public final void setComments(ArrayList<Comment> comments) {
		this.comments = comments; }

	public final Date getCreatedDate() {
		return createdDate; }

	public final void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate; }

	public final String getId() {
		return id; }

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", code="
				+ code + ", user=" + user.getUsername() + ", ratings=" + ratings
				+ ", shared=" + shared + ", comments=" + comments + "]"; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		return result; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Post)) {
			return false; }
		Post other = (Post) obj;
		if (code == null) {
			if (other.code != null) {
				return false; } }
		else if (!code.equals(other.code)) {
			return false; }
		if (description == null) {
			if (other.description != null) {
				return false; } }
		else if (!description.equals(other.description)) {
			return false; }
		return true; }
}