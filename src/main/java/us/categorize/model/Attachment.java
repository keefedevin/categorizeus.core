package us.categorize.model;

public class Attachment {
	private long id;
	private String filename;
	private long length;
	private long messageId;
	private String extension;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
