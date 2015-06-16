package api.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.interfaces.AccountConfigurationService;
import api.interfaces.SessionService;
import api.interfaces.UserFunctionsService;
import api.interfaces.VisualizationService;
import api.models.Account;
import api.models.SignUp;
import api.pojos.User;
import api.views.GenericResponse;
import api.views.GroupView;
import api.views.Message;
import api.views.UserView;

@RestController
@RequestMapping("/api/v0/")
public final class UserController {
	
	@Autowired
    private SessionService sessionService;
	
	@Autowired
	private AccountConfigurationService accountConfigurationService;
	
	@Autowired
	private UserFunctionsService userFunctionsService;
	
	@Autowired
	private VisualizationService visualizationService;
	
	@RequestMapping(value = "users/{username}", method = RequestMethod.GET)
	public UserView selectUser(HttpServletResponse response, @PathVariable("username") String username) {
		UserView userView = new UserView();
		try {
			User user = sessionService.getUser(username);
			int status = 0;
			if (user != null) { 
				status = HttpServletResponse.SC_FOUND;
				userView = new UserView(user); }
			else { 
				status = HttpServletResponse.SC_NOT_FOUND; }
			response.setStatus(status);
			return userView; }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return userView; } }
	
	@RequestMapping(value = "users/{username}", method = RequestMethod.DELETE)
	public GenericResponse deleteUser(HttpServletResponse response, @PathVariable("username") String username) {
		GenericResponse genericResponse;
		int status = 0;
		try {
			User user = accountConfigurationService.deleteAccount(username);
			if (user != null) {
				status = HttpServletResponse.SC_OK;
				genericResponse = new GenericResponse(status, Message.DELETED.get()); }
			else {
				status = HttpServletResponse.SC_NOT_FOUND;
				genericResponse = new GenericResponse(status, Message.NOT_FOUND.get()); }
			response.setStatus(status);
			return genericResponse; }
		catch (Exception e) {
			status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			response.setStatus(status);
			genericResponse = new GenericResponse(status, e.getMessage()); 
			return genericResponse; } }
	
	@RequestMapping(value = "users/{username}", method = RequestMethod.PUT)
	public UserView updateUser(HttpServletResponse response, @PathVariable("username") String username,
			@RequestBody Account account) {
		UserView userView = new UserView();
		try {
			String userId = username;
			ArrayList<String> languages = account.getLanguages();
			String password = account.getPassword();
			String location = account.getLocation();
			String image = account.getPicture();
			InputStream picture = new ByteArrayInputStream(image.getBytes(StandardCharsets.UTF_8));
			
			User user = accountConfigurationService.editAccount(userId, languages, password, location, picture);
			int status = 0;
			if(user != null) {
				status = HttpServletResponse.SC_OK;
				userView = new UserView(user); }
			else {
				status = HttpServletResponse.SC_NOT_MODIFIED; }
			response.setStatus(status);
			return userView; }
		catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return userView; } 
	}
	
	@RequestMapping(value = "users", method = RequestMethod.POST)
	public UserView insertUser(HttpServletResponse response, @RequestBody SignUp signUp) {
		UserView userView = new UserView();
		//try {
			String username = signUp.getUsername();
			String email = signUp.getEmail();
			String password = signUp.getPassword();
			String passwordConfirm = signUp.getPasswordConfirm();
			
			User user = sessionService.signUp(username, email, password, passwordConfirm);
			int status = 0;
			if (user != null) {
				status = HttpServletResponse.SC_CREATED;
				userView = new UserView(user); }
			else {
				status = HttpServletResponse.SC_NOT_ACCEPTABLE; }
			response.setStatus(status);
			return userView; 
		//}
		//catch(Exception e) {
			//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			//return userView; } 
		
	}
	
	@RequestMapping(value = "users/{follower}/relationship/{followed}", method = RequestMethod.PUT)
	public GenericResponse createRelation(HttpServletResponse response, @PathVariable("follower") String follower,
			@PathVariable("followed") String followed) {
		GenericResponse genericResponse;
		int status = 0;
		try {
			User user = userFunctionsService.follow(follower, followed);
			if (user != null) {
				status = HttpServletResponse.SC_CREATED;
				genericResponse = new GenericResponse(status, Message.CREATED_RELATION.get()); }
			else {
				status = HttpServletResponse.SC_NOT_ACCEPTABLE;
				genericResponse = new GenericResponse(status, Message.NOT_CREATED_RELATION.get()); }
			response.setStatus(status);
			return genericResponse; }
		catch(Exception e) {
			status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			response.setStatus(status);
			genericResponse = new GenericResponse(status, e.getMessage());
			return genericResponse; } }
	
	@RequestMapping(value = "users/{follower}/relationship/{followed}", method = RequestMethod.DELETE)
	public GenericResponse removeRelation(HttpServletResponse response, @PathVariable("follower") String follower,
			@PathVariable("followed") String followed) {
		GenericResponse genericResponse;
		int status = 0;
		try {
			User user = userFunctionsService.stopFollowing(follower, followed);
			if (user != null) {
				status = HttpServletResponse.SC_OK;
				genericResponse = new GenericResponse(status, Message.DELETED_RELATION.get()); }
			else {
				status = HttpServletResponse.SC_NOT_ACCEPTABLE;
				genericResponse = new GenericResponse(status, Message.NOT_DELETED_RELATION.get()); } 
			response.setStatus(status);
			return genericResponse; }
		catch(Exception e) {
			status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			response.setStatus(status);
			genericResponse = new GenericResponse(status, e.getMessage());
			return genericResponse; } }
	
	@RequestMapping(value = "users/{username}/followers", method = RequestMethod.GET)
	public ArrayList<UserView> selectFollowers(HttpServletResponse response, @PathVariable("username") String userId) {
		GroupView groupView = new GroupView();
		try {
			List<User> users = visualizationService.showFollowers(userId);
			int status = 0;
			if (users != null) {
				status = HttpServletResponse.SC_FOUND;
				groupView.setUsers(users); }
			else {
				status = HttpServletResponse.SC_NOT_FOUND; }
			response.setStatus(status);
			return groupView.getUsers(); }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return groupView.getUsers(); } }
	
	@RequestMapping(value = "users/{username}/followed", method = RequestMethod.GET)
	public ArrayList<UserView> selectFollowed(HttpServletResponse response, @PathVariable("username") String userId) {
		GroupView groupView = new GroupView();
		try {
			List<User> users = visualizationService.showFollowing(userId);
			int status = 0;
			if (users != null) {
				status = HttpServletResponse.SC_FOUND;
				groupView.setUsers(users); }
			else {
				status = HttpServletResponse.SC_NOT_FOUND; }
			response.setStatus(status);
			return groupView.getUsers(); }
		catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return groupView.getUsers(); } }
}