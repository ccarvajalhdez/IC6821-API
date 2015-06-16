package api.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.interfaces.UserFunctionsService;
import api.interfaces.VisualizationService;
import api.models.Commentary;
import api.models.DateRange;
import api.models.Publication;
import api.pojos.Comment;
import api.pojos.Post;
import api.views.CommentView;
import api.views.GroupView;
import api.views.PostView;

@RestController
@RequestMapping("/api/v0/")
public final class PostController {

	@Autowired
	private UserFunctionsService userFunctionsService;
	
	@Autowired
	private VisualizationService visualizationService;
	
	@RequestMapping(value = "posts", method = RequestMethod.POST)
	public PostView insertPost(HttpServletResponse response, @RequestBody Publication publication) {
		PostView postView = new PostView();
		try {
			String publisherId = publication.getPublisherId();
			String description = publication.getDescription();
			String code = publication.getCode();
			String language = publication.getLanguage();
			
			Post post = userFunctionsService.publish(publisherId, description, code, language);
			int status = 0;
			if (post != null) {
				status = HttpServletResponse.SC_CREATED;
				postView = new PostView(post); }
			else {
				status = HttpServletResponse.SC_NOT_ACCEPTABLE; }
			response.setStatus(status);
			return postView; }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return postView; } }
	
	@RequestMapping(value = "posts", method = RequestMethod.GET)
	public ArrayList<PostView> getPosts(HttpServletResponse response, @RequestBody DateRange date) {
		GroupView groupView = new GroupView();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date from = formatter.parse(date.getFrom());
			Date to = formatter.parse(date.getTo());
			String region = date.getRegion();
			
			List<Post> posts = visualizationService.showPostsByDateAndRegion(region, from, to);
			int status = 0;
			if (posts != null) {
				status = HttpServletResponse.SC_FOUND;
				groupView.setPosts(posts); }
			else {
				status = HttpServletResponse.SC_NOT_FOUND; }
			response.setStatus(status);
			return groupView.getPosts(); }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return groupView.getPosts(); } }
	
	@RequestMapping(value = "posts/{id}/comments", method = RequestMethod.POST)
	public CommentView insertComment(HttpServletResponse response, @PathVariable("id") String postId,
			@RequestBody Commentary commentary) {
		CommentView commentView = new CommentView();
		try {
			String userId = commentary.getUserId();
			String comment = commentary.getComment();
			
			Comment commentc = userFunctionsService.commentPublication(postId, userId, comment);
			int status = 0;
			if (comment != null) {
				status = HttpServletResponse.SC_CREATED;
				commentView = new CommentView(commentc); }
			else {
				status = HttpServletResponse.SC_NOT_ACCEPTABLE; }
			response.setStatus(status);
			return commentView; }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return commentView; } }
	
	@RequestMapping(value = "posts/{id}/sharing/{username}", method = RequestMethod.PUT)
	public PostView sharePost(HttpServletResponse response, @PathVariable("id") String postId, 
			@PathVariable("username") String userId) {
		PostView postView = new PostView();
		try {
			Post post = userFunctionsService.share(userId, postId);
			int status = 0;
			if (post != null) {
				status = HttpServletResponse.SC_OK;
				postView = new PostView(post); }
			else {
				status = HttpServletResponse.SC_NOT_ACCEPTABLE; }
			response.setStatus(status);
			return postView; }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return postView; } }
	
	@RequestMapping(value = "posts/feed/{username}", method = RequestMethod.GET)
	public ArrayList<PostView> selectFeed(HttpServletResponse response, @PathVariable("username") String userId) {
		GroupView groupView = new GroupView();
		try {
			List<Post> posts = visualizationService.showFeed(userId);
			int status = 0;
			if (posts != null) {
				status = HttpServletResponse.SC_FOUND;
				groupView.setPosts(posts); }
			else {
				status = HttpServletResponse.SC_NOT_FOUND; }
			response.setStatus(status);
			return groupView.getPosts(); }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return groupView.getPosts(); } }
	
	@RequestMapping(value = "posts/{username}", method = RequestMethod.GET)
	public ArrayList<PostView> selectPosts(HttpServletResponse response, 
			@PathVariable("username") String userId) {
		GroupView groupView = new GroupView();
		try {
			List<Post> posts = visualizationService.showUserPost(userId);
			int status = 0;
			if (posts != null) {
				status = HttpServletResponse.SC_FOUND;
				groupView.setPosts(posts); }
			else {
				status = HttpServletResponse.SC_NOT_FOUND; }
			response.setStatus(status);
			return groupView.getPosts(); }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return groupView.getPosts(); } }
}