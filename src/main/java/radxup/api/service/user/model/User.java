package radxup.api.service.user.model;

public class User {

	public User() {

	}

	private Data data;

	private Support support;

	public void setData(Data data) {
		this.data = data;
	}

	public Data getData() {
		return this.data;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	public Support getSupport() {
		return this.support;
	}

	@Override
	public String toString() {
		return "User [data=" + data + ", support=" + support + "]";
	}

}
