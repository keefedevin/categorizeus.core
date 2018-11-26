package us.categorize.model;

public class Message {
	private long internalId = -1;
	private String body = null;
	private String creator;
	public long getInternalId() {
		return internalId;
	}
	public void setInternalId(long internalId) {
		this.internalId = internalId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	} 
	
}
