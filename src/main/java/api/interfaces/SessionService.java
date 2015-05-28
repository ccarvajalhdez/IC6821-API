package api.interfaces;

import api.pojos.User;

public interface SessionService {
	
	public User signUp(String username,String email,String password,String passwordConfirm) throws Exception;
	
	public User getCurrentUser(String current_username);
	
	public boolean validateEmail(String email);
	
	public User getUser(String username); }

