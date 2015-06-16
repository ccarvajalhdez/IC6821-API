package api.interfaces;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import api.pojos.Medal;
import api.pojos.Notification;
import api.pojos.Post;
import api.pojos.User;

public interface VisualizationService {
	
	public List<User> showFollowers(String userId);
	
	public List<User> showFollowing(String userId);
	
	public List<Medal> showMedals(String userId);
	
	public List<Post> showFeed(String userId);
	
	public List<Post> showUserPost(String userId);
	
	public List<Notification> showUserNotifications(String userId);
	
	public InputStream showUserProfilePhoto(String userId);
	
    public Integer newNotifications(String userId);
    
    public List<Post> showPostsByDateAndRegion(String region, Date from, Date to); }
