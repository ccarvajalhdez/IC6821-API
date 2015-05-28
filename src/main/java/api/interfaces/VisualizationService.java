package api.interfaces;

import java.util.List;

import api.pojos.Medal;
import api.pojos.Notification;
import api.pojos.Post;
import api.pojos.User;

public interface VisualizationService {
	
	public List<User> showFollowers(String username);
	
	public List<User> showFollowing(String username);
	
	public List<Medal> showMedals(String username);
	
	public List<Post> showFeed(String username);
	
	public List<Post> showUserPost(String username);
	
	public List<Notification> showUserNotifications(String username); }