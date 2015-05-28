package api.models;

public class Publication {
	
	private String publisher;
	private String description;
	private String code;
	private String language;
	
	public Publication() {}

	public final String getPublisher() {
		return publisher; }

	public final void setPublisher(String publisher) {
		this.publisher = publisher; }

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