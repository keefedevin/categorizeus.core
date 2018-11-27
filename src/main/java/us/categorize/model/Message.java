package us.categorize.model;

public class Message {//would it be a good idea to parameterize on message type?
	private long id;
	private String body;
	private String title;
	private long postedBy;
	private long repliesTo;
	private long rootRepliesTo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public long getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(long postedBy) {
		this.postedBy = postedBy;
	}
	public long getRepliesTo() {
		return repliesTo;
	}
	public void setRepliesTo(long repliesTo) {
		this.repliesTo = repliesTo;
	}
	public long getRootRepliesTo() {
		return rootRepliesTo;
	}
	public void setRootRepliesTo(long rootRepliesTo) {
		this.rootRepliesTo = rootRepliesTo;
	}
	
	
}
