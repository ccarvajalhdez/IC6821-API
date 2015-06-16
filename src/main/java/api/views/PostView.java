package api.views;

import java.util.ArrayList;

import api.pojos.Code;
import api.pojos.Comment;
import api.pojos.Post;
import api.pojos.Rating;
import api.pojos.User;

public final class PostView {
	
	private String id;
	private String user;
	private String description;
	private Code code;
	private ArrayList<Integer> ratings;
	private ArrayList<String> shared;
	private ArrayList<CommentView> comments;

	public PostView(Post post) {
		this.id = post.getId();
		this.user = post.getUser().getUsername();
		this.description = post.getDescription();
		this.code = post.getCode();
		this.ratings = new ArrayList<Integer>();
		this.shared = new ArrayList<String>();
		this.comments = new ArrayList<CommentView>();
		this.fillRatings(post);
		this.fillShared(post);
		this.fillComments(post); }
	
	public PostView() {
		this.id = null;
		this.user = null;
		this.description = null;
		this.code = null;
		this.ratings = null;
		this.shared = null;
		this.comments = null; }
	
	private void fillRatings(Post post) {
		for (Rating rating : post.getRatings()) {
			this.ratings.add(rating.getScore()); } }
	
	private void fillShared(Post post) {
		for (User user : post.getShared()) {
			this.shared.add(user.getUsername()); } }
	
	private void fillComments(Post post) {
		for (Comment comment : post.getComments()) {
			this.comments.add(new CommentView(comment)); } }

	public final String getId() {
		return id; }

	public final void setId(String id) {
		this.id = id; }

	public final String getUser() {
		return user; }

	public final void setUser(String user) {
		this.user = user; }

	public final String getDescription() {
		return description; }

	public final void setDescription(String description) {
		this.description = description; }

	public final Code getCode() {
		return code; }

	public final void setCode(Code code) {
		this.code = code; }

	public final ArrayList<Integer> getRatings() {
		return ratings; }

	public final void setRatings(ArrayList<Integer> ratings) {
		this.ratings = ratings; }

	public final ArrayList<String> getShared() {
		return shared; }

	public final void setShared(ArrayList<String> shared) {
		this.shared = shared; }

	public final ArrayList<CommentView> getComments() {
		return comments; }

	public final void setComments(ArrayList<CommentView> comments) {
		this.comments = comments; }
}