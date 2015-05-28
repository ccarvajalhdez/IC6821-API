package api.services;

import java.util.List;

import api.interfaces.VisualizationService;
import api.pojos.Medal;
import api.pojos.Notification;
import api.pojos.Post;
import api.pojos.User;

public final class VisualizationServiceMock implements VisualizationService {

	@Override
	public List<User> showFollowers(String username) {
		User user = new SessionServiceMock().getUser(username);
		return user.getFollowers(); }

	@Override
	public List<User> showFollowing(String username) {
		User user = new SessionServiceMock().getUser(username);
		return user.getFollows(); }

	@Override
	public List<Medal> showMedals(String username) {
		User user = new SessionServiceMock().getUser(username);
		return user.getMedals(); }

	@Override
	public List<Post> showFeed(String username) {
		User user = new SessionServiceMock().getUser(username);
		return user.getPosts(); }

	@Override
	public List<Post> showUserPost(String username) {
		User user = new SessionServiceMock().getUser(username);
		return user.getPosts(); }

	@Override
	public List<Notification> showUserNotifications(String username) {
		User user = new SessionServiceMock().getUser(username);
		return user.getNotifications(); }
}