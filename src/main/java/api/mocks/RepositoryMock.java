package api.mocks;

import java.util.HashMap;

import api.pojos.Post;
import api.pojos.User;

public abstract class RepositoryMock {
	
	private final static HashMap<String, User> userRepository = new HashMap<String, User>();
	private final static HashMap<String, Post> postRepository = new HashMap<String, Post>();

	public RepositoryMock() { 
		userRepository.clear();
		postRepository.clear(); }

	public static final HashMap<String, User> getUserRepository() {
		return userRepository; }
	
	public static final HashMap<String, Post> getPostRepository() {
		return postRepository; }
}