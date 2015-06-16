package api.mocks;

import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import api.interfaces.AccountConfigurationService;
import api.pojos.User;

@Service
public final class AccountConfigurationServiceMock implements
		AccountConfigurationService {

	@Override
	public User deleteAccount(String userId) {
		User user = RepositoryMock.getUserRepository().get(userId);
		if (user != null) {
			RepositoryMock.getUserRepository().remove(userId); }
		return user; }

	@Override
	public String updateProfilePhoto(String userId, String photoFilename,
			InputStream photo) {
		return null; }

	@Override
	public User editPassword(String userId, String password,
			String confirmationPassword) {
		User user = RepositoryMock.getUserRepository().get(userId);
		if (user != null && password.equals(confirmationPassword)) {
			user.setPassword(confirmationPassword);
			return user; }
		else {
			return null; } }

	@Override
	public User editInformation(String userId, String localization,
			ArrayList<String> languajes) {
		User user = RepositoryMock.getUserRepository().get(userId);
		if (user != null) {
			user.setLocatedOn(localization);
			user.setLanguages(languajes); }
		return user; }

	@Override
	public User editAccount(String userId, ArrayList<String> languages,
			String password, String location, InputStream picture) {
		User user = RepositoryMock.getUserRepository().get(userId);
		if (user != null) {
			user.setLanguages(languages);
			user.setPassword(password);
			user.setLocatedOn(location);
			user.setProfileImage(picture); }
		return user; }
}