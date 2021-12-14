package radxup.api.utils.http;

import io.restassured.response.Response;

public class RestResponse<T> implements IRestResponse<T> {
	private T data;
	private Response response;
	private Exception e;

	public RestResponse(Class<?> t, Response response) {
		this.response = response;
		try {
			this.data = (T) t.newInstance();
		} catch (Exception e) {
			 System.out.println(e.getStackTrace());
			 throw new RuntimeException("No default constructor present in the Response POJO, please add a default one.");
		}
	}

	public String getContent() {
		return response.getBody().asString();
	}

	public int getStatusCode() {
		return response.getStatusCode();
	}

	public String getStatusDescription() {
		return response.getStatusLine();
	}

	public Response getResponse() {
		return response;
	}

	public T getBody() {
		try {
			data = (T) response.getBody().as(data.getClass());
		} catch (Exception e) {
			this.e = e;
		}
		return data;
	}

	public Exception getException() {
		return e;
	}

}