package us.categorize.model;

public class Message {//would it be a good idea to parameterize on message type?
	private String id;
	private String body;
	private String title;
	private String postedBy;
	private String repliesTo;
	private String rootRepliesTo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getRepliesTo() {
		return repliesTo;
	}
	public void setRepliesTo(String repliesTo) {
		this.repliesTo = repliesTo;
	}
	public String getRootRepliesTo() {
		return rootRepliesTo;
	}
	public void setRootRepliesTo(String rootRepliesTo) {
		this.rootRepliesTo = rootRepliesTo;
	}
	
	
}
