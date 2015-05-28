package api.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.models.Account;
import api.models.SignUp;
import api.pojos.User;
import api.repositories.Repository;
import api.services.AccountConfigurationServiceMock;
import api.services.SessionServiceMock;
import api.services.UserFunctionsServiceMock;

@RestController
public final class UserController {
	
	@RequestMapping(
			value = "/api/v0/users",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> getUsers() {
        Collection<User> users = Repository.getRepository();
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK); }
	
	@RequestMapping(
			value = "/api/v0/users/{username}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        User user = new SessionServiceMock().getUser(username);
        if (user != null){
        	return new ResponseEntity<User>(user, HttpStatus.OK); }
        else {
        	return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND); } }
	
	@RequestMapping(
			value = "/api/v0/users",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody SignUp signUp) {
        User user = null;
		try {
			user = new SessionServiceMock().signUp(signUp.getUsername(), signUp.getEmail(), signUp.getPassword(), signUp.getPasswordConfirm());
			return new ResponseEntity<User>(user, HttpStatus.CREATED); }
		catch (Exception e) {
			return new ResponseEntity<User>(user, HttpStatus.CONFLICT); } }
	
	@RequestMapping(
			value = "/api/v0/users/emails/{email}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> isEmail(@PathVariable("email") String email) {
		boolean bool = new SessionServiceMock().validateEmail(email);
		if (bool) { return new ResponseEntity<Boolean>(bool, HttpStatus.OK); }
		else { return new ResponseEntity<Boolean>(bool, HttpStatus.UNAUTHORIZED); } }
	
	@RequestMapping(
			value = "/api/v0/users/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
		try {
			new AccountConfigurationServiceMock().deleteAccount(id);
			return new ResponseEntity<String>("User deleted", HttpStatus.OK); }
		catch(Exception e){
			return new ResponseEntity<String>("User not found.", HttpStatus.NOT_FOUND); } }
	
	@RequestMapping(
			value = "/api/v0/users/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody Account account) {
		try {
			new AccountConfigurationServiceMock().editAccount(id, account.getLanguages(), account.getPassword(), account.getLocation(), account.getPicture());
			return new ResponseEntity<String>("User updated.", HttpStatus.ACCEPTED); }
		catch (Exception e) {
			return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND); } }
	
	@RequestMapping(
			value = "/api/v0/users/{currentUser}/friendship/{username}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> followUser(@PathVariable("currentUser") String currentUser, @PathVariable("username") String username) {
		try {
			new UserFunctionsServiceMock().follow(currentUser, username);
			return new ResponseEntity<String>("", HttpStatus.OK); }
		catch(Exception e) {
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND); } }
	
	
	@RequestMapping(
			value = "/api/v0/users/{currentUser}/friendship/{username}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> stopFollowUser(@PathVariable("currentUser") String currentUser, @PathVariable("username") String username) {
		try {
			new UserFunctionsServiceMock().stopFollowing(currentUser, username);
			return new ResponseEntity<String>("", HttpStatus.OK); }
		catch(Exception e) {
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND); } }
}