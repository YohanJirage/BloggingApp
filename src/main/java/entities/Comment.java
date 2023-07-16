package entities;

public class Comment 
{
	private int cid;
	private String text;
	private int topicid;
	private String u_id;
	
	
	
	
	public Comment() {
	 
	}

	public Comment(int cid, String text, int topicid, String u_id) {
		this.cid = cid;
		this.text = text;
		this.topicid = topicid;
		this.u_id = u_id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
	
	
	
	

}
