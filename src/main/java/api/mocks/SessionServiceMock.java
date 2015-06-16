package api.mocks;

import java.util.Collection;

import org.springframework.stereotype.Service;

import api.interfaces.SessionService;
import api.pojos.User;

@Service
public final class SessionServiceMock implements SessionService {

	public SessionServiceMock() { }

	@Override
	public User signUp(String username, String email, String password,
			String passwordConfirm) {
		if (password.equals(passwordConfirm) && this.validateEmail(email)
				&& this.getUser(username) == null) {
			User user = new User(username, password, email);
			RepositoryMock.getUserRepository().put(username, user);
			return user; }
		else { 
			return null; } }

	@Override
	public boolean validateEmail(String email) {
		Collection<User> users = RepositoryMock.getUserRepository().values();
		if (!users.isEmpty()) {
			for (User user: users) {
				if (email.equals(user.getEmail())) {
					return false; } }
			return true; }
		else {
			return true; } }

	@Override
	public User getUser(String userId) {
		return RepositoryMock.getUserRepository().get(userId); }
}