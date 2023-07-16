package entities;

public class Topic 
{
	private int topicid;
	private String tname;
	private String desc;
	private String u_id;
	
	
	
	public Topic() {
		 
	}
	public Topic(int topicid, String tname, String desc, String u_id) {
		super();
		this.topicid = topicid;
		this.tname = tname;
		this.desc = desc;
		this.u_id = u_id;
	}
	
	
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	

}
