package api.models;

public final class DateRange {
	
	private String from;
	private String to;
	private String region;

	public DateRange() { }

	public DateRange(String from, String to, String region) {
		this.from = from;
		this.to = to;
		this.setRegion(region); }

	public final String getFrom() {
		return from; }

	public final void setFrom(String from) {
		this.from = from; }

	public final String getTo() {
		return to; }

	public final void setTo(String to) {
		this.to = to; }

	public final String getRegion() {
		return region; }

	public final void setRegion(String region) {
		this.region = region; }
}