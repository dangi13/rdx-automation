package radxup.api.model;

import radxup.api.utils.http.RequestType;

public class Endpoint {

	private String route;
	private RequestType requestType;

	public Endpoint(String route, RequestType requestType) {
		super();
		this.route = route;
		this.requestType = requestType;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

}
