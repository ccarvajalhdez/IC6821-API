package api.mocks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import api.interfaces.VisualizationService;
import api.pojos.Medal;
import api.pojos.Notification;
import api.pojos.Post;
import api.pojos.User;

@Service
public final class VisualizationServiceMock implements VisualizationService {

	@Override
	public List<User> showFollowers(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		List<User> result = (user != null) ? user.getFollowers() : null;  
		return result; }

	@Override
	public List<User> showFollowing(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		List<User> result = (user != null) ? user.getFollows() : null;
		return result; }

	@Override
	public List<Medal> showMedals(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		List<Medal> result = (user != null) ? user.getMedals() : null;
		return result; }

	@Override
	public List<Post> showFeed(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		ArrayList<Post> posts = new ArrayList<Post>();
		if (user != null) {
			ArrayList<User> followeds = user.getFollows();
			if (!followeds.isEmpty()) {
				for (User followed : followeds) {
					for (Post post : followed.getPosts()) {
						posts.add(post); } }
				if (!posts.isEmpty()) {
					return posts; }
				else {
					return null; } }
			else {
				return null; } }
		else {
			return null; } }

	@Override
	public List<Post> showUserPost(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		List<Post> result = (user != null) ? user.getPosts() : null;
		return result; }

	@Override
	public List<Notification> showUserNotifications(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		List<Notification> result = (user != null) ? user.getNotifications() : null;
		return result; }

	@Override
	public InputStream showUserProfilePhoto(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		InputStream result = (user != null) ? user.getProfileImage() : null;
		return result; }

	@Override
	public Integer newNotifications(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		int result = 0;
		if (user != null) {
			ArrayList<Notification> notifications = user.getNotifications();
			if (!notifications.isEmpty()) {
				for (Notification notification : notifications) {
					if (notification.isSeen()) {
						result ++; } } } }
		return result; }

	@Override
	public List<Post> showPostsByDateAndRegion(String region, Date from, Date to) {
		Collection<User> users = RepositoryMock.getUserRepository().values();
		ArrayList<Post> posts = new ArrayList<Post>();
		for (User user : users) {
			if (user.getLocatedOn().equals(region)) {
				for (Post post : user.getPosts()) {
					if (post.getCreatedDate().before(to) && post.getCreatedDate().after(from)) {
						posts.add(post); } } } }
		if (!posts.isEmpty()) {
			return posts; }
		else {
			 return null; } }
}