package api.mocks;

import java.util.List;

import org.springframework.stereotype.Service;

import api.interfaces.UserFunctionsService;
import api.pojos.Code;
import api.pojos.Comment;
import api.pojos.Post;
import api.pojos.User;

@Service
public final class UserFunctionsServiceMock implements UserFunctionsService {

	public UserFunctionsServiceMock() { }

	@Override
	public List<Object> search(String value) {
		return null; }

	@Override
	public Post publish(String publisherId, String description, String code,
			String language) {
		User user = RepositoryMock.getUserRepository().get(publisherId);
		Post post = null;
		if (user != null) {
			Code codec = new Code(code, language);
			post = new Post(description, codec, user);
			user.getPosts().add(post);
			RepositoryMock.getPostRepository().put(post.getId(), post); } 
		return post; }

	@Override
	public Comment commentPublication(String postId, String userId, String comment) {
		User user = RepositoryMock.getUserRepository().get(userId);
		Post post = RepositoryMock.getPostRepository().get(postId);
		Comment commentc = null;
		if (user != null && post != null) {
			commentc = new Comment(user, comment);
			post.getComments().add(commentc); } 
		return commentc; }

	@Override
	public User follow(String currentUserId, String userId) {
		User follower = RepositoryMock.getUserRepository().get(currentUserId);
		User followed = RepositoryMock.getUserRepository().get(userId);
		if (follower != null && followed != null) {
			if (!follower.getFollows().contains(followed) &&
				!followed.getFollowers().contains(follower)) {
				follower.getFollows().add(followed);
				followed.getFollowers().add(follower);
				return followed; }
			else {
				return null; } }
		else {
			return null; } }

	@Override
	public User stopFollowing(String currentUserId, String userId) {
		User follower = RepositoryMock.getUserRepository().get(currentUserId);
		User followed = RepositoryMock.getUserRepository().get(userId);
		if (follower != null && followed != null) {
			if (follower.getFollows().contains(followed) &&
				followed.getFollowers().contains(follower)) {
				follower.getFollows().remove(followed); 
				followed.getFollowers().remove(follower);
				return follower; }
			else {
				return null; } }
		else {
			return null; } }

	@Override
	public Post share(String userId, String postId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		Post post = RepositoryMock.getPostRepository().get(postId);
		if (user != null && post != null) {
			post.getShared().add(user);
			return post; }
		else {
			return null; } }
}