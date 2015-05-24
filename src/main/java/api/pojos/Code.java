package api.pojos;

public final class Code {
	
	private String code;
	private String language;
	
	public Code(String code, String language) {
		this.code = code;
		this.language = language; }

	public final String getCode() {
		return code; }

	public final void setCode(String code) {
		this.code = code; }

	public final String getLanguage() {
		return language; }

	public final void setLanguage(String language) {
		this.language = language; }

	@Override
	public String toString() {
		return "Code [code=" + code + ", language=" + language + "]"; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		return result; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Code)) {
			return false; }
		Code other = (Code) obj;
		if (code == null) {
			if (other.code != null) {
				return false; } }
		else if (!code.equals(other.code)) {
			return false; }
		if (language == null) {
			if (other.language != null) {
				return false; } }
		else if (!language.equals(other.language)) {
			return false; }
		return true; }
}