package api.models;

public final class Publication {
	
	private String publisherId;
	private String description;
	private String code;
	private String language;

	public Publication() { }

	public Publication(String publisherId, String description, String code,
			String language) {
		this.publisherId = publisherId;
		this.description = description;
		this.code = code;
		this.language = language; }

	public final String getPublisherId() {
		return publisherId; }

	public final void setPublisherId(String publisherId) {
		this.publisherId = publisherId; }

	public final String getDescription() {
		return description; }

	public final void setDescription(String description) {
		this.description = description; }

	public final String getCode() {
		return code; }

	public final void setCode(String code) {
		this.code = code; }

	public final String getLanguage() {
		return language; }

	public final void setLanguage(String language) {
		this.language = language; }
}