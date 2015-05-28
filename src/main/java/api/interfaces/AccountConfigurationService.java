package api.interfaces;

import java.io.InputStream;
import java.util.ArrayList;

public interface AccountConfigurationService {
	
	public void deleteAccount(String userId) throws Exception;
	
	public void editAccount(String userId,ArrayList<String> languages,String password,String location,InputStream picture) throws Exception; }
