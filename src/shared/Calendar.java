package shared;


public class Calendar {
	
	private String overallID;
	private int calendarid;
	private String title;
	private int userid;
	private boolean permanent;
	private boolean active;
	
	public Calendar(int calendarid, String title, int userid) {
		super();
		this.calendarid = calendarid;
		this.title = title;
		this.userid = userid;
	}
	
	public Calendar(){
		
	}
	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	public int getCalendarid() {
		return calendarid;
	}
	public void setCalendarid(int calendarid) {
		this.calendarid = calendarid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getOverallID() {
		return overallID;
	}

	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

}
