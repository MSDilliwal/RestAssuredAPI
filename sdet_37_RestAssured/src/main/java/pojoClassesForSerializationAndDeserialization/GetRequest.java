package pojoClassesForSerializationAndDeserialization;

public class GetRequest {

	String baseURI;
	String endPoint;
	public GetRequest(String baseURI, String endPoint) {
		super();
		this.baseURI = baseURI;
		this.endPoint = endPoint;
	}
	
	public GetRequest() {
		
	}

	public String getBaseURI() {
		return baseURI;
	}

	public void setBaseURI(String baseURI) {
		this.baseURI = baseURI;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	
	
}
