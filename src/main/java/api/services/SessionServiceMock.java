package api.services;

import api.interfaces.SessionService;
import api.pojos.User;
import api.repositories.Repository;

public final class SessionServiceMock implements SessionService {

	@Override
	public User signUp(String username, String email, String password,
			String passwordConfirm) throws Exception {
		if (!this.validateEmail(email)) {
			throw new Exception("Email already exists."); }
		if (this.getUser(username) != null) {
			throw new Exception("Username already exists."); }
		if (!password.equals(passwordConfirm)) {
			throw new Exception("The passwords doesn't match."); }
		else { 
			User user = new User(username, email, password);
			Repository.getRepository().add(user);
			return user; } }

	@Override
	public User getCurrentUser(String current_username) {
		return null; }

	@Override
	public boolean validateEmail(String email) {
		if (!Repository.getRepository().isEmpty()) {
			for (User user: Repository.getRepository()) {
				if (user.getEmail().equals(email)) {
					return false; } } }
		return true; }

	@Override
	public User getUser(String username) {
		if (!Repository.getRepository().isEmpty()) {
			for (User user: Repository.getRepository()) {
				if (user.getUsername().equals(username)) {
					return user; } } }
		return null; }
}