package Mocks

import Services.*;
import java.io.InputStream;
import java.util.List;

public class AccountConfigurationServiceMock implements AccountConfigurationService {
	public void deleteAccount(String userId);
	public void editAccount(String userId,List<String> languages,String password,String location,InputStream picture);
	
}
