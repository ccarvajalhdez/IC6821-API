package api.views;

import java.util.ArrayList;
import java.util.List;

import api.pojos.Medal;
import api.pojos.Notification;
import api.pojos.Post;
import api.pojos.User;

public final class GroupView {
	
	private ArrayList<PostView> posts;
	private ArrayList<UserView> users;
	private ArrayList<NotificationView> notifications;
	private ArrayList<Medal> medals;
	
	public GroupView() {
		this.posts = null;
		this.users = null;
		this.notifications = null; }

	public final ArrayList<PostView> getPosts() {
		return posts; }

	public final void setPosts(ArrayList<PostView> posts) {
		this.posts = posts; }
	
	public final void setPosts(List<Post> posts) {
		this.posts = new ArrayList<PostView>();
		for (Post post : posts) {
			this.posts.add(new PostView(post)); } }

	public final ArrayList<UserView> getUsers() {
		return users; }

	public final void setUsers(ArrayList<UserView> users) {
		this.users = users; }
	
	public final void setUsers(List<User> users) {
		this.users = new ArrayList<UserView>();
		for (User user : users) {
			this.users.add(new UserView(user)); } }

	public final ArrayList<NotificationView> getNotifications() {
		return notifications; }

	public final void setNotifications(ArrayList<NotificationView> notifications) {
		this.notifications = notifications; }
	
	public final void setNotifications(List<Notification> notifications) {
		this.notifications = new ArrayList<NotificationView>();
		for (Notification notification : notifications) {
			this.notifications.add(new NotificationView(notification)); } }

	public final ArrayList<Medal> getMedals() {
		return medals; }

	public final void setMedals(ArrayList<Medal> medals) {
		this.medals = medals; }
	
	public final void setMedals(List<Medal> medals) {
		this.medals = new ArrayList<Medal>();
		for (Medal medal : medals) {
			this.medals.add(medal); } }
}