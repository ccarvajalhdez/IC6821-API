package api.services;

import java.io.InputStream;
import java.util.ArrayList;

import api.interfaces.AccountConfigurationService;
import api.pojos.User;
import api.repositories.Repository;

public final class AccountConfigurationServiceMock implements
		AccountConfigurationService {

	@Override
	public void deleteAccount(String userId) throws Exception {
		for (User user: Repository.getRepository()) {
			if (user.getId().equals(userId)) {
				Repository.getRepository().remove(user);
				return; } } 
		throw new Exception("User ID doesn't exist."); }

	@Override
	public void editAccount(String userId, ArrayList<String> languages,
			String password, String location, InputStream picture) throws Exception {
		for (User user: Repository.getRepository()) {
			if (user.getId().equals(userId)) {
				user.setLanguages(languages);
				user.setPassword(password);
				user.setLocatedOn(location);
				user.setProfileImage(picture);
				return; } }
		throw new Exception("User ID doesn't exist."); }

}