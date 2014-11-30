package shared;

public class SimpleCall implements java.io.Serializable {

	private  final long serialVersionUID = 4L;
	private String overallID;
	private int id;
	private String eventid;
	private int userId;
	
	public SimpleCall(){
		
	}

	public String getOverallID() {
		return overallID;
	}

	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getSerialVersionUID() {
		return serialVersionUID;
	}
}
