package radxup.api.service.user.model;

public class Support {

	public Support() {

	}

	private String url;

	private String text;

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	@Override
	public String toString() {
		return "Support [url=" + url + ", text=" + text + "]";
	}

}
