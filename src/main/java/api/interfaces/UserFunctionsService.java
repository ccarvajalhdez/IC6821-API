package api.interfaces;

import java.util.List;

import api.pojos.Comment;
import api.pojos.Post;
import api.pojos.User;

public interface UserFunctionsService {
	
	public List<Object> search(String value);
	
	public Post publish(String publisherId, String description, String code, String language);
	
	public Comment commentPublication(String postId, String userId, String comment);
	
	public User follow(String currentUserId, String userId);
	
	public User stopFollowing(String currentUserId, String userId);
	
	public Post share(String userId, String postId); }
