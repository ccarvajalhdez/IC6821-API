package api.interfaces;

import java.io.InputStream;
import java.util.ArrayList;

import api.pojos.User;

public interface AccountConfigurationService {
	
	public User deleteAccount(String userId);
	
	public User editAccount(String userId, ArrayList<String> languages, String password, String location, InputStream picture);
	
	public String updateProfilePhoto(String userId, String photoFilename, InputStream photo);
	
	public User editPassword(String userId, String password, String confirmationPassword);
	
	public User editInformation(String userId, String localization, ArrayList<String> languajes); }