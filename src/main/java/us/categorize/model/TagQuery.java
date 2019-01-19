package us.categorize.model;

public class TagQuery {
	private String id;
	private String after;
	private String before;
	private int count = 10;
	private String sort;
	private boolean loadMetadata = false;
	private String tags[];
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAfter() {
		return after;
	}
	public void setAfter(String after) {
		this.after = after;
	}
	public String getBefore() {
		return before;
	}
	public void setBefore(String before) {
		this.before = before;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public boolean isLoadMetadata() {
		return loadMetadata;
	}
	public void setLoadMetadata(boolean loadMetadata) {
		this.loadMetadata = loadMetadata;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
}
