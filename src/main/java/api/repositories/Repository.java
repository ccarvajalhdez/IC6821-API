package api.repositories;

import java.util.ArrayList;

import api.pojos.User;

public abstract class Repository {
	
	private static final ArrayList<User> repository = new ArrayList<User>();

	public static final ArrayList<User> getRepository() {
		return repository; }

}