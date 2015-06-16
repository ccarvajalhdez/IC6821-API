package api.models;

import java.util.ArrayList;

public final class Account {
	
	private ArrayList<String> languages;
	private String password;
	private String location;
	private String picture;

	public Account() { }
	
	public Account(ArrayList<String> languages, String password,
			String location, String picture) {
		this.languages = languages;
		this.password = password;
		this.location = location;
		this.picture = picture; }

	public final ArrayList<String> getLanguages() {
		return languages; }

	public final void setLanguages(ArrayList<String> languages) {
		this.languages = languages; }

	public final String getPassword() {
		return password; }

	public final void setPassword(String password) {
		this.password = password; }

	public final String getLocation() {
		return location; }

	public final void setLocation(String location) {
		this.location = location; }

	public final String getPicture() {
		return picture; }

	public final void setPicture(String picture) {
		this.picture = picture; }
}