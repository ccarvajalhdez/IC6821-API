package api.pojos;

import java.io.InputStream;

public final class Medal {
	
	private InputStream image;
	private String type;
	private String language;
	
	public Medal(InputStream image, String type, String language) {
		this.image = image;
		this.type = type;
		this.language = language; }

	public final InputStream getImage() {
		return image; }

	public final void setImage(InputStream image) {
		this.image = image; }

	public final String getType() {
		return type; }

	public final void setType(String type) {
		this.type = type; }

	public final String getLanguage() {
		return language; }

	public final void setLanguage(String language) {
		this.language = language; }

	@Override
	public String toString() {
		return "Medal [image=" + image + ", type=" + type + ", language="
				+ language + "]"; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Medal)) {
			return false; }
		Medal other = (Medal) obj;
		if (language == null) {
			if (other.language != null) {
				return false; } } 
		else if (!language.equals(other.language)) {
			return false; }
		if (type == null) {
			if (other.type != null) {
				return false; } }
		else if (!type.equals(other.type)) {
			return false; }
		return true; }
}