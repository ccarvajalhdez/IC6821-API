package api.models;

public final class SignUp {
	
	private String username;
	private String email;
	private String password;
	private String passwordConfirm;

	public SignUp() { }
	
	public SignUp(String username, String email, String password,
			String passwordConfirm) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm; }

	public final String getUsername() {
		return username; }

	public final void setUsername(String username) {
		this.username = username; }

	public final String getEmail() {
		return email; }

	public final void setEmail(String email) {
		this.email = email; }

	public final String getPassword() {
		return password; }

	public final void setPassword(String password) {
		this.password = password; }

	public final String getPasswordConfirm() {
		return passwordConfirm; }

	public final void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm; }
}