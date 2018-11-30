package us.categorize.model;

public class MetaMessage {
	private User postedBy;
	private String[] tags;
	private Message message;
	public User getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(User postedBy) {
		if(postedBy!=null) postedBy.setPasshash(null);
		this.postedBy = postedBy;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
