package Mocks

import Services.*;

public class SessionServiceMock implements SessionService {
	public void signUp(String username,String password);
	public void logIn(String username,String password);
	public void logOut(String username);
	public boolean validateEmail(String email);
}
