package api.interfaces;

import java.util.List;

public interface UserFunctionsService {
	
	public List<Object> search(String value);
	
	public void publish(String publisher,String description,String code,String language) throws Exception;
	
	public void commentPublication(int postId,String username,String comment) throws Exception;
	
	public void follow(String currentUser,String username) throws Exception;
	
	public void stopFollowing(String currentUser,String username) throws Exception; }