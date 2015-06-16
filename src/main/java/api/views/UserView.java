package api.views;

import java.util.ArrayList;

import api.pojos.User;

public final class UserView {
	
	private String username;
	private String email;
	private String location;
	private ArrayList<String> languages;
	private String image;
	
	public UserView(User user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.location = user.getLocatedOn();
		this.languages = user.getLanguages();
		this.image = ""; }
	
	public UserView() {
		this.username = null;
		this.email = null;
		this.location = null;
		this.languages = null; }

	public final String getUsername() {
		return username; }

	public final String getEmail() {
		return email; }

	public final String getLocation() {
		return location; }

	public final ArrayList<String> getLanguages() {
		return languages; }
	
	public final String getImage() {
		return image; }
}