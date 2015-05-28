package api.services;

import java.util.List;

import api.interfaces.UserFunctionsService;
import api.pojos.Comment;
import api.pojos.Post;
import api.pojos.User;
import api.pojos.Code;
import api.repositories.Repository;

public final class UserFunctionsServiceMock implements UserFunctionsService {
	
	@Override
	public List<Object> search(String value) {
		return null; }

	@Override
	public void publish(String publisher, String description, String code,
			String language) throws Exception {
		for (User user: Repository.getRepository()) {
			if (user.getUsername().equals(publisher)) {
				Code codec = new Code(code, language);
				Post post = new Post(description, codec);
				user.getPosts().add(post);
				return; } }
		throw new Exception("Publisher doesn't exist."); }

	@Override
	public void commentPublication(int postId, String username,
			String comment) throws Exception {
		for (User user: Repository.getRepository()) {
			for (Post post: user.getPosts()) {
				if (post.getId() == postId) {
					
					try { 
						User userc = new SessionServiceMock().getUser(username);
						Comment commentc = new Comment(userc, comment);
						post.getComments().add(commentc);
						return; }
					catch(Exception e) { throw e; } } } }
		throw new Exception("Post ID doesn't exist."); }

	@Override
	public void follow(String currentUser, String username) throws Exception {
		User userFollowing;
		User userFollowed;
		SessionServiceMock sessionServiceMock = new SessionServiceMock(); 
		try {
			userFollowing = sessionServiceMock.getUser(currentUser);
			userFollowed = sessionServiceMock.getUser(username);
			
			if (!userFollowing.getFollows().contains(userFollowed)) { 
				userFollowing.getFollows().add(userFollowed); }
			else {
				throw new Exception("It's already followed."); }
			if (!userFollowed.getFollowers().contains(userFollowing)) {
				userFollowed.getFollowers().add(userFollowing); } }
		
		catch(Exception e) { throw e; } }

	@Override
	public void stopFollowing(String currentUser, String username) throws Exception {
		User userFollowing;
		User userFollowed;
		try {
			userFollowing = new SessionServiceMock().getUser(currentUser);
			userFollowed = new SessionServiceMock().getUser(username); }
		catch(Exception e) { throw e; }
		if (userFollowing.getFollows().contains(userFollowed)) { 
			userFollowing.getFollows().remove(userFollowed); }
		else {
			throw new Exception("It isn't followed."); }
		if (userFollowed.getFollowers().contains(userFollowing)) {
			userFollowed.getFollowers().remove(userFollowing); } }
}