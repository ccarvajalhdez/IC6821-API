package api.views;

import java.io.InputStream;
import java.util.Scanner;

public final class ImageView {
	
	private final String picture;

	@SuppressWarnings("resource")
	public ImageView(InputStream picture) {
		this.picture = new Scanner(picture,"UTF-8").useDelimiter("\\A").next(); }

	public final String getPicture() {
		return picture; }
}
