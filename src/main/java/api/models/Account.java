package api.models;

import java.io.InputStream;
import java.util.ArrayList;

public class Account {
	
	private ArrayList<String> languages;
	private String password;
	private String location;
	private InputStream picture;
	
	public Account() {}

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

	public final InputStream getPicture() {
		return picture; }

	public final void setPicture(InputStream picture) {
		this.picture = picture; }
}